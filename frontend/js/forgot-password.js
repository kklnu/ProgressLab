const form = document.getElementById("forgotPasswordForm");
form.addEventListener("submit", async function(event)
{
    event.preventDefault();
    const email = document.getElementById("email").value;

    const forgotPasswordData = {email};

    const jsonData = JSON.stringify(forgotPasswordData);

    const response = await fetch(
        "http://localhost:8080/api/users/forgot-password",
        {
            method: "POST",
            headers:
            {
                "content-type": "application/json"
            },

            body: jsonData
        }
    )

}
);