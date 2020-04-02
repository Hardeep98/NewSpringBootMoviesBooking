<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CineTik|Register</title>
 <link rel="stylesheet" type="text/css" href="/resources/static/css/style.css" />
 <link rel="stylesheet" type="text/css" href="/resources/static/css/animate-custom.css" />
 <link rel="stylesheet" type="text/css" href="/resources/static/css/basic_Edit.css" />
 <script type="text/javascript" >
 function validate() {
		var password = document.getElementById("password").value;
		var Cpassword = document.getElementById("cpassword").value;
		if (password != Cpassword) {
			alert('Password Shuould match confirm password');
			return false;
		} else if (password == "") {
			alert('Password Shuould not be empty');
			return false;
		} else {
			return true;
		}

	}
 
 </script>
</head>
<div class="bgimg"></div>
<div class="container">
	<section>
		<div id="container_demo">
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form:form  autocomplete="on" method="post" modelAttribute="customer" >
						<h1>Log in</h1>
						<p>
							<label for="username"  class="uname" data-icon="u"> Your
								email or username </label> <input id="username" name="firstname"
								required="required" type="text"
								placeholder="myusername or mymail@mail.com" />
						</p>
						<p>
							<label for="password" class="youpasswd"  data-icon="p">
								Your password </label> <input id="password" name="password"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<<!-- p class="keeplogin">
							<input type="checkbox" name="loginkeeping" id="loginkeeping"
								value="loginkeeping" /> <label for="loginkeeping">Keep
								me logged in</label>
						</p> -->
						<p class="login button">
							<input type="submit" value="Login" />
						</p>
						<p class="change_link">
							Not a member yet ? <a href="#toregister" class="to_register">Join
								us</a>
						</p>
					</form:form>
				</div>
				<div id="register" class="animate form">
					<form:form action="/save" autocomplete="on" method="post" modelAttribute="customer" onsubmit="return validate()">
						<h1>Sign up</h1>
						<p>
							<label for="usernamesignup" class="uname" data-icon="u">Your
								username</label> <input id="usernamesignup" name="firstname"
								required="required" type="text" placeholder="mysuperusername690" />
						</p>
						<p>
							<label for="emailsignup" class="youmail" data-icon="e">
								Your email</label> <input id="emailsignup" name="email"
								required="required" type="email"
								placeholder="mysupermail@mail.com" />
						</p>
						<p>
							<label for="passwordsignup" class="youpasswd" data-icon="p">Your
								password </label> <input id="passwordsignup" name="password"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						 <p>
							<label for="passwordsignup_confirm" class="youpasswd"
								data-icon="p">Please confirm your password </label> <input
								id="passwordsignup_confirm" name="cpassword"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p> 
						<p class="signin button">
							<input type="submit" value="Sign up" />
						</p>
						<p class="change_link">
							Already a member ? <a href="#tologin" class="to_register"> Go
								and log in </a>
						</p>
					</form:form>
				</div>

			</div>
		</div>
	</section>
</div>
</html>