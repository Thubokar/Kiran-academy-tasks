package com.tka.ipl.service;

import java.util.List;

import com.tka.ipl.entity.Player;

public interface PlayerService {

    // 1. Add Player
    Player addPlayer(Player player);

    // 2. Fetch all Players
    List<Player> getAllPlayers();

    // 3. Fetch all Batsman Players
    List<Player> getAllBatsman();

    // 4. Fetch all Bowler Players
    List<Player> getAllBowler();

    // 5. Fetch Player by ID
    Player getPlayerById(int id);

    // 6. Fetch Players by teamName
    List<Player> getPlayersByTeam(String teamName);

    // 7. Fetch Player with highest score
    Player getHighestScorePlayer();

    // 8. Fetch Player with highest wickets
    Player getHighestWicketPlayer();

    // 9. Update Player score by ID
    Player updateScore(int id, int score);

    // 10. Update Player wickets by ID
    Player updateWickets(int id, int wickets);

    // 11. Update Player teamName by ID
    Player updateTeamName(int id, String teamName);

    // 12. Delete Player by ID
    String deletePlayer(int id);

    // 13. Delete Players by teamName
    String deletePlayersByTeam(String teamName);

    // 14. Fetch top 3 highest score Players
    List<Player> getTop3HighestScorePlayers();

    // 15. Fetch all-rounder Players
    List<Player> getAllRounders();
}