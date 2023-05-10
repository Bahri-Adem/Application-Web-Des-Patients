package com.javaBeans;

public class Prescription {
	private int id_prescription;
	private String title;
	private String dateOfPrescription;
	private String description;
	private String medicationList;
	private Patient patient;
	private boolean notification;

	public Prescription(int id_prescription, String title, String dateOfPrescription, String description,
			String medicationList, Patient patient, boolean notification) {
		this.id_prescription = id_prescription;
		this.title = title;
		this.dateOfPrescription = dateOfPrescription;
		this.description = description;
		this.medicationList = medicationList;
		this.patient = patient;
		this.notification = notification;
	}

	public Prescription() {

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

	public int getId_prescription() {
		return id_prescription;
	}

	public void setId_prescription(int id_prescription) {
		this.id_prescription = id_prescription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateOfPrescription() {
		return dateOfPrescription;
	}

	public void setDateOfPrescription(String dateOfPrescription) {
		this.dateOfPrescription = dateOfPrescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(String medicationList) {
		this.medicationList = medicationList;
	}
}
