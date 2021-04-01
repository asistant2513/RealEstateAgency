package com.agency.demo.repositories;

import com.agency.demo.models.Realtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorRepository extends CrudRepository<Realtor, Long> {

}
