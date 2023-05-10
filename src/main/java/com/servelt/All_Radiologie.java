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

import com.DAO.RadiographieDAO;
import com.javaBeans.Radiographie;
import com.javaBeans.User;

@WebServlet("/All_Radiologie")
public class All_Radiologie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public All_Radiologie() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RadiographieDAO radioDao = new RadiographieDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id_centre = user.getId_user();
		try {
			ArrayList<Radiographie> radioList = radioDao.getAllRadiographieByIdCentre(id_centre);

			request.setAttribute("radioList", radioList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/AllRadiologie.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RadiographieDAO radioDao = new RadiographieDAO();
		int id_A = Integer.parseInt(request.getParameter("id"));

		try {
			radioDao.deleteRadiographieById(id_A);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("id_A", id_A);
		request.setAttribute("action", "supprimer");
		doGet(request, response);
	}

}
