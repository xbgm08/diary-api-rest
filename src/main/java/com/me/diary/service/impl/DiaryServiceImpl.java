package com.me.diary.service.impl;

import com.me.diary.domain.model.Diary;
import com.me.diary.domain.repository.DiaryRepository;
import com.me.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository diaryRepository;

    public Diary createDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public Diary getDiaryById(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
