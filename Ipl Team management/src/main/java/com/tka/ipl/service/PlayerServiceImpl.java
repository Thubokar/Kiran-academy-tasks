package com.tka.ipl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tka.ipl.entity.Player;
import com.tka.ipl.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;

    // Constructor Injection
    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    // 1. Add Player
    @Override
    public Player addPlayer(Player player) {

        return repository.save(player);
    }

    // 2. Fetch all Players
    @Override
    public List<Player> getAllPlayers() {

        return repository.findAll();
    }

    // 3. Fetch all Batsman Players
    @Override
    public List<Player> getAllBatsman() {

        return repository.findByCategoryIgnoreCase("Batsman");
    }

    // 4. Fetch all Bowler Players
    @Override
    public List<Player> getAllBowler() {

        return repository.findByCategoryIgnoreCase("Bowler");
    }

    // 5. Fetch Player by ID
    @Override
    public Player getPlayerById(int id) {

        return repository.findById(id).orElse(null);
    }

    // 6. Fetch Players by teamName
    @Override
    public List<Player> getPlayersByTeam(String teamName) {

        return repository.findByTeamNameIgnoreCase(teamName);
    }

    // 7. Fetch Player with highest score
    @Override
    public Player getHighestScorePlayer() {

        return repository.findTopByOrderByScoreDesc();
    }

    // 8. Fetch Player with highest wickets
    @Override
    public Player getHighestWicketPlayer() {

        return repository.findTopByOrderByWicketsDesc();
    }

    // 9. Update Player score by ID
    @Override
    public Player updateScore(int id, int score) {

        Player player = repository.findById(id).orElse(null);

        if (player != null) {

            player.setScore(score);

            return repository.save(player);
        }

        return null;
    }

    // 10. Update Player wickets by ID
    @Override
    public Player updateWickets(int id, int wickets) {

        Player player = repository.findById(id).orElse(null);

        if (player != null) {

            player.setWickets(wickets);

            return repository.save(player);
        }

        return null;
    }

    // 11. Update Player teamName by ID
    @Override
    public Player updateTeamName(int id, String teamName) {

        Player player = repository.findById(id).orElse(null);

        if (player != null) {

            player.setTeamName(teamName);

            return repository.save(player);
        }

        return null;
    }

    // 12. Delete Player by ID
    @Override
    public String deletePlayer(int id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Player deleted successfully";
        }

        return "Player not found";
    }

    // 13. Delete Players by teamName
    @Override
    public String deletePlayersByTeam(String teamName) {

        List<Player> players =
                repository.findByTeamNameIgnoreCase(teamName);

        if (players.isEmpty()) {

            return "No players found for team: " + teamName;
        }

        repository.deleteAll(players);

        return "Players deleted successfully for team: " + teamName;
    }

    // 14. Fetch top 3 highest score Players
    @Override
    public List<Player> getTop3HighestScorePlayers() {

        return repository.findTop3ByOrderByScoreDesc();
    }

    // 15. Fetch all-rounder Players
    @Override
    public List<Player> getAllRounders() {

        return repository.findAllRounders();
    }
}