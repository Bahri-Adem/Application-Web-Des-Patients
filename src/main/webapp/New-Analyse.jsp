<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.javaBeans.Resultat_Analyse"%>
<%@page import="com.javaBeans.Patient"%>
<%@page import="com.DAO.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <!-- ===== BOX ICONS ===== -->
	    <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
	    <!-- ===== CSS ===== -->
	    <link rel="stylesheet" href="css/styles.css">
	    <!-- Custom styles for this template-->
	    <link href="css/sb-admin-2.min.css" rel="stylesheet">
	    <title>Ajouter une resultat d'Analyse</title>
	</head>
	
    <body id="body-pd">
    	<%@ include file="side-bar_laboratoire.jsp"%>
    	
    	<div class="container-fluid" style="padding-top:5rem;">	        	
	        <!-- Page Heading -->
	        <div class="d-sm-flex align-items-center justify-content-between mb-4">
	            <h1 class="h3 mb-0 text-gray-800">Ajouter une resultat d'Analyse </h1>
	        </div>
	        
	        <!-- Content Row -->
	        <div class="row">
	
	            <!-- Area Chart -->
	            <div class="col-xl-12 col-lg-10">
	                <div class="card shadow mb-4">
	                   	                                     
	                    <!-- Card Header - Dropdown -->
	                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
	                        <h6 class="m-0 font-weight-bold text-primary">Les informations d'Analyse</h6>
	                    </div>
	                    
	                    <!-- Card Body -->
	                    <div class="card-body">
		                    <form action="Analyses" method="POST">
		                  		<div class="mb-3">								  
								  	<label class="form-label">Type d'Analyse </label>
								    <input type="text"  class="form-control" name="type_analyse" id="analyseId" required>
								</div>
		                    	<div class="form-row d-flex flex-column pb-3">
		                               <label for="treatment">Laboratoire d'Analyse :</label>
		                               <div class="form-select">
		                                   <select name="patient" class="form-control" id="centreId">
		                                   <%
		                                   		PatientDAO patDao = new PatientDAO();
		                               			ArrayList<Patient> patList =patDao.ListePatients();
							                	for (Patient patient : patList ){
							                %>
												<option value="<%=patient.getId_user()%>"> <%=patient.getLastName()+" "+patient.getFirstName()%></option>
							<%
							}
			               %>
		                                   </select>
		                               </div>
		                           </div>                         	                   
								<div class="mb-3">								  
								  	<label class="form-label">Date d'Analyse </label>
								    <input type="datetime-local"  class="form-control" name="datetime" id="datetimeId" required>
								</div>
								<div class="mb-3">								  
								  	<label class="form-label">Resultat d'Analyse </label>
								    <input type="file"  class="form-control" name="resultat" id="resultId" required>
								</div>
							  	<button type="submit" class="btn btn-primary" name="submit" id="submitId">Confirmer</button>
						
							</form>  
	                    </div>
	                    
	                </div>
	            </div>
	
	        </div>
		        
		</div>
			
		<script>
		    if ( window.history.replaceState ) {
		        window.history.replaceState( null, null, window.location.href );
		    }
		</script>
		<!--===== MAIN JS =====-->
		<script src="js/main.js"></script>
	</body>

</html>