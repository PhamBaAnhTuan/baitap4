package com.group2.baitap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public String addUser(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute UserModel user) {
        System.out.println("FirstName: " + user.getFirstName());
        System.out.println("LastName: " + user.getLastName());

        userService.saveOrUpdate(user);
        return "redirect:/userList";
    }

    @GetMapping("/userList")
    public String userList(Model model) {
        Iterable<UserModel> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }
}