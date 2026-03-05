package com.example.JWT_API.Repository;

import com.example.JWT_API.Entity.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {
    List<MoodEntry> findByUserUsername(String username);
}
