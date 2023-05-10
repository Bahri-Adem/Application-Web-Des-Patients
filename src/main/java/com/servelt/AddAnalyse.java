package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.LaboratoireDAO;
import com.DAO.PatientDAO;
import com.DAO.ResultatDAO;
import com.javaBeans.Laboratoire;
import com.javaBeans.Resultat_Analyse;

@WebServlet("/AddAnalyse")
public class AddAnalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddAnalyse() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/add-analyse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Instanciation of Daos:
			LaboratoireDAO laboDao = new LaboratoireDAO();
			ResultatDAO resultatDao = new ResultatDAO();
			PatientDAO patientDao = new PatientDAO();
			// All_Consultation informations:
			int id_patient = Integer.parseInt(request.getParameter("id"));
			String result = request.getParameter("resultat");
			String type_analyse = request.getParameter("type_analyse");
			String date_analyse = request.getParameter("date_analyse");
			Laboratoire laboratoire = laboDao.getLaboratoireById(Integer.parseInt(request.getParameter("laboratoire")));
			Resultat_Analyse resultat = new Resultat_Analyse();
			resultat.setDate_resultat(date_analyse);
			resultat.setType_analyse(type_analyse);
			resultat.setResultat(result);
			resultat.setLaboratoire(laboratoire);
			resultat.setPatient(patientDao.getPatientById(id_patient));
			resultatDao.addResultat(resultat);
			request.setAttribute("add", "success");
			doGet(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
