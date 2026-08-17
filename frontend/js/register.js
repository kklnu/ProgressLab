const form = document.getElementById("registerForm");
const formMessage = document.getElementById("formMessage");

const passwordInput = document.getElementById("password");
const confirmPasswordInput =
    document.getElementById("confirmPassword");

const togglePassword =
    document.getElementById("togglePassword");

const toggleConfirmPassword =
    document.getElementById("toggleConfirmPassword");


/*
 * PASSWORD VISIBILITY
 */
togglePassword.addEventListener("click", function () {

    const passwordIsHidden =
        passwordInput.type === "password";

    passwordInput.type =
        passwordIsHidden ? "text" : "password";

    togglePassword.innerHTML =
        passwordIsHidden
            ? '<i data-lucide="eye-off"></i>'
            : '<i data-lucide="eye"></i>';

    togglePassword.setAttribute(
        "aria-label",
        passwordIsHidden
            ? "Hide password"
            : "Show password"
    );

    lucide.createIcons();
});


/*
 * CONFIRM PASSWORD VISIBILITY
 */
toggleConfirmPassword.addEventListener("click", function () {

    const passwordIsHidden =
        confirmPasswordInput.type === "password";

    confirmPasswordInput.type =
        passwordIsHidden ? "text" : "password";

    toggleConfirmPassword.innerHTML =
        passwordIsHidden
            ? '<i data-lucide="eye-off"></i>'
            : '<i data-lucide="eye"></i>';

    toggleConfirmPassword.setAttribute(
        "aria-label",
        passwordIsHidden
            ? "Hide confirm password"
            : "Show confirm password"
    );

    lucide.createIcons();
});


/*
 * REGISTRATION FORM
 */
form.addEventListener("submit", async function(event) {

    event.preventDefault();

    const firstName =
        document.getElementById("firstName").value;

    const lastName =
        document.getElementById("lastName").value;

    const email =
        document.getElementById("email").value;

    const password =
        passwordInput.value;

    const confirmPassword =
        confirmPasswordInput.value;


    if (password !== confirmPassword) {

        formMessage.textContent =
            "Passwords do not match.";

        formMessage.style.color = "#ff6b6b";

        return;
    }


    const userData = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password
    };


    try {

        const response = await fetch(
            "http://localhost:8080/api/users/register",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(userData)
            }
        );


        if (response.ok) {

            formMessage.textContent =
                "Account created successfully!";

            formMessage.style.color = "#7ce143";

            form.reset();

        } else {

            const errorMessage =
                await response.text();

            formMessage.textContent =
                errorMessage;

            formMessage.style.color =
                "#ff6b6b";
        }

    } catch (error) {

        formMessage.textContent =
            "Unable to connect to the server. Please try again.";

        formMessage.style.color =
            "#ff6b6b";
    }

});