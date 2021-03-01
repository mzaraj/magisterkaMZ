package com.pl.mz.gameinfoservice.repository;

import com.pl.mz.gameinfoservice.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<GameEntity,Long> {

    List<GameEntity> findAllByNameContaining(String name);


}
