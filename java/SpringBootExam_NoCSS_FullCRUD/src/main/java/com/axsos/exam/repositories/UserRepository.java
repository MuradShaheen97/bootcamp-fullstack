package com.axsos.exam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.exam.models.User;

/** Repository communicates with the users table. */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    //Optional<User> findByUsername(String username);
}
