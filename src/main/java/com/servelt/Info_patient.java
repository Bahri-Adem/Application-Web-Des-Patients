package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MedicalFileDAO;
import com.DAO.PatientDAO;
import com.DAO.RadiographieDAO;
import com.DAO.ResultatDAO;
import com.DAO.SejourDAO;
import com.javaBeans.MedicalFile;
import com.javaBeans.User;

@WebServlet("/Info_patient")
public class Info_patient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Info_patient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String accountType = user.getAccountType();
		int id_patient;
		if (request.getParameter("id_p") == null) {
			id_patient = user.getId_user();
		} else {
			id_patient = Integer.parseInt(request.getParameter("id_p"));
		}
		MedicalFileDAO medicalFileDao = new MedicalFileDAO();

		try {
			MedicalFile medicalFile = medicalFileDao.getMedicalFileById(id_patient);
			request.setAttribute("medicalFile", medicalFile);
			if (accountType.equals("patient")) {
				this.getServletContext().getRequestDispatcher("/Info_patient.jsp").forward(request, response);
			} else if (accountType.equals("pharmacie")) {
				this.getServletContext().getRequestDispatcher("/Info_patient_pharma.jsp").forward(request, response);
			} else if (accountType.equals("clinique")) {
				this.getServletContext().getRequestDispatcher("/Info_patient_clinique.jsp").forward(request, response);
			} else if (accountType.equals("centre")) {
				this.getServletContext().getRequestDispatcher("/Info_patient_centre.jsp").forward(request, response);
			} else if (accountType.equals("laboratoire")) {
				this.getServletContext().getRequestDispatcher("/Info_patient_laboratoire.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			String date_naiss = request.getParameter("date_naiss");
			String Sex = request.getParameter("Sex");

			PatientDAO patientDAO = new PatientDAO();
			try {
				patientDAO.ModifierPation(id, prenom, nom, tel, email, date_naiss, Sex);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("id_sej") != null) {
			int id_sej = Integer.parseInt(request.getParameter("id_sej"));
			SejourDAO sejDao = new SejourDAO();
			try {
				boolean isDelete = sejDao.deleteSejourById(id_sej);
				doGet(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("id_radiographie") != null) {
			int id_radiographie = Integer.parseInt(request.getParameter("id_radiographie"));
			RadiographieDAO radioDao = new RadiographieDAO();
			try {
				boolean isDelete3 = radioDao.deleteRadiographieById(id_radiographie);
				doGet(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("id_resultat") != null) {
			int id_resultat = Integer.parseInt(request.getParameter("id_resultat"));
			ResultatDAO resDao = new ResultatDAO();
			try {
				boolean isDelete2 = resDao.deleteResultatById(id_resultat);
				doGet(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("action", "edit");
		doGet(request, response);
	}

}
