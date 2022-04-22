package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Exceptions.InvalidRoomIdException;
import com.example.midan.model.Room;
import com.example.midan.repository.RoomRepository;
import com.example.midan.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired private RoomRepository repository;

    @Override
    public List<Room> listAllRooms() {
        return this.repository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return this.repository.findById(id).orElseThrow(InvalidRoomIdException::new);
    }

    @Override
    @Transactional
    public Optional<Room> save(String name, Double price, RoomType type, String imageUrl) {
        this.repository.deleteByName(name);
        return Optional.of(this.repository.save(new Room(name, price, type, imageUrl)));
    }

    @Override
    public Room create(String name, Double price, RoomType type, String imageUrl) {
        Room room = new Room(name, price, type, imageUrl);
        return this.repository.save(room);
    }

    @Override
    @Transactional
    public Room update(Long id, String name, Double price, RoomType type, String imageUrl) {
        Room room = this.findById(id);
        room.setName(name);
        room.setPrice(price);
        room.setType(type);
        room.setImageUrl(imageUrl);
        this.repository.save(room);
        return room;
    }

    @Override
    public Room delete(Long id) {
        Room room = this.findById(id);
        this.repository.delete(room);
        return room;
    }
}
