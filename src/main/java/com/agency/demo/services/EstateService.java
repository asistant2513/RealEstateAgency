package com.agency.demo.services;

import com.agency.demo.models.Estate;
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

    public Estate getEstateByID(long id){
        return estateRepository.findById(id).get();
    }

    public Iterable<Estate> getAll(){
        return estateRepository.findAll();
    }

    public void saveEstate(Estate e){
        estateRepository.save(e);
    }

    public void deleteEstateByID(long id){
        estateRepository.deleteById(id);
    }

    public Iterable<Estate> getAllWithoutAdverts(){
        return estateRepository.getAllEstatesWithoutAdvert();
    }
}
