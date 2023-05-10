package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Centre_Radiographie;

public class CentreDAO implements Cenre_radioService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public CentreDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Centre_Radiographie getCentreById(int id) throws SQLException {
		connection = dbInstance.getConnection();
		String query = "SELECT * FROM user,centre_radiographie WHERE user.id_user=centre_radiographie.id_centre and id_centre=?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		Centre_Radiographie centre;
		// informations personnelles du patient:
		if (result.next()) {
			centre = new Centre_Radiographie();
			centre.setId_user(result.getInt("id_centre"));
			centre.setCin(result.getString("cin"));
			centre.setFirstName(result.getString("firstName"));
			centre.setLastName(result.getString("lastName"));
			centre.setEmail(result.getString("email"));
			centre.setPhone(result.getString("phone"));
			centre.setNom(result.getString("nom"));
			centre.setAdresse(result.getString("adresse"));
		} else {
			centre = null;
		}
		return centre;
	}

	@Override
	public ArrayList<Centre_Radiographie> getListeCentre() throws SQLException {
		String query = "SELECT * FROM centre_radiographie";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Centre_Radiographie> cantreList = new ArrayList<Centre_Radiographie>();
		while (RS.next()) {
			cantreList.add(this.getCentreById(RS.getInt("id_centre")));
		}
		return cantreList;
	}
	

}
