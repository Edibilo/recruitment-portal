package iki.mashad.service;

import iki.mashad.dto.ApplicationDto;
import iki.mashad.dto.ApplicationProjectionDto;
import iki.mashad.enumerator.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
    ApplicationDto applyJob(ApplicationDto applicationDto);
    List<ApplicationProjectionDto> getApplicationsByJobId(Long jobId);
    ApplicationDto updateApplicationStatus(Long applicationId, ApplicationStatus status);
    ApplicationDto getApplicationById(Long applicationId);
}
