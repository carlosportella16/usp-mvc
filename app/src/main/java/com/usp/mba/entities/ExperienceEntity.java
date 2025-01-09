package com.usp.mba.entities;

import com.usp.mba.enums.Technology;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tb_experiences")
public class ExperienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private int yearsOfExperience;
    @Enumerated(EnumType.STRING)
    private Technology primaryTechnology;

    @Enumerated(EnumType.STRING)
    private Technology secondaryTechnology;

}
