package com.pl.mz.ratingsservice.service;

import com.pl.mz.ratingsservice.entity.RatingEntity;
import com.pl.mz.ratingsservice.entity.RatingId;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    //ask about optional, sometimes could be null if we use different implementation from e.g. dear Indian friend ?
    List<RatingEntity> getGamesRatingByUserId(Long userId);

    Optional<RatingEntity>  getById(RatingId id);

    List<RatingEntity> getAllRatings();

    RatingEntity addNewRating(RatingEntity newRating);

    boolean deleteRating(RatingEntity id);

    RatingEntity editRating(RatingEntity editRating);

    boolean initRating();

}
