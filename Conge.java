/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Hajer
 */
public class Conge {
    
    private int id_conge;
    private String date_debut;
    private String date_fin;
    private int ide_personnel;
    private String description;

    public Conge(String date_debut, String date_fin, int ide_personnel, String description) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.ide_personnel = ide_personnel;
        this.description = description;
    }

    public int getId_conge() {
        return id_conge;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public int getIde_personnel() {
        return ide_personnel;
    }

    public String getDescription() {
        return description;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public void setIde_personnel(int ide_personnel) {
        this.ide_personnel = ide_personnel;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
