package com.javaBeans;

public class Medecin {
	private int id_medecin;
	private Clinique clinique;
	private String nom;
	private String specialite;

	public Medecin() {
		// TODO Auto-generated constructor stub
	}

	public Medecin(int id_medecin, Clinique clinique, String nom, String specialite) {
		this.id_medecin = id_medecin;
		this.clinique = clinique;
		this.nom = nom;
		this.specialite = specialite;
	}

	public int getId_medecin() {
		return id_medecin;
	}

	public void setId_medecin(int id_medecin) {
		this.id_medecin = id_medecin;
	}

	public Clinique getClinique() {
		return clinique;
	}

	public void setClinique(Clinique clinique) {
		this.clinique = clinique;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

}
