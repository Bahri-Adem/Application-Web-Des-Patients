<%@page import="com.javaBeans.Pharmacie"%>
<%@page import="com.DAO.PharmacieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.javaBeans.User"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- ===== BOX ICONS ===== -->
<link
	href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css'
	rel='stylesheet'>
<!-- ===== CSS ===== -->
<link rel="stylesheet" href="css/styles.css">
<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/Accueil.css" rel="stylesheet">
<title>Patient</title>
</head>

<%
PharmacieDAO pharmaDao = new PharmacieDAO();
User user = (User) session.getAttribute("user");
Pharmacie ph = pharmaDao.getPharmacieById(user.getId_user());
%>

<body id="body-pd">
	<%@ include file="side-bar_pharmacie.jsp"%>

	<div class="container-fluid" style="padding-top: 5rem;">
		<%
		if (request.getAttribute("action") != null) {
		%>
		<div class="alert alert-success" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>L'Ajout !</strong> est effectué avec succès.
		</div>
		<%
		}
		%>

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">
			<b>Bonjour <%=user.getFirstName() + " " + user.getLastName()%></b>
		</h1>
		<h1 class="h3 mb-2 text-gray-800">
			<b>Adresse: <%=ph.getAdresse()%></b>
		</h1>
		<div class="row">

			<div class="col-4">
				<a href="/Cabinet/Patients">
					<div class="box">
						<div class="imgBx">
							<img src="images/doussi1.png" width="250px" height="300">
						</div>
						<p class="text">Les Patients</p>
						<div class="details">
							<h2>Patients</h2>
						</div>
					</div>
				</a>
			</div>

			<div class="col-4">
				<a href="/Cabinet/All_Prescription">
					<div class="box">
						<div class="imgBx">
							<img src="images/presc.png" width="250px" height="300">
						</div>
						<p class="text">Nouvelles Prescriptions</p>
						<div class="details">
							<h5>Nouvelles Prescriptions</h5>
						</div>
					</div>
				</a>
			</div>
			<div class="col-4">
				<a href="/Cabinet/All_Prescription_Vendu">
					<div class="box">
						<div class="imgBx">
							<img src="images/med.png" width="250px" height="300">
						</div>
						<p class="text">Prescriptions Vendus</p> 	
						<div class="details">
							<h4>Prescriptions Vendus</h4>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>

	<!-- script -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<!--===== MAIN JS =====-->
	<script src="js/main.js"></script>
	<!-- script -->
</body>
</html>
