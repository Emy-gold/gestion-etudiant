<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Signup</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="loginstyle.css">
</head>
<body>
	<div id="container">
		<div class="top">
			<h1>Sign up</h1>
		</div>
		<form action="SignupServlet" method="post">
			<input type="text" name="firstname" id="firstname" placeholder="firstname" required><br>
			<input type="text" name="lastname" id="lastname" placeholder="lastname" required><br>
			<input type="email" name="email" id="email" placeholder="email" required><br>
			<input type="password" name="password" id="password" placeholder="password" required><br>
			<input type="password" name="ConfirmPassword" id="ConfirmPassword" placeholder="Confirm password" required><br>
			<select id="role" name="role" required>
				<option value=""> Choose your role </option>
				<option value="student">Student</option>
				<option value="admin"> Teacher / admin</option>
			</select>
			<button type="submit" name="signup" id="signup">Sign up</button>
			 <a href=# class="login" onclick="switchAccount()">
                Do you already have an account ?
            </a>
		</form>
	</div>
	<div id="container2">
		<div class="top">
			<h1>Login</h1>
		</div>
		<form action="LoginServlet" method="post">
			<input type="email" name="email" placeholder="email" required>
			<input type="password" name="password" placeholder="password" required>
			<div class="signup_option">
				<a href="#" class="account"><i class="fa-brands fa-google" style="color: #000000"></i></a>
				<a href="#" class="account"><i class="fa-brands fa-github" style="color: #000000"></i></a>
			</div>
			<button name="login" id="login">Login</button>
			<a href=# class="login" onclick="switchAccount2()">
				Do not have an account yet ?
			</a>
		</form>
	</div>
	
	<script src="loginscript.js"></script>
</body>
</html>