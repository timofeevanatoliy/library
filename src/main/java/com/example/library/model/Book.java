package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  title;
    private String author;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;
}
