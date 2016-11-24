SELECT 
	h.idPere, p1.nom as nomPere, p1.prenom as prenomPere, p1.telephone as telephonePere, p1.evaluation as evaluationPere,
	h.idFils, p2.nom as nomFils, p2.prenom as prenomFils, p2.telephone as telephoneFils, p2.evaluation as evaluationFils 
FROM hierarchie h  
	INNER JOIN personne p1 ON h.idPere = p1.id 
	INNER JOIN personne p2 ON h.idFils = p2.id
WHERE p1.id=2 OR p2.id=2;

