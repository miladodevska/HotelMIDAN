package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Exceptions.OfferNotFoundException;
import com.example.midan.model.Offer;
import com.example.midan.model.ShoppingCart;
import com.example.midan.repository.OfferRepository;
import com.example.midan.repository.ShoppingCartRepository;
import com.example.midan.service.OfferService;
import com.example.midan.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired private OfferRepository offerRepository;


    @Override
    public List<Offer> listAllOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer findById(Long id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new OfferNotFoundException(id));
    }

    @Override
    public Offer findByName(String name) {
        return this.offerRepository.findByOfferName(name);
    }

    @Override
    @Transactional
    public Optional<Offer> save(String offerFor, String offerName, float offerPrice, OfferType type) {
        this.offerRepository.deleteByOfferName(offerName);
        return Optional.of(this.offerRepository.save(new Offer(offerFor, offerName, offerPrice, type)));

    }

    @Override
//    @Transactional
    public Offer create(String offerFor, String offerName, float offerPrice, OfferType type) {
        Offer offer = new Offer(offerFor,offerName,offerPrice,type);
        return this.offerRepository.save(offer);
    }

    @Override
    @Transactional
    public Optional<Offer> update(Long id, String offerFor, String offerName, float offerPrice, OfferType type) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new OfferNotFoundException(id));
        offer.setOfferFor(offerFor);
        offer.setOfferName(offerName);
        offer.setOfferPrice(offerPrice);
        offer.setType(type);
        this.offerRepository.save(offer);
        return Optional.of(offer);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Offer offer = this.findById(id);
        offer.setDeleted(true);
        this.offerRepository.save(offer);

    }
}
