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
public class Question {
    private int id_question;
    private int id_forum;
    private int id_personnel;
    private String image_question;
    private String text_question;
    private int nbr_like;

    public Question(int id_question, int id_forum, int id_personnel, String image_question, String text_question, int nbr_like) {
        this.id_question = id_question;
        this.id_forum = id_forum;
        this.id_personnel = id_personnel;
        this.image_question = image_question;
        this.text_question = text_question;
        this.nbr_like = nbr_like;
    }

    public Question(int id_forum, int id_personnel, String image_question, String text_question, int nbr_like) {
        this.id_forum = id_forum;
        this.id_personnel = id_personnel;
        this.image_question = image_question;
        this.text_question = text_question;
        this.nbr_like = nbr_like;
    }

    
    
   

    public int getId_forum() {
        return id_forum;
    }

    public int getId_question() {
        return id_question;
    }

    public int getId_personnel() {
        return id_personnel;
    }

    public String getImage_question() {
        return image_question;
    }

    public String getText_question() {
        return text_question;
    }

    public int getNbr_like() {
        return nbr_like;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }

    public void setImage_question(String image_question) {
        this.image_question = image_question;
    }

    public void setText_question(String text_question) {
        this.text_question = text_question;
    }

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    @Override
    public String toString() {
        return "Question{" + "id_forum=" + id_forum + ", id_question=" + id_question + ", id_personnel=" + id_personnel + ", image_question=" + image_question + ", text_question=" + text_question + ", nbr_like=" + nbr_like + '}';
    }
    
    
}
