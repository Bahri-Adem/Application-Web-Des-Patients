<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>    
<%@ page import = "com.DAO.PrescriptionDAO" %>
<%@ page import = "com.javaBeans.Prescription" %>    	    
<%@ page import = "com.DAO.AppointmentDAO" %>
<%@ page import = "com.javaBeans.Appointment" %>
    <head>
    	<link rel="stylesheet" href="css/notif.css">
    	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   
	</head>
    
    
	<header class="header" id="header">
	    <div class="header__toggle">
	        <i class='bx bx-menu' id="header-toggle"></i>
	    </div>
	    
	   
		
	    <div class="header__img">
	        <img src="images/perfil.jpg" alt="">
	    </div>
	    
	</header>
	
	<div class="l-navbar" id="nav-bar">
	    <nav class="nav">
	        <div>
	            <a href="#" class="nav__logo">
	                <i class='bx bx-layer nav__logo-icon'></i>
	                <span class="nav__logo-name">HEALTH CARE</span>
	            </a>
	
	            <div class="nav__list">
	                <a href="/Cabinet/Home" class="nav__link active">
	                <i class='bx bx-grid-alt nav__icon' ></i>
	                    <span class="nav__name">Dashboard</span>
	                </a>
	
	                <a href="/Cabinet/Patients" class="nav__link">
	                    <i class='bx bx-user nav__icon' ></i>
	                    <span class="nav__name">Patients</span>
	                </a>
	                <a href="/Cabinet/All_Sejour" class="nav__link">
	                    <i class='bx bx-calendar nav__icon' ></i>
	                    <span class="nav__name">Sejours</span>
	                </a>
	                <a href="/Cabinet/AddSejour" class="nav__link">
	                    <i class='bx bx-calendar-plus nav__icon' ></i>
	                    <span class="nav__name">Ajout Sejour</span>
	                </a>	

	            </div>
	        </div>
	
	        <a href="/Cabinet/Logout" class="nav__link">
	            <i class='bx bx-log-out nav__icon' ></i>
	            <span class="nav__name">Se déconnecter</span>
	        </a>
	    </nav>
	</div>
	
    <script>
		$(document).ready(function(){
	
			$(".notifications .icon_wrap").click(function(){
			  $(this).parent().toggleClass("active");
			   $(".profile").removeClass("active");
			});
		});
	</script>
