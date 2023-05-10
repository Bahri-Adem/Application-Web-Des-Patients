package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Demande_analyse;

public interface Demande_analyseService {

	public Demande_analyse getDemande_analyseById(int id) throws SQLException;

	public ArrayList<Demande_analyse> getAllDemande_analyse() throws SQLException;

	public int addDemande_analyse(Demande_analyse demande_analyse) throws SQLException;

}
