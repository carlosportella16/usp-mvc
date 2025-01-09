package com.usp.mba.dto;

import com.usp.mba.enums.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserExperienceDto {
    private String name;
    private String email;
    private String phone;
    private String linkedInProfile;
    private String role;
    private int yearsOfExperience;
    private Technology primaryTechnology;
    private Technology secondaryTechnology;

}
