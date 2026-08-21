package com.progresslab.progresslab.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginUserRequest
{
    //Email entered on the Login form
    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email")
    private String email;
    
    //Password entered onthe login form
    @NotBlank(message = "Password is reqiured")
    private String password;

    //Getter for email
    public String getEmail()
    {
        return email;
    }

    //setter for email

    public void setEmail(String email)
    {
        this.email = email;
    }

    //getter for passowrd

    public String getPassword()
    {
        return password;
    }
    //setter for password

    public void setPassword(String password)
    {
        this.password = password;
    }


}
