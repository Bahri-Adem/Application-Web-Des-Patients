<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- ===== BOX ICONS ===== -->
<link
	href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css'
	rel='stylesheet'>

<!-- ===== CSS ===== -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">

<!-- ===== CSS font ===== -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<!--lien dataTable.css-->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

<title>Liste des Sejours</title>
</head>

<%@ page import="com.javaBeans.Sejour"%>
<%@ page import="com.javaBeans.User"%>
<%@ page import="com.DAO.SejourDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>

<body id="body-pd">

	<%@ include file="side-bar_clinique.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid" style="padding-top: 1rem;">

		<%


		if (request.getAttribute("action") != null) {
			if (request.getAttribute("action").equals("supprimer")) {
		%>
		<div class="alert alert-danger" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Consultation ! numéro <%=request.getAttribute("id_A")%></strong>
			est supprimée !!
		</div>
		<%
		}
		}
		%>

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">
			<b>Liste des Sejours</b>
		</h1>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Informations des
					Sejours</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#</th>
								<th>Date de Début</th>
								<th>Date de fin</th>
								<th>Patient</th>
								<th>Raison</th>
								<th>Clinique</th>
								<th>Medecin</th>
								<th>Specialité</th>
								<th>Ordonnance</th>
							</tr>
						</thead>
						<tbody>
							<%
							int id1 = 1;
							SejourDAO sejourDao = new SejourDAO();
							User user = (User) session.getAttribute("user");
							int id_clinique = user.getId_user();
							ArrayList<com.javaBeans.Sejour> sejours = sejourDao.getAllSejourByIdClinic(id_clinique);
							//ArrayList<Sejour> sejours = (ArrayList<Sejour>) request.getAttribute("sejours");
							for (Sejour sejour : sejours) {
							%>

							<tr>
								<td><%=id1%></td>
								<td><%=sejour.getDate_debut()%></td>
								<td><%=sejour.getDate_fin()%></td>
								<td><%=sejour.getPatient().getLastName() + " " + sejour.getPatient().getFirstName()%></td>
								<td><%=sejour.getRaison()%></td>
								<td><%=sejour.getClinique().getNom()%></td>
								<td><%=sejour.getMedecin().getNom()%></td>
								<td><%=sejour.getMedecin().getSpecialite()%></td>
								<td>
									<!-- <input type="hidden" name="id" value="" /> --> <%
									 if (sejour.getPrescription() == null) {
									 %> Vide <%
									 } else {
									 %>
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#ModalShow<%=id1%>">
										<i class="fas fa-edit"></i>
									</button>
									<div class="modal" id="ModalShow<%=id1%>" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-body">
													<table class="table table-bordered table-striped"
														style="color: black; font-weight: bold;">
														<tbody>

															<tr>
																<td>Titre d'ordonnance :</td>
																<td><%=sejour.getPrescription().getTitle()%></td>
															</tr>
															<tr>
																<td>Description :</td>
																<td><%=sejour.getPrescription().getDescription()%></td>
															</tr>
															<tr>
																<td>Liste des médicaments :</td>
																<td><%=sejour.getPrescription().getMedicationList()%></td>
															</tr>


														</tbody>
													</table>
												</div>
												<div class="modal-footer">
													<button type="button"
														class="btn btn-outline-danger waves-effect"
														data-dismiss="modal">Fermer</button>

												</div>
											</div>
										</div>
									</div>
								</td>
								<%
								}
								%>
							</tr>
							<%
							id1++;
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- End of Main Content -->

	<!-- footer -->
	<%@ include file="footer.jsp"%>
	<!-- fin footer -->

	<!--===== MAIN JS =====-->
	<script src="js/main.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!--script dataTable-->
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>

	<script>
		$(document).ready(function() {
			var table = $('#dataTable').DataTable();
		});
	</script>

</body>
</html>
