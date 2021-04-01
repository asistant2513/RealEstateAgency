package com.agency.demo.services;

import com.agency.demo.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvertisementService {

    private final AdvertisementRepository advertRepository;

    @Autowired
    public AdvertisementService(AdvertisementRepository advertRepository) {
        this.advertRepository = advertRepository;
    }
}
