package iki.mashad.mapper;

import iki.mashad.dto.JobDto;
import iki.mashad.entity.Job;

public class JobMapper {
    public static Job mapToJob(JobDto jobDto){
        Job job=new Job();
        job.setDeadline(jobDto.getDeadline());
        job.setId(jobDto.getId());
        job.setDescription(jobDto.getDescription());
        job.setName(jobDto.getName());
        return job;
    }

    public static JobDto mapToJobDto(Job job){
        JobDto jobDto=new JobDto();
        jobDto.setDeadline(job.getDeadline());
        jobDto.setDescription(job.getDescription());
        jobDto.setName(job.getName());
        jobDto.setId(job.getId());
        jobDto.setCreatedAt(job.getCreatedAt());
        return jobDto;
    }
}
