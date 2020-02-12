/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Formation {
    int id_formation,	id_equipe;
    String nom_formation,sujet_formation,date_time_debut,date_time_fin;

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    public String getSujet_formation() {
        return sujet_formation;
    }

    public void setSujet_formation(String sujet_formation) {
        this.sujet_formation = sujet_formation;
    }

    public String getDate_time_debut() {
        return date_time_debut;
    }

    public void setDate_time_debut(String date_time_debut) {
        this.date_time_debut = date_time_debut;
    }

    public String getDate_time_fin() {
        return date_time_fin;
    }

    public void setDate_time_fin(String date_time_fin) {
        this.date_time_fin = date_time_fin;
    }

    public Formation(int id_formation, int id_equipe, String nom_formation, String sujet_formation, String date_time_debut, String date_time_fin) {
        this.id_formation = id_formation;
        this.id_equipe = id_equipe;
        this.nom_formation = nom_formation;
        this.sujet_formation = sujet_formation;
        this.date_time_debut = date_time_debut;
        this.date_time_fin = date_time_fin;
    }

    @Override
    public String toString() {
        return "Formation{" + "id_formation=" + id_formation + ", id_equipe=" + id_equipe + ", nom_formation=" + nom_formation + ", sujet_formation=" + sujet_formation + ", date_time_debut=" + date_time_debut + ", date_time_fin=" + date_time_fin + '}';
    }
    
    
    
    
}
