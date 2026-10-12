package iki.mashad.service.impl;

import iki.mashad.dto.ApplicationProjectionDto;
import iki.mashad.dto.DashboardDto;
import iki.mashad.entity.User;
import iki.mashad.repository.ApplicationRepository;
import iki.mashad.repository.JobRepository;
import iki.mashad.repository.UserRepository;
import iki.mashad.service.DashboardService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;

    public DashboardServiceImpl(UserRepository userRepository, JobRepository jobRepository, ApplicationRepository applicationRepository) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    public DashboardDto getDashboard() {
        DashboardDto dashboardDto=new DashboardDto();
        dashboardDto.setTotalUser(userRepository.totalUser());
        dashboardDto.setTotalAdmin(userRepository.totalAdmin());
        dashboardDto.setTotalRecruiter(userRepository.totalRecruiter());
        dashboardDto.setTotalApplicant(userRepository.totalApplicant());
        dashboardDto.setTotalJob(jobRepository.totalJob());
        dashboardDto.setTotalApplication(applicationRepository.totalApplication());
        dashboardDto.setPendingApplication(applicationRepository.totalPending());
        dashboardDto.setInProgressApplication(applicationRepository.totalInProgress());
        dashboardDto.setSuccessApplication(applicationRepository.totalSelect());
        dashboardDto.setRejectApplication(applicationRepository.totalReject());
        return dashboardDto;
    }

    @Override
    public List<ApplicationProjectionDto> getApplicantApplications() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User applicant=userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        return applicationRepository.getApplicantApplications(applicant.getId());
    }

    @Override
    public List<ApplicationProjectionDto> getAllApplication() {
        return applicationRepository.getAllApplications();
    }
}
