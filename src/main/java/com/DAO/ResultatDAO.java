package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Resultat_Analyse;

public class ResultatDAO implements ResultatService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public ResultatDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Resultat_Analyse getResultatById(int id) throws SQLException {
		String query = "SELECT * FROM resultat_analyse WHERE id_resultat = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		Resultat_Analyse resultat;

		if (result.next()) {
			resultat = new Resultat_Analyse();
			PatientDAO patientDao = new PatientDAO();
			LaboratoireDAO laboratoireDAO = new LaboratoireDAO();
			resultat.setId_resultat(result.getInt("id_resultat"));
			resultat.setPatient(patientDao.getPatientById(result.getInt("id_patient")));
			resultat.setLaboratoire(laboratoireDAO.getLaboratoireById(result.getInt("id_laboratoire")));
			resultat.setType_analyse(result.getString("type_analyse"));
			resultat.setResultat(result.getString("resultat"));
			resultat.setDate_resultat(result.getString("date_resultat"));
		} else {
			resultat = null;
		}
		return resultat;
	}

	@Override
	public ArrayList<Resultat_Analyse> getAllResultatById(int id_patient) throws SQLException {
		String query = "SELECT id_resultat FROM resultat_analyse WHERE id_patient = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();
		ArrayList<Resultat_Analyse> resultList = new ArrayList<Resultat_Analyse>();
		while (result.next()) {
			resultList.add(this.getResultatById(result.getInt("id_resultat")));
		}
		return resultList;
	}

	@Override
	public ArrayList<Resultat_Analyse> getAllResultatByIdLabo(int id_laboratoire) throws SQLException {
		String query = "SELECT id_resultat FROM resultat_analyse WHERE id_laboratoire = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_laboratoire);
		ResultSet result = preStat.executeQuery();
		ArrayList<Resultat_Analyse> resultList = new ArrayList<Resultat_Analyse>();
		while (result.next()) {
			resultList.add(this.getResultatById(result.getInt("id_resultat")));
		}
		return resultList;
	}

	@Override
	public boolean addResultat(Resultat_Analyse resultat) throws SQLException {
		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		String query = "INSERT INTO resultat_analyse(type_analyse,resultat,date_resultat,id_patient,id_laboratoire) VALUES (?,?,?,?,?)";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		preStat.setString(1, resultat.getType_analyse());
		preStat.setString(2, resultat.getResultat());
		preStat.setString(3, resultat.getDate_resultat());
		preStat.setInt(4, resultat.getPatient().getId_user());
		preStat.setInt(5, resultat.getLaboratoire().getId_user());
		int result = preStat.executeUpdate();

		boolean isInsert = result == 0 ? false : true;
		return isInsert;

	}

	@Override
	public boolean deleteResultatById(int id_resultat) throws SQLException {
		String query = "DELETE FROM resultat_analyse WHERE id_resultat= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_resultat);
		int state = preStat.executeUpdate();

		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

	@Override
	public ArrayList<Resultat_Analyse> getListeResult() throws SQLException {
		String query = "SELECT * FROM resultat_analyse";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Resultat_Analyse> consList = new ArrayList<Resultat_Analyse>();
		while (RS.next()) {
			consList.add(this.getResultatById(RS.getInt("id_resultat")));
		}
		return consList;
	}

}
