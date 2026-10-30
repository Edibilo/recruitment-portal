package iki.mashad.service;

import iki.mashad.dto.ScoreDto;
import iki.mashad.dto.ScoreProjectionDto;

import java.util.List;

public interface ScoreService {
    ScoreDto createScore(ScoreDto scoreDto);
    List<ScoreProjectionDto> getScoreAndApplicationByJobId(Long jobId);
    List<ScoreProjectionDto> getScoreAndApplicationByApplicantId();
}
