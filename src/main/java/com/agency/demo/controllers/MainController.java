package com.agency.demo.controllers;

import com.agency.demo.models.Advertisement;
import com.agency.demo.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    private AdvertisementService adService;

    @Autowired
    public MainController(AdvertisementService advertisementService){
        this.adService = advertisementService;
    }

    @GetMapping
    public String getPage(Model model){
        Iterable<Advertisement> list = adService.getAll();
        model.addAttribute("adverts", list);
        return "index";
    }
}
