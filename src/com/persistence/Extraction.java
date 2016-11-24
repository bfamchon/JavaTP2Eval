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
     * @param rs une ligne résultante de la requete
     * @param id l'id de la personne demandee en requete
     */
    public static Personne extrairePersonne(ResultSet rs, Integer id) throws SQLException {
        Personne personne = new Personne();
        Personne pere = new Personne();
        int idPers, idFils;
        String nomPere, nomFils;
        String telPere, telFils;
        String prenomPere, prenomFils;
        String evalPere, evalFils;
        do {
            Personne hierarchie = new Personne();
            idPers = rs.getInt(1);
            if (idPers == id) {
                idFils = rs.getInt(6);
                nomFils = rs.getString(7);
                prenomFils = rs.getString(8);
                telFils = rs.getString(9);
                evalFils = rs.getString(10);

                hierarchie.setId(idFils);
                hierarchie.setNom(nomFils);
                hierarchie.setPrenom(prenomFils);
                hierarchie.setTel(telFils);
                hierarchie.setEvaluation(evalFils);
                personne.addFils(hierarchie);
            } else {
                // On ne passera ici qu'une fois, une personne peut être fils d'un seul père
                nomPere = rs.getString(2);
                prenomPere = rs.getString(3);
                telPere = rs.getString(4);
                evalPere = rs.getString(5);
                pere.setId(idPers);
                pere.setNom(nomPere);
                pere.setPrenom(prenomPere);
                pere.setTel(telPere);
                pere.setEvaluation(evalPere);

                idFils = rs.getInt(6);
                nomFils = rs.getString(7);
                prenomFils = rs.getString(8);
                telFils = rs.getString(9);
                evalFils = rs.getString(10);

                personne.setId(idFils);
                personne.setNom(nomFils);
                personne.setNom(prenomFils);
                personne.setTel(telFils);
                personne.setEvaluation(evalFils);
                personne.setPere(pere);
            }
        } while(rs.next());

        return personne;
    }
}

