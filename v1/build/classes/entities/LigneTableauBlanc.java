/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author youss
 */
public class LigneTableauBlanc {
    private int id_ligne;
    private int id_TableauBlanc;
    private int id_personnel;
    private String nom_tache;
    private String etat_tache;
    private String date_ajout_ligne;

    public LigneTableauBlanc(int id_ligne, int id_TableauBlanc, int id_personnel, String nom_tache, String etat_tache, String date_ajout_ligne) {
        this.id_ligne = id_ligne;
        this.id_TableauBlanc = id_TableauBlanc;
        this.id_personnel = id_personnel;
        this.nom_tache = nom_tache;
        this.etat_tache = etat_tache;
        this.date_ajout_ligne = date_ajout_ligne;
    }

    public LigneTableauBlanc(int id_TableauBlanc, int id_personnel, String nom_tache, String etat_tache, String date_ajout_ligne) {
        this.id_TableauBlanc = id_TableauBlanc;
        this.id_personnel = id_personnel;
        this.nom_tache = nom_tache;
        this.etat_tache = etat_tache;
        this.date_ajout_ligne = date_ajout_ligne;
    }
    

    public int getId_ligne() {
        return id_ligne;
    }

    public int getId_TableauBlanc() {
        return id_TableauBlanc;
    }

    public int getId_personnel() {
        return id_personnel;
    }

    public String getNom_tache() {
        return nom_tache;
    }

    public String getEtat_tache() {
        return etat_tache;
    }

    public String getDate_ajout_ligne() {
        return date_ajout_ligne;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

    public void setId_TableauBlanc(int id_TableauBlanc) {
        this.id_TableauBlanc = id_TableauBlanc;
    }

    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }

    public void setNom_tache(String nom_tache) {
        this.nom_tache = nom_tache;
    }

    public void setEtat_tache(String etat_tache) {
        this.etat_tache = etat_tache;
    }

    public void setDate_ajout_ligne(String date_ajout_ligne) {
        this.date_ajout_ligne = date_ajout_ligne;
    }

    @Override
    public String toString() {
        return "LigneTableauBlanc{" + "id_ligne=" + id_ligne + ", id_TableauBlanc=" + id_TableauBlanc + ", id_personnel=" + id_personnel + ", nom_tache=" + nom_tache + ", etat_tache=" + etat_tache + ", date_ajout_ligne=" + date_ajout_ligne + '}';
    }
  
    
}
