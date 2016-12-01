package com.persistence.mapper;

import com.domain.Personne;
import com.domain.criteria.PersonneCriteria;
import com.persistence.gestionnaireconnexion.DBConfig;
import com.persistence.proxy.Factory;
import com.persistence.proxy.ListPersonneFactory;
import com.persistence.proxy.VirtualProxyBuilder;
import com.persistence.uow.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            "p.id, p.nom, p.prenom, p.telephone, p.evaluation, p.idPere " +
            "FROM personne p " +
            "WHERE p.id=?";

    private static final String SELECT_FROM_PERSONNE = "SELECT " +
            "p.id, p.nom, p.prenom, p.telephone, p.evaluation, " +
            "FROM personne p ";

    private static final String UPDATE_PERSONNE_SET_INFOS_WHERE_ID = "UPDATE personne " +
            "SET nom = ?, prenom = ?, telephone = ?, evaluation = ?, idPere = ? " +
            "WHERE id = ?";

    private static final String INSERT_INTO_PERSONNE_VALUES = "INSERT INTO personne VALUES(?,?,?,?,?,?)";

    private static final String SELECT_FILS_WHERE_IDPERE = "SELECT " +
            "p.id, p.nom, p.prenom, p.telephone, p.evaluation, p.idPere " +
            "FROM personne p " +
            "WHERE p.idPere = ?";


    private static final String DELETE_FROM_PERSONNE_WHERE_ID = "DELETE FROM personne WHERE id=?";

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
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Personne p) throws SQLException {

    }

    public void update(Personne p) throws SQLException {
        if ( p != null ) {
            String req = UPDATE_PERSONNE_SET_INFOS_WHERE_ID;
            PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(req);
            ps.setString(1,p.getNom());
            ps.setString(2,p.getPrenom());
            ps.setString(3,p.getTel());
            ps.setString(4,p.getEvaluation());
            ps.setInt(5,p.getIdPere());
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
        Personne p;
        PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(SELECT_FROM_PERSONNE_WHERE_ID);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
//		Si on a au moins une ligne en retour
        if(rs.next()) {
            p = this.initPersonne(rs);
            p.add(UnitOfWork.getInstance());
            return p;
        }
        return null;
    }

    public List<Personne> findFilsByIdPere(Integer idPere) throws SQLException {
        List<Personne> lp = new ArrayList<>();
        Personne p;
        PreparedStatement ps = DBConfig.getInstance().getConn().prepareStatement(SELECT_FILS_WHERE_IDPERE);
        ps.setInt(1,idPere);
        ResultSet rs = ps.executeQuery();
//		Si on a au moins une ligne en retour
        while(rs.next()) {
            p = this.initPersonne(rs);
            p.add(UnitOfWork.getInstance());
            lp.add(p);
        }
        return lp;
    }

    /**
     * Permet d'extraire et initialiser une personne d'une requete
     *
     * @param rs une ligne résultante de la requete
     */
    private Personne initPersonne(ResultSet rs) throws SQLException {
        Personne personne = new Personne();
        // On initialise la personne
        personne.setId(rs.getInt(1));
        personne.setNom(rs.getString(2));
        personne.setPrenom(rs.getString(3));
        personne.setTel(rs.getString(4));
        personne.setEvaluation(rs.getString(5));

        Factory<List<Personne>> lp = new ListPersonneFactory();
        List<Personne> fils = new VirtualProxyBuilder<List<Personne>>
                (List.class , lp, new PersonneCriteria(personne.getId())).getProxy();
        personne.setFils(fils);

        personne.setIdPere(rs.getInt(6));
        return personne;
    }
}

