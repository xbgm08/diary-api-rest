package com.me.diary.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "tb_diary_entry")
public class DiaryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private LocalDate date;

    @OneToOne
    @Getter
    @Setter
    private Mood mood;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Diary diary;
}
