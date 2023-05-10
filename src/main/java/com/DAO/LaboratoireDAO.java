package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Laboratoire;

public class LaboratoireDAO implements LaboratoireService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public LaboratoireDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Laboratoire getLaboratoireById(int id) throws SQLException {
		connection = dbInstance.getConnection();
		String query = "SELECT * FROM user,laboratoire WHERE user.id_user=laboratoire.id_laboratoire and id_laboratoire=?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		Laboratoire laboratoire;
		// informations personnelles du patient:
		if (result.next()) {
			laboratoire = new Laboratoire();
			laboratoire.setId_user(result.getInt("id_laboratoire"));
			laboratoire.setCin(result.getString("cin"));
			laboratoire.setFirstName(result.getString("firstName"));
			laboratoire.setLastName(result.getString("lastName"));
			laboratoire.setEmail(result.getString("email"));
			laboratoire.setPhone(result.getString("phone"));
			laboratoire.setNom(result.getString("nom"));
			laboratoire.setAdresse(result.getString("adresse"));
		} else {
			laboratoire = null;
		}

		return laboratoire;
	}

	@Override
	public ArrayList<Laboratoire> getListeLaboratoire() throws SQLException {
		String query = "SELECT * FROM laboratoire";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Laboratoire> laboList = new ArrayList<Laboratoire>();
		while (RS.next()) {
			laboList.add(this.getLaboratoireById(RS.getInt("id_laboratoire")));
		}
		return laboList;
	}
}
