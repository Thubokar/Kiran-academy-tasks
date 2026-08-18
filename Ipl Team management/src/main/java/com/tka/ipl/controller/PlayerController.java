package com.tka.ipl.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.ipl.entity.Player;
import com.tka.ipl.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService service;

    // Constructor Injection
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    // =========================================================
    // 1. ADD PLAYER
    // =========================================================

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {

        return service.addPlayer(player);
    }

    // =========================================================
    // 2. FETCH ALL PLAYERS
    // =========================================================

    @GetMapping
    public List<Player> getAllPlayers() {

        return service.getAllPlayers();
    }

    // =========================================================
    // 3. FETCH ALL BATSMAN PLAYERS
    // =========================================================

    @GetMapping("/batsman")
    public List<Player> getAllBatsman() {

        return service.getAllBatsman();
    }

    // =========================================================
    // 4. FETCH ALL BOWLER PLAYERS
    // =========================================================

    @GetMapping("/bowler")
    public List<Player> getAllBowler() {

        return service.getAllBowler();
    }

    // =========================================================
    // 5. FETCH PLAYER BY ID
    // =========================================================

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(
            @PathVariable int id) {

        Player player = service.getPlayerById(id);

        if (player == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    // =========================================================
    // 6. FETCH PLAYERS BY TEAM NAME
    // =========================================================

    @GetMapping("/team/{teamName}")
    public List<Player> getPlayersByTeam(
            @PathVariable String teamName) {

        return service.getPlayersByTeam(teamName);
    }

    // =========================================================
    // 7. FETCH PLAYER WITH HIGHEST SCORE
    // =========================================================

    @GetMapping("/highest-score")
    public Player getHighestScorePlayer() {

        return service.getHighestScorePlayer();
    }

    // =========================================================
    // 8. FETCH PLAYER WITH HIGHEST WICKETS
    // =========================================================

    @GetMapping("/highest-wicket")
    public Player getHighestWicketPlayer() {

        return service.getHighestWicketPlayer();
    }

    // =========================================================
    // 9. UPDATE PLAYER SCORE BY ID
    // =========================================================

    @PutMapping("/{id}/score")
    public ResponseEntity<Player> updateScore(
            @PathVariable int id,
            @RequestParam int score) {

        Player player = service.updateScore(id, score);

        if (player == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    // =========================================================
    // 10. UPDATE PLAYER WICKETS BY ID
    // =========================================================

    @PutMapping("/{id}/wickets")
    public ResponseEntity<Player> updateWickets(
            @PathVariable int id,
            @RequestParam int wickets) {

        Player player = service.updateWickets(id, wickets);

        if (player == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    // =========================================================
    // 11. UPDATE PLAYER TEAM NAME BY ID
    // =========================================================

    @PutMapping("/{id}/team")
    public ResponseEntity<Player> updateTeamName(
            @PathVariable int id,
            @RequestParam String teamName) {

        Player player =
                service.updateTeamName(id, teamName);

        if (player == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    // =========================================================
    // 12. DELETE PLAYER BY ID
    // =========================================================

    @DeleteMapping("/{id}")
    public String deletePlayer(
            @PathVariable int id) {

        return service.deletePlayer(id);
    }

    // =========================================================
    // 13. DELETE PLAYERS BY TEAM NAME
    // =========================================================

    @DeleteMapping("/team/{teamName}")
    public String deletePlayersByTeam(
            @PathVariable String teamName) {

        return service.deletePlayersByTeam(teamName);
    }

    // =========================================================
    // 14. FETCH TOP 3 HIGHEST SCORE PLAYERS
    // =========================================================

    @GetMapping("/top3")
    public List<Player> getTop3HighestScorePlayers() {

        return service.getTop3HighestScorePlayers();
    }

    // =========================================================
    // 15. FETCH ALL-ROUNDER PLAYERS
    // =========================================================

    @GetMapping("/all-rounders")
    public List<Player> getAllRounders() {

        return service.getAllRounders();
    }
}