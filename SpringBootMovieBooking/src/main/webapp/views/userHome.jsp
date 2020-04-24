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
<title>User| Home</title>
<link rel="stylesheet" href="/resources/static/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/static/css/simple-sidebar.css">
<style>
.main {
	background-color: #f3f3f1;
}
</style>
<body>
	<c:url var="updateLink" value="/edit">
		<c:param name="id" value="${customer.id}" />
	</c:url>
	<c:url var="home" value="/">
		<c:param name="id" value="${customer.id}" />
	</c:url>
	<nav class="navbar navbar-expand-md navbar-dark  bg-dark">

		<a class="navbar-brand" href="/"><img src="/resources/static/images/cine4.png" class="logo" height="50px"
			width="100px"></a>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item "><a class="nav-link" href="${home}">Home
				</a></li>
				<form:form action="/serchMovie" autocomplete="on" method="post"
							modelAttribute="SerchMovie">
				<li class="nav-item active"><div
						style="margin-left: 80%; width: 250%" class="input-group">
						
							<input type="text" style="height: 10%; width: 50%" name="movieName"
								class="form-control" placeholder="Search For Movie">
							<div class="input-group-append">
								<Button type="submit" value="" class="btn btn-secondary"
										type="button">
										<span class="glyphicon glyphicon-search"></span>
									</Button>
							</div>
						 
					</div></li></form:form> 
				

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item active" Style="align-content: center;"><a
					class="nav-link " href="/userDashboard">${customer.firstname} </a></li>
				<li class="nav-item " style="list-style: none;"><a class="nav-link" href="/logout"><button
							class="btn btn-outline-light">logout</button></a></li>
			</ul>
		</div>
	</nav>


	<c:url var="updateLink" value="/edit">
		<c:param name="id" value="${customer.id}" />
	</c:url>




	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="sidebar-heading">${customername}</div>
			<div class="list-group list-group-flush">
				<a href="/userDashboard"
					class="list-group-item list-group-item-action bg-light">Home</a> <a
					href="/cancelticketPage"
					class="list-group-item list-group-item-action bg-light">Cancel Ticket
					Detail</a> <a href="/userBookingDetail"
					class="list-group-item list-group-item-action bg-light">Booking
					Detail</a>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->

		<div class="container-fluid">
			<section class="col-md-8 blog-main ">
				<h3 align="center">Welcome to cineTik</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>User Name:</th>
							<td>${customer.firstname}</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Email:</td>
							<td>${customer.email}</td>
						</tr>
						<tr>
							<td>Password:</td>
							<td>${customer.password}</td>

						</tr>
						<tr>
							<td rowspan="2"><a href='${updateLink}'>edit details</a></td>
						</tr>
					</tbody>
				</table>
				
			</section>
		</div>
	</div>


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