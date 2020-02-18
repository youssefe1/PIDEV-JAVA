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
public class Tableuser {
    
    private int id;
    private String Nom;
    private String prenom;
    private String E_mail;

    public Tableuser(int id, String Nom, String prenom, String E_mail) {
        this.id = id;
        this.Nom = Nom;
        this.prenom = prenom;
        this.E_mail = E_mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }
    
    
    
    
}
