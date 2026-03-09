package com.project1.hospital.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentRequest {
    private String name;
    private String rollNo;
    private LocalDate dob;
    private Long classroomId; // Sirf ID pass karenge linking ke liye
}