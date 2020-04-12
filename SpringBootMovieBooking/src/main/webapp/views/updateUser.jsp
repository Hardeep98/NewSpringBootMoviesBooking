<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CineTik|Update</title>


<link rel="stylesheet" type="text/css"
	href="/resources/static/css/update.css" />
</head>
<body>

    <div class="main">

        <section class="signup">
          
            <div class="container">
                <div class="signup-content">
                    <form:form method="POST" id="update-form"  modelAttribute="updateUser" action="/save" class="signup-form">
                        <h2 class="form-title">Update</h2>
                        <div class="form-group">
                            <input type="text" class="form-input"  readonly="readonly"  value="${customer.id}"name="id" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input"  value="${customer.firstname}"name="firstname" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" value ="${customer.email}" id="email" placeholder="Your Email" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password" />
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password" />
                        </div>

                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up" />
                        </div>
                    </form:form>

                </div>
            </div>
        </section>

    </div>

</body>
</html>