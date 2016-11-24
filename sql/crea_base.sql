--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(15) DEFAULT NULL,
  `prenom` varchar(15) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `evaluation` varchar(30) DEFAULT NULL
);

ALTER TABLE `personne`
 ADD PRIMARY KEY (`id`);

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `telephone`, `evaluation`) VALUES
(0, 'AIRE', 'Axel', '0304050607', 'Lent'),
(1, 'FICHIER', 'Sam', '0000000000', 'Nul'),
(2, 'GOLAY', 'Jerry', '0123456789', 'Ludique'),
(3, 'KOLLYCK', 'Al', '012', 'Distrait');

--
-- Structure de la table `hierarchie`
--
CREATE TABLE IF NOT EXISTS `hierarchie` (
  `idPere` int(11) NOT NULL,
  `idFils` int(11) NOT NULL
);

ALTER TABLE `hierarchie`
 ADD PRIMARY KEY (`idPere`, `idFils`),
 ADD FOREIGN KEY (`idPere`) REFERENCES personne(id),
 ADD FOREIGN KEY (`idFils`) REFERENCES personne(id);

INSERT INTO `hierarchie` (`idPere`, `idFils`) VALUES
(0, 1),
(0, 2),
(2, 3);
