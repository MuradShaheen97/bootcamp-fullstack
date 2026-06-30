package com.axsos.OmikujiApp.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {

	@RequestMapping("/omikuji")
	public String index() {
		return "omikuji.jsp";
	}

	@RequestMapping("/omikuji/process")
	public String process(@RequestParam("number") String number, @RequestParam("city") String city,
			@RequestParam("person") String person, @RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing, @RequestParam("nice") String nice, HttpSession session) {

		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);

		return "redirect:/omikuji/show";
	}

	@RequestMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}
}