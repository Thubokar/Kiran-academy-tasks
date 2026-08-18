package com.tka.ipl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

    @Id
    private int id;

    private String name;
    private String teamName;
    private String category;
    private int score;
    private int catches;
    private int wickets;

    // Default Constructor
    public Player() {
    }

    // Parameterized Constructor
    public Player(int id, String name, String teamName, String category,
                  int score, int catches, int wickets) {

        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.category = category;
        this.score = score;
        this.catches = catches;
        this.wickets = wickets;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCatches() {
        return catches;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", catches=" + catches +
                ", wickets=" + wickets +
                '}';
    }
}