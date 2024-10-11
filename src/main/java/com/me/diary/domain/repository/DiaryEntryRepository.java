package com.me.diary.domain.repository;

import com.me.diary.domain.model.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {
}
