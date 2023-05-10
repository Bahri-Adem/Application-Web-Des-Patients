package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ConsultationDAO;
import com.DAO.Demande_analyseDAO;
import com.DAO.Demande_radiographieDAO;
import com.DAO.PatientDAO;
import com.DAO.PrescriptionDAO;
import com.javaBeans.Consultation;
import com.javaBeans.Demande_analyse;
import com.javaBeans.Demande_radiographie;
import com.javaBeans.Patient;
import com.javaBeans.Prescription;

@WebServlet("/AddConsultation")
public class AddConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddConsultation() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/add-consultation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_patient = Integer.parseInt(request.getParameter("id"));

		try {
			// Instanciation of Daos:
			PatientDAO patientDao = new PatientDAO();
			ConsultationDAO consultationDao = new ConsultationDAO();
			PrescriptionDAO prescriptionDao = new PrescriptionDAO();
			Demande_analyseDAO demDao = new Demande_analyseDAO();
			Demande_radiographieDAO demrDao = new Demande_radiographieDAO();

			Patient patient = patientDao.getPatientById(id_patient);
			// All_Consultation informations:
			String motif = request.getParameter("motif");
			String consultationDate = request.getParameter("ConsultationDate");
			double price = Double.parseDouble(request.getParameter("price"));

			Consultation consultation = new Consultation();
			consultation.setConsulationDate(consultationDate);
			consultation.setMotif(motif);
			consultation.setPrice(price);
			consultation.setPatient(patient);

			if (request.getParameter("presc").equals("oui")) {
				String title = request.getParameter("title");
				// String dateOfPrescription = request.getParameter("dateOfPrescription");
				String description = request.getParameter("description");
				String medicationList = request.getParameter("medicationList");

				Prescription prescription = new Prescription();
				prescription.setDateOfPrescription(consultationDate);
				prescription.setDescription(description);
				prescription.setTitle(title);
				prescription.setMedicationList(medicationList);
				prescription.setPatient(patient);
				prescription.setNotification(false);

				int id_prescription = prescriptionDao.addPrescription(prescription);
				prescription.setId_prescription(id_prescription);

				consultation.setPrescription(prescription);

				consultationDao.addConsultation(consultation);

			} else {
				consultationDao.addConsultation(consultation);
			}
			if (request.getParameter("dem_analyse").equals("oui")) {
				String dem_analyse_title = request.getParameter("dem_analyse_title");
				String dem_analyse_description = request.getParameter("dem_analyse_description");
				Demande_analyse demande = new Demande_analyse(dem_analyse_title, consultationDate,
						dem_analyse_description, patient, false);
				demDao.addDemande_analyse(demande);
			}
			if (request.getParameter("dem_radiographie").equals("oui")) {
				String dem_radiographie_title = request.getParameter("dem_radiographie_title");
				String dem_radiographie_description = request.getParameter("dem_radiographie_description");
				Demande_radiographie demander = new Demande_radiographie(dem_radiographie_title, consultationDate,
						dem_radiographie_description, patient, false);
				demrDao.addDemande_radiographie(demander);
			}
			request.setAttribute("add", "success");
			doGet(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
