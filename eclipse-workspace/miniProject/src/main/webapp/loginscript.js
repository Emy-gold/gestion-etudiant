// Initialize forms when page loads
document.addEventListener('DOMContentLoaded', function() {
    // Hide login form by default
    document.getElementById("container2").style.display = "none";
});

// Switch to Login form (hide Signup)
function switchAccount() {
    document.getElementById("container").style.display = "none";
    document.getElementById("container2").style.display = "flex";
    document.title = "Login Page";
}

// Switch to Signup form (hide Login)
function switchAccount2() {
    document.getElementById("container2").style.display = "none";
    document.getElementById("container").style.display = "flex";
    document.title = "Sign Up Page";
}