package com.trigon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trigon.entity.LeaderboardEntry;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<LeaderboardEntry, Long> {

    List<LeaderboardEntry> findAllByOrderByScoreDesc();

    List<LeaderboardEntry> findByDifficultyOrderByScoreDesc(String difficulty);
}
