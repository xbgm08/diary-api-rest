package com.me.diary.service;

import com.me.diary.domain.model.Mood;

import java.util.List;

public interface MoodService {
    Mood createMood(Mood mood);

    List<Mood> getAllMoods();

    Mood getMoodById(Long id);
}
