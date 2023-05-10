package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Pharmacie;

public class PharmacieDAO implements PharmacieService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public PharmacieDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Pharmacie getPharmacieById(int id) throws SQLException {
		String query = "SELECT * FROM user,pharmacie WHERE user.id_user=pharmacie.id_pharmacie and id_pharmacie=?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Pharmacie pharma;

		if (result.next()) {
			pharma = new Pharmacie();
			pharma.setId_user(result.getInt("id_pharmacie"));
			;
			pharma.setCin(result.getString("cin"));
			pharma.setFirstName(result.getString("firstName"));
			pharma.setLastName(result.getString("lastName"));
			pharma.setEmail(result.getString("email"));
			pharma.setPhone(result.getString("phone"));
			pharma.setNom(result.getString("nom"));
			pharma.setAdresse(result.getString("adresse"));
		} else {
			pharma = null;
		}

		return pharma;
	}

	@Override
	public ArrayList<Pharmacie> getListePharmacie() throws SQLException {
		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		ResultSet result;
		String query;
		ArrayList<Pharmacie> pharmacies = new ArrayList<Pharmacie>();
		query = "SELECT * FROM user ,pharmacie  WHERE id_user = id_pharmacie ";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		Pharmacie pharmacie = null;
		while (result.next()) {
			int id = result.getInt("id_user");
			String cin = result.getString("cin");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String password = result.getString("password");

			String nom = result.getString("nom");
			String adresse = result.getString("adresse");

			pharmacie = new Pharmacie(id, cin, firstName, lastName, phone, email, password, nom, adresse);
			pharmacies.add(pharmacie);

		}
		return pharmacies;
	}

}
