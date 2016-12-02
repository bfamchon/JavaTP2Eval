--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne`(
  `id` int(11) NOT NULL,
  `nom` varchar(15) DEFAULT NULL,
  `prenom` varchar(15) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `evaluation` varchar(30) DEFAULT NULL,
  `idPere` int(11) DEFAULT NULL
);

ALTER TABLE `personne`
 ADD PRIMARY KEY (`id`),
 ADD FOREIGN KEY (`idPere`) REFERENCES personne(id);

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `telephone`, `evaluation`, `idPere`) VALUES
(0, 'AIRE', 'Axel', '0304050607', 'Lent', 2),
(1, 'FICHIER', 'Sam', '0000000000', 'Nul', 0),
(2, 'GOLAY', 'Jerry', '0123456789', 'Ludique', 0),
(3, 'KOLLYCK', 'Al', '012', 'Distrait', 2);
