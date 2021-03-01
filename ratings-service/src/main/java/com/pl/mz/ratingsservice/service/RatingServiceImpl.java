package com.pl.mz.ratingsservice.service;

import com.pl.mz.ratingsservice.entity.RatingEntity;
import com.pl.mz.ratingsservice.entity.RatingId;
import com.pl.mz.ratingsservice.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;

    @Override
    public List<RatingEntity> getGamesRatingByUserId(Long userId) {
        return ratingRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<RatingEntity> getById(RatingId id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<RatingEntity> getAllRatings() {
        List<RatingEntity> allRatings = new ArrayList<>();
        ratingRepository.findAll().forEach(allRatings::add);
        return allRatings;
    }

    @Override
    public RatingEntity addNewRating(RatingEntity newRating) {
        return ratingRepository.save(newRating);
    }


    @Override
    public boolean deleteRating(RatingEntity ratingEntity) {
        RatingId id = new RatingId(ratingEntity.getUserId(),ratingEntity.getGameId());
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public RatingEntity editRating(RatingEntity editRating) {
        RatingEntity existingRating = ratingRepository.findById(new RatingId(editRating.getGameId(), editRating.getUserId())).orElse(null);
        if (existingRating != null) {
            existingRating.setRating(editRating.getRating());
            ratingRepository.save(existingRating);
        }
        return existingRating;
    }

    @Override
    public boolean initRating() {
        try {
            List<RatingEntity> ratings = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                long userId = Math.round(Math.random() * 50 + 1);
                long bookId = Math.round(Math.random() * 3710 + 1);
                int rating = (int) (Math.random() * 5 + 1);
                ratings.add(new RatingEntity(userId, bookId, rating));
            }
            ratingRepository.saveAll(ratings);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
