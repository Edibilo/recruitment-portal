package iki.mashad.repository;

import iki.mashad.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job,Long> {

    @Query("Select count(*) from Job ")
    int totalJob();
}
