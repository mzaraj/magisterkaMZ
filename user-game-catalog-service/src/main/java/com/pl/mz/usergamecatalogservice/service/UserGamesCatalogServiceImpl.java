package com.pl.mz.usergamecatalogservice.service;

import com.pl.mz.usergamecatalogservice.entity.GameEntity;
import com.pl.mz.usergamecatalogservice.entity.RatingEntity;
import com.pl.mz.usergamecatalogservice.entity.UserEntity;
import com.pl.mz.usergamecatalogservice.entity.UserGamesCatalog;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserGamesCatalogServiceImpl implements UserGamesCatalogService {

    RestTemplate restTemplate;

    @Override
    public UserGamesCatalog getGameCatalogByUserId(Long userId) {
        UserEntity user = restTemplate.getForObject("http://user-service/user/" + userId,UserEntity.class);

        ResponseEntity<RatingEntity[]> userRatings =  restTemplate.getForEntity("http://ratings-service/rating/user-id/" + userId, RatingEntity[].class);
        List<RatingEntity> ratings = Arrays.asList(userRatings.getBody());


        List<GameEntity> gameList = ratings.stream().map(r -> {
            GameEntity gameEntity = restTemplate.getForObject("http://game-info-service/info/game/" + r.getGameId(), GameEntity.class);
            if(gameEntity != null)
                gameEntity.setRating(r.getRating());
            return gameEntity;
        }).collect(Collectors.toList());

        return new UserGamesCatalog(user, gameList);
    }


}
