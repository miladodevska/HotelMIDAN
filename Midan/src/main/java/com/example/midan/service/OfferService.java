package com.example.midan.service;

import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    List<Offer> listAllOffers();

    Offer findById(Long id);

    Offer findByName(String name);

    Optional<Offer> save(String offerFor, String offerName, float offerPrice, OfferType type);

    Offer create(String offerFor, String offerName, float offerPrice, OfferType type);

    Optional<Offer> update(Long id, String offerFor, String offerName, float offerPrice, OfferType type);

    void deleteById(Long id);
}
