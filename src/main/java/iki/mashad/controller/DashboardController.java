package iki.mashad.controller;

import iki.mashad.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/dashboards")
@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public String dashboard(Model model){
        model.addAttribute("dashboard",dashboardService.getDashboard());
        model.addAttribute("myApplications",dashboardService.getApplicantApplications());
        model.addAttribute("allApplications",dashboardService.getAllApplication());
        return "get-dashboard";
    }



}
