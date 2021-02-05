<head>
<meta charset="utf-8">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="/css/aa.css" />
</head>
<body>
	<div class="container">
		<section id="content">
			<form action="register">
				<h1>Registration Form</h1>

				<div>
					<input type="text" placeholder="UserId" required="" id="username"
						name="id" />
				</div>
				<div>
					<input type="text" placeholder="Username" required="" id="username"
						name="name" />
				</div>
				<div>
					<input type="password" placeholder="Password" required=""
						id="password" name="password" />
				</div>

				<div>
					<input type="text" placeholder="UserAddress" required=""
						id="username" name="address" />
				</div>
				<div>
					<input type="text" placeholder="UserMob" required="" id="username"
						name="mobno" />
				</div>

				<div>
					<input type="text" placeholder="UserEmail" required=""
						id="username" name="email" />
				</div>
				<div>


					<input type="submit" value="Register" style="align-self:" />
				</div>

			</form>
			<!-- form -->

		</section>
		<!-- content -->
	</div>
	<!-- container -->
	
	
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
	
</body>
</html>