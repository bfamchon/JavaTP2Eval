package com.persistence;

import com.domain.Personne;
import com.persistence.mapper.PersonneMapper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by baptiste on 20/11/16.
 * Hi
 */
public class ProxyPersonne extends Personne{
    private Personne inst = null;

    public ProxyPersonne() {
        super();
    }
    public void initialize() throws SQLException {
        // Initialiser l'objet proxyfié avec la BD
        PersonneMapper PM = new PersonneMapper();
        try {
            inst = PM.findById(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("ProxyPersonne.initialize(): Je cree une instance de Personne avec un appel à la base");
    }

    public void ensureIsInitialized() throws SQLException {
        System.out.println("ProxyPersonne.ensureIsInitialized(): Check if inst exist");
        if(inst == null){
            inst = new Personne();
            try {
                this.initialize();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Integer getId() throws SQLException {
        ensureIsInitialized();
        return inst.getId();
    }
    public void setId(Integer id) {
        inst.setId(id);
        notifier();
    }
    public String getNom() throws SQLException {
        ensureIsInitialized();
        return inst.getNom();
    }
    public String getPrenom() throws SQLException {
        ensureIsInitialized();
        return inst.getPrenom();
    }
    public void setNom(String nom) {
        inst.setNom(nom);
        notifier();
    }
    public void setPrenom(String prenom) {
        inst.setPrenom(prenom);
        notifier();
    }

    public String getTel() throws SQLException {
        ensureIsInitialized();
        return inst.getTel();
    }

    public String getEvaluation() throws SQLException {
        ensureIsInitialized();
        return inst.getEvaluation();
    }

    public void setEvaluation(String evaluation) {
        inst.setEvaluation(evaluation);
        notifier();
    }

    public Personne getPere() throws SQLException {
        ensureIsInitialized();
        return inst.getPere();
    }

    public void setPere(Personne pere) {
        inst.setPere(pere);
        notifier();
    }

    public List<Personne> getFils() throws SQLException {
        ensureIsInitialized();
        return inst.getFils();
    }

    public void addFils(Personne fils) throws SQLException {
        inst.getFils().add(fils);
        notifier();
    }

    public void setFils(List<Personne> fils) {
        inst.setFils(fils);
        notifier();
    }

    public void setTel(String tel) {
        inst.setTel(tel);
        notifier();
    }
}