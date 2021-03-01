package com.pl.mz.usergamecatalogservice.controller;

import com.pl.mz.usergamecatalogservice.entity.UserGamesCatalog;
import com.pl.mz.usergamecatalogservice.service.UserGamesCatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
@AllArgsConstructor
public class UserGamesController {

    UserGamesCatalogService userGameCatalogService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserGamesCatalog> getGameCatalogByUserId(@PathVariable Long userId){
        return ResponseEntity.ok( userGameCatalogService.getGameCatalogByUserId(userId));
    }
}
