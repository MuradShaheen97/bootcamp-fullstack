package com.axsos.counter;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

    @RequestMapping("/")
    public String index(HttpSession session) {

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }

        Integer count = (Integer) session.getAttribute("count");
        count++;
        session.setAttribute("count", count);

        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model) {

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }

        model.addAttribute("count", session.getAttribute("count"));

        return "counter.jsp";
    }

    @RequestMapping("/counter2")
    public String counter2(HttpSession session) {

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }

        Integer count = (Integer) session.getAttribute("count");
        count += 2;
        session.setAttribute("count", count);

        return "counter2.jsp";
    }

    @RequestMapping("/reset")
    public String reset(HttpSession session) {
        session.setAttribute("count", 0);
        return "redirect:/counter";
    }
}