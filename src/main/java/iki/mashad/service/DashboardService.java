package iki.mashad.service;

import iki.mashad.dto.ApplicationProjectionDto;
import iki.mashad.dto.DashboardDto;

import java.util.List;

public interface DashboardService {
    DashboardDto getDashboard();
    List<ApplicationProjectionDto> getApplicantApplications();
    List<ApplicationProjectionDto> getAllApplication();

}
