package com.project1.hospital.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AttendanceRequest {
    private LocalDate date;
    private String status;
    private Long studentId;
}