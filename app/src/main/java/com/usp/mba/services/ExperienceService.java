package com.usp.mba.services;

import com.usp.mba.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;
}
