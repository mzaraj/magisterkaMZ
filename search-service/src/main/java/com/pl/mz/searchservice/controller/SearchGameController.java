package com.pl.mz.searchservice.controller;

import com.pl.mz.searchservice.service.SearchGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@RestController
@AllArgsConstructor
@RequestMapping("/search")
public class SearchGameController {

    SearchGameService searchGameService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getGamesBySearchString(@RequestParam("search") String search, @PathVariable Long userId){
        return ResponseEntity.ok(searchGameService.getGamesBySearchString(search, userId));
    }
}
