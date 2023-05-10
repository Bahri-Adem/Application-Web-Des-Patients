package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Patient;
import com.javaBeans.Prescription;

public class PrescriptionDAO implements PrescriptionService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public PrescriptionDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Prescription getPrescriptionById(int id) throws SQLException {
		connection = dbInstance.getConnection();
		String query = "SELECT * FROM prescription WHERE id_prescription= ?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Prescription prescription;

		if (result.next()) {
			PatientDAO patientDAO = new PatientDAO();
			prescription = new Prescription();
			prescription.setId_prescription(result.getInt("id_prescription"));
			prescription.setTitle(result.getString("title"));
			prescription.setDateOfPrescription(result.getString("dateOfPrescription"));
			prescription.setDescription(result.getString("description"));
			prescription.setMedicationList(result.getString("medicationList"));
			prescription.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));

		} else {
			prescription = null;
		}

		return prescription;
	}

	@Override
	public ArrayList<Prescription> getAllPrescriptionById(int id_patient) throws SQLException {
		String query = "SELECT id_prescription FROM prescription WHERE id_patient = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();
		ArrayList<Prescription> perscList = new ArrayList<Prescription>();
		while (result.next()) {
			perscList.add(this.getPrescriptionById(result.getInt("id_prescription")));
		}
		return perscList;
	}

	@Override
	public ArrayList<Prescription> getAllPrescription() throws SQLException {
		String query = "SELECT * FROM prescription";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Prescription> prescList = new ArrayList<Prescription>();
		while (RS.next()) {
			prescList.add(this.getPrescriptionById(RS.getInt("id_prescription")));
		}
		return prescList;
	}

	@Override
	public int addPrescription(Prescription prescription) throws SQLException {
		String query = "INSERT INTO prescription(title,dateOfPrescription,description,medicationList,id_patient,notification) VALUES (?,?,?,?,?,?)";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, prescription.getTitle());
		preStat.setString(2, prescription.getDateOfPrescription());
		preStat.setString(3, prescription.getDescription());
		preStat.setString(4, prescription.getMedicationList());
		preStat.setInt(5, prescription.getPatient().getId_user());
		preStat.setInt(6, prescription.isNotification() ? 1 : 0);
		int result = preStat.executeUpdate();

		if (result != 0) {
			String maxIdQuery = "SELECT MAX(id_prescription) FROM prescription";
			PreparedStatement preStatMax = connection.prepareStatement(maxIdQuery);
			ResultSet maxId = preStatMax.executeQuery();
			maxId.next();
			return maxId.getInt("MAX(id_prescription)");
		} else {
			return 0;
		}

	}

	@Override
	public boolean deletePrescriptionById(int id_prescription) throws SQLException {
		String query = "DELETE FROM prescription WHERE id_prescription= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_prescription);
		int state = preStat.executeUpdate();
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

	@Override
	public ArrayList<Prescription> getAllPrescriptionNonVendu() throws SQLException {
		String query = "SELECT * FROM prescription WHERE prescription.id_prescription NOT IN(SELECT vente.id_prescription FROM vente)";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Prescription> prescList = new ArrayList<Prescription>();
		while (RS.next()) {
			prescList.add(this.getPrescriptionById(RS.getInt("id_prescription")));
		}
		return prescList;
	}

	public int notification() throws SQLException {

		PreparedStatement preStat;
		ResultSet result;
		String query;

		query = "select count(*) as nbN from prescription where notification = 0";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		result.next();

		int nbNotification = result.getInt("nbN");

		return nbNotification;
	}

	public ArrayList<Prescription> NouveauPrescription() throws SQLException {
		PreparedStatement preStat;
		ResultSet result;
		String query;
		Prescription prescription;
		dbInstance = DbConfigDAO.getInstance();
		query = "SELECT * FROM prescription prsc, user u, patient p WHERE u.id_user = p.id_patient and p.id_patient = prsc.id_patient and notification = 0 LIMIT 5;";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();

		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
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

			int id_prescription = result.getInt("id_prescription");
			String title = result.getString("title");
			String dateOfPrescription = result.getString("dateOfPrescription");
			String description = result.getString("description");
			String medicationList = result.getString("medicationList");
			boolean notification = result.getBoolean("notification");

			prescription = new Prescription(id_prescription, title, dateOfPrescription, description, medicationList,
					patient, notification);
			prescriptions.add(prescription);
		}
		return prescriptions;
	}
	public boolean deleteAllNotifications() throws SQLException {
		String query = "UPDATE `prescription` SET `notification` = '1'";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		int state = preStat.executeUpdate();
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

}
