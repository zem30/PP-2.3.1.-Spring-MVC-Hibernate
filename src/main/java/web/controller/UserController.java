package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    //Показывает всех User'ов
    @GetMapping
    public String show(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "user/all-user";
    }


    public String addNewEmployee(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user/info-user";
    }


    public String saveUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/user";
    }


    public String updateUser(@RequestParam("empId") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user/info-user";
    }

    //Удаляет User'а
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
