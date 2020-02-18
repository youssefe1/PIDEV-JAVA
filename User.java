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
public class User {
    
    private int idU; 
    private String nom_u ;
    private String prenom ;
    private String Date_Naissance ;
    private int numero_tel; 
    private int UID ;
    private String email ;
    private String address ;
    private String user_name ;
    private String mot_de_passe ;
    private String image_user ;

    public User(String nom_u, String prenom, String Date_Naissance, int numero_tel, int UID, String email, String address, String user_name, String mot_de_passe, String image_user) {
        this.nom_u = nom_u;
        this.prenom = prenom;
        this.Date_Naissance = Date_Naissance;
        this.numero_tel = numero_tel;
        this.UID = UID;
        this.email = email;
        this.address = address;
        this.user_name = user_name;
        this.mot_de_passe = mot_de_passe;
        this.image_user = image_user;
    }

    public int getIdU() {
        return idU;
    }

    public String getNom_u() {
        return nom_u;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_Naissance() {
        return Date_Naissance;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public int getUID() {
        return UID;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getImage_user() {
        return image_user;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setNom_u(String nom_u) {
        this.nom_u = nom_u;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_Naissance(String Date_Naissance) {
        this.Date_Naissance = Date_Naissance;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setImage_user(String image_user) {
        this.image_user = image_user;
    }
    
    
    
}
