package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Clinique;

public interface CliniqueService {
	public Clinique getCliniqueById(int id) throws SQLException;

	public ArrayList<Clinique> getListeClinique() throws SQLException;
}
