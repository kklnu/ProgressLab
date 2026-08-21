package com.progresslab.progresslab.service;

import com.progresslab.progresslab.dto.ForgotPasswordRequest;
import com.progresslab.progresslab.dto.LoginUserRequest;
import java.util.Optional;
import java.util.UUID;
import javax.management.RuntimeErrorException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.progresslab.progresslab.dto.RegisterUserRequest;
import com.progresslab.progresslab.dto.ResetPasswordRequest;
import com.progresslab.progresslab.model.User;
import com.progresslab.progresslab.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;


    /*
     * Spring injects UserRepository.
     *
     * We currently create BCryptPasswordEncoder ourselves.
     */
    public UserService(UserRepository userRepository, JavaMailSender mailSender) {

        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.mailSender = mailSender;
    }

    public void sendResetEmail(String email, String resetLink)
    {
        SimpleMailMessage message = new SimpleMailMessage();


        message.setTo(email);
        message.setSubject("ProgressLab Password Reset");
        message.setText(
            "You requested a password reset. \n\n" +
            "Click the link below to reset your password:\n" +
            resetLink + 
            "\n\nThis link expires in 30 minutes."
        );

        mailSender.send(message);
    }


    /*
     * REGISTER USER BUSINESS LOGIC
     *
     * We now receive RegisterUserRequest instead of a User entity.
     *
     * This prevents the API client from directly controlling
     * our database entity.
     */
    public User registerUser(RegisterUserRequest request) {

        // STEP 1: Normalize incoming email.
        String normalizedEmail = request.getEmail()
                .trim()
                .toLowerCase();


        // STEP 2: Check whether the account already exists.
        if (userRepository.existsByEmailIgnoreCase(normalizedEmail)) {

            throw new IllegalArgumentException(
                    "Email is already registered."
            );
        }


        // STEP 3: Hash the plain password from the request DTO.
        String hashedPassword =
                passwordEncoder.encode(request.getPassword());


        /*
         * STEP 4:
         * Create the actual database entity.
         *
         * DTO data
         *    ↓
         * new User(...)
         *    ↓
         * User entity
         */
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                normalizedEmail,
                hashedPassword
        );


        /*
         * STEP 5:
         * Persist the entity.
         *
         * Repository
         *   ↓
         * JPA/Hibernate
         *   ↓
         * MySQL
         */
        return userRepository.save(user);
    }

    public User loginUser(LoginUserRequest request)
    {
        //Look for a user in the database using the email entered at Login

        Optional<User> userOptional = userRepository.findByEmailIgnoreCase(request.getEmail());
        System.out.println("EMAIL ENTERED: " + request.getEmail());
        System.out.println("EMAIL FOUND:" + userOptional.isPresent());
         
        //If email does not belogn to any user, Login Fails
        if(userOptional.isEmpty())
        {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Invalid email or password."
            );
        }

        //Get the User Object stored inside the Optional
        User user = userOptional.get();

        //Compare the password entered by the user with the encrypted password stored in the database
        if(!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword()))
            {
                throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid emial or password."
                );
            }

        //if both email and passsword are correct, 
        //return the user
        return user;
    }

    

    public void forgotPassword(String email)
    {
        Optional<User> userOptional = userRepository.findByEmailIgnoreCase(email);
        
        if(userOptional.isPresent())
        {
            User user = userOptional.get();
            String resetToken = UUID.randomUUID().toString();
            LocalDateTime resetTokenExpiry = LocalDateTime.now().plusMinutes(30);

            user.setResetToken(resetToken);
            user.setResetTokenExpiry(resetTokenExpiry);

            userRepository.save(user);
            String resetLink = "http://127.0.0.1:5500/frontend/reset-password.html?token=" + resetToken;

            sendResetEmail(user.getEmail(), resetLink);

        }
    }

    public void resetPassword(ResetPasswordRequest request)
    {
        Optional<User> userOptional = userRepository.findByResetToken(request.getResetToken());
        if(userOptional.isPresent())
        {
            User user = userOptional.get();

            if(LocalDateTime.now().isAfter(user.getResetTokenExpiry()))
            {
                throw new RuntimeException("Reset token has expired");
            }
            //Encode and save the new password
            user.setPassword(
                passwordEncoder.encode(request.getNewPassword())
            );

            //Remove the token so it cannot be used again
            user.setResetToken(null);
            user.setResetTokenExpiry(null);

            //Save all changes to the database
            userRepository.save(user);
        }

        else{
            throw new RuntimeException("Invalid reset token");
        }
    }
}
