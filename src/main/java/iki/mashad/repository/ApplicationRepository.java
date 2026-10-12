package iki.mashad.repository;

import iki.mashad.dto.ApplicationDto;
import iki.mashad.dto.ApplicationProjectionDto;
import iki.mashad.entity.Application;
import iki.mashad.entity.Job;
import iki.mashad.entity.User;
import iki.mashad.enumerator.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

    boolean existsByJobAndApplicant(Job job, User applicant);

    @Query("Select count(*) from Application")
    int totalApplication();

    @Query("Select count(*) from Application a " +
            "where a.status='Pending' ")
    int totalPending();

    @Query("Select count(*) from Application a " +
            "where a.status='In_progress' ")
    int totalInProgress();

    @Query("Select count(*) from Application a " +
            "where a.status='Rejected' ")
    int totalReject();

    @Query("Select count(*) from Application a " +
            "where a.status='Selected' ")
    int totalSelect();

    @Query("Select new iki.mashad.dto.ApplicationProjectionDto(a.id,a.status,j.name,ap.username) from Application a " +
            "join a.job j " +
            "join a.applicant ap " +
            "where ap.id=:applicantId")
    List<ApplicationProjectionDto> getApplicantApplications(Long applicantId);

    @Query("Select new iki.mashad.dto.ApplicationProjectionDto(a.id,a.status,j.name,ap.username) from Application a " +
            "join a.job j " +
            "join a.applicant ap ")
    List<ApplicationProjectionDto> getAllApplications();

    @Query("Select new iki.mashad.dto.ApplicationProjectionDto(a.id,a.status,j.name,ap.username) from Application a " +
            "join a.job j " +
            "join a.applicant ap " +
            "where j.id=:jobId")
    List<ApplicationProjectionDto> getApplicationsByJobId(Long jobId);

    ApplicationDto findApplicationByIdAndStatus(Long applicationId, ApplicationStatus status);


}
