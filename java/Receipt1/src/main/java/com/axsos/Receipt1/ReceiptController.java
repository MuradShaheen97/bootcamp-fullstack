package com.axsos.Receipt1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReceiptController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "Controller is working";
    }

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("name", "Murad Shaheen");
        model.addAttribute("itemName", "Gaming Mouse");
        model.addAttribute("price", 25.99);
        model.addAttribute("description", "Wireless mouse with RGB lights.");
        model.addAttribute("vendor", "Tech Store");

        return "index";
    }
}