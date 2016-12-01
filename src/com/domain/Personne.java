package com.domain;

import com.persistence.uow.IDomainObject;
import com.persistence.uow.Observateur;
import com.persistence.uow.Visiteur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baptiste on 20/11/16.
 * Hi
 */

public class Personne implements IDomainObject {
    private List<Observateur> obs;
    private Integer id;
    private String nom;
    private String prenom;
    private String tel;
    private String evaluation;
    private List<Personne> fils;

    private Integer idPere;

    public Personne() {
        this.nom = "";
        this.tel = "";
        this.prenom = "";
        this.fils = new ArrayList<>();
        this.obs = new ArrayList<>();
    }

    public Personne(String nom, String prenom, String tel) {
        this.nom = nom;
        this.tel = tel;
        this.prenom = prenom;
        this.fils = new ArrayList<>();
        this.obs = new ArrayList<>();
    }

    public Integer getId()  {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        notifier();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
        notifier();
    }

    public String getTel()  {
        return tel;
    }

    public String getEvaluation()  {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
        notifier();
    }


    public List<Personne> getFils() {
        return fils;
    }

    public void addFils(Personne fils)  {
        this.fils.add(fils);
        notifier();
    }

    public void setFils(List<Personne> fils) {
        this.fils = fils;
        notifier();
    }

    public void setNom(String nom) {
        this.nom = nom;
        notifier();
    }

    public void setTel(String tel) {
        this.tel = tel;
        notifier();
    }
    public Integer getIdPere() {
        return idPere;
    }

    public void setIdPere(Integer idPere) {
        this.idPere = idPere;
        notifier();
    }

    public List<Observateur> getObs() {
        return obs;
    }

    public void accepter(Visiteur v) {
        v.visiter(this);
    }

    public void add(Observateur o) {
        obs.add(o);
    }

    /**
     * On notifie l'observateur que l'on a fait un changement
     */
    public void notifier() {
        for (Observateur o : obs)
            o.action(this);
    }

    @Override
    public String toString() {
        return this.getPrenom() + " " + this.getNom();
    }
}