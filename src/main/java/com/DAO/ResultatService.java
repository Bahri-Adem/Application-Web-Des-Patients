package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Resultat_Analyse;

public interface ResultatService {
	public Resultat_Analyse getResultatById(int id) throws SQLException;

	public ArrayList<Resultat_Analyse> getAllResultatById(int id_patient) throws SQLException;
	
	public ArrayList<Resultat_Analyse> getAllResultatByIdLabo(int id_laboratoire) throws SQLException;

	public boolean addResultat(Resultat_Analyse resultat) throws SQLException;

	public boolean deleteResultatById(int id_resultat) throws SQLException;

	public ArrayList<Resultat_Analyse> getListeResult() throws SQLException;
}
