<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Customer Relationship Management</title>
</head>
<body>
	
			<center>
		<h1 style=" background-image: linear-gradient(to bottom right, #cc2b5e, #753a88); padding: 3rem; color:#FFFFFF">Customer Relationship Management</h1>	
	</center>
		<div class="container">
		<p class="h4 mb-4">Save Customer</p>

		<form action="/CustomerManagement/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customers.id}" />

			<div class="form-inline">
				<input type="text" name="f_name" value="${Customers.f_name}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>

			<div class="form-inline">

				<input type="text" name="l_name" value="${Customers.l_name}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Customers.email}"
					class="form-control mb-4 col-4" placeholder="Email">



			</div>

			<button type="submit" class="btn btn-info col-2" style="background-image: linear-gradient(to bottom right, #cc2b5e, #753a88); border:  none; color: #ffffff">Save</button>
			

		</form>

		<hr>
		<a href="/CustomerManagement">Back to Customer List</a>

	</div>
</body>

</html>



	
</body>
</html>