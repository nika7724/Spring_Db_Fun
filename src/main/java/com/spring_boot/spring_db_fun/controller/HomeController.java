package com.spring_boot.spring_db_fun.controller;

import com.spring_boot.spring_db_fun.model.User;
import com.spring_boot.spring_db_fun.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController { //controller is middle man between view and entity

    @Autowired //dependency injection to use UserService class
    private UserService userService;

    @GetMapping("/") //starting from here, get the mapping for index page
    public String index(Model model) {
        List<User> userList = userService.fetchAll(); //create the list of users @fetchAll() - add them to the model
        model.addAttribute("users", userList);
        return "home/index";
    }

    @GetMapping("/addUser")
        public String add() {
        return "home/addUser";
        }
    //from addUser page - posts the new user into the model(table)
    //redirects to index page
    @PostMapping("/addUser")
            public String addUser(@ModelAttribute User user) {
                userService.addUser(user);
                return "redirect:/";
            }

    //get the mapping for viewUser page
    //returns user via id
            @GetMapping("viewUser/{id}")
    public String viewUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "home/viewUser";
            }

    //deletes user via id
            @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        boolean deleted = userService.deleteUser(id);
                  return "redirect:/";
        }

    //get the mapping for editUser page
    //returns user via id
            @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "home/editUser";
            }

    //from editUser page - posts the edited user into the model(table)
    //redirects to index page
            @PostMapping("/edit")
    public String edit(@ModelAttribute User user) {
        userService.updateUser(user.getUserID(), user);
        return "redirect:/";
            }

        }


