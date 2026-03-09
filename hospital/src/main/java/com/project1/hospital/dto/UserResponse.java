package com.project1.hospital.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private Set<String> roles;
}