<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Cinetik|Payment</title>
<link rel="stylesheet" href="/resources/static/css/bootstrap.min.css">

<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<c:url var="payment" value="/payCard">
								<c:param name="id" value='${mId}' />
							</c:url>
							<form:form action="${payment}" class="form" method="post"
								role="form" autocomplete="off" modelAttribute="paymentcard">
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
	
	<div class="content py-5  bg-secondary">
		<div class="container">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<span class="anchor" id="formPayment"></span>
				
					<!-- form card cc payment -->
					<div class="card card-outline-secondary">
						<div class="card-body">
							<h3 class="text-center">Credit Card Payment</h3>
						
							
								<div class="form-group">
									<label for="cc_name">Card Holder's Name</label> <input
										type="text" class="form-control" name="nameOnCard"
										id="cc_name" pattern="\w+ \w+.*" title="First and last name"
										required="required">
								</div>
								<div class="form-group">
									<label>Card Number</label> <input type="text" name="cardNumber"
										class="form-control" autocomplete="off" maxlength="20"
										pattern="\d{16}" title="Credit card number" required="">
								</div>
								<div class="form-group row">
									<label class="col-md-12">Card Exp. Date</label>
									<div class="col-md-8">
										<input type="Date" name="expiray_date" name="expirayDate"
											class="form-control" autocomplete="off"
											title="Three digits at back of your card" required=""
											placeholder="Select Expiry Date Date">
									</div>
									<div class="col-md-4">
										<input type="text" class="form-control" autocomplete="off"
											maxlength="3" pattern="\d{3}" name="cvv"
											title="Three digits at back of your card" required=""
											placeholder="CVV">
									</div>
								</div>
								<div class="row">
									<label class="col-md-12">Amount</label>
								</div>
								<div class="form-inline">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">$</span>
										</div>
										<input type="text" readonly="readonly"
											class="form-control text-right" id="exampleInputAmount"
											placeholder="120">
										<div class="input-group-append">
											<span class="input-group-text">.00</span>
										</div>
									</div>
								</div>
								<hr>
								<div class="form-group row">

									<div class="col-md-12">
										<button type="submit" class="btn btn-success btn-lg btn-block">Submit</button>
									</div>
							
							</div>
							</form:form>
						</div>
					</div>
					<!-- /form card cc payment -->

				</div>
			</div>
		</div>

	


	
	</div>
</body>
</html> --%>