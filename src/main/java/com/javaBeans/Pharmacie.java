package com.javaBeans;

public class Pharmacie extends User {
	private String nom;
	private String adresse;
	
	public Pharmacie(int id,String cin,String firstName, String lastName, String phone,String specialty ,String email, String password) {
		super(id,cin,firstName,lastName,phone,email, password);
	}
	
	public Pharmacie(int id, String cin, String firstName, String lastName, String phone, String email, String password, String nom, String adresse) {
		super(id,cin,firstName,lastName,phone,email, password);
		this.nom=nom;
		this.adresse=adresse;
	}
	public Pharmacie() {
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
