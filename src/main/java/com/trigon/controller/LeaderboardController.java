package com.trigon.controller;

import com.trigon.entity.LeaderboardEntry;
import com.trigon.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    @Autowired
    private LeaderboardService service;

    // Save a score
    @PostMapping("/submit")
    public LeaderboardEntry submitScore(@RequestBody LeaderboardEntry entry) {
        return service.saveEntry(entry);
    }

    // Fetch full leaderboard
    @GetMapping
    public List<LeaderboardEntry> getLeaderboard() {
        return service.getAll();
    }

    // Fetch leaderboard filtered by difficulty
    @GetMapping("/{difficulty}")
    public List<LeaderboardEntry> getLeaderboardByDifficulty(@PathVariable String difficulty) {
    	System.out.println("BAckend data is fatching");
        return service.getByDifficulty(difficulty);
    }
}
