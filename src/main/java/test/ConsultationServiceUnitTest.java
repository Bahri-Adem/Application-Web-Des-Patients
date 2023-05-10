package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.DAO.UserDAO;
import com.DAO.ConsultationDAO;
import com.DAO.PrescriptionDAO;
import com.javaBeans.Consultation;
import com.javaBeans.Patient;
import com.javaBeans.Prescription;

public class ConsultationServiceUnitTest {

    @Test
    public void consultationShouldBeAdded() throws SQLException {
    	UserDAO userDAO = new UserDAO();
        ConsultationDAO consultationDAO = new ConsultationDAO();
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        Consultation consultation = new Consultation();
        Prescription prescription= new Prescription();
        Patient patient = new Patient(26,"0416863","abderrahmane","kanoun","559921","kanoun@gmail.com", "password","1993-01-01", "homme");
        assertEquals(0,userDAO.register(patient));
        prescription.setId_prescription(39);
        prescription.setDescription("simple calmant des douleurs");
        prescription.setMedicationList("doliprane");
        prescription.setTitle("douleur de tete pour les enfants");
        prescription.setDateOfPrescription("2020-10-11");
        consultation.setId_consultation(45);
        consultation.setMotif("fievre");
        consultation.setConsulationDate("2020-10-11");
        consultation.setPrice(100);
        consultation.setPrescription(prescription);
        consultation.setPatient(patient);
        assertNotEquals(0, prescriptionDAO.addPrescription(prescription));
        assertTrue(consultationDAO.addConsultation(consultation));
    }

    @Test
    public void consultationShouldBeDeleted() throws SQLException {
        ConsultationDAO consultationDAO = new ConsultationDAO();
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        Consultation consultation = new Consultation();
        Prescription prescription= new Prescription();
        Patient patient = new Patient(26,"0416863","abderrahmane","kanoun","559921","kanoun@gmail.com", "password","1993-01-01", "homme");
        prescription.setId_prescription(39);
        prescription.setDescription("simple calmant des douleurs");
        prescription.setMedicationList("doliprane");
        prescription.setTitle("douleur de tete pour les enfants");
        prescription.setDateOfPrescription("2020-10-11");
        consultation.setId_consultation(45);
        consultation.setMotif("fievre");
        consultation.setConsulationDate("2020-10-12");
        consultation.setPrice(100);
        consultation.setPrescription(prescription);
        consultation.setPatient(patient);
        assertNotEquals(0, prescriptionDAO.addPrescription(prescription));
        assertTrue(consultationDAO.deleteConsultationById(consultation.getId_consultation()));
    }

}
