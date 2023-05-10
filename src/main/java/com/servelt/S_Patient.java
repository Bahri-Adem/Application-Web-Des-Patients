package com.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AppointmentDAO;
import com.DAO.PatientDAO;
import com.javaBeans.Patient;
import com.javaBeans.User;

@WebServlet("/Patients")
public class S_Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public S_Patient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PatientDAO patientDAO = new PatientDAO();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			String accountType = user.getAccountType();
			try {
				ArrayList<Patient> patients = patientDAO.ListePatients();
				request.setAttribute("patients", patients);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (accountType.equals("doctor")) {
				this.getServletContext().getRequestDispatcher("/Table_Patients.jsp").forward(request, response);
			} else if (accountType.equals("pharmacie")) {
				this.getServletContext().getRequestDispatcher("/Table_Patients_Pharmacie.jsp").forward(request,
						response);
			} else if (accountType.equals("clinique")) {
				this.getServletContext().getRequestDispatcher("/Table_Patients_Clinique.jsp").forward(request,
						response);
			} else if (accountType.equals("centre")) {
				this.getServletContext().getRequestDispatcher("/Table_Patients_Centre.jsp").forward(request,
						response);
			} else if (accountType.equals("laboratoire")) {
				this.getServletContext().getRequestDispatcher("/Table_Patients_Laboratoire.jsp").forward(request,
						response);
			}
		} else {
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientDAO patientDAO = new PatientDAO();
		AppointmentDAO appointmentDAO = new AppointmentDAO();

		int id_p = Integer.parseInt(request.getParameter("id"));

		try {
			// Supprimer tout les rendez-vous du patient numero id_p
			appointmentDAO.SupprimerAppointmentPatient(id_p);

			// Supprimer le patient numero id_p
			patientDAO.SupprimerPation(id_p);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("id_p", id_p);
		request.setAttribute("action", "supprimer");
		doGet(request, response);
	}

}
