package com.pl.mz.gameinfoservice.controller;

import com.pl.mz.gameinfoservice.AuthoritiesConstants;
import com.pl.mz.gameinfoservice.entity.GameEntity;
import com.pl.mz.gameinfoservice.entity.una;
import com.pl.mz.gameinfoservice.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info/game")
@AllArgsConstructor
public class GameInfoController {

    GameService gameService;


    @GetMapping("/init")
    public ResponseEntity<Void> loadDataToDatabase(){
        gameService.initDatabase();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<?> getGameById(@PathVariable Long gameId) {
        una una = new una();
        List mlist = new ArrayList();
        mlist.add(una);

//        return gameService.getGameById(gameId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//return ResponseEntity.status("dnksjadsakj", HttpStatus.UNAUTHORIZED).build();
//        String token= "wutOMZ68y7dNN1f8wz1UZCZSAyH123M5ldvxfFYw6Qo2uiQyi8gHZb4brXsiMxKQToQ4lwR0A7O9esHCQrVynLjhHxs1CpH8HcbSH5dsTVN5gN8WHZtocw5CcxC2k6tNoSeuWQN17MtUvJXwH4rlyu4N4w2GWGs4q0Cwv1S3SKQ5d7Yl9d1v0Zn0f3lpKeXgnQekyurB";
//return new ResponseEntity<>( mlist.get(0), null, HttpStatus.UNAUTHORIZED);
return new ResponseEntity<>( mlist.get(0), null, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameEntity>> getAllGames(){
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/search")
    public ResponseEntity<?> getGameBySearchString(@RequestParam("string") String searchString) {
        List<GameEntity> listOfGame = gameService.getGameByName(searchString);
        if (listOfGame.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(listOfGame);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createNewGameInGameInfo(@RequestBody GameEntity newGame) {
        GameEntity createdGame = gameService.createGame(newGame);
        if (createdGame == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return ResponseEntity.ok(newGame);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<?> deleteGameById(@PathVariable Long gameId) {
        if (gameService.deleteGameById(gameId))
            return ResponseEntity.ok("Usunieto gre");
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editGame(@RequestBody GameEntity incomingGame){
        GameEntity editedGame = gameService.editGame(incomingGame);
        if(editedGame != null)
            return ResponseEntity.ok(editedGame);
        return ResponseEntity.notFound().build();
    }


}
