package com.me.diary.controller;

import com.me.diary.domain.model.Mood;
import com.me.diary.service.MoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/diary/{diaryId}/entries/{entryId}/moods")
public class MoodController {
    private final MoodService moodService;

    public MoodController(MoodService moodService){
        this.moodService = moodService;
    }

    @PostMapping
    public ResponseEntity<Mood> createMood(@RequestBody Mood mood){
        Mood createdMood = moodService.createMood(mood);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createdMood.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdMood);
    }

    @GetMapping
    public ResponseEntity<List<Mood>> getAllMoods() {
        List<Mood> moods = moodService.getAllMoods();
        return ResponseEntity.ok(moods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mood> getMoodById(@PathVariable Long id) {
        Mood mood = moodService.getMoodById(id);
        return ResponseEntity.ok(mood);
    }
}
