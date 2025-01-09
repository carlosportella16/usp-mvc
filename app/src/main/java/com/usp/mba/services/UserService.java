package com.usp.mba.services;

import com.usp.mba.dto.UserExperienceDto;
import com.usp.mba.dto.UserRequestDto;
import com.usp.mba.entities.ExperienceEntity;
import com.usp.mba.entities.UserEntity;
import com.usp.mba.enums.Technology;
import com.usp.mba.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Page<UserExperienceDto> getUsersWithTechnologies(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size))
                .map(user -> new UserExperienceDto(
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getLinkedInProfile(),
                        user.getExperience().getRole(),
                        user.getExperience().getYearsOfExperience(),
                        user.getExperience().getPrimaryTechnology(),
                        user.getExperience().getSecondaryTechnology()
                ));
    }

    public Page<UserExperienceDto> searchUsersByTechnologyAndExperience(Technology technology, int minYearsOfExperience, int page, int size) {
        return userRepository.findByExperiencePrimaryTechnologyAndExperienceYearsOfExperienceGreaterThanEqual(
                        technology,
                        minYearsOfExperience,
                        PageRequest.of(page, size))
                .map(user -> new UserExperienceDto(
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getLinkedInProfile(),
                        user.getExperience().getRole(),
                        user.getExperience().getYearsOfExperience(),
                        user.getExperience().getPrimaryTechnology(),
                        user.getExperience().getSecondaryTechnology()
                ));
    }

    public UserEntity createUser(UserRequestDto userRequestDTO) {
        if (userRequestDTO.getRole() == null || userRequestDTO.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role is mandatory and cannot be null or empty.");
        }

        ExperienceEntity experience = new ExperienceEntity();
        experience.setRole(userRequestDTO.getRole());
        experience.setYearsOfExperience(userRequestDTO.getYearsOfExperience());
        experience.setPrimaryTechnology(userRequestDTO.getPrimaryTechnology());
        experience.setSecondaryTechnology(userRequestDTO.getSecondaryTechnology());

        UserEntity user = new UserEntity();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setLinkedInProfile(userRequestDTO.getLinkedInProfile());
        user.setExperience(experience);

        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserRequestDto userRequestDTO) {
        Optional<UserEntity> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + id + " not found.");
        }

        UserEntity existingUser = existingUserOptional.get();

        ExperienceEntity experience = existingUser.getExperience();
        experience.setRole(userRequestDTO.getRole());
        experience.setYearsOfExperience(userRequestDTO.getYearsOfExperience());
        experience.setPrimaryTechnology(userRequestDTO.getPrimaryTechnology());
        experience.setSecondaryTechnology(userRequestDTO.getSecondaryTechnology());

        existingUser.setName(userRequestDTO.getName());
        existingUser.setEmail(userRequestDTO.getEmail());
        existingUser.setPhone(userRequestDTO.getPhone());
        existingUser.setLinkedInProfile(userRequestDTO.getLinkedInProfile());
        existingUser.setExperience(experience);

        return userRepository.save(existingUser);
    }
}


