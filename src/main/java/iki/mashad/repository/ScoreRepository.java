package iki.mashad.repository;

import iki.mashad.dto.ScoreProjectionDto;
import iki.mashad.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {

    @Query("Select new iki.mashad.dto.ScoreProjectionDto(s.id,s.mark,a.status,j.name,ap.username,a.id) " +
            "from Score s " +
            "join s.application a " +
            "join a.job j " +
            "join a.applicant ap " +
            "where j.id=:jobId ")
    List<ScoreProjectionDto> getAllScoreAndApplicationAndApplicantByJobId(Long jobId);

    @Query("Select new iki.mashad.dto.ScoreProjectionDto(s.id,s.mark,a.status,j.name,ap.username,a.id) " +
            "from Score s " +
            "join s.application a " +
            "join a.job j " +
            "join a.applicant ap " +
            "where ap.id=:applicantId ")
    List<ScoreProjectionDto> getAllScoreAndApplicationAndApplicantByApplicantId(Long applicantId);
}
