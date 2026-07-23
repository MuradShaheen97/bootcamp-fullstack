package com.axsos.projectmanager.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // Spring creates the SQL query automatically from the method name.
    Optional<User> findByEmail(String email);
}
