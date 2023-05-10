package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaBeans.Vente;

public class VenteDAO implements VenteService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public VenteDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Vente getVenteById(int id) throws SQLException {
		String query = "SELECT * FROM vente WHERE id_vente = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Vente vente;

		if (result.next()) {
			vente = new Vente();
			vente.setId_vente(result.getInt("id_vente"));
			vente.setDatevente(result.getString("datevente"));
			vente.setQuantite(result.getInt("quantite"));

			PatientDAO patientDAO = new PatientDAO();
			vente.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));

			PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
			vente.setPrescription(prescriptionDAO.getPrescriptionById(result.getInt("id_prescription")));

			PharmacieDAO pharDao = new PharmacieDAO();
			vente.setPharmacie(pharDao.getPharmacieById(result.getInt("id_pharmacie")));
		} else {
			vente = null;
		}

		return vente;
	}

	@Override
	public ArrayList<Vente> getAllVenteByIdPatient(int id_patient) throws SQLException {
		String query = "SELECT id_vente FROM vente WHERE id_patient = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();

		ArrayList<Vente> venteList = new ArrayList<Vente>();
		while (result.next()) {
			venteList.add(this.getVenteById(result.getInt("id_vente")));
		}
		return venteList;
	}

	@Override
	public boolean addVente(Vente vente) throws SQLException {
		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		String query = "INSERT INTO vente(id_patient,id_pharmacie,id_prescription,datevente,quantite) VALUES (?,?,?,?,?)";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		preStat.setInt(1, vente.getPatient().getId_user());
		preStat.setInt(2, vente.getPharmacie().getId_user());
		preStat.setInt(3, vente.getPrescription().getId_prescription());
		preStat.setString(4, vente.getDatevente());
		preStat.setInt(5, vente.getQuantite());
		int result = preStat.executeUpdate();
		boolean isInsert = result == 0 ? false : true;
		return isInsert;
	}

	@Override
	public boolean deleteVenteById(int id_vente) throws SQLException {
		String query = "DELETE FROM vente WHERE id_vente= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_vente);
		int state = preStat.executeUpdate();

		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

	@Override
	public ArrayList<Vente> getListeVente() throws SQLException {
		String query = "SELECT * FROM vente";
		connection = dbInstance.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet RS = stmt.executeQuery(query);
		ArrayList<Vente> venList = new ArrayList<Vente>();
		while (RS.next()) {
			venList.add(this.getVenteById(RS.getInt("id_vente")));
		}
		return venList;
	}
	@Override
	public ArrayList<Vente> getAllVenteByIdPharmacie(int id_pharmacie) throws SQLException {
		String query = "SELECT id_vente FROM vente WHERE id_pharmacie = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_pharmacie);
		ResultSet result = preStat.executeQuery();

		ArrayList<Vente> venteList = new ArrayList<Vente>();
		while (result.next()) {
			venteList.add(this.getVenteById(result.getInt("id_vente")));
		}
		return venteList;
	}

}
