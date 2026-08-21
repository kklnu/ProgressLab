package com.progresslab.progresslab.controller;
import com.progresslab.progresslab.dto.ForgotPasswordRequest;
import com.progresslab.progresslab.dto.LoginResponse;
import com.progresslab.progresslab.dto.LoginUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.progresslab.progresslab.dto.ResetPasswordRequest;
import com.progresslab.progresslab.dto.RegisterUserRequest;
import com.progresslab.progresslab.dto.UserResponse;
import com.progresslab.progresslab.model.User;
import com.progresslab.progresslab.service.UserService;
import com.progresslab.progresslab.dto.ForgotPasswordRequest;
import jakarta.validation.Valid;

/*
 * USER CONTROLLER
 *
 * Handles HTTP requests involving Users.
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "http://127.0.0.1:5500"
})
public class UserController {

    private final UserService userService;


    /*
     * Constructor injection.
     *
     * Spring already manages UserService,
     * so Spring passes its UserService object here.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /*
     * POST /api/users/register
     *
     * Example request JSON:
     *
     * {
     *   "firstName": "Kiran",
     *   "lastName": "Kaur",
     *   "email": "kiran@gmail.com",
     *   "password": "Progress123!"
     * }
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(
            @Valid @RequestBody RegisterUserRequest request) {

        /*
         * STEP 1:
         * Controller receives RegisterUserRequest DTO.
         *
         * STEP 2:
         * Send it to the service layer.
         */
        User registeredUser =
                userService.registerUser(request);


        /*
         * STEP 3:
         * Convert the database User entity into a safe response DTO.
         */
        UserResponse response =
                UserResponse.from(registeredUser);


        /*
         * STEP 4:
         * Return HTTP 201 Created and the safe response.
         */
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
        public LoginResponse loginUser(
        @Valid @RequestBody LoginUserRequest request) {

    User user = userService.loginUser(request);

    return new LoginResponse(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail()
    );
}

        @PostMapping("/forgot-password")
        public void forgotPassword(
                @Valid @RequestBody ForgotPasswordRequest request)
                {
                        userService.forgotPassword(request.getEmail());
                }

        @PostMapping("/reset-password")
        public ResponseEntity<String> resetPassword(
                @Valid @RequestBody ResetPasswordRequest request)
        {
                userService.resetPassword(request);

                return ResponseEntity.ok("Password reset successful");
        }

}