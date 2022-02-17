package com.example.midan.service;

import com.example.midan.model.Guest;
import com.example.midan.model.Receipt;
import com.example.midan.model.Room;

import java.util.List;

public interface ReceiptService {
    List<Receipt> listAllReceipts();
    Receipt findById(Long id);
    Receipt create(Guest guest, List<Room> room, Double price);
    Receipt update(Long id, Guest guest, List<Room> room, Double price);
    Receipt delete(Long id);
}
