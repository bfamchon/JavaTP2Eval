package com.persistence.mapper;

import com.domain.Personne;
import com.persistence.gestionnaireconnexion.DBConfig;
import com.persistence.uow.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
            "WHERE p.id=?";

    private static final String SELECT_FROM_PERSONNE = "SELECT " +
            "p.id, p.nom, p.prenom, p.telephone, p.evaluation, " +
            "p2.id, p2.nom, p2.prenom, p2.telephone, p2.evaluation, " +
            "p1.id, p1.nom, p1.prenom, p1.telephone, p1.evaluation " +
            "FROM personne p " +
            "LEFT JOIN personne p1 ON p1.idPere = p.id " +
            "LEFT JOIN personne p2 ON p2.id = p.idPere ";

    private static final String UPDATE_PERSONNE_SET_INFOS_WHERE_ID = "UPDATE personne " +
            "SET nom = ?, prenom = ?, telephone = ?, evaluation = ?, idPere = ? " +
            "WHERE id = ?";

    private static final String INSERT_INTO_PERSONNE_VALUES = "INSERT INTO personne VALUES(?,?,?,?,?,?)";
    // TODO Autres requetes
    private static final String DELETE_FROM_PERSONNE_WHERE_ID = "DELETE FROM personne WHERE id=?";
    private static final String SEARCH_MAX_ID = "SELECT MAX(id) as maxid FROM personne";

    static PersonneMapper inst;
    public static PersonneMapper getInstance() {
        if (inst == null)
            inst = new PersonneMapper();
        return inst;
    }

    @Override
    public void insert(Personne p) throws SQLException {
        if ( p != null ) {
            String req = INSERT_INTO_PERSONNE_VALUES;
            PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(req);
            ps.setInt(1,p.getId());
            ps.setString(2,p.getNom());
            ps.setString(3,p.getPrenom());
            ps.setString(4,p.getTel());
            ps.setString(5,p.getEvaluation());
            if (p.getPere() != null) {
                ps.setInt(6, p.getPere().getId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Personne p) throws SQLException {

    }

    public void update(Personne p) throws SQLException {
        // faire des accès en base: alter table blablabla
        if ( p != null ) {
            String req = UPDATE_PERSONNE_SET_INFOS_WHERE_ID;
            PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(req);
            ps.setString(1,p.getNom());
            ps.setString(2,p.getPrenom());
            ps.setString(3,p.getTel());
            ps.setString(4,p.getEvaluation());
            if (p.getPere() != null) {
                ps.setInt(5, p.getPere().getId());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setInt(6,p.getId());
            ps.executeUpdate();
            System.out.println("PM.update(): MÀJ personne dans la base de donnees.");
        }
    }

    @Override
    public List<Personne> find() throws SQLException {
        return null;
    }

    @Override
    public Personne findById(Integer id) throws SQLException {
        // faire des accès en base: SELECT ... WHERE id = id
        Personne p = new Personne();
        PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(SELECT_FROM_PERSONNE_WHERE_ID);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
//		Si on a au moins une ligne en retour
        if(rs.next()) {
            p = extrairePersonne(rs);
            p.add(UnitOfWork.getInstance());
            return p;
        }
        return null;
    }
}

