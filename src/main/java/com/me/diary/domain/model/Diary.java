package com.me.diary.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "tb_diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private LocalDate creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private User user;
}
