package iki.mashad.mapper;

import iki.mashad.dto.ScoreDto;
import iki.mashad.entity.Score;

public class ScoreMapper {

    public static Score mapToScore(ScoreDto scoreDto){
        Score score=new Score();
        score.setId(scoreDto.getId());
        score.setMark(scoreDto.getMark());
        return score;
    }

    public static ScoreDto mapToScoreDto(Score score){
        ScoreDto scoreDto=new ScoreDto();
        scoreDto.setId(score.getId());
        scoreDto.setMark(score.getMark());
        scoreDto.setApplicationId(score.getApplication().getId());
        return scoreDto;
    }
}
