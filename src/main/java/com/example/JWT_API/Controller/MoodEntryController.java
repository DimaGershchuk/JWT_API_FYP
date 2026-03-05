package com.example.JWT_API.Controller;

import com.example.JWT_API.Entity.MoodEntry;
import com.example.JWT_API.Entity.User;
import com.example.JWT_API.Repository.UserRepository;
import com.example.JWT_API.Service.MoodEntryService;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.List;

@RestController
@RequestMapping("/api/moods")
public class MoodEntryController {

    private final MoodEntryService moodEntryService;
    private final UserRepository userRepository;

    public MoodEntryController(MoodEntryService moodEntryService, UserRepository userRepository) {
        this.moodEntryService = moodEntryService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<MoodEntry> getUserMoods(Authentication authentication) {
        String username = authentication.getName();
        return moodEntryService.getUserMoods(username);
    }

    @PostMapping
    public MoodEntry createMoood(@RequestBody MoodEntry moodEntry){
        return moodEntryService.createMood(moodEntry);
    }
}
