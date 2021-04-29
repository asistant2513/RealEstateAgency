package com.agency.demo.repositories;

import com.agency.demo.models.Estate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EstateRepository extends CrudRepository<Estate, Long> {

    @Query(value="select * from estates e left outer join adverts a on e.id = a.estate_id where a.estate_id is null", nativeQuery = true)
    public Iterable<Estate> getAllEstatesWithoutAdvert();

}
