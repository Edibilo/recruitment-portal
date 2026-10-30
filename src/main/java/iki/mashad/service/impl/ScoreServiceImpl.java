package iki.mashad.service.impl;

import iki.mashad.dto.ScoreDto;
import iki.mashad.dto.ScoreProjectionDto;
import iki.mashad.entity.Application;
import iki.mashad.entity.Score;
import iki.mashad.entity.User;
import iki.mashad.mapper.ScoreMapper;
import iki.mashad.repository.ApplicationRepository;
import iki.mashad.repository.ScoreRepository;
import iki.mashad.repository.UserRepository;
import iki.mashad.service.ScoreService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository, ApplicationRepository applicationRepository,
                            UserRepository userRepository) {
        this.scoreRepository = scoreRepository;
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
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

    @Override
    public List<ScoreProjectionDto> getScoreAndApplicationByJobId(Long jobId) {
        return scoreRepository.getAllScoreAndApplicationAndApplicantByJobId(jobId);
    }

    @Override
    public List<ScoreProjectionDto> getScoreAndApplicationByApplicantId() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User applicant=userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        return scoreRepository.getAllScoreAndApplicationAndApplicantByApplicantId(applicant.getId());
    }
}
