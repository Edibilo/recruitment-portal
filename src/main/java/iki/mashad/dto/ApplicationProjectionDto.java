package iki.mashad.dto;

import iki.mashad.enumerator.ApplicationStatus;

public class ApplicationProjectionDto {
    private Long applicationId;
    private ApplicationStatus applicationStatus;
    private String jobName;
    private String applicantName;

    public ApplicationProjectionDto(Long applicationId, ApplicationStatus applicationStatus,
                                    String jobName, String applicantName) {
        this.applicationId = applicationId;
        this.applicationStatus = applicationStatus;
        this.jobName = jobName;
        this.applicantName = applicantName;
    }

    public ApplicationProjectionDto(){

    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
}
