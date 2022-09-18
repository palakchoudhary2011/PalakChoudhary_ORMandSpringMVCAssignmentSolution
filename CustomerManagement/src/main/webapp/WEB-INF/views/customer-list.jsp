<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
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
		<a
							href="/CustomerManagement/createCustomer"
							class="btn btn-sm" style="margin: 2rem 0; background-image: linear-gradient(to bottom right, #cc2b5e, #753a88); color: #ffffff"> Add customer </a> 
		

		<!-- Add a search form -->


		<table class="table table-bordered table-striped">
			<thead class="" style=" background-image: linear-gradient(to bottom right, #cc2b5e, #753a88); color:#FFFFFF">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<td><c:out value="${customer.f_name}" /></td>
						<td><c:out value="${customer.l_name}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerManagement/updateCustomer?id=${customer.id}"
							class="btn btn-info btn-sm" style="background-image: linear-gradient(to bottom right, #cc2b5e, #753a88); border:  none; color: #ffffff"> Update </a> <!-- Add "delete" button/link -->
							<a href="/CustomerManagement/delete?id=${customer.id}"
							class="btn btn-danger btn-sm" style="background-image: linear-gradient(to bottom right, #bdc3c7, #2c3e50); border:  none; color: #ffffff""
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
	
	
</body>
</html>