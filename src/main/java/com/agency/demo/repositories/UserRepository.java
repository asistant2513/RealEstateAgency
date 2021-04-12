package com.agency.demo.repositories;

import com.agency.demo.enums.UserRole;
import com.agency.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByPhoneNumber(String number);

    List<User> findUsersByRoleEquals(UserRole role);
}
