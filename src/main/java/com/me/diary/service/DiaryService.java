package com.me.diary.service;

import com.me.diary.domain.model.Diary;

public interface DiaryService {
    Diary createDiary(Diary diary);

    Diary getDiaryById(Long id);
}
