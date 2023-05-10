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

import com.DAO.SejourDAO;
import com.javaBeans.User;

@WebServlet("/All_Sejour")
public class All_Sejour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public All_Sejour() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SejourDAO sejourDao = new SejourDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id_clinique = user.getId_user();
		try {
			ArrayList<com.javaBeans.Sejour> sejours = sejourDao.getAllSejourByIdClinic(id_clinique);
			request.setAttribute("sejours", sejours);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/AllSejour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * ConsultationDAO consultationDao = new ConsultationDAO();
		 * 
		 * int id_A = Integer.parseInt(request.getParameter("id"));
		 * 
		 * try { consultationDao.deleteConsultationById(id_A);
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 * 
		 * request.setAttribute("id_A", id_A); request.setAttribute("action",
		 * "supprimer"); doGet(request, response);
		 */
	}

}
