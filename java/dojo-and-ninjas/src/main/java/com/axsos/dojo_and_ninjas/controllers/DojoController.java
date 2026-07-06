package com.axsos.dojo_and_ninjas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.dojo_and_ninjas.models.Dojo;
import com.axsos.dojo_and_ninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dojos/new";
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo";
    }

    @PostMapping("/dojos/new")
    public String createDojo(
            @Valid @ModelAttribute("dojo") Dojo dojo,
            BindingResult result) {

        if (result.hasErrors()) {
            return "newDojo";
        }

        Dojo newDojo = dojoService.createDojo(dojo);
        return "redirect:/dojos/" + newDojo.getId();
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(
            @PathVariable("id") Long id,
            Model model) {

        Dojo dojo = dojoService.findDojo(id);

        if (dojo == null) {
            return "redirect:/dojos/new";
        }

        model.addAttribute("dojo", dojo);
        return "showDojo";
    }
}