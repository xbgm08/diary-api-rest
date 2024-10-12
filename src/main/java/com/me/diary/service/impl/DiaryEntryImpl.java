package com.me.diary.service.impl;

import com.me.diary.domain.model.DiaryEntry;
import com.me.diary.domain.repository.DiaryEntryRepository;
import com.me.diary.service.DiaryEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DiaryEntryImpl implements DiaryEntryService {
    private final DiaryEntryRepository diaryEntryRepository;

    public DiaryEntry addEntry(DiaryEntry diaryEntry) {
        return diaryEntryRepository.save(diaryEntry);
    }

    public DiaryEntry getEntryById(Long entryId) {
        return diaryEntryRepository.findById(entryId)
                .orElseThrow(NoSuchElementException::new);
    }

    public DiaryEntry updateEntry(Long entryId, DiaryEntry updatedEntry) {
        DiaryEntry existingEntry = getEntryById(entryId);

        existingEntry.setTitle(updatedEntry.getTitle());
        existingEntry.setContent(updatedEntry.getContent());
        existingEntry.setDate(updatedEntry.getDate());
        existingEntry.setMood(updatedEntry.getMood());

        return diaryEntryRepository.save(existingEntry);
    }

    public void deleteEntry(Long entryId) {
        DiaryEntry existingEntry = getEntryById(entryId);
        diaryEntryRepository.delete(existingEntry);
    }
}
