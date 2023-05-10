package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Pharmacie;

public interface PharmacieService {
	public Pharmacie getPharmacieById(int id) throws SQLException;

	public ArrayList<Pharmacie> getListePharmacie() throws SQLException;
}
