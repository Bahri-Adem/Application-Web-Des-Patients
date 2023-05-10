package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Clinique;
import com.javaBeans.Medecin;

public class MedecinDAO implements MedecinService {
	private DbConfigDAO dbInstance;
	private Connection connection;

	public MedecinDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Medecin getMedecineById(int id) throws SQLException {
		String query = "SELECT * FROM medecin WHERE id_medecin=?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		CliniqueDAO cliniqueDao = new CliniqueDAO();
		Medecin medecin;
		if (result.next()) {
			medecin = new Medecin();
			medecin.setId_medecin(result.getInt("id_medecin"));
			medecin.setNom(result.getString("nom"));
			medecin.setSpecialite(result.getString("specialite"));
			medecin.setClinique(cliniqueDao.getCliniqueById(result.getInt("id_clinique")));
		} else {
			medecin = null;
		}

		return medecin;
	}

	@Override
	public ArrayList<Medecin> getListeMedecin() throws SQLException {
		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		ResultSet result;
		String query;
		ArrayList<Medecin> medecins = new ArrayList<Medecin>();
		query = "SELECT * FROM medecin";
		connection = dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		result = preStat.executeQuery();
		Medecin medecin = null;
		CliniqueDAO cliniqueDao = new CliniqueDAO();
		while (result.next()) {
			int id = result.getInt("id_medecin");
			String nom = result.getString("nom");
			String specialite = result.getString("specialite");
			Clinique clinique = cliniqueDao.getCliniqueById(result.getInt("id_clinique"));
			medecin = new Medecin(id, clinique, nom, specialite);
			medecins.add(medecin);

		}
		return medecins;
	}

	@Override
	public ArrayList<Medecin> getListeMedecinByIdClinic(int id_clinique) throws SQLException {
		String query = "SELECT id_medecin FROM medecin WHERE id_clinique = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_clinique);
		ResultSet result = preStat.executeQuery();

		ArrayList<Medecin> medList = new ArrayList<Medecin>();
		while (result.next()) {
			medList.add(this.getMedecineById(result.getInt("id_medecin")));
		}
		return medList;
	}
}
