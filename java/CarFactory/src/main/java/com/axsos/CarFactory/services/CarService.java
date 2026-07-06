package com.axsos.CarFactory.services;

import java.util.Optional;

import org.springframework.expression.spel.ast.OpDec;
import org.springframework.stereotype.Service;

import com.axsos.CarFactory.models.Cars;
import com.axsos.CarFactory.repositres.CarRepo;

@Service
public class CarService {

	private final CarRepo carRepo;

	public CarService(CarRepo carRepo) {
		this.carRepo = carRepo;
		// TODO Auto-generated constructor stub

	}

	public void create(Cars car) {
		carRepo.save(car);
	}

	public void delete(Long id) {
		carRepo.deleteById(id);
	}

	public void update(Long id, Cars car) {
		Optional<Cars> oldCars = carRepo.findById(id);
		if (oldCars.isPresent()) {
			Cars newcar = oldCars.get();

			newcar.setCarDate(car.getCarDate());
			newcar.setColor(car.getColor());
			newcar.setCompany(car.getCompany());
			newcar.setFule(car.getFule());
			newcar.setModel(car.getModel());

		}
	}
}
