package com.progresslab.progresslab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
public class ForgotPasswordRequest 
{
    @NotBlank(message = "Email is required.")
    @Email(message = "Please enter a valid email.")
    private String email;

    //getter for email
    public String getEmail()
    {
        return email;
    }

    //setter for email
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
