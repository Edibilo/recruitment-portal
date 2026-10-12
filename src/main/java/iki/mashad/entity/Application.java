package iki.mashad.entity;

import iki.mashad.enumerator.ApplicationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resume;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    @ManyToOne
    private Job job;
    @ManyToOne
    private User applicant;

    @PrePersist
    void prePersists(){
        if(status==null){
            status=ApplicationStatus.PENDING;
        }
    }

    public Application(){

    }

    public Application(Long id, String resume, ApplicationStatus status, Job job, User applicant) {
        this.id = id;
        this.resume = resume;
        this.status = status;
        this.job = job;
        this.applicant = applicant;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }
}
