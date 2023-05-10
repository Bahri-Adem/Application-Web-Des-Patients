package com.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PatientDAO;
import com.DAO.PharmacieDAO;
import com.DAO.PrescriptionDAO;
import com.DAO.VenteDAO;
import com.javaBeans.Prescription;
import com.javaBeans.User;
import com.javaBeans.Vente;

@WebServlet("/All_Prescription")
public class All_Prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public All_Prescription() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrescriptionDAO prescDao = new PrescriptionDAO();
		try {
			prescDao.deleteAllNotifications();
			ArrayList<Prescription> prescriptions = prescDao.getAllPrescriptionNonVendu();
			request.setAttribute("prescriptions", prescriptions);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/AllPrescription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id_pharmacie = user.getId_user();
		int id_prescription = Integer.parseInt(request.getParameter("id_prescription"));
		int id_patient = Integer.parseInt(request.getParameter("id_patient"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		//String datevente = "2023-03-01";
		
		  DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		  Date date =new Date();
		  String datevente = format.format(date);
		 
		/*
		 * PrescriptionDAO prescDao = new PrescriptionDAO();
		 * 
		 * int id_A = Integer.parseInt(request.getParameter("id"));
		 * 
		 * try { prescDao.deleteResultatById(id_A);
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 * 
		 * request.setAttribute("id_A", id_A); request.setAttribute("action",
		 * "supprimer"); doGet(request, response);
		 */
		try {
			// Instanciation of Daos:
			PharmacieDAO pharDao = new PharmacieDAO();
			PrescriptionDAO prescDao = new PrescriptionDAO();
			PatientDAO patientDao = new PatientDAO();
			VenteDAO venteDao = new VenteDAO();
			// ALL_Vente informations:
			Vente vente = new Vente();
			vente.setPatient(patientDao.getPatientById(id_patient));
			vente.setPharmacie(pharDao.getPharmacieById(id_pharmacie));
			vente.setPrescription(prescDao.getPrescriptionById(id_prescription));
			vente.setDatevente(datevente);
			vente.setQuantite(quantite);
			venteDao.addVente(vente);
			request.setAttribute("add", "success");
			doGet(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
