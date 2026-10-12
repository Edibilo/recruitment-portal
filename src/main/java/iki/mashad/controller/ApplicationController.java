package iki.mashad.controller;

import iki.mashad.dto.JobDto;
import iki.mashad.dto.ScoreDto;
import iki.mashad.enumerator.ApplicationStatus;
import iki.mashad.service.ApplicationService;
import iki.mashad.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ScoreService scoreService;

    public ApplicationController(ApplicationService applicationService, ScoreService scoreService) {
        this.applicationService = applicationService;
        this.scoreService = scoreService;
    }

    @GetMapping("{applicationId}/{status}/status")
    public String updateApplicationStatus(@PathVariable Long applicationId,
                                          @PathVariable ApplicationStatus status, Model model){
        applicationService.updateApplicationStatus(applicationId,status);
        model.addAttribute("job",new JobDto());
        return "redirect:/api/v1/jobs";
    }

    @GetMapping("{applicationId}/score")
    public String getScore(@PathVariable Long applicationId,Model model){
        model.addAttribute("score",new ScoreDto());
        model.addAttribute("applicationDetails",applicationService.getApplicationById(applicationId));
        return "get-score";
    }

    @PostMapping("{applicationId}/score")
    public String saveScore(@ModelAttribute ScoreDto scoreDto, @PathVariable Long applicationId, RedirectAttributes redirectAttributes){
        String string;
        try{
            scoreDto.setApplicationId(applicationId);
            scoreService.createScore(scoreDto);
            redirectAttributes.addFlashAttribute("success","Saved !");
            string="redirect:/api/v1/jobs";
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail",exception.getMessage());
            string="redirect:/api/v1/jobs";
        }

        return string;
    }

}
