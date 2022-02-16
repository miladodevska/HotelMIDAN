package com.example.midan.service;

import com.example.midan.model.Receipt;

import java.util.List;

public interface ReceiptService {
    List<Receipt> listAllReceipts();
    Receipt findById(Long id);
    Receipt create();
    Receipt update();
    Receipt delete(Long id);
}
