package com.example.midan.service;

import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> findAll();
    Offer findById(Long id);
    Offer create(String offerFor, String offerName, OfferType type);
    Offer update(Long id, String offerFor, String offerName, OfferType type);
    Offer delete(Long id);
}
