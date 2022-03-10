package com.example.midan.service.impl;

import com.example.midan.model.Exceptions.InvalidReceiptIdException;
import com.example.midan.model.Guest;
import com.example.midan.model.Receipt;
import com.example.midan.model.Room;
import com.example.midan.repository.ReceiptRepository;
import com.example.midan.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private ReceiptRepository repository;

    @Override
    public List<Receipt> listAllReceipts() {
        return this.repository.findAll();
    }

    @Override
    public Receipt findById(Long id) {
        return this.repository.findById(id).orElseThrow(InvalidReceiptIdException::new);
    }

    @Override
    public Receipt create(Guest guest, List<Room> room, Double price) {
        Receipt receipt = new Receipt(guest,room,price);
        return this.repository.save(receipt);
    }

    @Override
    public Receipt update(Long id, Guest guest, List<Room> room, Double price) {
        Receipt receipt = this.repository.findById(id).orElseThrow(InvalidReceiptIdException::new);
        receipt.setGuest(guest);
        receipt.setRoom(room);
        receipt.setPrice(price);
        this.repository.save(receipt);
        return receipt;
    }

    @Override
    public Receipt delete(Long id) {
        Receipt receipt = this.findById(id);
        this.repository.delete(receipt);
        return receipt;
    }
}
