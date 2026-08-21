// ===============================
// RESET PASSWORD PAGE
// ===============================


// Get the form and message element
const resetPasswordForm =
    document.getElementById("resetPasswordForm");

const message =
    document.getElementById("message");


// ===============================
// GET RESET TOKEN FROM URL
// ===============================

// Example URL:
// reset-password.html?token=abc123

const urlParameters =
    new URLSearchParams(window.location.search);

const resetToken =
    urlParameters.get("token");


// If the URL does not contain a token,
// show an error immediately.
if (!resetToken)
{
    message.textContent =
        "Invalid password reset link.";

    message.className =
        "error";
}


// ===============================
// FORM SUBMISSION
// ===============================

resetPasswordForm.addEventListener(
    "submit",

    async function(event)
    {
        // Prevent the browser from doing
        // the normal HTML form submission.
        event.preventDefault();


        // Get the password values
        // entered by the user.
        const newPassword =
            document.getElementById("newPassword").value;

        const confirmPassword =
            document.getElementById("confirmPassword").value;


        // ===============================
        // CHECK PASSWORDS MATCH
        // ===============================

        if (newPassword !== confirmPassword)
        {
            message.textContent =
                "Passwords do not match.";

            message.className =
                "error";

            return;
        }


        // ===============================
        // CHECK TOKEN EXISTS
        // ===============================

        if (!resetToken)
        {
            message.textContent =
                "Invalid password reset link.";

            message.className =
                "error";

            return;
        }


        // ===============================
        // SEND REQUEST TO BACKEND
        // ===============================

        try
        {
            const response =
                await fetch(
                    "http://localhost:8080/api/users/reset-password",
                    {
                        method: "POST",

                        headers:
                        {
                            "Content-Type":
                                "application/json"
                        },

                        body: JSON.stringify(
                            {
                                resetToken: resetToken,
                                newPassword: newPassword
                            }
                        )
                    }
                );


            // Read the response returned
            // by Spring Boot.
            const responseMessage =
                await response.text();


            // ===============================
            // SUCCESS
            // ===============================

            if (response.ok)
            {
                message.textContent =
                    "Password reset successfully! Redirecting to login...";

                message.className =
                    "success";


                // Wait 2 seconds,
                // then send the user to login.
                setTimeout(
                    function()
                    {
                        window.location.href =
                            "login.html";
                    },

                    2000
                );
            }


            // ===============================
            // BACKEND ERROR
            // ===============================

            else
            {
                message.textContent =
                    responseMessage ||
                    "Unable to reset password.";

                message.className =
                    "error";
            }
        }


        // ===============================
        // CONNECTION ERROR
        // ===============================

        catch (error)
        {
            console.error(
                "Reset password error:",
                error
            );

            message.textContent =
                "Unable to connect to the server.";

            message.className =
                "error";
        }
    }
);


// ===============================
// PASSWORD VISIBILITY TOGGLE
// ===============================

function setupPasswordToggle(
    buttonId,
    inputId
)
{
    const button =
        document.getElementById(buttonId);

    const input =
        document.getElementById(inputId);


    button.addEventListener(
        "click",

        function()
        {
            // If password is hidden,
            // show it.
            if (input.type === "password")
            {
                input.type =
                    "text";
            }

            // Otherwise hide it again.
            else
            {
                input.type =
                    "password";
            }
        }
    );
}


// Toggle for New Password field
setupPasswordToggle(
    "toggleNewPassword",
    "newPassword"
);


// Toggle for Confirm Password field
setupPasswordToggle(
    "toggleConfirmPassword",
    "confirmPassword"
);