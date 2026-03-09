package com.project1.hospital.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subName;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
