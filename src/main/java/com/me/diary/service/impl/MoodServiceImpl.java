package com.me.diary.service.impl;

import com.me.diary.domain.model.Mood;
import com.me.diary.domain.repository.MoodRepository;
import com.me.diary.service.MoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MoodServiceImpl implements MoodService {
    private final MoodRepository moodRepository;

    public Mood createMood(Mood mood) {
        return moodRepository.save(mood);
    }

    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }

    public Mood getMoodById(Long id) {
        return moodRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
