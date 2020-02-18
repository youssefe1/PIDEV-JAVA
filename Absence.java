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
public class Absence {
    
    private int id_Absence;
    private int ide_user;
    private String Nom;
    private String date;
    private String heure;
    private int nbre;

    public Absence( int ide_user, String date, String heure, int nbre) {
        
        this.ide_user = ide_user;
        this.date = date;
        this.heure = heure;
        this.nbre = nbre;
    }

    public Absence(int ide_user, String nom, String date, String heure, int nbre) {
        this.ide_user = ide_user;
        this.Nom = nom;
        this.date = date;
        this.heure = heure;
        this.nbre = nbre;
    }

    public Absence(int id_Absence, int ide_user, String nom, String date, String heure, int nbre) {
        this.id_Absence = id_Absence;
        this.ide_user = ide_user;
        this.Nom = nom;
        this.date = date;
        this.heure = heure;
        this.nbre = nbre;
    }
    

    public int getId_Absence() {
        return id_Absence;
    }

    public void setId_Absence(int id_Absence) {
        this.id_Absence = id_Absence;
    }

    public int getIde_user() {
        return ide_user;
    }

    public void setIde_user(int ide_user) {
        this.ide_user = ide_user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    

    

   
    
    
    
}
