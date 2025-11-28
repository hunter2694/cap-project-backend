package com.trigon.service;

import com.trigon.entity.LeaderboardEntry;
import com.trigon.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepository repo;

    // Save each score attempt
    public LeaderboardEntry saveEntry(LeaderboardEntry entry) {
        return repo.save(entry);
    }

    // Global leaderboard (all difficulties)
    public List<LeaderboardEntry> getAll() {
        return repo.findAllByOrderByScoreDesc();
    }

    // Filter by Beginner / Intermediate / Expert
    public List<LeaderboardEntry> getByDifficulty(String difficulty) {
        return repo.findByDifficultyOrderByScoreDesc(difficulty);
    }
}
