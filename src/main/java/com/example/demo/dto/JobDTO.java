package com.example.demo.dto;

import jakarta.persistence.Column;

public record JobDTO(String title, String description, String requirements, Boolean isActive) {
}
