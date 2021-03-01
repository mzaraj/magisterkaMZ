package com.pl.mz.gameinfoservice.service;

import com.pl.mz.gameinfoservice.entity.GameApiHelper;
import com.pl.mz.gameinfoservice.entity.GameEntity;
import com.pl.mz.gameinfoservice.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameServiceImlp implements GameService {


    GameRepository gameRepository;
    RestTemplate restTemplate;


    @Override
    public Optional<GameEntity> getGameById(Long gameId) {
        if (gameId == 2)
            return Optional.of(new GameEntity());

        else
            return gameRepository.findById(gameId);
    }

    @Override
    public List<GameEntity> getGameByName(String name) {
        List<GameEntity> listOfGame = gameRepository.findAllByNameContaining(name);
        if (listOfGame.isEmpty())
            throw new NullPointerException("Lista jest pusta");

        return listOfGame;
    }

    @Override
    public GameEntity createGame(GameEntity newGame) {
        GameEntity saveGame = gameRepository.save(newGame);

        return saveGame;
    }

    @Override
    public boolean deleteGameById(Long gameId) {
        if (gameRepository.existsById(gameId)) {
            gameRepository.deleteById(gameId);
            return true;
        }
        return false;
    }

    @Override
    public List<GameEntity> getAllGames() {
        List allExistingGames = new ArrayList();
        gameRepository.findAll().forEach(allExistingGames::add);
        return allExistingGames;
    }

    @Override
    public void initDatabase() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "rawg-video-games-database.p.rapidapi.com");
        headers.set("x-rapidapi-key", "154d6314e3mshffb2bb4c2f46ea6p14442djsn7b0ef05a4b0b");
        HttpEntity entity = new HttpEntity(headers);

        String url = "https://api.rawg.io/api/games?page=";
        for (int i = 1; i <= 200; i++) {
            ResponseEntity<GameApiHelper> response = restTemplate.exchange(url + i, HttpMethod.GET, entity, GameApiHelper.class);
            GameApiHelper gameApiHelper = response.getBody();
            gameRepository.saveAll(Arrays.asList(gameApiHelper.getResults()));
        }
    }

    @Override
    public GameEntity editGame(GameEntity incomingGame) {
        GameEntity existingGame = gameRepository.findById(incomingGame.getId()).orElse(null);
        if(existingGame != null){
            incomingGame.setId(existingGame.getId());
            gameRepository.save(incomingGame);
        }
        return incomingGame;
    }
}
