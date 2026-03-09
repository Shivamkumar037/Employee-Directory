package com.project1.hospital.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rollNo;
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}