package com.me.diary.controller;

import com.me.diary.domain.model.DiaryEntry;
import com.me.diary.service.DiaryEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/users/{userId}/diary/{diaryId}/entries")
public class DiaryEntryController {
    private final DiaryEntryService diaryEntryService;

    public DiaryEntryController(DiaryEntryService diaryEntryService){
        this.diaryEntryService = diaryEntryService;
    }

    @PostMapping
    public ResponseEntity<DiaryEntry> addEntry(@RequestBody DiaryEntry diaryEntry) {
        DiaryEntry createdEntry = diaryEntryService.addEntry(diaryEntry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createdEntry.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdEntry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> getEntryById(@PathVariable Long id) {
        DiaryEntry entry = diaryEntryService.getEntryById(id);
        return ResponseEntity.ok(entry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntry> updateEntry(@PathVariable Long id, @RequestBody DiaryEntry updatedEntry) {
        DiaryEntry updated = diaryEntryService.updateEntry(id, updatedEntry);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        diaryEntryService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}
