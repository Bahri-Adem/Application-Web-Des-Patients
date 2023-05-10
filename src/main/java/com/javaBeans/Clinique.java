package com.javaBeans;

public class Clinique extends User {
	private String nom;
	private String adresse;
	
	public Clinique(int id,String cin,String firstName, String lastName, String phone,String email, String password) {
		super(id,cin,firstName,lastName,phone,email, password);
	}
	
	public Clinique(int id, String cin, String firstName, String lastName, String phone, String email, String password, String nom, String adresse) {
		super(id,cin,firstName,lastName,phone,email, password);
		this.nom=nom;
		this.adresse=adresse;
	}
	public Clinique() {
		// TODO Auto-generated constructor stub
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
