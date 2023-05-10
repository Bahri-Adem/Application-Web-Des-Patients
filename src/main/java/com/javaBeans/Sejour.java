package com.javaBeans;

public class Sejour {
	private int id_sejour;
	private Clinique clinique;
	private Patient patient;
	private Prescription prescription;
	private Medecin medecin;
	private String date_debut;
	private String date_fin;
	private String raison;

	public Sejour() {
		// TODO Auto-generated constructor stub
	}

	public Sejour(int id_sejour, Clinique clinique, Patient patient, Prescription prescription, Medecin medecin,
			String date_debut, String date_fin, String raison) {
		this.id_sejour = id_sejour;
		this.clinique = clinique;
		this.patient = patient;
		this.prescription = prescription;
		this.medecin = medecin;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.raison = raison;
	}

	public int getId_sejour() {
		return id_sejour;
	}

	public void setId_sejour(int id_sejour) {
		this.id_sejour = id_sejour;
	}

	public Clinique getClinique() {
		return clinique;
	}

	public void setClinique(Clinique clinique) {
		this.clinique = clinique;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

}
