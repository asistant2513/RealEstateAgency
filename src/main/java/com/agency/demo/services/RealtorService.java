package com.agency.demo.services;

import com.agency.demo.models.Realtor;
import com.agency.demo.repositories.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {
    private final RealtorRepository realtorRepository;

    @Autowired
    public RealtorService(RealtorRepository realtorRepository){
        this.realtorRepository = realtorRepository;
    }

    public void saveRealtor(Realtor r){
        realtorRepository.save(r);
    }

    public Realtor getById(long id){
        return realtorRepository.findById(id).get();
    }

    public Iterable<Realtor> getAll(){
        return realtorRepository.findAll();
    }

    public void deleteRealtor(long id){
        realtorRepository.deleteById(id);
    }
}
