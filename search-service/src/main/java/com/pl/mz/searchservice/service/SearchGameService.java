package com.pl.mz.searchservice.service;

import com.pl.mz.searchservice.entity.SearchGameEntity;

public interface SearchGameService {
    SearchGameEntity getGamesBySearchString(String search, Long userId);
}
