package iki.mashad.service.impl;

import iki.mashad.dto.ApplicationDto;
import iki.mashad.dto.ApplicationProjectionDto;
import iki.mashad.entity.Application;
import iki.mashad.entity.Job;
import iki.mashad.entity.User;
import iki.mashad.enumerator.ApplicationStatus;
import iki.mashad.mapper.ApplicationMapper;
import iki.mashad.repository.ApplicationRepository;
import iki.mashad.repository.JobRepository;
import iki.mashad.repository.UserRepository;
import iki.mashad.service.ApplicationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, UserRepository userRepository,
                                  JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public ApplicationDto applyJob(ApplicationDto applicationDto) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User applicant=userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        Job job=jobRepository.findById(applicationDto.getJobId()).orElseThrow(
                () -> new RuntimeException("Job Not Found !")
        );
        if(applicationRepository.existsByJobAndApplicant(job,applicant)){
            throw new RuntimeException("Job Already Applied !");
        }
        Application application=new Application();
        application.setApplicant(applicant);
        application.setResume(applicationDto.getResume());
        application.setStatus(applicationDto.getStatus());
        application.setJob(job);
        Application savedApplication=applicationRepository.save(application);
        return ApplicationMapper.mapToApplicationDto(savedApplication);
    }

    @Override
    public List<ApplicationProjectionDto> getApplicationsByJobId(Long jobId) {
        return applicationRepository.getApplicationsByJobId(jobId);
    }

    @Override
    public ApplicationDto updateApplicationStatus(Long applicationId, ApplicationStatus status) {
        Application application=applicationRepository.findById(applicationId).orElseThrow(
                () -> new RuntimeException("Application Not Found !")
        );
        application.setStatus(status);
        Application savedApplication=applicationRepository.save(application);
        return ApplicationMapper.mapToApplicationDto(savedApplication);
    }

    @Override
    public ApplicationDto getApplicationById(Long applicationId) {
        Application application=applicationRepository.findById(applicationId).orElseThrow(
                () -> new RuntimeException("Application Not Found !")
        );
        return ApplicationMapper.mapToApplicationDto(application);
    }
}
