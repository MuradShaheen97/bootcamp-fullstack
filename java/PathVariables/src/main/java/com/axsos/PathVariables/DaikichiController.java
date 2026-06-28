package com.axsos.PathVariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DaikichiController {

    // http://localhost:8080/daikichi
    @RequestMapping("")
    public String welcome() {
        return "Welcome!";
    }

    // http://localhost:8080/daikichi/today
    @RequestMapping("/today")
    public String today() {
        return "Today you will find luck in all your endeavors!";
    }

    // http://localhost:8080/daikichi/tomorrow
    @RequestMapping("/tomorrow")
    public String tomorrow() {
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

    // http://localhost:8080/daikichi/travel/kyoto
    @RequestMapping("/travel/{city}")
    public String travel(@PathVariable("city") String citys) {
        return "Congratulations! You will soon travel to " + citys + "!";
    }

    // http://localhost:8080/daikichi/lotto/8
    @RequestMapping("/lotto/{number}")
    public String lotto(@PathVariable("number") int number) {

        if (number % 2 == 0) {
            return "You will take a grand journey in the near future but be wary of tempting offers.";
        } else {
            return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
        }
    }
}