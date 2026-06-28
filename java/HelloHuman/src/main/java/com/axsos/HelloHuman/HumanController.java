package com.axsos.HelloHuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {

    public HumanController() {

    }

    // Default
    @RequestMapping("/")
    public String home() {
        return "Hello Human";
    }

    // First name only
    @RequestMapping("/{firstName}")
    public String greeting(@PathVariable("firstName") String firstName) {
        return "Hello " + firstName;
    }

    // First and last name
    @RequestMapping("/{firstName}/{lastName}")
    public String greeting(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {

        return "Hello " + firstName + " " + lastName;
    }
}