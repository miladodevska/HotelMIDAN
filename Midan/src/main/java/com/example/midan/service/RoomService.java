package com.example.midan.service;

import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> listAll();
    Room findById(Long id);
    Room create(String name, Double price, RoomType type);
    Room update(Long id, String name, Double price, RoomType type);
    Room delete(Long id);
}
