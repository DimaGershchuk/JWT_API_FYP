package com.example.JWT_API.Service;

import com.example.JWT_API.Controller.MoodEntryController;
import com.example.JWT_API.Entity.MoodEntry;
import com.example.JWT_API.Entity.User;
import com.example.JWT_API.Repository.MoodEntryRepository;
import com.example.JWT_API.Repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MoodEntryService {
    private final MoodEntryRepository moodEntryRepository;
    private final UserRepository userRepository;


    public MoodEntryService(MoodEntryRepository moodEntryRepository, UserRepository userRepository) {
        this.moodEntryRepository = moodEntryRepository;
        this.userRepository = userRepository;
    }

    public List<MoodEntry> getUserMoods(String username){

        return moodEntryRepository.findByUserUsername(username);
    }

    public MoodEntry createMood(@RequestBody MoodEntry moodEntry){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        moodEntry.setUser(user);

        return moodEntryRepository.save(moodEntry);
    }
}
