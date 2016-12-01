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
public class SMUpdatePersonne {
    /**
     * personneMapper commun aux methodes de class
     */
    private PersonneMapper pMapper;

    /**
     * Constructeur du Gestionnaire de Personne
     */
    public SMUpdatePersonne() {
        super();
        this.pMapper = new PersonneMapper();
    }

    public Personne updateEvaluation(Personne p,String eval) {
        p.setEvaluation(eval);
        return p;
    }

    /**
     * Ferme la connexion à la base de donnees si l'objet n'est plus utilise
     */
    public void finalize() {
        DBConfig.getInstance().fermerConnexion();
    }
}
