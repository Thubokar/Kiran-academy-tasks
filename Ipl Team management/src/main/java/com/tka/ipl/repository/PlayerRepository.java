package com.tka.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tka.ipl.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    // 3. Fetch all Batsman Players
    List<Player> findByCategoryIgnoreCase(String category);

    // 6. Fetch Players by teamName
    List<Player> findByTeamNameIgnoreCase(String teamName);

    // 7. Fetch Player with highest score
    Player findTopByOrderByScoreDesc();

    // 8. Fetch Player with highest wickets
    Player findTopByOrderByWicketsDesc();

    // 14. Fetch top 3 highest score Players
    List<Player> findTop3ByOrderByScoreDesc();

    // 15. Fetch all-rounder Players
    @Query("SELECT p FROM Player p WHERE p.score > 500 AND p.wickets > 20")
    List<Player> findAllRounders();
}