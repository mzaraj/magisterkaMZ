package com.pl.mz.searchservice.entity;

import lombok.Data;

@Data
public class GameEntity {

    private Long id;

    private String name;

    private Integer metacritic;

    private Integer playtime;

    private String released;

    private Integer rating;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
