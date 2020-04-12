<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">
<title>ONLINE MOVIE BOOKING</title>



<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="/resources/static/css/bootstrap.min.css">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

		<a class="navbar-brand" href="#"><img
			src="/resources/static/images/cinema.png" class="logo" height="50px"
			width="60"></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a href="/register" class="nav-link">Login</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown01"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Type</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
						<a class="dropdown-item" href="#">Bollywood</a> <a
							class="dropdown-item" href="#">Hollywood</a> <a
							class="dropdown-item" href="#">Pollywood</a>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search" style="align-items: center;">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" height="400px"
					src="/resources/static/images/1.jpg" alt="First slide"
					width="400px">
				<div class="carousel-caption d-none d-md-block">
					<h1>Book Your Movie</h1>
					<h2>Enjoy Your favourite movies here</h2>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" width="400px" height="400px"
					src="/resources/static/images/2.jpg" alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h1>Book Your Movie</h1>
					<h2>Enjoy Your favourite movies here</h2>
				</div>
			</div>
			<div class="carousel-item">
				<img height="400px" class="d-block w-100" width="400px"
					src="/resources/static/images/3.jpeg" alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h1>Book your movie</h1>
					<h2>Enjoy Your favourite movies here</h2>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<main role="main" class="mt-5">

		<div class="container">

			
			<table>
				<tr>
				<c:forEach var="movies" items="${listMovies}">
					
					<td><div class="row ml-5">
						<div class="card" style="width: 18rem;">
							<img class="card-img-top" src='${movies.posterlink}' 
								height="400px" width="60px" alt="Card image cap">
							<div class="card-body">
								<p class="card-text" >${movies.moviename}</p>
							</div>
						</div>
						<hr>
						
					</div>
					</td>
					</c:forEach>
					</tr>
			</table>
			
			
		</div>
		<!-- /container -->
	</main>

	<footer class="pt-4 my-md-5 pt-md-5 border-top">
		<div class="row">
			<div class="col-12 col-md">
				<img class="mb-2" src="/docs/4.4/assets/brand/bootstrap-solid.svg"
					alt="" width="24" height="24">

			</div>
			<div class="col-6 col-md">
				<h5>Best lnguage Genre Movies</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Bollywood Movie</a></li>
					<li><a class="text-muted" href="#">Hindi comedy movie</a></li>
					<li><a class="text-muted" href="#">English Comedy movie</a></li>
					<li><a class="text-muted" href="#">English Action Movie</a></li>
					<li><a class="text-muted" href="#">Punjabi comedy movie</a></li>
					<li><a class="text-muted" href="#">Hindi Action movie</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>Movies Cinema Celibrity</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Latest Upcoming Movies</a></li>
					<li><a class="text-muted" href="#">Best now Showing Movies</a></li>
					<li><a class="text-muted" href="#">Movies stars and
							celibrity</a></li>
					<li><a class="text-muted" href="#">Best Cinemas</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>About</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Team</a></li>
					<li><a class="text-muted" href="#">Locations</a></li>
					<li><a class="text-muted" href="#">Privacy</a></li>
					<li><a class="text-muted" href="#">Terms</a></li>
				</ul>
			</div>
		</div>
	</footer>
	<script src="/resources/static/js/jquery.min.js"></script>
	<!-- <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script> -->
	<script src="/resources/static/js/bootstrap.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>



</body>

</html>