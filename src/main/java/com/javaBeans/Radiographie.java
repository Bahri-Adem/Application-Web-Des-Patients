package com.javaBeans;

public class Radiographie {
	private int id_radiographie;
	private Patient patient;
	private Centre_Radiographie centre;
	private String type_radiographie;
	private String date_radiographie;
	private String resultat;
	public Radiographie() {
	}
	public Radiographie(Patient patient,Centre_Radiographie centre,String type_radiographie,String date_radiographie,String resultat) {
		this.patient=patient;
		this.centre=centre;
		this.type_radiographie=type_radiographie;
		this.date_radiographie=date_radiographie;
		this.resultat=resultat;
	}
	public int getId_radiographie() {
		return id_radiographie;
	}
	public void setId_radiographie(int id_radiographie) {
		this.id_radiographie = id_radiographie;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Centre_Radiographie getCentre() {
		return centre;
	}
	public void setCentre(Centre_Radiographie centre) {
		this.centre = centre;
	}
	public String getType_radiographie() {
		return type_radiographie;
	}
	public void setType_radiographie(String type_radiographie) {
		this.type_radiographie = type_radiographie;
	}
	public String getDate_radiographie() {
		return date_radiographie;
	}
	public void setDate_radiographie(String date_radiographie) {
		this.date_radiographie = date_radiographie;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
}
