package iki.mashad.controller;

import iki.mashad.dto.ApplicationDto;
import iki.mashad.dto.JobDto;
import iki.mashad.enumerator.ApplicationStatus;
import iki.mashad.service.ApplicationService;
import iki.mashad.service.JobService;
import iki.mashad.service.ScoreService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("api/v1/jobs")
public class JobController {

    private final JobService jobService;
    private final ApplicationService applicationService;
    private final ScoreService scoreService;

    public JobController(JobService jobService, ApplicationService applicationService, ScoreService scoreService) {
        this.jobService = jobService;
        this.applicationService = applicationService;
        this.scoreService = scoreService;
    }

    @GetMapping()
    public String getJob(Model model){
        model.addAttribute("job",new JobDto());
        model.addAttribute("jobs",jobService.getAllJob());
        return "get-job";
    }

    @PostMapping()
    public String saveJob(JobDto jobDto, RedirectAttributes redirectAttributes){
        String string;
        try {
            jobService.createJob(jobDto);
            redirectAttributes.addFlashAttribute("success","Saved !");
            string="redirect:/api/v1/jobs";
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail","Enter Valid Entry !");
            string="redirect:/api/v1/jobs";
        }
       return string;
    }

    @GetMapping("{jobId}/edit")
    public String editJob(Model model,@PathVariable Long jobId){
        model.addAttribute("job",jobService.findJobById(jobId));
        model.addAttribute("jobs",jobService.getAllJob());
        return "get-job";
    }

    @GetMapping("{jobId}/delete")
    public String deleteJob(@PathVariable Long jobId){
        jobService.deleteJob(jobId);
      return "redirect:/api/v1/jobs";
    }

    @GetMapping("{jobId}/apply")
    public String getApplication(@PathVariable Long jobId, Model model){
        model.addAttribute("application",new ApplicationDto());
        model.addAttribute("job",jobService.findJobById(jobId));
        return "get-application";
    }

    @PostMapping("{jobId}/apply")
    public String saveApplication(@ModelAttribute ApplicationDto applicationDto,
                                  @PathVariable Long jobId,RedirectAttributes redirectAttributes){
        String string;
        try{
            applicationDto.setJobId(jobId);
            applicationService.applyJob(applicationDto);
            string= "redirect:/api/v1/dashboards";
            redirectAttributes.addFlashAttribute("success","Saved !");
        }catch (Exception exception){
            redirectAttributes.addFlashAttribute("fail",exception.getMessage());
            string= "redirect:/api/v1/jobs";
        }

        return string;
    }

    @GetMapping("{jobId}/applications")
    public String getApplicationsByJobId(@PathVariable Long jobId,Model model){
        model.addAttribute("applicationsByJobId",applicationService.getApplicationsByJobId(jobId));
        model.addAttribute("job",jobService.findJobById(jobId));
        model.addAttribute("statuses", ApplicationStatus.values());
        model.addAttribute("application",new ApplicationDto());
        return "get-application";
    }

    @GetMapping("{jobId}/score")
    public String getScoreApplicationByJobId(@PathVariable Long jobId,Model model){
        model.addAttribute("scoresByJobId",scoreService.getScoreAndApplicationByJobId(jobId));
        model.addAttribute("job",jobService.findJobById(jobId));
        model.addAttribute("statuses", ApplicationStatus.values());
        model.addAttribute("application",new ApplicationDto());
        return "get-application";
    }

}
