package com.trigon.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leaderboard")
public class LeaderboardEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;     // shown in frontend
    private String difficulty;   // Beginner / Intermediate / Expert
    private int score;           // numeric score
}
