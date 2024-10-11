package com.me.diary.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "tb_diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private LocalDate creationDate;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<DiaryEntry> entries;
}
