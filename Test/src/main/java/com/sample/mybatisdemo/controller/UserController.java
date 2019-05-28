package com.sample.mybatisdemo.controller;


import com.sample.mybatisdemo.domain.User;
import com.sample.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public String listUsers(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/";
    }

  
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public  List<User> listUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @ResponseBody
    @RequestMapping(value="/{userId}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public User findUser(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        userService.insertUser(user);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.PUT)
    public String deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }
}
