<%@page import="com.javaBeans.Demande_radiographie"%>
<%@page import="com.DAO.Demande_radiographieDAO"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<%
Demande_radiographieDAO demDao = new Demande_radiographieDAO();
ArrayList<Demande_radiographie> ListDem = demDao.NouveauDemande_radiographie();
%>

<head>
<link rel="stylesheet" href="css/notif.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style type="text/css">
<%if (demDao.notification() > 0) {%> @keyframes bell { 0% { transform:rotate(0);
	
}

10
%
{
transform
:
rotate(
30deg
);
}
20
%
{
transform
:
rotate(
0
);
}
80
%
{
transform
:
rotate(
0
);
}
90
%
{
transform
:
rotate(
-30deg
);
}
100
%
{
transform
:
rotate(
0
);
}
}
@
keyframes zoom { 1% {
	opacity: 0;
	transform: scale(0);
}
10
%
{
opacity
:
1;
transform
:
scale(
1
);
}
90
%
{
opacity
:
1;
}
100
%
{
opacity
:
0;
}
}
<%}%>
</style>
</head>


<header class="header" id="header">
	<div class="header__toggle">
		<i class='bx bx-menu' id="header-toggle"></i>
	</div>

	<div class="notif">

		<div class="notif_body">
			<div class="notifications">

				<div class="icon_wrap">
					<span class="notification-count"><%=demDao.notification()%></span>
					<div class="notification-bell">
						<span class="bell-top"></span> <span class="bell-middle"></span> <span
							class="bell-bottom"></span> <span class="bell-rad"></span>
					</div>
				</div>

				<div class="notification_dd">

					<ul class="notification_ul">

						<%
						for (Demande_radiographie demande : ListDem) {
						%>

						<li>
							<%
							if (demande.getPatient().getSex().equals("femme")) {
							%> <img src="images/woman.png"> <%
 } else {
 %> <img src="images/man.png"> <%
 }
 %>
							<div class="notify_data">
								<div class="title">
									<%=demande.getPatient().getFirstName() + " " + demande.getPatient().getLastName()%>
								</div>
								<div class="sub_title">
									<strong><%=demande.getTitle()%></strong>
									<%=demande.getDescription()%>
								</div>
							</div>
						</li>
						<%
						}
						%>

						<li class="show_all"><a href="/Cabinet/Radiographies"
							class="link">Ajouter une Radiographie</a></li>
					</ul>
				</div>

			</div>

		</div>
	</div>


	<div class="header__img">
		<img src="images/perfil.jpg" alt="">
	</div>

</header>

<div class="l-navbar" id="nav-bar">
	<nav class="nav">
		<div>
			<a href="#" class="nav__logo"> <i
				class='bx bx-layer nav__logo-icon'></i> <span class="nav__logo-name">HEALTH
					CARE</span>
			</a>

			<div class="nav__list">
				<a href="/Cabinet/Home" class="nav__link active"> <i
					class='bx bx-grid-alt nav__icon'></i> <span class="nav__name">Dashboard</span>
				</a> <a href="/Cabinet/Patients" class="nav__link"> <i
					class='bx bx-user nav__icon'></i> <span class="nav__name">Patients</span>
				</a> <a href="/Cabinet/All_Radiologie" class="nav__link"> <i
					class='bx bx-scan nav__icon'></i> <span class="nav__name">Radiographies</span>
				</a> <a href="/Cabinet/Radiographies" class="nav__link"> <i
					class='bx bx-image-add nav__icon'></i> <span class="nav__name">Ajout
						Radiographie</span>
				</a>

			</div>
		</div>

		<a href="/Cabinet/Logout" class="nav__link"> <i
			class='bx bx-log-out nav__icon'></i> <span class="nav__name">Se
				déconnecter</span>
		</a>
	</nav>
</div>

<script>
	$(document).ready(function() {

		$(".notifications .icon_wrap").click(function() {
			$(this).parent().toggleClass("active");
			$(".profile").removeClass("active");
		});
	});
</script>
