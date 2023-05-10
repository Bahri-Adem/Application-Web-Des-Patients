package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Demande_radiographie;
import com.javaBeans.Patient;

public class Demande_radiographieDAO implements Demande_radiographieService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public Demande_radiographieDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Demande_radiographie getDemande_radiographieById(int id) throws SQLException {
		connection = dbInstance.getConnection();
		String query = "SELECT * FROM demande_radiographie WHERE id_demande_radiographie= ?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Demande_radiographie demande_radiographie;

		if (result.next()) {
			PatientDAO patientDAO = new PatientDAO();
			demande_radiographie = new Demande_radiographie();
			demande_radiographie.setId_demande_radiographie(result.getInt("id_demande_radiographie"));
			demande_radiographie.setTitle(result.getString("title"));
			demande_radiographie.setDescription(result.getString("description"));
			demande_radiographie.setDate_demande_radiographie(result.getString("date_demande_radiographie"));
			demande_radiographie.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));

		} else {
			demande_radiographie = null;
		}

		return demande_radiographie;
	}

	@Override
	public ArrayList<Demande_radiographie> getAllDemande_radiographie() throws SQLException {
		String query = "SELECT * FROM demande_radiographie";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Demande_radiographie> demList = new ArrayList<Demande_radiographie>();
		while (RS.next()) {
			demList.add(this.getDemande_radiographieById(RS.getInt("id_demande_radiographie")));
		}
		return demList;
	}

	@Override
	public int addDemande_radiographie(Demande_radiographie demande_radiographie) throws SQLException {
		String query = "INSERT INTO demande_radiographie(title,date_demande_radiographie,description,id_patient,notification) VALUES (?,?,?,?,?)";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, demande_radiographie.getTitle());
		preStat.setString(2, demande_radiographie.getDate_demande_radiographie());
		preStat.setString(3, demande_radiographie.getDescription());
		preStat.setInt(4, demande_radiographie.getPatient().getId_user());
		preStat.setInt(5, demande_radiographie.isNotification() ? 1 : 0);
		int result = preStat.executeUpdate();

		if (result != 0) {
			String maxIdQuery = "SELECT MAX(id_demande_radiographie) FROM demande_radiographie";
			PreparedStatement preStatMax = connection.prepareStatement(maxIdQuery);
			ResultSet maxId = preStatMax.executeQuery();
			maxId.next();
			return maxId.getInt("MAX(id_demande_radiographie)");
		} else {
			return 0;
		}

	}

	public int notification() throws SQLException {

		PreparedStatement preStat;
		ResultSet result;
		String query;

		query = "select count(*) as nbN from demande_radiographie where notification = 0";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		result.next();

		int nbNotification = result.getInt("nbN");

		return nbNotification;
	}

	public ArrayList<Demande_radiographie> NouveauDemande_radiographie() throws SQLException {
		PreparedStatement preStat;
		ResultSet result;
		String query;
		Demande_radiographie demande_radiographie;
		dbInstance = DbConfigDAO.getInstance();
		query = "SELECT * FROM demande_radiographie dem, user u, patient p WHERE u.id_user = p.id_patient and p.id_patient = dem.id_patient and notification = 0 LIMIT 5;";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		ArrayList<Demande_radiographie> demande_radiographies = new ArrayList<Demande_radiographie>();
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

			int id_demande_radiographie = result.getInt("id_demande_radiographie");
			String title = result.getString("title");
			String date_demande_radiographie = result.getString("date_demande_radiographie");
			String description = result.getString("description");
			boolean notification = result.getBoolean("notification");
			demande_radiographie = new Demande_radiographie(id_demande_radiographie, title, date_demande_radiographie,
					description, patient, notification);
			demande_radiographies.add(demande_radiographie);
		}
		return demande_radiographies;
	}

	public boolean deleteAllNotifications() throws SQLException {
		String query = "UPDATE `demande_radiographie` SET `notification` = '1'";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		int state = preStat.executeUpdate();
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

}
