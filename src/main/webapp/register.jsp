<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Registration Page">
  <meta name="author" content="Ansh Goyal">

  <title>Register | HDFS</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- jQuery -->
  <script src="jquery/jquery.min.js"></script>

  <!-- Custom Styles-->
  <link href="css/register.css" rel="stylesheet">

  <!-- Custom Scripts -->
  <script src="js/validation.js" type="text/javascript"></script>
  <script src="js/register.js" type="text/javascript"></script>

</head>

<body>

<div class="container">
  <div class="auth-form-body create-caller-account mt-3">
    <img src="images/logo.jpg"><br>

    <form class="form-signin" id="registration-form">

      <div class="form-label-group form-group-sm">
        <input type="text" id="name" class="form-control form-control-sm" placeholder="Full Name" required autofocus>
        <label for="inputName">Full Name</label>
      </div>

      <div class="form-label-group">
        <input type="email" id="email" class="form-control form-control-sm" placeholder="Email address">
        <label for="inputEmail">Email address</label>
      </div>

      <div class="form-label-group">
        <input type="password" id="password" class="form-control form-control-sm" placeholder="Password" required>
        <label for="inputPassword">Password</label>
      </div>

      <div class="form-label-group">
        <input type="password" id="confirmPassword" class="form-control form-control-sm" placeholder="Confirm Password" required>
        <label for="inputConfirmPassword">Confirm Password</label>
      </div>

      <div class="error-box" id="error-message">
        <p> Username Already Exists</p>
      </div>

      <br>
      <button class="btn btn-primary btn-block" type="submit">Sign up</button>

    </form>
  </div>

  <p class="create-account-callout mt-3">
    Already a User?
    <a href="login">Sign in</a>.
  </p>
</div>

</body>
</html>
