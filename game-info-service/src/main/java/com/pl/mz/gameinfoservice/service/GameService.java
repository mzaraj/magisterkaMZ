package com.pl.mz.gameinfoservice.service;

import com.pl.mz.gameinfoservice.entity.GameEntity;

import java.util.List;
import java.util.Optional;

public interface GameService {

    public Optional<GameEntity> getGameById(Long gameId);

    List<GameEntity> getGameByName(String name);

    GameEntity createGame(GameEntity newGame);

    boolean  deleteGameById(Long gameId);

    List<GameEntity> getAllGames();

    void initDatabase();

    GameEntity editGame(GameEntity incomingGame);
}
