package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.servise.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        System.out.println(userService.getUsers());
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/addUser")
    public String addMessage(@RequestParam("addString") String addString) {
        String[] strings = addString.split(",");
        userService.addUser(new User(strings[0], strings[1], strings[2]));
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteMessage(@RequestParam("id") String stringId) {
        int id = Integer.parseInt(stringId);
        userService.deleteUser(userService.getUser(id));
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateMessage(@RequestParam("updateString") String updateString) {
        String[] strings = updateString.split(",");
        User newUser = userService.getUser(Integer.parseInt(strings[0]));
        newUser.setUsername(strings[1]);
        newUser.setPassword(strings[2]);
        newUser.setEmail(strings[3]);
        userService.updateUser(newUser);
        return "redirect:/";
    }
}
