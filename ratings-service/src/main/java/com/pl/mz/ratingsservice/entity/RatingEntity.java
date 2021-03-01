package com.pl.mz.ratingsservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(RatingId.class)
public class RatingEntity {

    @Id
    private Long gameId;

    @Id
    private Long userId;

    private Integer rating;

    public RatingEntity() {
    }

    public RatingEntity(Long gameId, Long userId, Integer rating) {
        this.gameId = gameId;
        this.userId = userId;
        this.rating = rating;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
