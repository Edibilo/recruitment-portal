package iki.mashad.dto;

public class ScoreDto {
    private Long id;
    private double mark;
    private Long applicationId;

    public ScoreDto(Long id, double mark, Long applicationId) {
        this.id = id;
        this.mark = mark;
        this.applicationId = applicationId;
    }

    public ScoreDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
}
