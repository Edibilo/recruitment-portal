package iki.mashad.mapper;

import iki.mashad.dto.ApplicationDto;
import iki.mashad.entity.Application;

public class ApplicationMapper {

    public static Application mapToApplication(ApplicationDto applicationDto){
        Application application=new Application();
        application.setResume(applicationDto.getResume());
        application.setStatus(applicationDto.getStatus());
        return application;
    }

    public static ApplicationDto mapToApplicationDto(Application application){
        ApplicationDto applicationDto=new ApplicationDto();
        applicationDto.setApplicantId(application.getApplicant().getId());
        applicationDto.setId(application.getId());
        applicationDto.setResume(application.getResume());
        applicationDto.setStatus(application.getStatus());
        applicationDto.setJobId(application.getJob().getId());
        applicationDto.setApplicantName(application.getApplicant().getUsername());
        applicationDto.setJobName(application.getJob().getName());
        return applicationDto;
    }
}
