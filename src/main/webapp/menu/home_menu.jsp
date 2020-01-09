<style>
body
{
	padding-top: 4.5rem;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	// get current URL path and assign 'active' class
	var pathname = window.location.pathname;
	$('.navbar-nav > li > a[href="'+pathname+'"]').parent().addClass('active');
})
</script>
<div id="header">
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="/">HDFS Cluster</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="home">Home<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="admin">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
			</ul>
		</div>

	<ul class="nav navbar-nav navbar-right">

		<li><a class="nav-link" href="#"> Logout</a></li>
	</ul>
	</nav>
</div>

<script src="../resources/static/bootstrap/js/bootstrap.min.js"></script>
	<link href="../resources/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">