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

import com.DAO.ResultatDAO;
import com.javaBeans.Resultat_Analyse;
import com.javaBeans.User;

@WebServlet("/All_Analyse")
public class All_Analyse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public All_Analyse() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ResultatDAO resultDao = new ResultatDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id_laboratoire = user.getId_user();
		try {
			ArrayList<Resultat_Analyse> resultats = resultDao.getAllResultatByIdLabo(id_laboratoire);

			request.setAttribute("resultats", resultats);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/AllAnalyse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultatDAO resultDao = new ResultatDAO();

		int id_A = Integer.parseInt(request.getParameter("id"));

		try {
			resultDao.deleteResultatById(id_A);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("id_A", id_A);
		request.setAttribute("action", "supprimer");
		doGet(request, response);
	}

}
