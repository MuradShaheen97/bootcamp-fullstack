package com.axsos.SpringBoot.Burger.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.SpringBoot.Burger.Models.Burgers;

@Repository
public interface BurgerRepositorie extends CrudRepository<Burgers, Long> {
	boolean existsByName(String name);
	
}
