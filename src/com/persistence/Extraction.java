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
     */
    public static Personne extrairePersonne(ResultSet rs) throws SQLException {
        Personne personne = new Personne();
        do {
            Personne hierarchie;
            // On fait se test pour initialiser la personne et son pere une fois
            if (personne.getId() == null) {
                personne = initPersonne(rs);
            }
            // On rempli les fils de la personne
            if (rs.getString(12) != null) {
                hierarchie = remplirFils(rs);
                personne.addFils(hierarchie);
            }
        } while (rs.next());
        return personne;
    }

    private static Personne remplirFils(ResultSet rs) throws SQLException {
        Personne fils = new Personne();

        fils.setId(rs.getInt(11));
        fils.setNom(rs.getString(12));
        fils.setPrenom(rs.getString(13));
        fils.setTel(rs.getString(14));
        fils.setEvaluation(rs.getString(15));

        return fils;
    }

    private static Personne initPersonne(ResultSet rs) throws SQLException {
        Personne personne = new Personne();
        Personne pere = new Personne();
        // On initialise la personne
        personne.setId(rs.getInt(1));
        personne.setNom(rs.getString(2));
        personne.setPrenom(rs.getString(3));
        personne.setTel(rs.getString(4));
        personne.setEvaluation(rs.getString(5));

        // Puis son père
        pere.setId(rs.getInt(6));
        pere.setNom(rs.getString(7));
        pere.setPrenom(rs.getString(8));
        pere.setTel(rs.getString(9));
        pere.setEvaluation(rs.getString(10));
        personne.setPere(pere);

        return personne;
    }
}