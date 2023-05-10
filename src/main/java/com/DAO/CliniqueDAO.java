package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Clinique;

public class CliniqueDAO implements CliniqueService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public CliniqueDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Clinique getCliniqueById(int id) throws SQLException {
		String query = "SELECT * FROM user,clinique WHERE user.id_user=clinique.id_clinique and id_clinique=?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Clinique clinique;

		if (result.next()) {
			clinique = new Clinique();
			clinique.setId_user(result.getInt("id_clinique"));
			clinique.setCin(result.getString("cin"));
			clinique.setFirstName(result.getString("firstName"));
			clinique.setLastName(result.getString("lastName"));
			clinique.setEmail(result.getString("email"));
			clinique.setPhone(result.getString("phone"));
			clinique.setNom(result.getString("nom"));
			clinique.setAdresse(result.getString("adresse"));
		} else {
			clinique = null;
		}

		return clinique;
	}

	@Override
	public ArrayList<Clinique> getListeClinique() throws SQLException {
		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		ResultSet result;
		String query;
		ArrayList<Clinique> cliniques = new ArrayList<Clinique>();
		query = "SELECT * FROM user ,clinique  WHERE id_user = id_clinique ";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();
		Clinique clinique = null;
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

			clinique = new Clinique(id, cin, firstName, lastName, phone, email, password, nom, adresse);
			cliniques.add(clinique);

		}
		return cliniques;
	}

}
