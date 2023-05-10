package com.javaBeans;

public class Demande_analyse {
	private int id_demande_analyse;
	private String title;
	private String date_demande_analyse;
	private String description;
	private Patient patient;
	private boolean notification;

	public Demande_analyse(int id_demande_analyse, String title, String date_demande_analyse, String description,
			Patient patient, boolean notification) {
		this.id_demande_analyse = id_demande_analyse;
		this.title = title;
		this.date_demande_analyse = date_demande_analyse;
		this.description = description;
		this.patient = patient;
		this.notification = notification;
	}

	public Demande_analyse(String title, String date_demande_analyse, String description, Patient patient,
			boolean notification) {
		this.title = title;
		this.date_demande_analyse = date_demande_analyse;
		this.description = description;
		this.patient = patient;
		this.notification = notification;
	}

	public Demande_analyse() {

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

	public int getId_demande_analyse() {
		return id_demande_analyse;
	}

	public void setId_demande_analyse(int id_demande_analyse) {
		this.id_demande_analyse = id_demande_analyse;
	}

	public String getDate_demande_analyse() {
		return date_demande_analyse;
	}

	public void setDate_demande_analyse(String date_demande_analyse) {
		this.date_demande_analyse = date_demande_analyse;
	}

}
