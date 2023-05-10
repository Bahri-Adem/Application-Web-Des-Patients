package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.Demande_analyseDAO;
import com.DAO.LaboratoireDAO;
import com.DAO.PatientDAO;
import com.DAO.ResultatDAO;
import com.javaBeans.Laboratoire;
import com.javaBeans.Patient;
import com.javaBeans.Resultat_Analyse;
import com.javaBeans.User;

@WebServlet("/Analyses")
public class Analyses extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Analyses() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Demande_analyseDAO demDao = new Demande_analyseDAO();
		try {
			demDao.deleteAllNotifications();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/New-Analyse.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientDAO patientDao = new PatientDAO();
		ResultatDAO resultDao = new ResultatDAO();
		LaboratoireDAO laboDao = new LaboratoireDAO();

		String datetime = request.getParameter("datetime");
		String[] strDate = datetime.split("T");
		// String datee = strDate[0]+' '+strDate[1]+":00";
		String date = strDate[0];
		String type_analyse = request.getParameter("type_analyse");
		int id_patient = Integer.parseInt(request.getParameter("patient"));

		String resultat = request.getParameter("resultat");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			Patient patient = patientDao.getPatientById(id_patient);
			Laboratoire laboratoire = laboDao.getLaboratoireById(user.getId_user());
			Resultat_Analyse newResultat = new Resultat_Analyse(patient, laboratoire, type_analyse, resultat, date);
			resultDao.addResultat(newResultat);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		request.setAttribute("action", "effectue");
		this.getServletContext().getRequestDispatcher("/home_laboratoire.jsp").forward(request, response);
	}
}