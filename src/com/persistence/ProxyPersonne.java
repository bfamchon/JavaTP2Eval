package com.persistence;

import com.domain.Personne;
import com.persistence.mapper.PersonneMapper;

import java.sql.SQLException;

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
}