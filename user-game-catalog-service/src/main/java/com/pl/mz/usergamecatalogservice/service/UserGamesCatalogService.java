package com.pl.mz.usergamecatalogservice.service;

import com.pl.mz.usergamecatalogservice.entity.UserGamesCatalog;

public interface UserGamesCatalogService {
    UserGamesCatalog getGameCatalogByUserId(Long userId);
}
