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
    private static final String SELECT_FROM_PERSONNE_WHERE_ID = "SELECT " +
    "h.idPere, p1.nom, p1.prenom, p1.telephone, p1.evaluation, " +
    "h.idFils, p2.nom, p2.prenom, p2.telephone, p2.evaluation " +
    "FROM hierarchie h " +
    "INNER JOIN personne p1 ON h.idPere = p1.id " +
    "INNER JOIN personne p2 ON h.idFils = p2.id " +
    "WHERE p1.id=? OR p2.id=?; ";

    private static final String SELECT_FROM_PERSONNE = "SELECT " +
            "h.idPere, p1.nom as nomPere, p1.prenom as prenomPere, p1.telephone as telephonePere, p1.evaluation as evaluationPere, " +
            "h.idFils, p2.nom as nomFils, p2.prenom as prenomFils, p2.telephone as telephoneFils, p2.evaluation as evaluationFils " +
            "FROM hierarchie h " +
            "INNER JOIN personne p1 ON h.idPere = p1.id " +
            "INNER JOIN personne p2 ON h.idFils = p2.id ";

    // TODO
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
        ps.setInt(2,id);
        ResultSet rs = ps.executeQuery();
//		Si on a au moins une ligne en retour
        if(rs.next()) {
            p = extrairePersonne(rs,id);
            return p;
        }
        return null;
    }
}

