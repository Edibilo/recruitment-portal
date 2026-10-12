package iki.mashad.controller;

import iki.mashad.service.RoleService;
import iki.mashad.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("profile")
    public String getProfile(Model model){
        model.addAttribute("profile",userService.profile());
        return "get-profile";
    }

    @GetMapping("profile/edit")
    public String editProfile(Model model){
        model.addAttribute("user",userService.findLoggedInUserById());
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-register";
    }

    @GetMapping
    public String getAllUser(Model model){
        model.addAttribute("users",userService.getAllUsers());
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-user";
    }

    @GetMapping("{userId}/edit")
    public String editUser(@PathVariable Long userId,Model model){
        model.addAttribute("user",userService.findUserById(userId));
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-register";
    }

    @GetMapping("{userId}/delete")
    public String deleteUser(@PathVariable Long userId,Model model){
        userService.deleteUser(userId);
        model.addAttribute("users",userService.getAllUsers());
        return "redirect:/api/v1/users";
    }
}
