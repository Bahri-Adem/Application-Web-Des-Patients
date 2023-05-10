-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 10 mai 2023 à 13:09
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `database`
--

-- --------------------------------------------------------

--
-- Structure de la table `appointment`
--

CREATE TABLE `appointment` (
  `id_appointment` int(11) NOT NULL,
  `DateofChecking` datetime DEFAULT NULL,
  `DateofAppointment` datetime DEFAULT NULL,
  `id_patient` int(11) DEFAULT NULL,
  `TypeofIllness` varchar(100) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `notification` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `appointment`
--

INSERT INTO `appointment` (`id_appointment`, `DateofChecking`, `DateofAppointment`, `id_patient`, `TypeofIllness`, `Description`, `notification`) VALUES
(32, '2023-03-29 15:32:38', '2023-03-29 14:00:00', 4, 'douleur', 'douleur', 1),
(33, '2023-05-01 20:55:11', '2023-05-02 16:00:00', 4, 'douleur', 'fievre', 0);

-- --------------------------------------------------------

--
-- Structure de la table `centre_radiographie`
--

CREATE TABLE `centre_radiographie` (
  `id_centre` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `centre_radiographie`
--

INSERT INTO `centre_radiographie` (`id_centre`, `nom`, `adresse`, `telephone`) VALUES
(10, 'Centre de radiologie Ibn zohr', 'Immeuble ibn zohr, 3027 Av. de Carthage', '74 407 503'),
(11, 'Centre de radiologie Dr Omar Kammoun', 'Immeuble Mharza centre, km4 Rte M\'harza', '70 295 230');

-- --------------------------------------------------------

--
-- Structure de la table `clinique`
--

CREATE TABLE `clinique` (
  `id_clinique` int(11) NOT NULL,
  `nom` varchar(254) NOT NULL,
  `adresse` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `clinique`
--

INSERT INTO `clinique` (`id_clinique`, `nom`, `adresse`) VALUES
(8, 'Clinique Essalema', 'PQQ4+7RH, Av. des Martyrs'),
(9, 'Clinique Errayhane', 'Km 0.5, Route Manzel Chaker');

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `id_consultation` int(11) NOT NULL,
  `motif` varchar(100) DEFAULT NULL,
  `ConsultationDate` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `id_prescription` int(11) DEFAULT NULL,
  `id_patient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id_consultation`, `motif`, `ConsultationDate`, `price`, `id_prescription`, `id_patient`) VALUES
(2, 'fievre', '2023-03-23', 60, 18, 3),
(20, 'Analyse d\'urine', '2023-03-22', 160, 40, 3),
(21, 'douleurs au niveau de tête ', '2023-04-10', 60, 14, 5),
(22, 'douleurs au niveau de tête ', '2023-04-02', 60, 15, 4),
(23, 'Des courbatures', '2023-04-05', 60, 16, 4),
(24, 'Des courbatures', '2023-04-17', 60, 17, 3),
(25, 'mal au tête ', '2022-03-16', 60, 18, 3),
(26, 'douleur et fièvre', '2023-03-18', 60, 19, 3),
(27, 'douleurs dentaires', '2023-03-19', 60, 20, 4),
(28, 'des sensations de nez bouché ', '2023-03-20', 60, 21, 35),
(29, 'maladies rhumatismales ', '2023-03-21', 60, 22, 4),
(30, 'maladies rhumatismales ', '2023-03-22', 60, 23, 3),
(31, 'maladies rhumatismales', '2023-03-23', 60, 24, 35),
(32, 'grippal accompagnés d\'une éruption cutanée ', '2023-03-24', 80, 25, 5),
(33, 'douleur de tete pour les enfants', '2023-03-25', 60, 36, 4),
(109, 'fievre', '2023-02-02', 60, 58, 3);

-- --------------------------------------------------------

--
-- Structure de la table `demande_analyse`
--

CREATE TABLE `demande_analyse` (
  `id_demande_analyse` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `date_demande_analyse` date DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `id_patient` int(11) NOT NULL,
  `notification` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `demande_radiographie`
--

CREATE TABLE `demande_radiographie` (
  `id_demande_radiographie` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `date_demande_radiographie` date DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `id_patient` int(11) NOT NULL,
  `notification` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

CREATE TABLE `doctor` (
  `id_doctor` int(11) NOT NULL,
  `speciality` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `doctor`
--

INSERT INTO `doctor` (`id_doctor`, `speciality`) VALUES
(2, 'généraliste');

-- --------------------------------------------------------

--
-- Structure de la table `laboratoire`
--

CREATE TABLE `laboratoire` (
  `id_laboratoire` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `laboratoire`
--

INSERT INTO `laboratoire` (`id_laboratoire`, `nom`, `adresse`, `telephone`) VALUES
(12, 'Laboratoire d\'analyses médicales ZIED ABID', 'Laboratoire d\'analyse médicale\r\nRoute de Gremda km 3.5 (à coté de polyclinique Chams internationale ', '74 261 444'),
(13, 'Laboratoire d\'analyses médicales Mharza Centre', 'Route Mharza km 4 Immeuble Mharza centre sfax', '74 677 522');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id_medecin` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_clinique` int(11) NOT NULL,
  `specialite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id_medecin`, `nom`, `id_clinique`, `specialite`) VALUES
(1, 'A', 8, 'Chirurgie Generale'),
(2, 'B', 8, 'Dermatologie'),
(3, 'C', 8, 'Chirurgie Cardiovasculaire'),
(4, 'D', 8, 'Medecine Nucleaire'),
(5, 'E', 8, 'Neurologie'),
(6, 'F', 8, 'Gynecologie-obstetrique'),
(7, 'G', 8, 'Cardiologie'),
(9, 'X', 9, 'Chirurgie Generale'),
(10, 'Y', 9, 'Ophtalmologie'),
(11, 'Z', 9, 'Chirurgie Cardiovasculaire'),
(12, 'H', 9, 'Chirurgie Orthopedique'),
(13, 'I', 9, 'Neurologie'),
(14, 'J', 9, 'Chirurgie Orthopedique'),
(15, 'K', 9, 'Cardiologie');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL,
  `BirthDate` date DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `BirthDate`, `sex`) VALUES
(3, '2000-02-01', 'homme'),
(4, '2000-01-01', 'homme'),
(5, '2000-10-03', 'femme'),
(35, '2001-01-25', 'Homme');

-- --------------------------------------------------------

--
-- Structure de la table `pharmacie`
--

CREATE TABLE `pharmacie` (
  `id_pharmacie` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pharmacie`
--

INSERT INTO `pharmacie` (`id_pharmacie`, `nom`, `adresse`) VALUES
(6, 'Pharmacie Mohamed Ben Habib DRIRA', 'Bd Farhat Hached'),
(7, 'Pharmacie Centrale\r\n', '190 Av. habib bouguatfa');

-- --------------------------------------------------------

--
-- Structure de la table `prescription`
--

CREATE TABLE `prescription` (
  `id_prescription` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `dateOfPrescription` date DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `medicationList` text DEFAULT NULL,
  `id_patient` int(11) NOT NULL,
  `notification` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `prescription`
--

INSERT INTO `prescription` (`id_prescription`, `title`, `dateOfPrescription`, `description`, `medicationList`, `id_patient`, `notification`) VALUES
(14, 'douleurs au niveau de tête ', '2023-04-11', 'douleurs au niveau de tête ', 'Doliprane\nSuppositoire à 200 mg\n1 Boîte 10 suppositoires', 5, 1),
(15, 'douleurs au niveau de tête ', '2023-04-11', 'douleurs au niveau de tête ', 'Doliprane\nComprimé effervescent à 500 mg\n1 Boîte 16 comprimés', 4, 1),
(16, 'Des courbatures', '2023-04-13', 'mal au tete et des courbatures', 'aspegic\r\nPoudre pour solution buvable à 500 mg \r\n1 Boîte 20 sachets', 4, 1),
(17, 'Des courbatures', '2023-04-12', 'mal au tete et des courbatures', 'aspegic\r\nPoudre pour solution buvable à 500 mg \r\n1 Boîte 20 sachets', 3, 1),
(18, 'mal au tête ', '2023-03-16', 'des sensations de nez bouché\nde l\'écoulement nasal clair\ndes maux de tête et fièvre.', 'Gripex\nPoudre pour solution buvable à 1000 mg \n1 Boîte 20 sachets', 3, 1),
(19, 'douleur et fièvre', '2023-03-16', 'douleurs au niveau de tête ', 'Doliprane\nComprimé effervescent à 500 mg\n1 Boîte 16 comprimés', 3, 1),
(20, 'douleurs dentaires', '2023-03-31', 'douleur et chaleur', 'paracetamole', 4, 1),
(21, 'des sensations de nez bouché', '2023-04-16', 'des sensations de nez bouché\nde l\'écoulement nasal clair\ndes maux de tête et fièvre.', 'Gripex\nPoudre pour solution buvable à 1000 mg \n1 Boîte 20 sachets', 35, 1),
(22, 'maladies rhumatismales', '2023-04-18', 'maladies rhumatismales', 'ASPEGIC ADULTES \r\nPoudre pour solution buvable à 1000 mg \r\n1 Boîte 20 sachets', 4, 1),
(23, 'maladies rhumatismales', '2023-04-18', 'maladies rhumatismales', 'ASPEGIC ADULTES \r\nPoudre pour solution buvable à 1000 mg \r\n1 Boîte 20 sachets', 3, 1),
(24, 'maladies rhumatismales', '2023-04-18', 'maladies rhumatismales', 'ASPEGIC ADULTES \r\nPoudre pour solution buvable à 1000 mg \r\n1 Boîte 20 sachets', 35, 1),
(25, 'grippal accompagnés d\'une éruption cutanée', '2023-04-21', 'Symptômes de type grippal accompagnés d\'une éruption cutanée, de fièvre, de ganglions enflés', 'CLAMOXYL\r\nPoudre pour suspension buvable à 125 mg/ 5 ml\r\n1 Flacon 60 ml', 5, 1),
(36, 'douleur de tete pour les enfants', '2020-10-11', 'simple calmant des douleurs', 'doliprane', 4, 1),
(39, 'douleur de tete pour les enfants', '2020-10-11', 'simple calmant des douleurs', 'doliprane', 3, 1),
(40, 'Prescription d\'Analyse d\'urine', '2023-03-21', 'Vous n\'avez pas de cystite car le nombre de micro-organismes est inférieur à 1 000 UFC/ml. Vous avez', 'Monuril 1 sachet/jour\nAprès le déjeuner. ', 3, 1),
(58, 'aa', '2023-02-02', 'aa', 'aa', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `radiographie`
--

CREATE TABLE `radiographie` (
  `id_radiographie` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_centre` int(11) NOT NULL,
  `type_radiographie` varchar(255) NOT NULL,
  `resultat` text DEFAULT NULL,
  `date_radiographie` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `radiographie`
--

INSERT INTO `radiographie` (`id_radiographie`, `id_patient`, `id_centre`, `type_radiographie`, `resultat`, `date_radiographie`) VALUES
(1, 3, 10, 'Radiologie ostéoarticulaire', 'sinus.jpg', '2023-03-23'),
(2, 3, 11, 'Radiologie Arthographie', 'cosinus.jfif', '2023-03-23'),
(3, 4, 11, 'Radiologie Gynécologique', 'gynecologie.jpg', '2023-03-23'),
(4, 4, 10, 'radiographie du thorax', 'radiographieduthorax.jpg', '2023-04-04'),
(5, 35, 10, 'radiographie du thorax', 'radiographieduthorax.jpg', '2023-04-05'),
(6, 35, 11, 'radiographie du rachis cervical', 'radio2.jpg', '2023-04-06'),
(7, 5, 10, 'radiographie du rachis dorsal', '22.jpg', '2023-04-07'),
(8, 3, 11, 'radiographie de l\'abdomen ASP', 'ASP.jpg', '2023-04-08'),
(9, 4, 10, 'radiographie de l\'abdomen ASP', 'asp2.jpg', '2023-04-08'),
(12, 5, 10, 'Radiographie generale', 'sinus.jpg', '2023-04-10');

-- --------------------------------------------------------

--
-- Structure de la table `resultat_analyse`
--

CREATE TABLE `resultat_analyse` (
  `id_resultat` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_laboratoire` int(11) NOT NULL,
  `type_analyse` varchar(50) NOT NULL,
  `resultat` varchar(255) NOT NULL,
  `date_resultat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `resultat_analyse`
--

INSERT INTO `resultat_analyse` (`id_resultat`, `id_patient`, `id_laboratoire`, `type_analyse`, `resultat`, `date_resultat`) VALUES
(1, 3, 12, 'Analyse de sang', 'analysedesang.jpg', '2023-03-23'),
(2, 3, 13, 'Analyse d\'urine', 'analysedurine.png', '2023-03-23'),
(3, 4, 12, 'analyse bactériologique', 'analysebacteriologique.png', '2023-03-23'),
(4, 5, 13, 'Analyse d\'urine', 'ecbu.jpg', '2022-12-28'),
(5, 5, 13, 'Analyse d\'urine', 'ecbu.jpg', '2022-12-28'),
(6, 35, 12, 'Analyse d\'urine', 'ecbu.jpg', '2022-12-28'),
(7, 3, 13, 'Analyse de sang', 'res1.jpg', '2022-12-28'),
(8, 5, 13, 'Analyse de sang', 'res1.jpg', '2022-12-28'),
(9, 4, 13, 'analyse de sang', 'analysedesang.jpg', '2023-04-02'),
(10, 4, 12, 'analyse de sang', 'analysebacteriologique.png', '2023-03-28'),
(13, 4, 12, 'analyse de sang', 'analysedesang.jpg', '2023-04-10');

-- --------------------------------------------------------

--
-- Structure de la table `sejour`
--

CREATE TABLE `sejour` (
  `id_sejour` int(11) NOT NULL,
  `id_clinique` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_prescription` int(11) DEFAULT NULL,
  `id_medecin` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date DEFAULT NULL,
  `raison` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sejour`
--

INSERT INTO `sejour` (`id_sejour`, `id_clinique`, `id_patient`, `id_prescription`, `id_medecin`, `date_debut`, `date_fin`, `raison`) VALUES
(2, 8, 3, NULL, 1, '2023-04-04', '2023-04-04', 'ekke'),
(3, 8, 4, NULL, 2, '2023-04-04', '2023-04-04', 'aaaaaaaa'),
(7, 9, 3, NULL, 10, '2023-03-25', '2023-04-04', 'parce que');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `accountType` varchar(100) DEFAULT 'patient',
  `cin` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`firstName`, `lastName`, `phone`, `email`, `password`, `id_user`, `accountType`, `cin`) VALUES
('Bahri', 'Adem', '50091931', 'adem.bahri@enis.tn', '123', 2, 'doctor', '14019376'),
('Bouchnak', 'Maher', '55613287', 'maher@gmail.com', '1234', 3, 'patient', '14019377'),
('Mabrouk', 'Wadhah', '50091931', 'wadhah@gmail.com', '1234', 4, 'patient', '14019378'),
('Chakroun', 'Farah', '97316824', 'farah@gmail.com', '1234', 5, 'patient', '14073979'),
('Drira', 'Habib', '73916284', 'habib@gmail.com', '12345', 6, 'pharmacie', '14019380'),
('Pharmacie', 'Centrale', '73916285', 'centrale@gmail.com', '12345', 7, 'pharmacie', '14019381'),
('Essalema', 'Clinique', '73440474', 'Clinique.Essalama@gmail.com', '123456', 8, 'clinique', '14019382'),
('Errayhane', 'Clinique', '74 404 404', 'Clinique.Errayhane@gmail.com', '123456', 9, 'clinique', '14019383'),
('Ibn Zohr', 'Centre de radiologie', '74407503', 'centre.ibn-zohr@gmail.com', '1234567', 10, 'centre', '14019384'),
('Dr Omar Kammoun', 'Centre de radiologie', '70295230', 'centre.omar@gmail.com', '1234567', 11, 'centre', '14019385'),
('ZIED ABID', 'Laboratoire d\'analyses médicales', '74261444', 'labo.zied@gmail.com', '12345678', 12, 'laboratoire', '14019386'),
('Mharza Centre', 'Laboratoire d\'analyses médicales', '74677522', 'labo.mharza@gmail.com', '12345678', 13, 'laboratoire', '14019387'),
('Bjeoui', 'Aziz', '50091931', 'aziz@gmail.com', '1234', 35, 'patient', '14019390');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `id_vente` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_pharmacie` int(11) NOT NULL,
  `id_prescription` int(11) NOT NULL,
  `datevente` date NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id_vente`, `id_patient`, `id_pharmacie`, `id_prescription`, `datevente`, `quantite`) VALUES
(16, 3, 6, 19, '2023-04-11', 1),
(17, 4, 6, 20, '2023-04-12', 2),
(18, 35, 6, 21, '2023-04-13', 1),
(19, 5, 6, 25, '2023-04-14', 2),
(20, 3, 7, 17, '2023-04-18', 1),
(21, 4, 7, 16, '2023-04-17', 1),
(22, 35, 7, 24, '2023-04-19', 1),
(23, 5, 7, 14, '2023-04-20', 2),
(24, 4, 7, 15, '2023-04-01', 2),
(25, 3, 7, 40, '2023-04-02', 2),
(26, 3, 6, 18, '2023-04-03', 1),
(27, 4, 6, 36, '2023-04-04', 2),
(28, 3, 6, 39, '2023-04-05', 2),
(29, 3, 6, 58, '2023-05-01', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id_appointment`),
  ADD KEY `Appointment_FK` (`id_patient`);

--
-- Index pour la table `centre_radiographie`
--
ALTER TABLE `centre_radiographie`
  ADD PRIMARY KEY (`id_centre`);

--
-- Index pour la table `clinique`
--
ALTER TABLE `clinique`
  ADD PRIMARY KEY (`id_clinique`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`id_consultation`),
  ADD KEY `consultation_FK` (`id_patient`),
  ADD KEY `consultation_FK_1` (`id_prescription`),
  ADD KEY `id_prescription` (`id_prescription`);

--
-- Index pour la table `demande_analyse`
--
ALTER TABLE `demande_analyse`
  ADD PRIMARY KEY (`id_demande_analyse`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Index pour la table `demande_radiographie`
--
ALTER TABLE `demande_radiographie`
  ADD PRIMARY KEY (`id_demande_radiographie`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Index pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id_doctor`);

--
-- Index pour la table `laboratoire`
--
ALTER TABLE `laboratoire`
  ADD PRIMARY KEY (`id_laboratoire`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id_medecin`),
  ADD KEY `fk_clinque1` (`id_clinique`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_patient`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Index pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  ADD PRIMARY KEY (`id_pharmacie`);

--
-- Index pour la table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`id_prescription`),
  ADD KEY `id_prescription` (`id_prescription`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Index pour la table `radiographie`
--
ALTER TABLE `radiographie`
  ADD PRIMARY KEY (`id_radiographie`),
  ADD KEY `fk_centre` (`id_centre`),
  ADD KEY `fk_centreconsultation` (`id_patient`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Index pour la table `resultat_analyse`
--
ALTER TABLE `resultat_analyse`
  ADD PRIMARY KEY (`id_resultat`),
  ADD KEY `fk_laboresult` (`id_laboratoire`),
  ADD KEY `id_consultation` (`id_laboratoire`),
  ADD KEY `id_patient` (`id_patient`);

--
-- Index pour la table `sejour`
--
ALTER TABLE `sejour`
  ADD PRIMARY KEY (`id_sejour`),
  ADD KEY `fk_prescription` (`id_prescription`),
  ADD KEY `id_clinique` (`id_clinique`,`id_patient`),
  ADD KEY `fk_patient2` (`id_patient`),
  ADD KEY `fk_medecin` (`id_medecin`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `USER_UN` (`id_user`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id_vente`),
  ADD KEY `fk_Pharmaven` (`id_pharmacie`),
  ADD KEY `vente_ibfk_1` (`id_patient`),
  ADD KEY `fk_prescven` (`id_prescription`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id_appointment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `centre_radiographie`
--
ALTER TABLE `centre_radiographie`
  MODIFY `id_centre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `clinique`
--
ALTER TABLE `clinique`
  MODIFY `id_clinique` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `id_consultation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT pour la table `demande_analyse`
--
ALTER TABLE `demande_analyse`
  MODIFY `id_demande_analyse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `demande_radiographie`
--
ALTER TABLE `demande_radiographie`
  MODIFY `id_demande_radiographie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id_doctor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `laboratoire`
--
ALTER TABLE `laboratoire`
  MODIFY `id_laboratoire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id_medecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  MODIFY `id_pharmacie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `id_prescription` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT pour la table `radiographie`
--
ALTER TABLE `radiographie`
  MODIFY `id_radiographie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `resultat_analyse`
--
ALTER TABLE `resultat_analyse`
  MODIFY `id_resultat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `sejour`
--
ALTER TABLE `sejour`
  MODIFY `id_sejour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id_vente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `Appointment_FK` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`);

--
-- Contraintes pour la table `centre_radiographie`
--
ALTER TABLE `centre_radiographie`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_centre`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `clinique`
--
ALTER TABLE `clinique`
  ADD CONSTRAINT `fk_clinique` FOREIGN KEY (`id_clinique`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `consultation_FK` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pharmapresc` FOREIGN KEY (`id_prescription`) REFERENCES `prescription` (`id_prescription`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande_analyse`
--
ALTER TABLE `demande_analyse`
  ADD CONSTRAINT `id_patanalyse` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande_radiographie`
--
ALTER TABLE `demande_radiographie`
  ADD CONSTRAINT `fk_patienradio` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `Doctor_FK` FOREIGN KEY (`id_doctor`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `laboratoire`
--
ALTER TABLE `laboratoire`
  ADD CONSTRAINT `fk_userlabo` FOREIGN KEY (`id_laboratoire`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `fk_clinque1` FOREIGN KEY (`id_clinique`) REFERENCES `clinique` (`id_clinique`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `Patient_FK` FOREIGN KEY (`id_patient`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  ADD CONSTRAINT `fk_pharmaa` FOREIGN KEY (`id_pharmacie`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `fk_patientpresc` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `radiographie`
--
ALTER TABLE `radiographie`
  ADD CONSTRAINT `fk_patient` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fr_centree` FOREIGN KEY (`id_centre`) REFERENCES `centre_radiographie` (`id_centre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `resultat_analyse`
--
ALTER TABLE `resultat_analyse`
  ADD CONSTRAINT `fk_laboratoire` FOREIGN KEY (`id_laboratoire`) REFERENCES `laboratoire` (`id_laboratoire`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_patient1` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `sejour`
--
ALTER TABLE `sejour`
  ADD CONSTRAINT `fk_clinic` FOREIGN KEY (`id_clinique`) REFERENCES `clinique` (`id_clinique`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_medecin` FOREIGN KEY (`id_medecin`) REFERENCES `medecin` (`id_medecin`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_patient2` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_prescription` FOREIGN KEY (`id_prescription`) REFERENCES `prescription` (`id_prescription`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `fk_patientt` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pharmacie` FOREIGN KEY (`id_pharmacie`) REFERENCES `pharmacie` (`id_pharmacie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_presc` FOREIGN KEY (`id_prescription`) REFERENCES `prescription` (`id_prescription`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
