package com.axsos.projectmanager.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    // In one-to-one, this returns the single project owned by this user.
    Optional<Project> findByOwner(User owner);
}
