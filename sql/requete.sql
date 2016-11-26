SELECT 
	p.id as idPers, p.nom as nomPers, p.prenom as prenomPers, p.telephone as telPers, p.evaluation as evalPers,
	p2.id as idPere, p2.nom as nomPere, p2.prenom as prenomPere, p2.telephone as telPere, p2.evaluation as evalPere,
	p1.id as idFils, p1.nom as nomFils, p1.prenom as prenomFils, p1.telephone as telFils, p1.evaluation as evalFils
FROM personne p
	LEFT JOIN personne p1 ON p1.idPere = p.id
	LEFT JOIN personne p2 ON p2.id = p.idPere
WHERE p.id=0;
