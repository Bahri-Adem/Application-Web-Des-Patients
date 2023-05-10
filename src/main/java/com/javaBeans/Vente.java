package com.javaBeans;

public class Vente {
	private int id_vente;
	private Patient patient;
	private Pharmacie pharmacie;
	private Prescription prescription;
	private String datevente;
	private int quantite;

	public Vente(Patient patient, Pharmacie pharmacie, Prescription prescription, String datevente, int quantite) {
		this.patient = patient;
		this.pharmacie = pharmacie;
		this.prescription = prescription;
		this.datevente = datevente;
		this.quantite = quantite;
	}

	public Vente() {

	}

	public int getId_vente() {
		return id_vente;
	}

	public void setId_vente(int id_vente) {
		this.id_vente = id_vente;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public String getDatevente() {
		return datevente;
	}

	public void setDatevente(String datevente) {
		this.datevente = datevente;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
