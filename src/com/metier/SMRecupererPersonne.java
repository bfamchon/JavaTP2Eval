package com.metier;

import com.domain.Personne;
import com.domain.criteria.Criteria;
import com.domain.criteria.PersonneCriteria;
import com.exception.UtilisateurInconnuException;
import com.persistence.gestionnaireconnexion.DBConfig;
import com.persistence.mapper.PersonneMapper;

import java.sql.SQLException;

/**
 * Created by baptiste on 01/12/16.
 * Hi
 */
public class SMRecupererPersonne {
    /**
     * personneMapper commun aux methodes de class
     */
    private PersonneMapper pMapper;

    /**
     * Constructeur du Gestionnaire de Personne
     */
    public SMRecupererPersonne() {
        super();
        this.pMapper = new PersonneMapper();
    }

    public Personne process(Criteria pc) throws SQLException, UtilisateurInconnuException{
         Personne p = pMapper.findById(((PersonneCriteria) pc).getId());
         if (p==null){
        	 throw new UtilisateurInconnuException("L'utilisateur n'existe pas");
         }
         return p;
    }

    /**
     * Ferme la connexion à la base de donnees si l'objet n'est plus utilise
     */
    public void finalize() {
        DBConfig.getInstance().fermerConnexion();
    }
}
