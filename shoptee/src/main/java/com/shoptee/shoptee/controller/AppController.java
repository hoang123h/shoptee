package com.shoptee.shoptee.controller;

import com.shoptee.shoptee.entity.Role;
import com.shoptee.shoptee.entity.User;
import com.shoptee.shoptee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String viewHomePage() {
        return "home/index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "home/signup_form";
    }

    @PostMapping("process_register")
    public String processRegister(User user) {
        userService.registerDefaultUser(user);
        return "home/register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "home/users";
    }

    @GetMapping("users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.get(id);
        List<Role> listRoles = userService.listRole();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "home/user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("users/new")
    public String newUser(Model model){
        List<Role> listRoles = userService.listRole();
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("listRole",listRoles);
        return "home/user_add";
    }
    @GetMapping("users/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/403")
    public String error403(){
        return "home/403";
    }
}
