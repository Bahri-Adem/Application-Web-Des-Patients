package com.javaBeans;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicalFile {
	private String id;
	private Patient patient;
	private ArrayList<Appointment> appointmentList;
	private ArrayList<Consultation> consultationList;
	private ArrayList<Radiographie> radioList;
	private ArrayList<Resultat_Analyse> resultatsList;
	private ArrayList<Vente> venteList;
	private ArrayList<Sejour> sejourList;
	private HashMap<String, String> statistiques;

	public MedicalFile() {

	}

	public ArrayList<Sejour> getSejourList() {
		return sejourList;
	}

	public void setSejourList(ArrayList<Sejour> sejourList) {
		this.sejourList = sejourList;
	}

	public ArrayList<Vente> getVenteList() {
		return venteList;
	}

	public void setVenteList(ArrayList<Vente> venteList) {
		this.venteList = venteList;
	}

	public ArrayList<Radiographie> getRadioList() {
		return radioList;
	}

	public void setRadioList(ArrayList<Radiographie> radioList) {
		this.radioList = radioList;
	}

	public ArrayList<Resultat_Analyse> getResultatsList() {
		return resultatsList;
	}

	public void setResultatsList(ArrayList<Resultat_Analyse> resultatsList) {
		this.resultatsList = resultatsList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public ArrayList<Consultation> getConsultationList() {
		return consultationList;
	}

	public void setConsultationList(ArrayList<Consultation> consultationList) {
		this.consultationList = consultationList;
	}

	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public HashMap<String, String> getStatistiques() {
		return statistiques;
	}

	public void setStatistiques(HashMap<String, String> statistiques) {
		this.statistiques = statistiques;
	}

}
