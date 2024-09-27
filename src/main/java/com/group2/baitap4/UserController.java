package com.group2.baitap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        userService.saveOrUpdate(user);
        System.out.println("Added user!");
        System.out.println("FirstName: " + user.getFirstName());
        System.out.println("LastName: " + user.getLastName());
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String userList(Model model) {
        Iterable<UserModel> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/user/detail/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        UserModel user = userService.getUserById(id);
        model.addAttribute("users", user);
        return "userDetail";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        UserModel user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "userUpdate";
    }

    @PostMapping("/user/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, @ModelAttribute("user") UserModel user, UserModel model) {
        user.setId(id);
        userService.updateUser(user);
        System.out.println("Updated user!");
        return "redirect:/user";
    }

    @PostMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        System.out.println("Deleted user!");
        return "redirect:/user";
    }
}