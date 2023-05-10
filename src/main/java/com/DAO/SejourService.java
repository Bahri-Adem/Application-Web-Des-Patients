package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Sejour;

public interface SejourService {
	public Sejour getSejourById(int id) throws SQLException;

	public ArrayList<Sejour> getAllSejourById(int id_patient) throws SQLException;

	public ArrayList<Sejour> getAllSejourByIdClinic(int id_clinic) throws SQLException;
	
	public boolean addSejour(Sejour sejour) throws SQLException;

	public boolean deleteSejourById(int id_sejour) throws SQLException;

	public ArrayList<Sejour> getListeSejour() throws SQLException;

}
