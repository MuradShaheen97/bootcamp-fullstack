package com.axsos.NinjaGold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {

    @RequestMapping("/")
    public String index(HttpSession session) {

        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }

        int gold = (int) session.getAttribute("gold");

        if (gold <= -100) {
            return "prison.jsp";
        }

        return "index.jsp";
    }

    @RequestMapping("/process")
    public String process(@RequestParam("place") String place, HttpSession session) {

        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }

        if (place.equals("reset")) {
            session.invalidate();
            return "redirect:/";
        }

        Random rand = new Random();

        int gold = (int) session.getAttribute("gold");

        @SuppressWarnings("unchecked")
        ArrayList<String> activities =
                (ArrayList<String>) session.getAttribute("activities");

        int amount = 0;
        String message = "";

        if (place.equals("farm")) {
            amount = rand.nextInt(11) + 10;
            message = "You entered a farm and earned " + amount + " gold.";
        } else if (place.equals("cave")) {
            amount = rand.nextInt(6) + 5;
            message = "You entered a cave and earned " + amount + " gold.";
        } else if (place.equals("house")) {
            amount = rand.nextInt(4) + 2;
            message = "You entered a house and earned " + amount + " gold.";
        } else if (place.equals("quest")) {
            amount = rand.nextInt(101) - 50;

            if (amount >= 0) {
                message = "You completed a quest and earned " + amount + " gold.";
            } else {
                message = "You failed a quest and lost " + Math.abs(amount) + " gold.";
            }

        } else if (place.equals("spa")) {
            amount = -(rand.nextInt(16) + 5);
            message = "You went to the spa and lost " + Math.abs(amount) + " gold.";
        }

        gold += amount;

        String time = new SimpleDateFormat("MMMM dd yyyy h:mm a").format(new Date());

        activities.add(0, message + " (" + time + ")");

        session.setAttribute("gold", gold);
        session.setAttribute("activities", activities);

        return "redirect:/";
    }
}