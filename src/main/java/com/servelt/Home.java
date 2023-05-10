package com.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DoctorDAO;
import com.javaBeans.HomeData;
import com.javaBeans.User;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// call Dao to bring data from database
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			String accountType = user.getAccountType();
			DoctorDAO doctorDAO = new DoctorDAO();
			HomeData homeData;
			homeData = doctorDAO.getData();
			request.setAttribute("homeData", homeData);
			if (accountType.equals("doctor")) {
				this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			} else if (accountType.equals("pharmacie")) {
				this.getServletContext().getRequestDispatcher("/home_pharmacie.jsp").forward(request, response);
			} else if (accountType.equals("clinique")) {
				this.getServletContext().getRequestDispatcher("/home_clinique.jsp").forward(request, response);
			} else if (accountType.equals("centre")) {
				this.getServletContext().getRequestDispatcher("/home_centre.jsp").forward(request, response);
			} else if (accountType.equals("laboratoire")) {
				this.getServletContext().getRequestDispatcher("/home_laboratoire.jsp").forward(request, response);
			}
		} else {
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
