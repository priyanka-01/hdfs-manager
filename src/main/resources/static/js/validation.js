$(document).ready(function()
{
	var email = document.getElementById("email");
	var password = document.getElementById("password")
	var confirm_password = document.getElementById("confirmPassword");

	// Rules
	email.pattern = "^[a-zA-Z.0-9]+@iiitb\\.((ac\\.in)|(org))$";
	password.minLength = 8;

	function validatePassword()
	{
		if (password.value != confirm_password.value)
		{
			confirm_password.setCustomValidity("Passwords Don't Match");
		}
		else
		{
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
})
$(function()
{
	$("input[id=email]")[0].oninvalid = function()
	{
		this.setCustomValidity("Enter a valid IIITB Email ID");
	};
	$("input[id=password]")[0].oninvalid = function()
	{
		this.setCustomValidity("Password should be minimum 8 characters");
	};
});
$(function()
{
	$("input[id=email]")[0].oninput = function()
	{
		this.setCustomValidity("");
	};
	$("input[id=password]")[0].oninput = function()
	{
		this.setCustomValidity("");
	};
});
