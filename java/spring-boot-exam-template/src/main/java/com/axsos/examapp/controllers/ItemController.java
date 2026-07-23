package com.axsos.examapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.examapp.models.Item;
import com.axsos.examapp.models.User;
import com.axsos.examapp.services.ItemService;
import com.axsos.examapp.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/*
 * إذا السؤال Game:
 * 1. غيّر ItemController إلى GameController
 * 2. غيّر Item إلى Game
 * 3. غيّر routes من /items إلى /games
 * 4. غيّر JSP names إذا حبيت
 */
@Controller
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    public ItemController(
            ItemService itemService,
            UserService userService) {

        this.itemService = itemService;
        this.userService = userService;
    }

    private Long loggedUserId(HttpSession session) {
        return (Long) session.getAttribute("userId");
    }

    // READ ALL
    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model) {

        Long userId = loggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findUser(userId);

        model.addAttribute("user", user);
        model.addAttribute("items", itemService.allItems());

        return "dashboard";
    }

    // CREATE FORM
    @GetMapping("/items/new")
    public String newItem(
            HttpSession session,
            Model model) {

        if (loggedUserId(session) == null) {
            return "redirect:/";
        }

        model.addAttribute("item", new Item());

        return "new";
    }

    // CREATE PROCESS
    @PostMapping("/items")
    public String createItem(
            @Valid @ModelAttribute("item") Item item,
            BindingResult result,
            HttpSession session) {

        Long userId = loggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "new";
        }

        User owner = userService.findUser(userId);
        item.setOwner(owner);

        itemService.saveItem(item);

        return "redirect:/dashboard";
    }

    // READ ONE
    @GetMapping("/items/{id}")
    public String showItem(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model) {

        if (loggedUserId(session) == null) {
            return "redirect:/";
        }

        Item item = itemService.findItem(id);

        if (item == null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("item", item);

        return "show";
    }

    // UPDATE FORM
    @GetMapping("/items/{id}/edit")
    public String editItem(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model) {

        Long userId = loggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Item item = itemService.findItem(id);

        if (item == null
                || !item.getOwner().getId().equals(userId)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("item", item);

        return "edit";
    }

    // UPDATE PROCESS
    @PostMapping("/items/{id}/update")
    public String updateItem(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("item") Item formItem,
            BindingResult result,
            HttpSession session) {

        Long userId = loggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Item databaseItem = itemService.findItem(id);

        if (databaseItem == null
                || !databaseItem.getOwner().getId().equals(userId)) {
            return "redirect:/dashboard";
        }

        if (result.hasErrors()) {
            return "edit";
        }

        /*
         * عدّل الحقول المطلوبة فقط.
         * لا تستبدل owner أو id.
         */
        databaseItem.setName(formItem.getName());
        databaseItem.setDescription(formItem.getDescription());
        databaseItem.setValue(formItem.getValue());

        itemService.saveItem(databaseItem);

        return "redirect:/dashboard";
    }

    // DELETE
    @PostMapping("/items/{id}/delete")
    public String deleteItem(
            @PathVariable("id") Long id,
            HttpSession session) {

        Long userId = loggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Item item = itemService.findItem(id);

        if (item != null
                && item.getOwner().getId().equals(userId)) {
            itemService.deleteItem(id);
        }

        return "redirect:/dashboard";
    }
}
