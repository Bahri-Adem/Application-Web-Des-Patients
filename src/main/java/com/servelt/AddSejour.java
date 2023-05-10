package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CliniqueDAO;
import com.DAO.MedecinDAO;
import com.DAO.PatientDAO;
import com.DAO.PrescriptionDAO;
import com.DAO.SejourDAO;
import com.javaBeans.Patient;
import com.javaBeans.Prescription;
import com.javaBeans.Sejour;
import com.javaBeans.User;

@WebServlet("/AddSejour")
public class AddSejour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddSejour() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/add-sejour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id_clinique = user.getId_user();
		try {
			// Instanciation of Daos:
			PatientDAO patientDao = new PatientDAO();
			CliniqueDAO clinicDao = new CliniqueDAO();
			SejourDAO sejourDao = new SejourDAO();
			MedecinDAO medDao = new MedecinDAO();
			PrescriptionDAO prescriptionDao = new PrescriptionDAO();


			// All_Consultation informations:
			String raison = request.getParameter("raison");
			String date_debut = request.getParameter("date_debut");
			String date_fin = request.getParameter("date_fin");
			int id_medecin = Integer.parseInt(request.getParameter("medecin"));
			int id_patient = Integer.parseInt(request.getParameter("patient"));
			Patient patient = patientDao.getPatientById(id_patient);
			String specialite = medDao.getMedecineById(id_medecin).getSpecialite();
			request.setAttribute("specialite", specialite);
			Sejour sejour = new Sejour();
			sejour.setRaison(raison);
			sejour.setDate_debut(date_debut);
			sejour.setDate_fin(date_fin);
			sejour.setPatient(patient);
			sejour.setClinique(clinicDao.getCliniqueById(id_clinique));
			sejour.setMedecin(medDao.getMedecineById(id_medecin));

			if (request.getParameter("presc").equals("oui")) {
				String title = request.getParameter("title");
				// String dateOfPrescription = request.getParameter("dateOfPrescription");
				String description = request.getParameter("description");
				String medicationList = request.getParameter("medicationList");

				Prescription prescription = new Prescription();
				prescription.setDateOfPrescription(date_fin);
				prescription.setDescription(description);
				prescription.setTitle(title);
				prescription.setMedicationList(medicationList);
				prescription.setPatient(patient);
				prescription.setNotification(false);

				int id_prescription = prescriptionDao.addPrescription(prescription);
				prescription.setId_prescription(id_prescription);

				sejour.setPrescription(prescription);
				sejourDao.addSejour(sejour);

			} else {
				sejourDao.addSejour(sejour);
			}
			request.setAttribute("add", "success");
			doGet(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
