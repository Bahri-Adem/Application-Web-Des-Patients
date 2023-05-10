package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Vente;

public interface VenteService {
	public Vente getVenteById(int id) throws SQLException;
	public ArrayList<Vente> getAllVenteByIdPatient(int id_patient) throws SQLException;
	public ArrayList<Vente> getAllVenteByIdPharmacie(int id_pharmacie) throws SQLException;
	public boolean addVente(Vente vente) throws SQLException;
	public boolean deleteVenteById(int id_vente) throws SQLException ;
	public ArrayList<Vente> getListeVente() throws SQLException;
}
