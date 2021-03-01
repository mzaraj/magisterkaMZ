package com.pl.mz.ratingsservice.repository;

import com.pl.mz.ratingsservice.entity.RatingEntity;
import com.pl.mz.ratingsservice.entity.RatingId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<RatingEntity, RatingId> {

    List<RatingEntity> findAllByUserId(Long userId);

}
