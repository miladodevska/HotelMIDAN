package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Offer;
import com.example.midan.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Override
    public List<Offer> listallOffers() {
        return null;
    }

    @Override
    public Offer findById(Long id) {
        return null;
    }

    @Override
    public Offer findByName() {
        return null;
    }

    @Override
    public Offer create(String offerFor, String offerName, OfferType type) {
        return null;
    }

    @Override
    public Offer update(Long id, String offerFor, String offerName, OfferType type) {
        return null;
    }

    @Override
    public Offer delete(Long id) {
        return null;
    }
}
