package com.progresslab.progresslab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/*
 * REGISTER USER REQUEST DTO
 *
 * PURPOSE:
 * Represents the data that a client is allowed to send
 * when creating a new ProgressLab account.
 *
 * This is NOT a database entity.
 * It is simply a Java object used to transfer incoming API data.
 *
 * Incoming JSON:
 *
 * {
 *   "firstName": "Kiran",
 *   "lastName": "Kaur",
 *   "email": "kiran@gmail.com",
 *   "password": "Progress123!"
 * }
 *
 *             ↓ Spring converts JSON
 *
 * RegisterUserRequest object
 */
public class RegisterUserRequest {

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Please enter a valid email address.")
    @Pattern(
    regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
    message = "Please enter a valid email address."
    )
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(
        min = 10,
        message = "Password must be at least 10 characters."
    )
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).+$",
        message = "Password must contain an uppercase letter, number, and special character.")

    
    private String password;


    /*
     * Spring needs a no-argument constructor when converting
     * incoming JSON into this Java object.
     */
    public RegisterUserRequest() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}