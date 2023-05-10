package com.javaBeans;

public class Resultat_Analyse {
	private int id_resultat;
	private Patient patient;
	private Laboratoire laboratoire;
	private String type_analyse;
	private String resultat;
	private String date_resultat;

	public Resultat_Analyse() {
		// TODO Auto-generated constructor stub
	}

	public Resultat_Analyse( Patient patient, Laboratoire laboratoire, String type_analyse,
			String resultat, String date_resultat) {
		this.patient = patient;
		this.laboratoire = laboratoire;
		this.type_analyse = type_analyse;
		this.resultat = resultat;
		this.date_resultat = date_resultat;
	}

	public int getId_resultat() {
		return id_resultat;
	}

	public void setId_resultat(int id_resultat) {
		this.id_resultat = id_resultat;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public String getType_analyse() {
		return type_analyse;
	}

	public void setType_analyse(String type_analyse) {
		this.type_analyse = type_analyse;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getDate_resultat() {
		return date_resultat;
	}

	public void setDate_resultat(String date_resultat) {
		this.date_resultat = date_resultat;
	}

}
