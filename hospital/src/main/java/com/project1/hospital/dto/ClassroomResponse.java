package com.project1.hospital.dto;

import lombok.Data;
import java.util.List;

@Data
public class ClassroomResponse {
    private Long id;
    private String name;
    private String section;
    private List<String> studentNames; // Saari details ki jagah sirf naam bhej sakte hain
}