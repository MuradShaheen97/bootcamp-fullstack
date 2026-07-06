package com.axsos.CarFactory.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.CarFactory.models.Cars;
import com.axsos.CarFactory.services.CarService;

@Controller
@RequestMapping("/")
public class CarController {
	private final CarService carServices;

	public CarController(CarService carServices) {
		this.carServices = carServices;
	}

		@RequestMapping("/")
	public String index(@ModelAttribute("car") Cars car) {
	    return "index";
	}

	@RequestMapping("/addCar")
	public String createCar(@Valid @ModelAttribute("car") Cars car, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		carServices.create(car);
		return "redirect:/";

	}

}
