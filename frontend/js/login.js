const form  = document.getElementById("loginForm");
const loginMessage = document.getElementById("loginMessage");
const passwordInput = document.getElementById("password");
const togglePassword = document.getElementById("togglePassword");
const loginButton = document.getElementById("loginButton");

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

form.addEventListener("submit", async function(event)
{
     event.preventDefault();
     sessionStorage.removeItem("loggedInUser");
    loginButton.disabled = true;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;


    const loginData = {
        email,
        password
    };
    const jsonData = JSON.stringify(loginData);

    try
    {
     const response = await fetch(
        "http://localhost:8080/api/users/login",
        {
            method: "POST",
            headers:
            {
                "content-type": "application/json"
            },

            body: jsonData
        }
    )
    if(response.ok)
    {
        loginMessage.textContent = "Login successful."
        loginMessage.style.color = "#fffb00af";

        const user = await response.json();
        sessionStorage.setItem("loggedInUser",
                                JSON.stringify(user)
        );
        window.location.href = "dashboard.html";

    }
    else{
        loginMessage.textContent = "Login failed. Invalid email or password."
        loginMessage.style.color = "#fffb00af"
        form.reset();
    }
    }

    catch
    {
        loginMessage.textContent = "Unable to connect to the server. Please try again."
        loginMessage.style.color = "#fffb00af"
    }
    finally
    {
        loginButton.disabled = false;
    }

  

});
