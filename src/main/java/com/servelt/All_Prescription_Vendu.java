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

import com.DAO.VenteDAO;
import com.javaBeans.User;
import com.javaBeans.Vente;

@WebServlet("/All_Prescription_Vendu")
public class All_Prescription_Vendu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public All_Prescription_Vendu() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		int id_pharmacie = user.getId_user();

		VenteDAO venteDao = new VenteDAO();
		try {
			ArrayList<Vente> ventes = venteDao.getAllVenteByIdPharmacie(id_pharmacie);
			request.setAttribute("ventes", ventes);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/AllPrescription_Vendu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * PrescriptionDAO prescDao = new PrescriptionDAO();
		 * 
		 * int id_A = Integer.parseInt(request.getParameter("id"));
		 * 
		 * try { prescDao.deleteResultatById(id_A);
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 * 
		 * request.setAttribute("id_A", id_A); request.setAttribute("action",
		 * "supprimer"); doGet(request, response);
		 */
	}

}
