package iki.mashad.service.impl;

import iki.mashad.dto.ScoreDto;
import iki.mashad.entity.Application;
import iki.mashad.entity.Score;
import iki.mashad.mapper.ScoreMapper;
import iki.mashad.repository.ApplicationRepository;
import iki.mashad.repository.ScoreRepository;
import iki.mashad.service.ScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;
    private final ApplicationRepository applicationRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository, ApplicationRepository applicationRepository) {
        this.scoreRepository = scoreRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ScoreDto createScore(ScoreDto scoreDto) {
        Application application=applicationRepository.findById(scoreDto.getApplicationId()).orElseThrow(
                () -> new RuntimeException("Application Not Found!")
        );
        Score score=new Score();
        score.setMark(scoreDto.getMark());
        score.setApplication(application);
        Score savedScore=scoreRepository.save(score);
        return ScoreMapper.mapToScoreDto(savedScore);
    }
}
