package com.pl.mz.usergamecatalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserGamesCatalog {

    UserEntity user;

    List<GameEntity> games;


}
