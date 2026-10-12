package iki.mashad.controller;

import iki.mashad.dto.RoleDto;
import iki.mashad.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getRole(Model model){
        model.addAttribute("role",new RoleDto());
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-role";
    }

    @PostMapping
    public String createRole(@ModelAttribute RoleDto roleDto,RedirectAttributes redirectAttributes){
        String string;
        try{
            roleService.createRole(roleDto);
            redirectAttributes.addFlashAttribute("success","Saved !");
            string="redirect:/api/v1/roles";
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail",exception.getMessage());
            string="get-role";
        }
        return string;
    }

    @GetMapping("{roleId}/edit")
    public String getRoleById(@PathVariable Long roleId, Model model){
        model.addAttribute("role",roleService.getRoleById(roleId));
        model.addAttribute("roles",roleService.getAllRoles());
        return "get-role";
    }

    @GetMapping("{roleId}/delete")
    public String deleteRole(@PathVariable Long roleId){
        roleService.delete(roleId);
        return "redirect:/api/v1/roles";
    }
}
