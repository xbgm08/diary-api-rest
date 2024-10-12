package com.me.diary.service;

import com.me.diary.domain.model.DiaryEntry;

public interface DiaryEntryService {
    DiaryEntry addEntry(DiaryEntry diaryEntry);

    DiaryEntry getEntryById(Long entryId);

    DiaryEntry updateEntry(Long entryId, DiaryEntry updatedEntry);

    void deleteEntry(Long entryId);
}
