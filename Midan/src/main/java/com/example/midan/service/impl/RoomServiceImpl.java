package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Exceptions.InvalidRoomIdException;
import com.example.midan.model.Room;
import com.example.midan.repository.RoomRepository;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository repository;

    @Override
    public List<Room> listAllRooms() {
        return this.repository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return this.repository.findById(id).orElseThrow(InvalidRoomIdException::new);
    }

    @Override
    public Room create(String name, Double price, RoomType type) {
        Room room = new Room(name,price,type);
        return this.repository.save(room);
    }

    @Override
    public Room update(Long id, String name, Double price, RoomType type) {
        Room room = this.findById(id);
        room.setName(name);
        room.setPrice(price);
        room.setType(type);
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
