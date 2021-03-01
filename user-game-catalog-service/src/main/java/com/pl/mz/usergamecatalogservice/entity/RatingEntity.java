package com.pl.mz.usergamecatalogservice.entity;

import lombok.Data;

@Data
public class RatingEntity {

    private Long gameId;

    private Long userId;

    private Integer rating;

}
