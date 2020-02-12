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
public class Reclamation {
    int id_personnel,etat_reclamation; 
    String sujet_reclamation,description_reclamation;

    public Reclamation(int id_personnel,  String sujet_reclamation, int etat_reclamation,String description_reclamation) {
        
        this.id_personnel = id_personnel;
        this.etat_reclamation = etat_reclamation;
        this.sujet_reclamation = sujet_reclamation;
        this.description_reclamation = description_reclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{ " + " id_personnel=" + id_personnel + ", etat_reclamation=" + etat_reclamation + ", sujet_reclamation=" + sujet_reclamation + ", description_reclamation=" + description_reclamation + '}';
    }
    
    

    public int getId_personnel() {
        return id_personnel;
    }

    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }

    public int getEtat_reclamation() {
        return etat_reclamation;
    }

    public void setEtat_reclamation(int etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

    public String getSujet_reclamation() {
        return sujet_reclamation;
    }

    public void setSujet_reclamation(String sujet_reclamation) {
        this.sujet_reclamation = sujet_reclamation;
    }

    public String getDescription_reclamation() {
        return description_reclamation;
    }

    public void setDescription_reclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }
    
    
    
    
}
