<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/aa.css">
</head>
<body>
	<div class="container">
		<section id="content">
			<form action="log">
				<h1>Login Form</h1>
				<div>
					<input type="text" placeholder="Username" id="username" name="name" />
				</div>
				<div>
					<input type="password" placeholder="Password" id="password"
						name="password" />
				</div>
				<div>
					<input type="submit" value="Log in" /> <a href="reg">Register</a>
				</div>


			</form>
			<div>
				<%
					String ss = (String) request.getAttribute("msg");

				if (ss != null) {
				%>
				<h3 style="color: red" align="center">${msg}</h1>

					<%
						}
					%>
				
			</div>
		</section>
		<!-- content -->
	</div>
	<!-- container -->

</body>
</html>