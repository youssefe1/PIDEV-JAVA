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
public class Like {
    private int id_like;
    private int id_question;
    private String like_etat;

    public Like(int id_like, int id_question, String like_etat) {
        this.id_like = id_like;
        this.id_question = id_question;
        this.like_etat = like_etat;
    }

    public Like(int id_question, String like_etat) {
        this.id_question = id_question;
        this.like_etat = like_etat;
    }

    public int getId_like() {
        return id_like;
    }

    public int getId_question() {
        return id_question;
    }

    public String getLike_etat() {
        return like_etat;
    }

    public void setId_like(int id_like) {
        this.id_like = id_like;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setLike_etat(String like_etat) {
        this.like_etat = like_etat;
    }

    @Override
    public String toString() {
        return "Like{" + "id_like=" + id_like + ", id_question=" + id_question + ", like_etat=" + like_etat + '}';
    }

    

    
    
}
