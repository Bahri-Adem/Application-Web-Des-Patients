package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Radiographie;

public interface RadiographieService {
	public Radiographie getRadiographieById(int id) throws SQLException;

	public ArrayList<Radiographie> getAllRadiographieById(int id_patient) throws SQLException;
	
	public ArrayList<Radiographie> getAllRadiographieByIdCentre(int id_centre) throws SQLException;

	public boolean addRadiographie(Radiographie radiographie) throws SQLException;

	public boolean deleteRadiographieById(int id_radio) throws SQLException;

	public ArrayList<Radiographie> getListeRadio() throws SQLException;
}
