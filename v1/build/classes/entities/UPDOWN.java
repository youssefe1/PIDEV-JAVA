/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author youss
 */
public class UPDOWN {
    private int id_updown;
    private int id_personnel;
    private int id_reponse;
    private String etat_updown;

    public UPDOWN(int id_updown, int id_personnel, int id_reponse, String etat_updown) {
        this.id_updown = id_updown;
        this.id_personnel = id_personnel;
        this.id_reponse = id_reponse;
        this.etat_updown = etat_updown;
    }

    public UPDOWN(int id_personnel, int id_reponse, String etat_updown) {
        this.id_personnel = id_personnel;
        this.id_reponse = id_reponse;
        this.etat_updown = etat_updown;
    }

    public int getId_updown() {
        return id_updown;
    }

    public int getId_personnel() {
        return id_personnel;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public String getEtat_updown() {
        return etat_updown;
    }

    public void setId_updown(int id_updown) {
        this.id_updown = id_updown;
    }

    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public void setEtat_updown(String etat_updown) {
        this.etat_updown = etat_updown;
    }

    @Override
    public String toString() {
        return "UPDOWN{" + "id_updown=" + id_updown + ", id_personnel=" + id_personnel + ", id_reponse=" + id_reponse + ", etat_updown=" + etat_updown + '}';
    }

   
    
}
