package com.metier;

import com.domain.Personne;
import com.persistence.gestionnaireconnexion.DBConfig;

/**
 * Created by baptiste on 01/12/16.
 * Hi
 */
public class SMUpdatePersonne {

    /**
     * Constructeur du Gestionnaire de Personne
     */
    public SMUpdatePersonne() {
        super();
    }

    public Personne process(Personne p,String eval) {
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
