<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Login Page">
	<meta name="author" content="Ansh Goyal">
	
	<title>Login | HDFS</title>
	
	<!-- Bootstrap core CSS -->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- jQuery -->
	<script src="jquery/jquery.min.js"></script>
	
	<!-- Custom Styles-->
	<link href="css/login.css" rel="stylesheet">

	<!-- Custom Scripts -->
<!--	<script src="js/login.js" type="text/javascript"></script> -->
</head>

<body class="text-center">
	<div class="container">
		<div class="auth-form-body create-caller-account mt-3">
			<img src="images/logo.jpg"><br>
			<form class="form-signin" id="login-form" method="post" action="/login">
				<label for="email" class="sr-only">Email address</label>
				<input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
				
				<label for="password" class="sr-only">Password</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
				
				<div class="mb-3">
					<a href="#">Forgot password?</a>
				</div>
				<button class="btn btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>

		<p class="create-account-callout mt-3"> New User? <a href="register">Create an account</a>.</p>

	</div>
</body>
</html>
