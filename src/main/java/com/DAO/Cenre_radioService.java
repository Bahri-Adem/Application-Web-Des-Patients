package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Centre_Radiographie;

public interface Cenre_radioService {
	public Centre_Radiographie getCentreById(int id) throws SQLException;

	public ArrayList<Centre_Radiographie> getListeCentre() throws SQLException;
	
}
