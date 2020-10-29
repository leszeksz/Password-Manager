package com.leszeksz.passwordmanager.web;

import com.leszeksz.passwordmanager.entity.User;
import com.leszeksz.passwordmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String formAdd(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult validation) {
        if (validation.hasErrors()){
            return "signup";
        }
        userService.save(user);
        return "index";
    }
}