package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Exceptions.OfferNotFoundException;
import com.example.midan.model.Offer;
import com.example.midan.repository.OfferRepository;
import com.example.midan.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;


    @Override
    public List<Offer> listAllOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer findById(Long id) {
        return this.offerRepository.findById(id).orElseThrow(OfferNotFoundException::new);
    }

    @Override
    public Offer findByName(String name) {
        return this.offerRepository.findByOfferName(name);
    }

    @Override
    public Optional<Offer> save(String offerFor, String offerName, OfferType type) {
        return Optional.of(this.offerRepository.save(new Offer(offerFor, offerName, type)));

    }

    @Override
    public Offer create(String offerFor, String offerName, OfferType type) {
        Offer offer = new Offer(offerFor,offerName,type);
        return this.offerRepository.save(offer);
    }

    @Override
    public Offer update(Long id, String offerFor, String offerName, OfferType type) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(OfferNotFoundException::new);
        offer.setOfferFor(offerFor);
        offer.setOfferName(offerName);
        offer.setType(type);
        this.offerRepository.save(offer);
        return offer;
    }

    @Override
    public Offer delete(Long id) {
        Offer offer = this.findById(id);
        this.offerRepository.delete(offer);
        return offer;
    }
}
