package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Room;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public List<Room> listAllRooms() {
        return null;
    }

    @Override
    public Room findById(Long id) {
        return null;
    }

    @Override
    public Room create(String name, Double price, RoomType type) {
        return null;
    }

    @Override
    public Room update(Long id, String name, Double price, RoomType type) {
        return null;
    }

    @Override
    public Room delete(Long id) {
        return null;
    }
}
