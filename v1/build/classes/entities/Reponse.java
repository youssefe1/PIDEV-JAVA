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
public class Reponse {
    private int id_reponse;
    private int id_question;
    private int id_personnel;
    private String image_reponse;
    private String text_reponse;
     private int nbr_up;
    private int nbr_down;

    public Reponse(int id_reponse, int id_question, int id_personnel, String image_reponse, String text_reponse, int nbr_up, int nbr_down) {
        this.id_reponse = id_reponse;
        this.id_question = id_question;
        this.id_personnel = id_personnel;
        this.image_reponse = image_reponse;
        this.text_reponse = text_reponse;
        this.nbr_up = nbr_up;
        this.nbr_down = nbr_down;
    }

    public Reponse(int id_question, int id_personnel, String image_reponse, String text_reponse, int nbr_up, int nbr_down) {
        this.id_question = id_question;
        this.id_personnel = id_personnel;
        this.image_reponse = image_reponse;
        this.text_reponse = text_reponse;
        this.nbr_up = nbr_up;
        this.nbr_down = nbr_down;
    }
   
    
    

    public int getId_reponse() {
        return id_reponse;
    }

    public int getId_question() {
        return id_question;
    }

    public int getId_personnel() {
        return id_personnel;
    }

    public String getImage_reponse() {
        return image_reponse;
    }

    public String getText_reponse() {
        return text_reponse;
    }

    public int getNbr_down() {
        return nbr_down;
    }

    public int getNbr_up() {
        return nbr_up;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }

    public void setImage_reponse(String image_reponse) {
        this.image_reponse = image_reponse;
    }

    public void setText_reponse(String text_reponse) {
        this.text_reponse = text_reponse;
    }

    public void setNbr_down(int nbr_down) {
        this.nbr_down = nbr_down;
    }

    public void setNbr_up(int nbr_up) {
        this.nbr_up = nbr_up;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_reponse + ", id_question=" + id_question + ", id_personnel=" + id_personnel + ", image_reponse=" + image_reponse + ", text_reponse=" + text_reponse + ", nbr_down=" + nbr_down + ", nbr_up=" + nbr_up + '}';
    }
    
    
}
