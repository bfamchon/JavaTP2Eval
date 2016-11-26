package com.persistence.mapper;

import com.domain.Personne;
import com.persistence.gestionnaireconnexion.DBConfig;
import com.persistence.uow.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.persistence.Extraction.extrairePersonne;


/**
 * Created by baptiste on 20/11/16.
 * Hi
 * But: Le PM est modifié pour ajouter un observateur à chaque objet Personne créé.
 */
public class PersonneMapper implements InterfaceMapper<Personne>{
    /**
     * Constantes utilisées pour nos requetes dans le Personne Mapper
     */
    private static final String SELECT_FROM_PERSONNE_WHERE_ID  = "SELECT " +
            "p.id, p.nom, p.prenom, p.telephone, p.evaluation, " +
            "p2.id, p2.nom, p2.prenom, p2.telephone, p2.evaluation, " +
            "p1.id, p1.nom, p1.prenom, p1.telephone, p1.evaluation " +
            "FROM personne p " +
            "LEFT JOIN personne p1 ON p1.idPere = p.id " +
            "LEFT JOIN personne p2 ON p2.id = p.idPere " +
            "WHERE p.id=?; ";

    private static final String SELECT_FROM_PERSONNE = "SELECT " +
            "p.id, p.nom, p.prenom, p.telephone, p.evaluation, " +
            "p2.id, p2.nom, p2.prenom, p2.telephone, p2.evaluation, " +
            "p1.id, p1.nom, p1.prenom, p1.telephone, p1.evaluation " +
            "FROM personne p " +
            "LEFT JOIN personne p1 ON p1.idPere = p.id " +
            "LEFT JOIN personne p2 ON p2.id = p.idPere ";

    // TODO Autres requetes
    private static final String UPDATE_PERSONNE_SET_INFOS_WHERE_ID = "UPDATE personne";
    private static final String INSERT_INTO_PERSONNE_VALUES = "INSERT INTO personne VALUES(?,?,?,?,?)";
    private static final String DELETE_FROM_PERSONNE_WHERE_ID = "DELETE FROM personne WHERE id=?";
    private static final String SEARCH_MAX_ID = "SELECT MAX(id) as maxid FROM personne";

    static PersonneMapper inst;
    public static PersonneMapper getInstance() {
        if (inst == null)
            inst = new PersonneMapper();
        return inst;
    }

    @Override
    public void insert(Personne b) throws SQLException {

    }

    @Override
    public void delete(Personne b) throws SQLException {

    }

    public void update(Personne p) {
        // faire des accès en base: alter table blablabla
        System.out.println("PM.update(): MÀJ personne dans la base de donnees.");
    }

    @Override
    public List<Personne> find() throws SQLException {
        return null;
    }

    @Override
    public Personne findById(Integer id) throws SQLException {
        // faire des accès en base: SELECT ... WHERE id = id
        Personne p = new Personne();
        p.add(UnitOfWork.getInstance());
        PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(SELECT_FROM_PERSONNE_WHERE_ID);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
//		Si on a au moins une ligne en retour
        if(rs.next()) {
            p = extrairePersonne(rs);
            return p;
        }
        return null;
    }
}

