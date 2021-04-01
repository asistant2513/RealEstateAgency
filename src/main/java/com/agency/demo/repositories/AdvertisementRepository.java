package com.agency.demo.repositories;

import com.agency.demo.models.Advertisement;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
}
