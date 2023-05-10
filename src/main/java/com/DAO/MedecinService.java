package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Medecin;

public interface MedecinService {
	public Medecin getMedecineById(int id) throws SQLException;

	public ArrayList<Medecin> getListeMedecin() throws SQLException;
	
	public ArrayList<Medecin> getListeMedecinByIdClinic(int id_clinique) throws SQLException;
}
