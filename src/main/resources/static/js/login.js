$(document).ready(function()
{

	$("#login-form").submit(function(event)
	{
		//stop submit the form, we will post it manually.
		event.preventDefault();

		login();
	});

});

function login()
{
	var data = {}
	data["username"] = $("#email").val();
	data["password"] = $("#password").val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/login",
		data : JSON.stringify(data),
		dataType : 'json',
		async : false,
		cache : false,
		timeout : 10000,
		statusCode : {
			200 : function()
			{
				window.location.href = "/home";
			},
			404 : function()
			{
				alert("404");
			},
			405 : function()
			{
				alert("405");
			}
		}
	});
}