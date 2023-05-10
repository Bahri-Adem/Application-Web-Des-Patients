package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Radiographie;

public class RadiographieDAO implements RadiographieService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public RadiographieDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Radiographie getRadiographieById(int id) throws SQLException {
		String query = "SELECT * FROM radiographie WHERE id_radiographie = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		Radiographie radiographie;

		if (result.next()) {
			radiographie = new Radiographie();
			PatientDAO patientDAO = new PatientDAO();
			CentreDAO centreDao = new CentreDAO();
			radiographie.setId_radiographie(result.getInt("id_radiographie"));
			radiographie.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));
			radiographie.setCentre(centreDao.getCentreById(result.getInt("id_centre")));
			radiographie.setType_radiographie(result.getString("type_radiographie"));
			radiographie.setResultat(result.getString("resultat"));
			radiographie.setDate_radiographie(result.getString("date_radiographie"));
		} else {
			radiographie = null;
		}
		return radiographie;
	}

	@Override
	public ArrayList<Radiographie> getAllRadiographieById(int id_patient) throws SQLException {
		String query = "SELECT id_radiographie FROM radiographie WHERE id_patient = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();
		ArrayList<Radiographie> radioList = new ArrayList<Radiographie>();
		while (result.next()) {
			radioList.add(this.getRadiographieById(result.getInt("id_radiographie")));
		}
		return radioList;
	}

	@Override
	public ArrayList<Radiographie> getAllRadiographieByIdCentre(int id_centre) throws SQLException {
		String query = "SELECT id_radiographie FROM radiographie WHERE id_centre = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_centre);
		ResultSet result = preStat.executeQuery();
		ArrayList<Radiographie> radioList = new ArrayList<Radiographie>();
		while (result.next()) {
			radioList.add(this.getRadiographieById(result.getInt("id_radiographie")));
		}
		return radioList;
	}

	@Override
	public boolean addRadiographie(Radiographie radiographie) throws SQLException {

		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		String query = "INSERT INTO radiographie(type_radiographie,resultat,date_radiographie,id_centre,id_patient) VALUES (?,?,?,?,?)";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		preStat.setString(1, radiographie.getType_radiographie());
		preStat.setString(2, radiographie.getResultat());
		preStat.setString(3, radiographie.getDate_radiographie());
		preStat.setInt(4, radiographie.getCentre().getId_user());
		preStat.setInt(5, radiographie.getPatient().getId_user());
		int result = preStat.executeUpdate();
		boolean isInsert = result == 0 ? false : true;
		return isInsert;

	}

	@Override
	public boolean deleteRadiographieById(int id_radio) throws SQLException {
		String query = "DELETE FROM radiographie WHERE id_radiographie= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_radio);
		int state = preStat.executeUpdate();
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

	@Override
	public ArrayList<Radiographie> getListeRadio() throws SQLException {
		String query = "SELECT * FROM radiographie";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Radiographie> consList = new ArrayList<Radiographie>();
		while (RS.next()) {
			consList.add(this.getRadiographieById(RS.getInt("id_radiographie")));
		}
		return consList;
	}
}
