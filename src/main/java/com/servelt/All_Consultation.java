package com.servelt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ConsultationDAO;

@WebServlet("/All_Consultation")
public class All_Consultation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public All_Consultation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ConsultationDAO consultationDao = new ConsultationDAO();
		try {
			ArrayList<com.javaBeans.Consultation> consultations = consultationDao.getListeConsultation();

			request.setAttribute("consultations", consultations);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/AllConsultation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConsultationDAO consultationDao = new ConsultationDAO();

		int id_A = Integer.parseInt(request.getParameter("id"));

		try {
			consultationDao.deleteConsultationById(id_A);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("id_A", id_A);
		request.setAttribute("action", "supprimer");
		doGet(request, response);
	}

}
