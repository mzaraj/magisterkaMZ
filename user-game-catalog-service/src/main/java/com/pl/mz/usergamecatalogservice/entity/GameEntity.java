package com.pl.mz.usergamecatalogservice.entity;

import lombok.Data;

@Data
public class GameEntity {

    private Long id;

    private String name;

    private Integer metacritic;

    private Integer playtime;

    private String released;

    private Integer rating;
}
