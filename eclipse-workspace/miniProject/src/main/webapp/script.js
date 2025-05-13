//event listener for the button
document.getElementById("connect-btn").addEventListener("click", function() {
	window.location.href = 'signup.jsp';
});
document.querySelector("form").addEventListener("submit", function(e) {
  const pwd = document.getElementById("password").value;
  const confirm = document.getElementById("confirmPassword").value;
  if (pwd !== confirm) {
    e.preventDefault();
    alert("Les mots de passe ne correspondent pas !");
  }
});
