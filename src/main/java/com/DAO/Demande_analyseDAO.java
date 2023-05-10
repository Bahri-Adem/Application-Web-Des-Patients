package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Demande_analyse;
import com.javaBeans.Patient;

public class Demande_analyseDAO implements Demande_analyseService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public Demande_analyseDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Demande_analyse getDemande_analyseById(int id) throws SQLException {
		connection = dbInstance.getConnection();
		String query = "SELECT * FROM demande_analyse WHERE id_demande_analyse= ?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Demande_analyse demande_analyse;

		if (result.next()) {
			PatientDAO patientDAO = new PatientDAO();
			demande_analyse = new Demande_analyse();
			demande_analyse.setId_demande_analyse(result.getInt("id_demande_analyse"));
			demande_analyse.setTitle(result.getString("title"));
			demande_analyse.setDescription(result.getString("description"));
			demande_analyse.setDate_demande_analyse(result.getString("date_demande_analyse"));
			demande_analyse.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));

		} else {
			demande_analyse = null;
		}

		return demande_analyse;
	}

	@Override
	public ArrayList<Demande_analyse> getAllDemande_analyse() throws SQLException {
		String query = "SELECT * FROM demande_analyse";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Demande_analyse> demList = new ArrayList<Demande_analyse>();
		while (RS.next()) {
			demList.add(this.getDemande_analyseById(RS.getInt("id_demande_analyse")));
		}
		return demList;
	}

	@Override
	public int addDemande_analyse(Demande_analyse demande_analyse) throws SQLException {
		String query = "INSERT INTO demande_analyse(title,date_demande_analyse,description,id_patient,notification) VALUES (?,?,?,?,?)";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, demande_analyse.getTitle());
		preStat.setString(2, demande_analyse.getDate_demande_analyse());
		preStat.setString(3, demande_analyse.getDescription());
		preStat.setInt(4, demande_analyse.getPatient().getId_user());
		preStat.setInt(5, demande_analyse.isNotification() ? 1 : 0);
		int result = preStat.executeUpdate();

		if (result != 0) {
			String maxIdQuery = "SELECT MAX(id_demande_analyse) FROM demande_analyse";
			PreparedStatement preStatMax = connection.prepareStatement(maxIdQuery);
			ResultSet maxId = preStatMax.executeQuery();
			maxId.next();
			return maxId.getInt("MAX(id_demande_analyse)");
		} else {
			return 0;
		}

	}

	public int notification() throws SQLException {

		PreparedStatement preStat;
		ResultSet result;
		String query;

		query = "select count(*) as nbN from demande_analyse where notification = 0";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		result.next();

		int nbNotification = result.getInt("nbN");

		return nbNotification;
	}

	public ArrayList<Demande_analyse> NouveauDemande_analyse() throws SQLException {
		PreparedStatement preStat;
		ResultSet result;
		String query;
		Demande_analyse demande_analyse;
		dbInstance = DbConfigDAO.getInstance();
		query = "SELECT * FROM demande_analyse dem, user u, patient p WHERE u.id_user = p.id_patient and p.id_patient = dem.id_patient and notification = 0 LIMIT 5;";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		ArrayList<Demande_analyse> demande_analyses = new ArrayList<Demande_analyse>();
		Patient patient = null;

		while (result.next()) {
			int id_patient = result.getInt("id_patient");
			String cin = result.getString("cin");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String password = result.getString("password");
			String birthDate = result.getString("birthDate");
			String sex = result.getString("sex");

			patient = new Patient(id_patient, cin, firstName, lastName, phone, email, password, birthDate, sex);

			int id_demande_analyse = result.getInt("id_demande_analyse");
			String title = result.getString("title");
			String date_demande_analyse = result.getString("date_demande_analyse");
			String description = result.getString("description");
			boolean notification = result.getBoolean("notification");
			demande_analyse = new Demande_analyse(id_demande_analyse, title, date_demande_analyse, description,
					patient, notification);
			demande_analyses.add(demande_analyse);
		}
		return demande_analyses;
	}

	public boolean deleteAllNotifications() throws SQLException {
		String query = "UPDATE `demande_analyse` SET `notification` = '1'";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		int state = preStat.executeUpdate();
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

}
