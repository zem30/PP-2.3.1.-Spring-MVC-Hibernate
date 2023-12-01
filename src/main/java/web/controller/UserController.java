package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUser(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "user/all-user";
    }


    @GetMapping("/new")
    public String NewUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new-user";
    }

    @PostMapping("/saveUser")
    public String creatUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "user/info-user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@RequestParam("user") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
