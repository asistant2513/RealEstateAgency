package com.agency.demo.services;

import com.agency.demo.models.Advertisement;
import com.agency.demo.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertRepository;

    @Autowired
    public AdvertisementService(AdvertisementRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public void saveAdvert(Advertisement ad){
        advertRepository.save(ad);
    }
}
