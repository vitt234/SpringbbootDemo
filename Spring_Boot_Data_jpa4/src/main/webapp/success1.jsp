<%@page import="com.example.demo.model.Student"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<title>Success page</title>
<link rel="stylesheet" type="text/css" href="/css/xyz.css" />
<script type="text/javascript">
	function deleteRecord() {
		alert("You Want to delete Record..?")
		document.form.action = "delete";
		document.form.submit();
	}

	function editRecord() {
		alert("You Want to Update data..?")
		document.form.action = "edit";
		document.form.submit();
	}

	function SortRecord() {
		alert("You Want to sort data..?")
		document.form.action = "sort";
		document.form.submit();
	}
	function genrate() {

		var option = document.getElementById("myselect").value
		if (option == 1) {

			alert("You Want to Genarate Pdf..?")
			document.form.action = "exportpdf";
			document.form.submit();
		} else {
			alert("You Want to Genarate excel..?")
			document.form.action = "excel";
			document.form.submit();

		}

	}
</script>


</head>
<form name="form">
	<div class="container">
		<h1 style="color: black" align="center">Student Deails</h1>
		<table>

			<tr>
				<th>id</th>
				<th>name</th>
				<th>pass</th>
				<th>address</th>
				<th>mobno</th>
				<th>email</th>
				<th>select</th>

			</tr>


			<%
				List<Student> list = (List<Student>) request.getAttribute("data");

			for (Student stu : list) {
			%>

			<tr>
				<td><%=stu.getId()%></td>
				<td><%=stu.getName()%></td>

				<td><%=stu.getPassword()%></td>

				<td><%=stu.getAddress()%></td>

				<td><%=stu.getMobno()%></td>


				<td><%=stu.getEmail()%></td>


				<td><input type="radio" name="id" value="<%=stu.getId()%>"></td>


			</tr>
			<%
				}
			%>
			<tr>


				</td>


				<td colspan="2" align="center">


					<button class="button button2" onclick="editRecord()">Edit</button>


				</td>

				<td colspan="1" align="center">

					<button class="button button1" onclick="deleteRecord()">Delete</button>
				</td>




				<td colspan="3" align="center"><select name="sortvalue"
					id="myselect" onchange="SortRecord()">
						<option>SelectSort</option>
						<option value="1">ById</option>
						<option value="2">ByName</option>
						<option value="3">ByAdd</option>

				</select></td>

				<td colspan="3" align="center"><select name="download"
					id="myselect" onchange="genrate()">
						<option>download</option>
						<option value="1">PDF</option>
						<option value="2">Excel</option>
				</select></td>


			</tr>
		</table>
</form>
</div>
</html>