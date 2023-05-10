import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DAO.CliniqueDAO;
import com.DAO.DbConfigDAO;
import com.DAO.Demande_analyseDAO;
import com.DAO.Demande_radiographieDAO;
import com.DAO.MedecinDAO;
import com.DAO.PatientDAO;
import com.DAO.SejourDAO;
import com.javaBeans.Clinique;
import com.javaBeans.Demande_analyse;
import com.javaBeans.Demande_radiographie;
import com.javaBeans.Medecin;
import com.javaBeans.Patient;
import com.javaBeans.Sejour;

// Votre Run
public class main {
	private static DbConfigDAO dbInstance;
	private static Connection connection;

	public static void main(String[] args) throws SQLException {
		dbInstance = DbConfigDAO.getInstance();
		System.out.println(dbInstance);
		try {
			Connection connection = dbInstance.getConnection();
			System.out.println(connection);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CliniqueDAO clinicDao = new CliniqueDAO();
		ArrayList<Clinique> clinicList = clinicDao.getListeClinique();
		for (Clinique clinic : clinicList) {
			System.out.println(clinic.getId_user());
		}
		MedecinDAO medDao = new MedecinDAO();
		ArrayList<Medecin> medList = medDao.getListeMedecin();
		for (Medecin med : medList) {
			System.out.println(med.getSpecialite());
		}
		SejourDAO sejDao = new SejourDAO();
		ArrayList<Sejour> sejList = sejDao.getListeSejour();
		for (Sejour sej : sejList) {
			System.out.println(sej.getRaison());
		}
		Demande_analyseDAO demDao = new Demande_analyseDAO();
		PatientDAO patientDao = new PatientDAO();
		Patient maher = patientDao.getPatientById(3);
		Demande_analyse demande = new Demande_analyse(2, "analyse nucliaaire", "1993-01-01", "ekkakakaaaaaa", maher,
				true);
		demDao.addDemande_analyse(demande);
		ArrayList<Demande_analyse> demList = demDao.getAllDemande_analyse();
		for (Demande_analyse demandes : demList) {
			System.out.println(demandes.getDescription());
		}
		System.out.println(demDao.deleteAllNotifications());
		Demande_radiographieDAO demrDao = new Demande_radiographieDAO();
		Demande_radiographie demande_radio = new Demande_radiographie(2, "analyse nucliaaire", "1993-01-01",
				"ekkakakaaaaaa", maher, true);
		demrDao.addDemande_radiographie(demande_radio);
		ArrayList<Demande_radiographie> demrList = demrDao.getAllDemande_radiographie();
		for (Demande_radiographie demandes : demrList) {
			System.out.println(demandes.getDescription());
		}
		/*
		 * PatientDAO patientDao = new PatientDAO(); VenteDAO venteDao = new VenteDAO();
		 * PharmacieDAO pharmaDao = new PharmacieDAO(); PrescriptionDAO prescDao = new
		 * PrescriptionDAO(); ResultatDAO resultatDAO = new ResultatDAO();
		 * LaboratoireDAO laboDAO = new LaboratoireDAO(); CentreDAO centreDao = new
		 * CentreDAO(); RadiographieDAO radioDao = new RadiographieDAO();
		 * ConsultationDAO consDao = new ConsultationDAO(); ArrayList<Vente> venteList =
		 * venteDao.getAllVenteByIdPharmacie(7); ArrayList<Prescription> presList =
		 * prescDao.getAllPrescriptionNonVendu(); Pharmacie pharmacie =
		 * pharmaDao.getPharmacieById(7); ArrayList<Pharmacie> pharmaList =
		 * pharmaDao.getListePharmacie(); System.out.println(pharmacie.getNom());
		 * ArrayList<Consultation> consultationList = consDao.getListeConsultation();
		 * ArrayList<Radiographie> radioList = radioDao.getAllRadiographieById(3);
		 * ArrayList<Centre_Radiographie> centreList = centreDao.getListeCentre();
		 * ArrayList<Resultat_Analyse> resultatList = resultatDAO.getAllResultatById(3);
		 * ArrayList<Laboratoire> laboList = laboDAO.getListeLaboratoire();
		 */
		/*
		 * Vente vente = new Vente(); vente.setPatient(patientDao.getPatientById(3));
		 * vente.setPharmacie(pharmaDao.getPharmacieById(7));
		 * vente.setPrescription(prescDao.getPrescriptionById(20));
		 * vente.setDatevente("2023-03-22"); vente.setQuantite(4);
		 * venteDao.addVente(vente);
		 */
		/*
		 * Prescription prescription = new Prescription();
		 * prescription.setDateOfPrescription("2023-03-02");
		 * prescription.setDescription("aa"); prescription.setTitle("aa");
		 * prescription.setMedicationList("aaaa");
		 * prescription.setPatient(patientDao.getPatientById(5));
		 * //prescription.setNotification(true); int id_prescription =
		 * prescDao.addPrescription(prescription); System.out.println(id_prescription);
		 */
		/*
		 * for (Vente ven : venteList) {
		 * System.out.println(ven.getPrescription().getId_prescription()); } for
		 * (Prescription presc : presList) {
		 * System.out.println(presc.getId_prescription()); } for (Pharmacie phar :
		 * pharmaList) { System.out.println(phar.getNom()); } for (Laboratoire lab :
		 * laboList) { System.out.println(lab.getNom()); } for (Centre_Radiographie cen
		 * : centreList) { System.out.println(cen.getNom()); } for (Radiographie radio :
		 * radioList) { System.out.println(radio.getType_radiographie()); } for
		 * (Consultation consultation : consultationList) {
		 * System.out.println(consultation.getPrice()); }
		 * System.out.println(resultatList.get(0).getResultat());
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Votre fonction Run
				// Vos information de connexion à une base de données
				String BDD = "sonoo";
				String url = "jdbc:mysql://localhost:3306/database";
				String user = "root";
				String passwd = "";
				// L'essaie de connexion à votre base de donées
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, user, passwd);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM user");
					while (rs.next()) {
						System.out.println(rs.getString("firstName") + "\t" + rs.getString("lastName"));
					}
					System.out.println("Connecter");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Erreur");
					System.exit(0);
				}
			}
		});
	}
}
