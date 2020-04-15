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
<title>User| Home</title>



<!-- Bootstrap core CSS -->
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

		<a class="navbar-brand" href="/"><img
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

				<li class="nav-item "><a class="nav-link" href="${home}">Home
				</a></li>

				<li class="nav-item active" Style="align-content: center;"><a
					class="nav-link " href="/#">${customer.firstname} </a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item "><a class="nav-link" href="/logout"><button
							class="btn btn-outline-light">logout</button></a></li>
			</ul>
		</div>
	</nav>




 <div class="d-flex" id="wrapper">

        <!-- Sidebar -->
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="sidebar-heading">${customername}</div>
            <div class="list-group list-group-flush">
                <a href="/userDashboard" class="list-group-item list-group-item-action bg-light">Home</a>
                <a href="/userBookingDetail" class="list-group-item list-group-item-action bg-light">Edit Detail</a>
                <a href="/userBookingDetail" class="list-group-item list-group-item-action bg-light">Booking Detail</a> 
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <div class="container-fluid" >
            <h1 class="mt-4" align="Center">Booking Detail</h1>
            <section class="col-md-6" >
                <div class="detail" style="width:200%">

                    <table class="table ">
                        <thead>
                            <tr>
                                <th>User Name</th>
                                <th>Movie Name</th>
                                <th>Date</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="bookingDetail" items="${bookingDetail}">
                                <tr>
                                    <td>${bookingDetail.customer.firstname}</td>
                                    <td>${bookingDetail.movies.moviename}</td>
                                    <td>${bookingDetail.bookingDate}</td>
                                    <td>${bookingDetail.price_movie}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
               </section>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

    







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