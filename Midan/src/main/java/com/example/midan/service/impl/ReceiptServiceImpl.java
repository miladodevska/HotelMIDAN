package com.example.midan.service.impl;

import com.example.midan.model.Guest;
import com.example.midan.model.Receipt;
import com.example.midan.model.Room;
import com.example.midan.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public List<Receipt> listAllReceipts() {
        return null;
    }

    @Override
    public Receipt findById(Long id) {
        return null;
    }

    @Override
    public Receipt create(Guest guest, List<Room> room, Double price) {
        return null;
    }

    @Override
    public Receipt update(Long id, Guest guest, List<Room> room, Double price) {
        return null;
    }

    @Override
    public Receipt delete(Long id) {
        return null;
    }
}
