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
public class Personnel extends User{
    
    private String specialite;
    

    public Personnel(String nom_u, String prenom, String Date_Naissance, int numero_tel, int UID, String email, String address, String user_name, String mot_de_passe, String image_user, String specialite) {
        super(nom_u, prenom, Date_Naissance, numero_tel, UID, email, address, user_name, mot_de_passe, image_user);
        this.specialite = specialite;
        
    }

    public String getSpecialite() {
        return specialite;
    }

   

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   
    
    
    
}
