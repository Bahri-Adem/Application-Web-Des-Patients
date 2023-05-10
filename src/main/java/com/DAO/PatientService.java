package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Patient;

public interface PatientService {

	public Patient getPatientById(int id) throws SQLException;

	public ArrayList<Patient> ListePatients() throws SQLException;

}
