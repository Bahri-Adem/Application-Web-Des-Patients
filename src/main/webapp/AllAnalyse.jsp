<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <!-- ===== BOX ICONS ===== -->
     <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
     
     <!-- ===== CSS ===== -->
     <link href="css/sb-admin-2.min.css" rel="stylesheet">
     <link rel="stylesheet" href="css/styles.css">
     
     <!-- ===== CSS font ===== -->
     <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
     <!--lien dataTable.css-->
     <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

     <title>Liste des Analyses</title>
    </head>

    <%@ page import = "com.javaBeans.Resultat_Analyse" %>
	<%@ page import = "java.util.ArrayList" %>
	<%@ page import = "java.util.Date" %>
	
	<body id="body-pd">
	
	<%@ include file="side-bar_laboratoire.jsp" %>	
	
		<!-- Begin Page Content -->
		<div class="container-fluid" style="padding-top:1rem;">
		
		<%
			ArrayList<Resultat_Analyse> resultats = (ArrayList<Resultat_Analyse>) request.getAttribute("resultats");
	
			if(request.getAttribute("action")!=null)
			{ 
				if(request.getAttribute("action").equals("supprimer"))
				{
		%>
					<div class="alert alert-danger" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span></button>
					  	<strong>Analyse ! numéro <%= request.getAttribute("id_A") %></strong> est supprimée !!  	
				    </div>
	    <%
				}
			}
		%>

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800"><b>Liste des Analyses</b></h1>
		 
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Informations des Analyses</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                           <tr>
								<th>#</th>
								<th>Date d'Analyse</th>
								<th>Patient</th>
								<th>Type d'Analyse</th>
								<th>Laboratoire</th>
								<th>Resultat</th>
								<th>Actions</th>
							</tr>
							</thead>

							<tbody>
								<%
			                	int id2=1;     	
			                	for (Resultat_Analyse result: resultats ){
			                %>
								<tr>
									<td><%=id2 %></td>
									<td><%=result.getDate_resultat() %></td>
									<td><%=result.getPatient().getLastName()+" "+result.getPatient().getFirstName() %></td>
									<td><%=result.getType_analyse() %></td>
									<td><%=result.getLaboratoire().getNom() %></td>
									<td>
										<!-- <input type="hidden" name="id" value="" /> -->
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#ModalShow<%=id2 %>">
											<i class="fas fa-edit"></i>
										</button>
										<div class="modal" id="ModalShow<%=id2 %>" tabindex="-1"
											role="dialog" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-body">
														<table class="table table-bordered table-striped"
															style="color: black; font-weight: bold;">
															<tbody>

																<tr>
																	<td>Type d'analyse d'ordonnance :</td>
																	<td><%=result.getType_analyse()%></td>
																</tr>
																<tr>
																	<td>Resultat :</td>
																	<td><img src="images/<%=result.getResultat() %>"
																		width="300" height="400" class="team-img"></td>
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
			                     <td>
					                <form action="/Cabinet/All_Analyse" method="POST">						            
					                	<input type="hidden" name="id" value="<%=result.getId_resultat()%>" />	
					                	<button class="btn btn-danger" type="submit"><i class="fas fa-calendar-times"></i></button>				                	
					                </form>
								</td>					        
                            </tr>
							<%
							id2++;
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
		<%@ include file="footer.jsp" %>
		<!-- fin footer -->
		
		<!--===== MAIN JS =====-->
        <script src="js/main.js"></script>
	
		<!-- Custom scripts for all pages-->
	    <script src="js/sb-admin-2.min.js"></script>
	
		<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
		<!--script dataTable-->
	    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	    
	    <script>
            
	       	$(document).ready(function() {
	            var table = $('#dataTable').DataTable();
	   		 } );
    	</script>

    </body>
</html>
    