package com.example.midan.service;

import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> listAllRooms();

    Room findById(Long id);

    Optional<Room> save(String name, Double price, RoomType type, String imageUrl);

    Room create(String name, Double price, RoomType type, String imageUrl);

    Room update(Long id, String name, Double price, RoomType type, String imageUrl);

    Room delete(Long id);
}
