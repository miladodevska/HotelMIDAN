package com.example.midan.service;

import com.example.midan.model.Receipt;

import java.util.List;

public interface ReceiptService {
    List<Receipt> listAllReceipts();
    Receipt findById(Long id);
    Receipt create(Integer roomNumber, Double price);
    Receipt update(Long id, Integer roomNumber, Double price);
    Receipt delete(Long id);
}
