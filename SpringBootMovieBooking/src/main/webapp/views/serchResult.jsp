<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	
	<main role="main" style="margin-top: 10%">

		<div class="container">

			<h3 align="center">search Result</h3>
			<table>
				<tr>


					<c:forEach var="movies" items="${movieList}">
						<c:url var="moviedetail" value="/movieDeatil">
							<c:param name="mid" value="${movies.id}" />
						</c:url>
						<%-- <c:if test="${movies.id % 3 == 0}">
					<br/>
					</c:if> --%>

						<td><a style="text-decoration: none;" href='${moviedetail}'>
								<div class="row ml-5">
									<div class="card" style="width: 18rem;">

										<img class="card-img-top"
											src="/resources/static/images/${movies.posterlink}"
											height="300px" width="10px" alt="Card image cap">
										<div class="card-body">
											<p class="card-text" style="align-content: center;">${movies.moviename}</p>

										</div>
									</div>
									<hr>
									
								</div>
															</a></td>
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

</body>

</html>