package com.controller;

import com.constante.Constante;
import com.domain.Personne;
import com.domain.criteria.Criteria;
import com.domain.criteria.PersonneCriteria;
import com.exception.UtilisateurInconnuException;
import com.metier.SMRecupererPersonne;

import java.sql.SQLException;

/**
 * Created by baptiste on 01/12/16.
 * Hi
 */
public class ConnexionControler {

    public static ModelAndView doPost(ModelAndView mav) {
        final Integer id = Integer.parseInt((String)mav.recupRequest(Constante.IDENTIFIANT_PERSONNE));
        mav.viderRequest();
        Criteria criterePersonne = new PersonneCriteria(id);
        Personne p = null;
        Personne papa = null;

        try {
            SMRecupererPersonne smrp = new SMRecupererPersonne();
            p = smrp.process(criterePersonne);
            papa = smrp.process(new PersonneCriteria(p.getIdPere()));
        } catch (SQLException e) {
            mav.addErreur("Problème accès BDD");
        } catch (UtilisateurInconnuException e) {
            mav.addErreur(e.getMessage());
        }
        mav.addSession(Constante.UTILISATEUR,p);
        mav.addSession(Constante.PERE,papa);

        return mav;
    }
}
