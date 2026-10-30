package iki.mashad.controller;

import iki.mashad.service.DashboardService;
import iki.mashad.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/dashboards")
@Controller
public class DashboardController {

    private final DashboardService dashboardService;
    private final ScoreService scoreService;

    public DashboardController(DashboardService dashboardService, ScoreService scoreService) {
        this.dashboardService = dashboardService;
        this.scoreService = scoreService;
    }

    @GetMapping
    public String dashboard(Model model){
        model.addAttribute("dashboard",dashboardService.getDashboard());
        model.addAttribute("applicantApplications",scoreService.getScoreAndApplicationByApplicantId());
        return "get-dashboard";
    }



}
