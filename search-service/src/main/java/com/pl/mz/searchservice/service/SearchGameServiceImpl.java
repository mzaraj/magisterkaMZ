package com.pl.mz.searchservice.service;

import com.pl.mz.searchservice.entity.GameEntity;
import com.pl.mz.searchservice.entity.RatingEntity;
import com.pl.mz.searchservice.entity.SearchGameEntity;
import com.pl.mz.searchservice.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SearchGameServiceImpl implements SearchGameService {

    RestTemplate restTemplate;

    @Override
    public SearchGameEntity getGamesBySearchString(String search, Long userId) {
        UserEntity user = restTemplate.getForObject("http://user-service/user/" + userId,UserEntity.class);

        ResponseEntity<RatingEntity[]> ratingResponse =  restTemplate.getForEntity("http://ratings-service/rating/user-id/" + userId, RatingEntity[].class);
        Map<Long, RatingEntity> ratingsMap = Arrays.stream(ratingResponse.getBody())
                .collect(Collectors.toMap(RatingEntity::getGameId, Function.identity()));


        ResponseEntity<GameEntity[]> gameResponse =  restTemplate.getForEntity("http://game-info-service/info/game/search?string=" + search,GameEntity[].class);

        List<GameEntity> gameList = Arrays.asList(gameResponse.getBody());

        gameList.stream().forEach(g -> g.setRating(ratingsMap.getOrDefault(g.getId(),new RatingEntity()).getRating()));

        return new SearchGameEntity(search, user,gameList);


    }
}
