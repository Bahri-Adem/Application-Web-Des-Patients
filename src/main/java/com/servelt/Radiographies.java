package com.servelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CentreDAO;
import com.DAO.Demande_radiographieDAO;
import com.DAO.PatientDAO;
import com.DAO.RadiographieDAO;
import com.javaBeans.Centre_Radiographie;
import com.javaBeans.Patient;
import com.javaBeans.Radiographie;
import com.javaBeans.User;

@WebServlet("/Radiographies")
public class Radiographies extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Radiographies() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Demande_radiographieDAO demDao = new Demande_radiographieDAO();
		try {
			demDao.deleteAllNotifications();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/New-Radiographie.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PatientDAO patientDao = new PatientDAO();
		CentreDAO centreDao = new CentreDAO();
		RadiographieDAO radioDao = new RadiographieDAO();

		String datetime = request.getParameter("datetime");
		String[] strDate = datetime.split("T");
		// String datee = strDate[0]+' '+strDate[1]+":00";
		String date = strDate[0];
		String type_radiographie = request.getParameter("type_radiographie");
		int id_patient = Integer.parseInt(request.getParameter("patient"));
		String resultat = request.getParameter("resultat");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			Patient patient = patientDao.getPatientById(id_patient);
			Centre_Radiographie centre = centreDao.getCentreById(user.getId_user());
			Radiographie newRadio = new Radiographie(patient, centre, type_radiographie, date, resultat);
			radioDao.addRadiographie(newRadio);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		request.setAttribute("action", "effectue");
		this.getServletContext().getRequestDispatcher("/home_centre.jsp").forward(request, response);
	}
}