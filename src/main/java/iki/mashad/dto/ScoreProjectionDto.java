package iki.mashad.dto;

import iki.mashad.enumerator.ApplicationStatus;

public class ScoreProjectionDto {
    private Long scoreId;
    private double mark;
    private ApplicationStatus applicationStatus;
    private String jobName;
    private String applicantName;
    private Long applicationId;

    public ScoreProjectionDto(Long scoreId, double mark, ApplicationStatus applicationStatus,
                              String jobName, String applicantName, Long applicationId) {
        this.scoreId = scoreId;
        this.mark = mark;
        this.applicationStatus = applicationStatus;
        this.jobName = jobName;
        this.applicantName = applicantName;
        this.applicationId = applicationId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public ScoreProjectionDto(){

    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
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
