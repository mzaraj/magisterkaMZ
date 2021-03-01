package com.pl.mz.searchservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchGameEntity {

    String search;

    UserEntity user;

    List<GameEntity> games;




    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<GameEntity> getGames() {
        return games;
    }

    public void setGames(List<GameEntity> games) {
        this.games = games;
    }
}
