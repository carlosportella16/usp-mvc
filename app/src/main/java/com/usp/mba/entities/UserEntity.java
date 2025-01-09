package com.usp.mba.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String linkedInProfile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id", referencedColumnName = "id")
    private ExperienceEntity experience;

}
