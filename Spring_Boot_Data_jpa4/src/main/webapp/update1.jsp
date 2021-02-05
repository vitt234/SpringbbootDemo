<%@page import="com.example.demo.model.Student"%>

<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="/css/aa.css" />
</head>
<body>
<%
		Student e = (Student) request.getAttribute("data");
	%>
	<div class="container">
		<section id="content">
			<form action="update">
				<h1>UPDATE INFO</h1>

				<div>
					<input type="text""  id="username"
						name="id"  value="<%=e.getId()%>" />
				</div>
				<div>
			<input type="text" id="username" name="name"
				value="<%=e.getName()%> " />
		</div>
		<div>
			<div>
				<input type="text" id="username" name="password"
					value="<%=e.getPassword()%> " "/>
			</div>
			<div>
				<input type="hidden" id="username" name="address"
					value="<%=e.getAddress()%> " "/>
			</div>

			<div>
				<input type="hidden" id="username" name="mobno"
					value="<%=e.getMobno()%> " "/>
			</div>
				<div>
				<input type="hidden" id="username" name="email"
					value="<%=e.getEmail()%> " "/>
			</div>

			<input type="submit" value="Submit" /> 
		</div>
			</form>
			<!-- form -->

		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
</html>