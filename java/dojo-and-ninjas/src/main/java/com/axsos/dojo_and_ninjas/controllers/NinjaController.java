package com.axsos.dojo_and_ninjas.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.dojo_and_ninjas.models.Ninja;
import com.axsos.dojo_and_ninjas.services.DojoService;
import com.axsos.dojo_and_ninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("/ninjas/new")
    public String newNinja(
            @ModelAttribute("ninja") Ninja ninja,
            Model model) {

        model.addAttribute("dojos", dojoService.allDojos());
        return "newNinja";
    }

    @PostMapping("/ninjas/new")
    public String createNinja(
            @Valid @ModelAttribute("ninja") Ninja ninja,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("dojos", dojoService.allDojos());
            return "newNinja";
        }

        Ninja newNinja = ninjaService.createNinja(ninja);
        return "redirect:/dojos/" + newNinja.getDojo().getId();
    }
}