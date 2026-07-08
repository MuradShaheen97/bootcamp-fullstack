package com.axsos.SpringBoot.Burger.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.SpringBoot.Burger.Models.Burgers;
import com.axsos.SpringBoot.Burger.Repositories.BurgerRepositorie;

@Service
public class BurgerService {
	private final BurgerRepositorie burgerRepo;
	public BurgerService(BurgerRepositorie burgerRepo) {
		this.burgerRepo = burgerRepo;
	}
	public boolean addBurger(Burgers burger) {
        // 1. Check if a burger with this name already exists
        if (burgerRepo.existsByName(burger.getName())) {
            return false; // It exists! Stop operation.
        }
        
        // 2. If it doesn't exist, save it to the database
        burgerRepo.save(burger);
        return true;
    }
	public boolean deleteBurger(Long burgerId) {
		if(burgerRepo.existsById(burgerId)) {
			burgerRepo.deleteById(burgerId);
			return true;
		}
		return false;
	}
	public boolean updateBurger(Burgers newBurger, Long id) {
	    Optional<Burgers> burger = burgerRepo.findById(id);
	    
	    if (burger.isPresent()) {
	        Burgers oldBurger = burger.get();
	        oldBurger.setName(newBurger.getName());
	        oldBurger.setNotes(newBurger.getNotes());
	        oldBurger.setRate(newBurger.getRate());
	        oldBurger.setResturantName(newBurger.getResturantName());
	        
	        burgerRepo.save(oldBurger);
	        return true;
	    }
	    
	    return false;
	}
	public List<Burgers> allBurgers() {
	    return (List<Burgers>) burgerRepo.findAll();
	}
	public Burgers findBurger(Long id) {
	    Optional<Burgers> optionalBurger = burgerRepo.findById(id);
	    return optionalBurger.orElse(null);
	}

}
