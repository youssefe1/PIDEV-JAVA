-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 07 fév. 2020 à 20:27
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pi_dev_1.0`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

CREATE TABLE `absence` (
  `id_absence` int(11) NOT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `date_conge` date DEFAULT NULL,
  `heure_conge` time DEFAULT NULL,
  `nbre_absence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `Nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `Date_Naissance` varchar(45) DEFAULT NULL,
  `Numero_Tel` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT '0',
  `E-mail` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `User_name` varchar(45) DEFAULT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `Image_user` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `avancement`
--

CREATE TABLE `avancement` (
  `id_avancement` int(11) NOT NULL,
  `id_sprint` int(11) DEFAULT NULL,
  `id_tache` int(11) DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `backlog_produit`
--

CREATE TABLE `backlog_produit` (
  `id_Backlog_produit` int(11) NOT NULL,
  `liste_features_bp` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `backlog_sprint`
--

CREATE TABLE `backlog_sprint` (
  `id_bs` int(11) NOT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_sm` int(11) DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `liste_sprint` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `burndownchart`
--

CREATE TABLE `burndownchart` (
  `id_burndownchart` int(11) NOT NULL,
  `description_bdc` varchar(45) DEFAULT NULL,
  `id_bp` int(11) DEFAULT NULL,
  `id_bs` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `calendrier`
--

CREATE TABLE `calendrier` (
  `id_calendrier` int(11) NOT NULL,
  `liste_id_projets` varchar(45) DEFAULT NULL,
  `liste_id_reunions` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `conflit`
--

CREATE TABLE `conflit` (
  `id_conflit` int(11) NOT NULL,
  `conflitcol` varchar(45) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_sm` int(11) DEFAULT NULL,
  `description_conflit` varchar(45) DEFAULT NULL,
  `id_bs` int(11) DEFAULT NULL,
  `etat_conflit` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `conge`
--

CREATE TABLE `conge` (
  `id_Conge` int(11) NOT NULL,
  `date_debut_conge` date DEFAULT NULL,
  `date_fin_conge` date DEFAULT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `description_conge` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `daily_meeting`
--

CREATE TABLE `daily_meeting` (
  `id_daily_meeting` int(11) NOT NULL,
  `heure` time DEFAULT NULL,
  `duree_meeting` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `remaque` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `documentation`
--

CREATE TABLE `documentation` (
  `id_documentation` int(11) NOT NULL,
  `nom_documentation` varchar(45) DEFAULT NULL,
  `contenu_documentation` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `equipes`
--

CREATE TABLE `equipes` (
  `id_equipe` int(11) NOT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `id_po` int(11) DEFAULT NULL,
  `id_sm` int(11) DEFAULT NULL,
  `liste_personnel_equipe` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `features`
--

CREATE TABLE `features` (
  `id_Features` int(11) NOT NULL,
  `liste_user_story_bp` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id_formation` int(11) NOT NULL,
  `sujet_formation` varchar(45) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `date_time_debut` datetime DEFAULT NULL,
  `date_time_fin` datetime DEFAULT NULL,
  `nom_formation` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

CREATE TABLE `forum` (
  `id_forum` int(11) NOT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

CREATE TABLE `intervention` (
  `id_intervention` int(11) NOT NULL,
  `id_sm` int(11) DEFAULT NULL,
  `decription_intervention` varchar(45) DEFAULT NULL,
  `date_intevention` date DEFAULT NULL,
  `id_reclamation` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_tab`
--

CREATE TABLE `ligne_tab` (
  `id_ligne_tab` int(11) NOT NULL,
  `id_tableau_blanc` int(11) DEFAULT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `nom_tache` varchar(45) DEFAULT NULL,
  `etat_tache` varchar(45) DEFAULT NULL,
  `date_ajout_ligne` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `like`
--

CREATE TABLE `like` (
  `id_like` int(11) NOT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `like_etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id_Personnel` int(11) NOT NULL,
  `Nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `Date_Naissance` varchar(45) DEFAULT NULL,
  `Numero_Tel` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT '2',
  `E-mail` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `User_name` varchar(45) DEFAULT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `Image_user` varchar(45) DEFAULT NULL,
  `Specialite` varchar(45) DEFAULT NULL,
  `ide_note` varchar(45) DEFAULT NULL,
  `ide_profil` varchar(45) DEFAULT NULL,
  `salaire` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `po`
--

CREATE TABLE `po` (
  `id_Client` int(11) NOT NULL,
  `Nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `Date_Naissance` varchar(45) DEFAULT NULL,
  `Numero_Tel` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT '3',
  `E-mail` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `User_name` varchar(45) DEFAULT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `Image_user` varchar(45) DEFAULT NULL,
  `id_projet` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id_Profil` int(11) NOT NULL,
  `id_Personnel` int(11) DEFAULT NULL,
  `Description_profil` varchar(45) DEFAULT NULL,
  `projet_realise` varchar(45) DEFAULT NULL,
  `experience` varchar(45) DEFAULT NULL,
  `anciente` varchar(45) DEFAULT NULL,
  `note_globale` varchar(45) DEFAULT NULL,
  `reclamations_profil` varchar(45) DEFAULT NULL,
  `specialite_sous_spec` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `id_projet` int(11) NOT NULL,
  `id_po` int(11) DEFAULT NULL,
  `nom_projet` varchar(45) DEFAULT NULL,
  `date_debut_projet` date DEFAULT NULL,
  `date_fin_projet` date DEFAULT NULL,
  `etat_projet` int(11) DEFAULT NULL,
  `Description_projet` longtext,
  `id_equipe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `id_question` int(11) NOT NULL,
  `id_forum` int(11) DEFAULT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `image_question` varchar(45) DEFAULT NULL,
  `text_question` varchar(45) DEFAULT NULL,
  `nbr_like` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_reclamation` int(11) NOT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `sujet_reclamation` varchar(45) DEFAULT NULL,
  `etat_reclamation` int(11) DEFAULT NULL,
  `description_reclamation` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `id_reponse` int(11) NOT NULL,
  `id_question` int(11) DEFAULT NULL,
  `image_reponser` varchar(45) DEFAULT NULL,
  `nbr_up` int(11) DEFAULT NULL,
  `nbr_down` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `resolution_conflit`
--

CREATE TABLE `resolution_conflit` (
  `id_resolution_conflit` int(11) NOT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_conflit` int(11) DEFAULT NULL,
  `id_sm` int(11) DEFAULT NULL,
  `description_resolution_conflit` varchar(45) DEFAULT NULL,
  `id_bs` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `review_po`
--

CREATE TABLE `review_po` (
  `id_review_po` int(11) NOT NULL,
  `id_po` int(11) DEFAULT NULL,
  `id_sprint` int(11) DEFAULT NULL,
  `description_po` varchar(45) DEFAULT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sm`
--

CREATE TABLE `sm` (
  `id` int(11) NOT NULL,
  `Nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `Date_Naissance` varchar(45) DEFAULT NULL,
  `Numero_Tel` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT '1',
  `E-mail` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `User_name` varchar(45) DEFAULT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `Image_user` varchar(45) DEFAULT NULL,
  `id_projet1` varchar(45) DEFAULT NULL,
  `id_projet2` varchar(45) DEFAULT NULL,
  `id_projet3` varchar(45) DEFAULT NULL,
  `Max_projet` varchar(45) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sprint`
--

CREATE TABLE `sprint` (
  `id_sprint` int(11) NOT NULL,
  `date_debut_sprint` date DEFAULT NULL,
  `date_fin_sprint` date DEFAULT NULL,
  `liste_user_sroty_bs` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sprint_retrospective`
--

CREATE TABLE `sprint_retrospective` (
  `id_sprint_retrospective` int(11) NOT NULL,
  `id_sprint+1` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `descripion_TODO` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sprint_review`
--

CREATE TABLE `sprint_review` (
  `id_sprint_review` int(11) NOT NULL,
  `id_sprint` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `remarque_sprint_review` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tableau_blanc`
--

CREATE TABLE `tableau_blanc` (
  `id_tableau_blanc` int(11) NOT NULL,
  `id_projet` int(11) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_sprint` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id_Tache` int(11) NOT NULL,
  `id_user_story_bs` int(50) NOT NULL,
  `id_Sprint` varchar(45) DEFAULT NULL,
  `date_debut_tache` varchar(50) DEFAULT NULL,
  `date_fin_tache` varchar(50) DEFAULT NULL,
  `nom_tache` varchar(45) DEFAULT NULL,
  `type_tache` varchar(45) DEFAULT NULL,
  `liste_Personnel` varchar(50) DEFAULT NULL,
  `description_tache` varchar(45) DEFAULT NULL,
  `liste_nbre_heure` varchar(45) DEFAULT NULL,
  `moyenne_estimation` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id_Tache`, `id_user_story_bs`, `id_Sprint`, `date_debut_tache`, `date_fin_tache`, `nom_tache`, `type_tache`, `liste_Personnel`, `description_tache`, `liste_nbre_heure`, `moyenne_estimation`) VALUES
(10, 1, '3', '', '', 'yassmine', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `up_down`
--

CREATE TABLE `up_down` (
  `id_up_down` int(11) NOT NULL,
  `id_personnel` int(11) DEFAULT NULL,
  `id_reponse` int(11) DEFAULT NULL,
  `up` int(11) DEFAULT NULL,
  `down` varchar(45) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `Nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `Date_Naissance` varchar(45) DEFAULT NULL,
  `Numero_Tel` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT '0',
  `E-mail` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `User_name` varchar(45) DEFAULT NULL,
  `mot_de_passe` varchar(45) DEFAULT NULL,
  `Image_user` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user_stories_bp`
--

CREATE TABLE `user_stories_bp` (
  `id_User_stories_bp` int(11) NOT NULL,
  `user_story_bp` varchar(45) DEFAULT NULL,
  `priority_bp` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user_story_bs`
--

CREATE TABLE `user_story_bs` (
  `id_user_story_bs` int(50) NOT NULL,
  `id_sprint` int(11) DEFAULT NULL,
  `description_user_story_bs` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_story_bs`
--

INSERT INTO `user_story_bs` (`id_user_story_bs`, `id_sprint`, `description_user_story_bs`) VALUES
(1, 2, 'fggg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id_absence`);

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `avancement`
--
ALTER TABLE `avancement`
  ADD PRIMARY KEY (`id_avancement`);

--
-- Index pour la table `backlog_produit`
--
ALTER TABLE `backlog_produit`
  ADD PRIMARY KEY (`id_Backlog_produit`);

--
-- Index pour la table `backlog_sprint`
--
ALTER TABLE `backlog_sprint`
  ADD PRIMARY KEY (`id_bs`);

--
-- Index pour la table `burndownchart`
--
ALTER TABLE `burndownchart`
  ADD PRIMARY KEY (`id_burndownchart`);

--
-- Index pour la table `calendrier`
--
ALTER TABLE `calendrier`
  ADD PRIMARY KEY (`id_calendrier`);

--
-- Index pour la table `conflit`
--
ALTER TABLE `conflit`
  ADD PRIMARY KEY (`id_conflit`);

--
-- Index pour la table `conge`
--
ALTER TABLE `conge`
  ADD PRIMARY KEY (`id_Conge`);

--
-- Index pour la table `daily_meeting`
--
ALTER TABLE `daily_meeting`
  ADD PRIMARY KEY (`id_daily_meeting`);

--
-- Index pour la table `documentation`
--
ALTER TABLE `documentation`
  ADD PRIMARY KEY (`id_documentation`);

--
-- Index pour la table `equipes`
--
ALTER TABLE `equipes`
  ADD PRIMARY KEY (`id_equipe`);

--
-- Index pour la table `features`
--
ALTER TABLE `features`
  ADD PRIMARY KEY (`id_Features`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id_formation`);

--
-- Index pour la table `forum`
--
ALTER TABLE `forum`
  ADD PRIMARY KEY (`id_forum`);

--
-- Index pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD PRIMARY KEY (`id_intervention`);

--
-- Index pour la table `ligne_tab`
--
ALTER TABLE `ligne_tab`
  ADD PRIMARY KEY (`id_ligne_tab`);

--
-- Index pour la table `like`
--
ALTER TABLE `like`
  ADD PRIMARY KEY (`id_like`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id_Personnel`);

--
-- Index pour la table `po`
--
ALTER TABLE `po`
  ADD PRIMARY KEY (`id_Client`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id_Profil`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`id_projet`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_question`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_reclamation`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id_reponse`);

--
-- Index pour la table `resolution_conflit`
--
ALTER TABLE `resolution_conflit`
  ADD PRIMARY KEY (`id_resolution_conflit`);

--
-- Index pour la table `review_po`
--
ALTER TABLE `review_po`
  ADD PRIMARY KEY (`id_review_po`);

--
-- Index pour la table `sm`
--
ALTER TABLE `sm`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sprint`
--
ALTER TABLE `sprint`
  ADD PRIMARY KEY (`id_sprint`);

--
-- Index pour la table `sprint_retrospective`
--
ALTER TABLE `sprint_retrospective`
  ADD PRIMARY KEY (`id_sprint_retrospective`);

--
-- Index pour la table `sprint_review`
--
ALTER TABLE `sprint_review`
  ADD PRIMARY KEY (`id_sprint_review`);

--
-- Index pour la table `tableau_blanc`
--
ALTER TABLE `tableau_blanc`
  ADD PRIMARY KEY (`id_tableau_blanc`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id_Tache`),
  ADD KEY `id_user_story_bs` (`id_user_story_bs`);

--
-- Index pour la table `up_down`
--
ALTER TABLE `up_down`
  ADD PRIMARY KEY (`id_up_down`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_stories_bp`
--
ALTER TABLE `user_stories_bp`
  ADD PRIMARY KEY (`id_User_stories_bp`);

--
-- Index pour la table `user_story_bs`
--
ALTER TABLE `user_story_bs`
  ADD PRIMARY KEY (`id_user_story_bs`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id_Tache` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id`) REFERENCES `sm` (`id`);

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`id_Personnel`) REFERENCES `sm` (`id`);

--
-- Contraintes pour la table `po`
--
ALTER TABLE `po`
  ADD CONSTRAINT `po_ibfk_1` FOREIGN KEY (`id_Client`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `sm`
--
ALTER TABLE `sm`
  ADD CONSTRAINT `sm_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`id_user_story_bs`) REFERENCES `user_story_bs` (`id_user_story_bs`),
  ADD CONSTRAINT `tache_ibfk_2` FOREIGN KEY (`id_user_story_bs`) REFERENCES `user_story_bs` (`id_user_story_bs`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
