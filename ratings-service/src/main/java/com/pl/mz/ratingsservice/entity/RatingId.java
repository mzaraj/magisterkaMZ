package com.pl.mz.ratingsservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Data
public class RatingId implements Serializable {

    private Long userId;

    private Long gameId;

    public RatingId(Long userId, Long gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    public RatingId() {
    }
}
