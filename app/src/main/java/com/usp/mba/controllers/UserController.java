package com.usp.mba.controllers;


import com.usp.mba.dto.UserExperienceDto;
import com.usp.mba.dto.UserRequestDto;
import com.usp.mba.entities.UserEntity;
import com.usp.mba.enums.Technology;
import com.usp.mba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public Page<UserExperienceDto> getUsersWithTechnologies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getUsersWithTechnologies(page, size);
    }

    @GetMapping("/search")
    public Page<UserExperienceDto> searchUsersByTechnologyAndExperience(
            @RequestParam Technology technology,
            @RequestParam int minYearsOfExperience,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.searchUsersByTechnologyAndExperience(technology, minYearsOfExperience, page, size);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequestDto userRequestDTO) {
        UserEntity createdUser = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto userRequestDTO) {
        UserEntity updatedUser = userService.updateUser(id, userRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }
}