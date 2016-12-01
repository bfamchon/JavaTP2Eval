package com.controller;

import com.constante.Constante;
import com.domain.Personne;
import com.domain.criteria.Criteria;
import com.domain.criteria.PersonneCriteria;
import com.exception.UtilisateurInconnuException;
import com.metier.SMRecupererPersonne;
import com.metier.SMUpdatePersonne;

import java.sql.SQLException;

/**
 * Created by baptiste on 01/12/16.
 * Hi
 */
public class ModifEvalControler {
    public static ModelAndView doPost(ModelAndView mav) {
        final Personne exFils = (Personne) mav.recupRequest(Constante.EXFILS);
        final String eval = (String) mav.recupRequest(Constante.EVALUATION);

        mav.viderRequest();
        Personne p;

        SMUpdatePersonne smrp = new SMUpdatePersonne();
        p = smrp.updateEvaluation(exFils,eval);

        mav.addSession(Constante.EXFILS,p);

        return mav;
    }
}
