<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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




</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

		<a class="navbar-brand" href="#"><img
			src="/resources/static/images/cine4.png" class="logo" height="50px"
			width="100px"></a>



		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>

				<c:if test="${id==null}">

					<li class="nav-item"><a href="/register" class="nav-link">Login</a></li>
				</c:if>
				<form:form action="/serchMovie" autocomplete="on" method="post"
					modelAttribute="SerchMovie">
					<li class="nav-item active"><div
							style="margin-left: 80%; width: 250%" class="input-group">

							<input type="text" style="height: 10%; width: 50%"
								name="movieName" class="form-control"
								placeholder="Search For Movie">
							<div class="input-group-append">
								<Button type="submit" value="" class="btn btn-secondary"
									type="button">
									<span class="glyphicon glyphicon-search"></span>
								</Button>
							</div>

						</div></li>
				</form:form>

			</ul>

			<c:if test="${id>0 }">
				<ul class="navbar-nav mr">
					<li class="nav-item" style="display: inline; list-style: none;"><a
						href="/userDashboard" class="nav-link">${customername}</a></li>
					<li class="nav-item" style="display: inline; list-style: none;"><a
						class="nav-link" href="/logout"><button
								class="btn btn-outline-light">logout</button></a></li>
				</ul>
			</c:if>
		</div>
	</nav>
	<hr>
	<div id="carouselExampleIndicators"
		style="width: 80%; position: relative; margin-left: 10%; margin-top: 4%"
		class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" height="400px"
					src="/resources/static/images/fast.jpg" alt="First slide"
					width="400px">
				<div class="carousel-caption d-none d-md-block">
					<h1>Fast and furious</h1>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" width="400px" height="400px"
					src="/resources/static/images/2.jpg" alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h1>Book Your Movie</h1>
					
				</div>
			</div>
			<div class="carousel-item">
				<img height="400px" class="d-block w-100" width="400px"
					src="/resources/static/images/3.jpeg" alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h1>Book your movie</h1>
					
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
	<hr>
	<main role="main" class="mt-5" style="margin-top: 10%">

		<div class="container">

			<h3 align="center">Today's hits</h3>
			<table>
				<tr>

					<c:set var="count" value="0" scope="page" />
					<c:forEach var="movies" items="${listMovies}">
						<c:url var="moviedetail" value="/movieDeatil">
							<c:param name="mid" value="${movies.id}" />
						</c:url>
						<c:set var="count" value="${count + 1}" scope="page" />

						<td><a href='${moviedetail}'>
								<div class="row ml-5">
									<div class="card" style="width: 18rem;">

										<img class="card-img-top"
											src="/resources/static/images/${movies.posterlink}"
											height="300px" width="20px" alt="Card image cap">
										<div class="card-body">
											<p class="card-text">${movies.moviename}</p>

										</div>
									</div>


								</div>
						</a></td>

						<c:if test="${count % 3 == 0}">
				</tr>
				<tr style="margin-top: 5%">
					</c:if>
					</c:forEach>
				</tr>
			</table>
			

		</div>
		<!-- /container -->
	</main>

	<footer class="pt-4">

		<div class="row"
			style="color: white; background-color: #1d1e1f">
			<div class="col-12 col-md">
				<img src="/resources/static/images/cine4.png" style="margin-left:25%;margin-top:5%" class="logo"
					height="50px" width="100px">

			</div>
			<div class="col-6 col-md">
				<br/>
				<h5>Best language Genre Movies</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Bollywood Movie</a></li>
					<li><a class="text-muted" href="#">Hindi comedy movie</a></li>
				</ul>
			</div>
			<br/>
			<div class="col-6 col-md">
				<br/>
				<h5>Movies Cinema Celibrity</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Latest Upcoming Movies</a></li>
					<li><a class="text-muted" href="#">Best now Showing Movies</a></li>

				</ul>
			</div>
			<br/>
			<div class="col-6 col-md">
				<br/>
				<h5>About</h5>
				<ul class="list-unstyled text-small">
					<li><a class="text-muted" href="#">Team</a></li>
					<li><a class="text-muted" href="#">Locations</a></li>

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
	<c:if test="${booked==1}">alert("Booked Successful check in your account");</c:if>
	${booked }
</body>

</html>