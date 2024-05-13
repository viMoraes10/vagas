package com.example.demo.model.job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "jobs")
@Getter
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String requirements;

    @Column(nullable = false)
    private Boolean isActive;

    public Job(String title, String description, String requirements, Boolean isActive) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.isActive = isActive;
    }

    public Job(Long id, String title, String description, String requirements, Boolean isActive) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.isActive = isActive;
    }
}
