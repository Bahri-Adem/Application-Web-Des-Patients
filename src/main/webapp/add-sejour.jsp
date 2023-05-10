<%@page import="com.DAO.LaboratoireDAO"%>
<%@page import="com.javaBeans.Laboratoire"%>
<%@page import="com.DAO.PatientDAO"%>
<%@page import="com.javaBeans.Medecin"%>
<%@page import="com.javaBeans.Patient"%>
<%@page import="com.javaBeans.User"%>
<%@page import="com.DAO.MedecinDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <!-- ===== BOX ICONS ===== -->
	    <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
	    <!-- ===== CSS ===== -->
	    <link rel="stylesheet" href="css/styles.css">
	    <!-- ===== CSS font ===== -->
	    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	    <!--lien dataTable.css-->
	       <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
	    <!-- Custom styles for this template-->
	    <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <title>Ajouter un Sejour</title>
    </head>
    <body id="body-pd">
    	 <!--===== SIDE BAR =====-->
    	<%@ include file="side-bar_clinique.jsp" %>
    
        <div class="container-fluid" style="margin-top: 100px;">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800"><b>Ajouter un Sejour</b> </h1>
        </div>
        
        <!-- Content Row -->
        <div class="row">
	        <%
	        	String add  = (String) request.getAttribute("add");
	        	if(add != null && add.equals("success")){
	        		
	        %>
		        <div class="alert alert-success" role="alert" >
		        	Sejour ajouté
		        </div>
        	
            <%
	        	}
            %>
            <div class="col-xl-12 col-lg-10">
                <div class="card shadow mb-4">
                    
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary"><i class="fa fa-list-alt" aria-hidden="true"></i> &nbsp;Informations du Sejour</h6>
                    </div>
                    
                    <!-- Card Body -->
                    <div class="card-body">
	                    <form action="/Cabinet/AddSejour" method="POST" style="color: black;">
	                    	<input type="hidden" class="form-control" name="id" value="" required>
	                    	
	                    	<div class="mb-3">
		                        <div class="row">
									<div class="col">
										<label class="form-label">Date de début du Sejour</label>
									  	<input type="DAte" class="form-control" id="date_debut" name="date_debut" required>
									</div>
									
									<div class="col">
										<label class="form-label">Date de fin du Sejour</label>
									 	<input type="DAte" class="form-control" name="date_fin" id="date_fin" required>
									</div>
								</div>
							</div>
							<div class="mb-3">
								<div class="row">
									<div class="col">
										<div class="form-row d-flex flex-column pb-3">
			                               <label for="treatment">Patient :</label>
			                               <div class="form-select">
			                                <select name="patient" class="form-control" id="medecin">
										<%
											PatientDAO patDao = new PatientDAO();
											ArrayList<Patient> patList =patDao.ListePatients();
											for (Patient pat : patList ){
						                %>
											<option value="<%=pat.getId_user() %>"> <%=pat.getLastName()+" "+pat.getFirstName()%></option>
										<%
											}
							               %>
										 </select>
		                               </div>
		                           </div> 
							</div>
									<div class="col">
										<div class="form-row d-flex flex-column pb-3">
			                               <label for="treatment">Medecin :</label>
			                               <div class="form-select">
			                                <select name="medecin" class="form-control" id="medecin">
											<%
												User user = (User) session.getAttribute("user");
												int id_clinique = user.getId_user();
												MedecinDAO medDao = new MedecinDAO();
												ArrayList<Medecin> medList =medDao.getListeMedecinByIdClinic(id_clinique);
												for (Medecin med : medList ){
							                %>
												<option value="<%=med.getId_medecin() %>"> <%=med.getNom()%></option>
										<%
											}
							               %>
		                                   </select>
		                               </div>
		                           </div> 
							</div>
						</div>
						</div>
							<div class="mb-3 ">
		                        <div class="row">
								  <div class="col">
								  	<label class="form-label">Raison du Sejour</label>
								    <textarea rows="2" cols="4"class="form-control" name="raison" id="raison"></textarea>
								  </div>
								  							  
								</div>
							</div>
						 	<div >
		                        <label style="padding-right:30px;">Voulez-vous ajouter un ordonnance</label>
		                        <input class="presc" type="radio" name="presc" id="oui" value="oui" >
		                        <label class="label" for="oui" style="padding-right:30px;">OUI</label>
		                        <input class="presc" type="radio" name="presc" id="non" checked value="non">
		                        <label class="label" for="non">NON</label>
	                   		</div>
	                    	<div class="mb-3 presc" id="presc" style="display: none">
		                        <div class="row">
									<div class="col">
										<label class="form-label">Titre d'ordonnance</label>
									  	<input type="text" class="form-control" id="title" name="title" >
									</div>
								  
									<div class="col">
										<label class="form-label">Description</label>
									 	<textarea rows="2" cols="4"class="form-control" name="description" id="description"></textarea>
									 
									</div>
								</div>
								<div class="mb-3 ">
			                        <div class="row">
										<div class="col">
											<label class="form-label">Liste des médicaments</label>
										  	<textarea rows="2" cols="4"class="form-control" name="medicationList" id="medicationList"></textarea>
										</div>
									</div>
								</div>
							</div>
	                    	
							
							<button type="submit" class="btn btn-primary" style="margin-right: 20px;">Ajouter</button>
							<a href="/Cabinet/All_Sejour" class="btn btn-danger ">Quitter</a>
						  
						</form>  
                    </div>
                    
                </div>
            </div>

        </div>
        
    </div>
    <!-- footer -->
	<%@ include file="footer.jsp" %>
	<!-- fin footer -->
    <!--===== MAIN JS =====-->
    <script src="js/main.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
    <script type="text/javascript">
    	$(document).ready(function() {
    		$("#oui").click(function() {
         	   $("#presc").css("display","block")
         	});
    		$("#non").click(function() {
          	   $("#presc").css("display","none")
          	});
    		
    	});
             	
    </script>
    <script>
	    if ( window.history.replaceState ) {
	        window.history.replaceState( null, null, window.location.href );
	    }
	</script>
    </body>
</html>