package com.agency.demo.repositories;

import com.agency.demo.models.Estate;
import org.springframework.data.repository.CrudRepository;

public interface EstateRepository extends CrudRepository<Estate, Long> {
}
