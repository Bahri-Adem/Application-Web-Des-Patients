package com.javaBeans;

public class Laboratoire extends User {
	private String nom;
	private String adresse;

	public Laboratoire(int id, String cin, String firstName, String lastName, String phone, String specialty,
			String email, String password) {
		super(id, cin, firstName, lastName, phone, email, password);
	}

	public Laboratoire(int id, String cin, String firstName, String lastName, String phone, String email,
			String password, String nom, String adresse) {
		super(id, cin, firstName, lastName, phone, email, password);
		this.nom = nom;
		this.adresse = adresse;
	}

	public Laboratoire() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
