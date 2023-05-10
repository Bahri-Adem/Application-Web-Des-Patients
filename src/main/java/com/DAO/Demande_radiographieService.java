package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Demande_radiographie;

public interface Demande_radiographieService {

	public Demande_radiographie getDemande_radiographieById(int id) throws SQLException;

	public ArrayList<Demande_radiographie> getAllDemande_radiographie() throws SQLException;

	public int addDemande_radiographie(Demande_radiographie demande_radiographie) throws SQLException;

}
