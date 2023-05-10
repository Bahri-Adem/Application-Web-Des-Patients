package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Prescription;

public interface PrescriptionService {
	public Prescription getPrescriptionById(int id) throws SQLException;

	public ArrayList<Prescription> getAllPrescriptionById(int id_patient) throws SQLException;

	public ArrayList<Prescription> getAllPrescription() throws SQLException;
	
	public ArrayList<Prescription> getAllPrescriptionNonVendu() throws SQLException;

	public int addPrescription(Prescription prescription) throws SQLException;

	public boolean deletePrescriptionById(int id_prescription) throws SQLException;

}
