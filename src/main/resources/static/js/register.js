$(document).ready(function()
{

	$("#registration-form").submit(function(event)
	{
		//stop submit the form, we will post it manually.
		event.preventDefault();

		register();
	});

});

function register()
{
	var data = {}
	data["name"] = $("#name").val();
	data["email"] = $("#email").val();
	data["password"] = $("#password").val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/register",
		data : JSON.stringify(data),
		dataType : 'json',
		async : false,
		cache : false,
		timeout : 10000,
		statusCode : {
			200 : function()
			{
				window.location.href = "/login";
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

function fire_ajax_submit()
{

	var search = {}
	search["username"] = $("#username").val();

	$("#btn-search").prop("disabled", true);

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/search",
		data : JSON.stringify(search),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data)
		{

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedback').html(json);

			console.log("SUCCESS : ", data);
			$("#btn-search").prop("disabled", false);

		},
		error : function(e)
		{

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});

}