package com.pl.mz.gameinfoservice.entity;

public class GameApiHelper {


    private GameEntity[] results;

    public GameApiHelper(GameEntity[] results) {
        this.results = results;
    }

    public GameApiHelper() {
    }

    public GameEntity[] getResults() {
        return results;
    }
}
