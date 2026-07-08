package com.axsos.orders.repos;

import org.springframework.data.repository.CrudRepository;

import com.axsos.orders.models.Users;

public interface UserRepo extends CrudRepository<Users, Long>{

}
