package com.agency.demo.controllers;

import com.agency.demo.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstateController {

    private final EstateService estateService;

    @Autowired
    public EstateController(EstateService estateService) {
        this.estateService = estateService;
    }


}
