package iki.mashad.dto;

import iki.mashad.enumerator.ApplicationStatus;

public class ApplicationDto {
    private Long id;
    private String resume;
    private ApplicationStatus status;
    private Long jobId;
    private Long applicantId;
    private String applicantName;
    private String jobName;

    public ApplicationDto(Long id, String resume, ApplicationStatus status, Long jobId, Long applicantId,
                          String applicantName, String jobName) {
        this.id = id;
        this.resume = resume;
        this.status = status;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.jobName = jobName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public ApplicationDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}
