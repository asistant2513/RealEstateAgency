package com.agency.demo.services;

import com.agency.demo.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateService {

    private final EstateRepository estateRepository;

    @Autowired
    public EstateService(EstateRepository estateRepository) {
        this.estateRepository = estateRepository;
    }


}
