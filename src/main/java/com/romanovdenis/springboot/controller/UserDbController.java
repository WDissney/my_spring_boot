package com.romanovdenis.springboot.controller;

import com.romanovdenis.springboot.model.User;
import com.romanovdenis.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserDbController {
    final private UserService userService;
    @Autowired
    public UserDbController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers (Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "usersAll";
    }
    @GetMapping ("deleteUser/{id}")
    public String removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
        return "redirect:/";
    }
    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        return "addUser";
    }
    @PostMapping("/add")
    public String addUserInDB(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUserId(id));
        return "edit";
    }

    @PostMapping("/updateUser")
    public String update (@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
}
