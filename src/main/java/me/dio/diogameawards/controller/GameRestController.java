package me.dio.diogameawards.controller;

import me.dio.diogameawards.controller.games.BaseRestController;
import me.dio.diogameawards.domain.model.Game;
import me.dio.diogameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameRestController extends BaseRestController {
    @Autowired
    private GameService gameService;

    @GetMapping("games")
    public ResponseEntity<List<Game>> findAll(){
        List<Game> games = gameService.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("games/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        Game game = gameService.findById(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping("games")
    public ResponseEntity<Game> insert(@RequestBody Game game){
        gameService.insert(game);
        return ResponseEntity.ok(game);
    }
    @PutMapping("games/{id}")
    public ResponseEntity<Game> insert(@PathVariable Long id, @RequestBody Game game){
        gameService.update(id, game);
        return ResponseEntity.ok(game);
    }

    @PatchMapping("games/{id}/vote")
    public ResponseEntity<Game> insert(@PathVariable Long id){
        gameService.vote(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("games/{id}")
    public ResponseEntity<Game> delete(@PathVariable Long id){
        gameService.delete(id);
        return ResponseEntity.ok().build();
    }

}
