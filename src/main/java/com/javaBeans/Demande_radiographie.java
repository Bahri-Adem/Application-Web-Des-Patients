package com.javaBeans;

public class Demande_radiographie {
	private int id_demande_radiographie;
	private String title;
	private String date_demande_radiographie;
	private String description;
	private Patient patient;
	private boolean notification;

	public Demande_radiographie(int id_demande_radiographie, String title, String date_demande_radiographie,
			String description, Patient patient, boolean notification) {
		this.id_demande_radiographie = id_demande_radiographie;
		this.title = title;
		this.date_demande_radiographie = date_demande_radiographie;
		this.description = description;
		this.patient = patient;
		this.notification = notification;
	}

	public Demande_radiographie(String title, String date_demande_radiographie, String description, Patient patient,
			boolean notification) {
		this.title = title;
		this.date_demande_radiographie = date_demande_radiographie;
		this.description = description;
		this.patient = patient;
		this.notification = notification;
	}

	public Demande_radiographie() {

	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId_demande_radiographie() {
		return id_demande_radiographie;
	}

	public void setId_demande_radiographie(int id_demande_radiographie) {
		this.id_demande_radiographie = id_demande_radiographie;
	}

	public String getDate_demande_radiographie() {
		return date_demande_radiographie;
	}

	public void setDate_demande_radiographie(String date_demande_radiographie) {
		this.date_demande_radiographie = date_demande_radiographie;
	}

}
