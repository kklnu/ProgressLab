package com.progresslab.progresslab.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.progresslab.progresslab.dto.RegisterUserRequest;
import com.progresslab.progresslab.model.User;
import com.progresslab.progresslab.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    /*
     * Spring injects UserRepository.
     *
     * We currently create BCryptPasswordEncoder ourselves.
     */
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
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
}