package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Laboratoire;

public interface LaboratoireService {
	public Laboratoire getLaboratoireById(int id) throws SQLException;

	public ArrayList<Laboratoire> getListeLaboratoire() throws SQLException;
}
