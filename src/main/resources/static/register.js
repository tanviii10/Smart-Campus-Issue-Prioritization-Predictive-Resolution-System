function registerUser() {

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    // Validation

    if (name.trim() === "") {
        alert("Please enter your name");
        return;
    }

    if (email.trim() === "") {
        alert("Please enter your email");
        return;
    }

    if (password.trim() === "") {
        alert("Please enter password");
        return;
    }

    if (password !== confirmPassword) {
        alert("Passwords do not match");
        return;
    }

    fetch("/auth/register", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            name: name,
            email: email,
            password: password
        })

    })

    .then(res => {

        if (!res.ok) {
            throw new Error("Email already registered");
        }

        return res.json();

    })

    .then(user => {

        alert("Account Created Successfully!");

        window.location.href = "/login.html#login";

    })

    .catch(error => {

        alert(error.message);

    });

}