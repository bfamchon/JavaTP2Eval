package com.persistence;

import com.domain.Personne;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by baptiste on 24/11/16.
 * Hi
 */
// TODO faire le tri et découper en fonctions
public class Extraction {
    /**
     * Permet d'extraire une personne et ses fils/pere d'une requete venant de PersonneMapper
     *
     * @param rs une ligne résultante de la requete
     * @param id l'id de la personne demandee en requete
     */
    public static Personne extrairePersonne(ResultSet rs, Integer id) throws SQLException {
        Personne personne = new Personne();
        int idPers;
        do {
            Personne hierarchie;
            idPers = rs.getInt(1);
            // On fait se test pour initialiser la personne une fois
            if (personne.getId() == null) {
                personne = remplirPersonne(rs,idPers != id);
            }
            // On rempli les fils de la personne
            if (idPers == id) {
                hierarchie = remplirPersonne(rs,true);
                personne.addFils(hierarchie);
            } else {
                // On passe ici 1 fois, pour remplir le père
                hierarchie = remplirPersonne(rs,false);
                personne.setPere(hierarchie);
            }
        } while (rs.next());
        return personne;
    }

    private static Personne remplirPersonne(ResultSet rs, Boolean remplirFils) throws SQLException {
        Personne personne = new Personne();
        Integer idPers;
        String nomPers;
        String telPers;
        String prenomPers;
        String evalPers;
        if ( remplirFils ) {
            idPers = rs.getInt(6);
            nomPers = rs.getString(7);
            prenomPers = rs.getString(8);
            telPers = rs.getString(9);
            evalPers = rs.getString(10);

            personne.setId(idPers);
            personne.setNom(nomPers);
            personne.setPrenom(prenomPers);
            personne.setTel(telPers);
            personne.setEvaluation(evalPers);
        } else {
            idPers = rs.getInt(1);
            nomPers = rs.getString(2);
            telPers = rs.getString(4);
            prenomPers = rs.getString(3);
            evalPers = rs.getString(5);
            personne.setId(idPers);
            personne.setNom(nomPers);
            personne.setPrenom(prenomPers);
            personne.setTel(telPers);
            personne.setEvaluation(evalPers);
        }
        return personne;
    }
}