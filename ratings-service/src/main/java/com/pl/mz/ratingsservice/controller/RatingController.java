package com.pl.mz.ratingsservice.controller;


import com.pl.mz.ratingsservice.entity.RatingEntity;
import com.pl.mz.ratingsservice.entity.RatingId;
import com.pl.mz.ratingsservice.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {

    RatingService ratingService;



    @GetMapping("/user-id/{userId}")
    public ResponseEntity<?> getGamesRatingByUserId(@PathVariable Long userId) {
        List<RatingEntity> ratingList = ratingService.getGamesRatingByUserId(userId);
        if (ratingList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/user-id/{userId}/game-id/{gameId}")
    public ResponseEntity<?> getGameById(@PathVariable Long userId, @PathVariable Long gameId) {
        return ratingService.getById(new RatingId(userId, gameId)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<RatingEntity>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewRating(@RequestBody RatingEntity ratingEntity) {
        RatingEntity createdRating = ratingService.addNewRating(ratingEntity);
        if (createdRating == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(createdRating);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRating(@RequestBody RatingEntity ratingEntity) {
        if (ratingService.deleteRating(ratingEntity))
            return ResponseEntity.ok().build();

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editRating(@RequestBody RatingEntity editRating) {
        RatingEntity editedRating = ratingService.editRating(editRating);
        if (editedRating != null)
            return ResponseEntity.ok(editedRating);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/init")
    public ResponseEntity<Void> initRating() {
        if (ratingService.initRating())
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

}
