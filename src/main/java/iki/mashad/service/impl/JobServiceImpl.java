package iki.mashad.service.impl;

import iki.mashad.dto.JobDto;
import iki.mashad.entity.Job;
import iki.mashad.mapper.JobMapper;
import iki.mashad.repository.JobRepository;
import iki.mashad.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobDto createJob(JobDto jobDto) {
        Job job= JobMapper.mapToJob(jobDto);
        Job savedJob=jobRepository.save(job);
        return JobMapper.mapToJobDto(savedJob);
    }

    @Override
    public List<JobDto> getAllJob() {
        List<Job> jobs=jobRepository.findAll();
        return jobs.stream().map(JobMapper::mapToJobDto).collect(Collectors.toList());
    }

    @Override
    public JobDto findJobById(Long jobId) {
        Job job=jobRepository.findById(jobId).orElseThrow(
                () -> new RuntimeException("Job Not Found !")
        );
        return JobMapper.mapToJobDto(job);
    }

    @Override
    public void deleteJob(Long jobId) {
        Job job=jobRepository.findById(jobId).orElseThrow(
                () -> new RuntimeException("Job Not Found !")
        );
        jobRepository.delete(job);
    }
}
