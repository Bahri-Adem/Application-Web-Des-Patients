package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Sejour;

public class SejourDAO implements SejourService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public SejourDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Sejour getSejourById(int id) throws SQLException {
		String query = "SELECT * FROM sejour WHERE id_sejour = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		Sejour sejour;
		if (result.next()) {
			sejour = new Sejour();
			sejour.setId_sejour(result.getInt("id_sejour"));
			sejour.setDate_debut(result.getString("date_debut"));
			sejour.setDate_fin(result.getString("date_fin"));
			sejour.setRaison(result.getString("raison"));
			PatientDAO patientDAO = new PatientDAO();
			sejour.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));
			PrescriptionDAO presDao = new PrescriptionDAO();
			sejour.setPrescription(presDao.getPrescriptionById(result.getInt("id_prescription")));
			MedecinDAO medDao = new MedecinDAO();
			sejour.setMedecin(medDao.getMedecineById(result.getInt("id_medecin")));
			CliniqueDAO clinicDao = new CliniqueDAO();
			sejour.setClinique(clinicDao.getCliniqueById(result.getInt("id_clinique")));
		} else {
			sejour = null;
		}
		return sejour;
	}

	@Override
	public ArrayList<Sejour> getAllSejourByIdClinic(int id_clinic) throws SQLException {
		String query = "SELECT id_sejour FROM sejour WHERE id_clinique = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_clinic);
		ResultSet result = preStat.executeQuery();

		ArrayList<Sejour> sejourList = new ArrayList<Sejour>();
		while (result.next()) {
			sejourList.add(this.getSejourById(result.getInt("id_sejour")));
		}
		return sejourList;
	}
	
	@Override
	public ArrayList<Sejour> getAllSejourById(int id_patient) throws SQLException {
		String query = "SELECT id_sejour FROM sejour WHERE id_patient = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();

		ArrayList<Sejour> sejourList = new ArrayList<Sejour>();
		while (result.next()) {
			sejourList.add(this.getSejourById(result.getInt("id_sejour")));
		}
		return sejourList;
	}

	@Override
	public boolean addSejour(Sejour sejour) throws SQLException {

		connection = dbInstance.getConnection();
		PreparedStatement preStat;

		if (sejour.getPrescription() != null) {
			String query = "INSERT INTO sejour(id_clinique,id_patient,id_prescription,id_medecin,date_debut,date_fin,raison) VALUES (?,?,?,?,?,?,?)";
			connection = dbInstance.getConnection();
			preStat = connection.prepareStatement(query);
			preStat.setInt(1, sejour.getClinique().getId_user());
			preStat.setInt(2, sejour.getPatient().getId_user());
			preStat.setInt(3, sejour.getPrescription().getId_prescription());
			preStat.setInt(4, sejour.getMedecin().getId_medecin());
			preStat.setString(5, sejour.getDate_debut());
			preStat.setString(6, sejour.getDate_fin());
			preStat.setString(7, sejour.getRaison());
		} else {
			String query = "INSERT INTO sejour(id_clinique,id_patient,id_medecin,date_debut,date_fin,raison) VALUES (?,?,?,?,?,?)";
			connection = dbInstance.getConnection();
			preStat = connection.prepareStatement(query);
			preStat.setInt(1, sejour.getClinique().getId_user());
			preStat.setInt(2, sejour.getPatient().getId_user());
			preStat.setInt(3, sejour.getMedecin().getId_medecin());
			preStat.setString(4, sejour.getDate_debut());
			preStat.setString(5, sejour.getDate_fin());
			preStat.setString(6, sejour.getRaison());
		}

		int result = preStat.executeUpdate();

		boolean isInsert = result == 0 ? false : true;
		return isInsert;

	}

	@Override
	public boolean deleteSejourById(int id_sejour) throws SQLException {
		String query = "DELETE FROM sejour WHERE id_sejour= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_sejour);
		int state = preStat.executeUpdate();

		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

	@Override
	public ArrayList<Sejour> getListeSejour() throws SQLException {
		String query = "SELECT * FROM sejour";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Sejour> sejList = new ArrayList<Sejour>();
		while (RS.next()) {
			sejList.add(this.getSejourById(RS.getInt("id_sejour")));
		}
		return sejList;
	}

}
