package com.agency.demo.controllers;

import com.agency.demo.services.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realtors")
public class RealtorController {

    private final RealtorService realtorService;

    @Autowired
    public RealtorController(RealtorService realtorService) {
        this.realtorService = realtorService;
    }

}
