package com.usp.mba.dto;

import com.usp.mba.enums.Technology;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String phone;
    private String linkedInProfile;
    private String role;
    private int yearsOfExperience;
    private Technology primaryTechnology;
    private Technology secondaryTechnology;
}
