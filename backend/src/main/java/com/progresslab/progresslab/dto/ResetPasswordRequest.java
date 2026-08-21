package com.progresslab.progresslab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class ResetPasswordRequest 
{
    private String resetToken;
 
    @NotBlank(message = "Password is required.")
    @Size(
        min = 10,
        message = "Password must be at least 10 characters."
    )
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).+$",
        message = "Password must contain an uppercase letter, number, and special character.")
    private String newPassword;

        public String getResetToken()
        {
            return resetToken;
        }

        public String getNewPassword()
        {
            return newPassword;
        }

        public void setResetToken(String resetToken)
        {
            this.resetToken = resetToken;
        }

        public void setNewPassword(String newPassword)
        {
            this.newPassword = newPassword;
        }
    
}
