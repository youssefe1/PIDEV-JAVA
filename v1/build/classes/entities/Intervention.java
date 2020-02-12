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
public class Intervention {
    int id_intervention, id_sm,id_reclamation; 
    String decription_intervention,date_intevention;

    @Override
    public String toString() {
        return "Intervention{" + "id_intervention=" + id_intervention + ", id_sm=" + id_sm + ", id_reclamation=" + id_reclamation + ", decription_intervention=" + decription_intervention + ", date_intevention=" + date_intevention + '}';
    }
    

    public Intervention(int id_intervention, int id_sm, int id_reclamation, String decription_intervention, String date_intevention) {
        this.id_intervention = id_intervention;
        this.id_sm = id_sm;
        this.id_reclamation = id_reclamation;
        this.decription_intervention = decription_intervention;
        this.date_intevention = date_intevention;
    }
    
    
    

    public int getId_intervention() {
        return id_intervention;
    }

    public void setId_intervention(int id_intervention) {
        this.id_intervention = id_intervention;
    }

    public int getId_sm() {
        return id_sm;
    }

    public void setId_sm(int id_sm) {
        this.id_sm = id_sm;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getDecription_intervention() {
        return decription_intervention;
    }

    public void setDecription_intervention(String decription_intervention) {
        this.decription_intervention = decription_intervention;
    }

    public String getDate_intevention() {
        return date_intevention;
    }

    public void setDate_intevention(String date_intevention) {
        this.date_intevention = date_intevention;
    }
    
    
    
    
    
}
