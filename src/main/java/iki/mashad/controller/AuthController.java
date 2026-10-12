package iki.mashad.controller;

import iki.mashad.dto.UserDto;
import iki.mashad.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("register")
    public String getUser(Model model){
        model.addAttribute("user",new UserDto());
        return "get-register";
    }

    @PostMapping("register")
    public String registerUser(@ModelAttribute UserDto userDto, RedirectAttributes redirectAttributes){
        String string;
        try{
            authService.register(userDto);
            redirectAttributes.addFlashAttribute("success","Saved");
            string="redirect:/api/v1/users/profile";
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail", exception.getMessage());
            string="redirect:/api/v1/auth/login";
        }
        return string ;
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }


}
