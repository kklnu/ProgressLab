package com.progresslab.progresslab.dto;

import java.time.LocalDateTime;

import com.progresslab.progresslab.model.User;

/*
 * USER RESPONSE DTO
 *
 * PURPOSE:
 * Controls which User information we send back to the client.
 *
 * Notice that there is NO password field.
 *
 * The database entity may contain the password hash,
 * but the API response will never expose it.
 */
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;


    public UserResponse(
            Long id,
            String firstName,
            String lastName,
            String email,
            LocalDateTime createdAt) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = createdAt;
    }


    /*
     * Converts a User ENTITY into a UserResponse DTO.
     *
     * Entity:
     * contains database information including password hash.
     *
     * Response DTO:
     * contains only information safe to send to the client.
     */
    public static UserResponse from(User user) {

        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}