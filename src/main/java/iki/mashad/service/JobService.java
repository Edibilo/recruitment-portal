package iki.mashad.service;

import iki.mashad.dto.JobDto;

import java.util.List;

public interface JobService {
    JobDto createJob(JobDto jobDto);
    List<JobDto> getAllJob();
    JobDto findJobById(Long jobId);
    void deleteJob(Long jobId);
}
