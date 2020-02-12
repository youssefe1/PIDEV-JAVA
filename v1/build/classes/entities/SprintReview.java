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
public class SprintReview {
    
    private int id_sprintreview;
    private int id_sprint;
    private int id_equipe;
    private int id_projet;
    private int id_product_owner;
    private String remarque_equipe;
    private String remarque_product_owner;

    public SprintReview(int id_sprintreview, int id_sprint, int id_equipe, int id_projet, int id_product_owner, String remarque_equipe, String remarque_product_owner) {
        this.id_sprintreview = id_sprintreview;
        this.id_sprint = id_sprint;
        this.id_equipe = id_equipe;
        this.id_projet = id_projet;
        this.id_product_owner = id_product_owner;
        this.remarque_equipe = remarque_equipe;
        this.remarque_product_owner = remarque_product_owner;
    }

    public SprintReview(int id_sprint, int id_equipe, int id_projet, int id_product_owner, String remarque_equipe, String remarque_product_owner) {
        this.id_sprint = id_sprint;
        this.id_equipe = id_equipe;
        this.id_projet = id_projet;
        this.id_product_owner = id_product_owner;
        this.remarque_equipe = remarque_equipe;
        this.remarque_product_owner = remarque_product_owner;
    }
    
    
    

    

    public int getId_sprintreview() {
        return id_sprintreview;
    }

    public int getId_sprint() {
        return id_sprint;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public int getId_product_owner() {
        return id_product_owner;
    }

    public int getId_projet() {
        return id_projet;
    }

    public String getRemarque_equipe() {
        return remarque_equipe;
    }

    public String getRemarque_product_owner() {
        return remarque_product_owner;
    }

    public void setId_sprintreview(int id_sprintreview) {
        this.id_sprintreview = id_sprintreview;
    }

    public void setId_sprint(int id_sprint) {
        this.id_sprint = id_sprint;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setId_product_owner(int id_product_owner) {
        this.id_product_owner = id_product_owner;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public void setRemarque_equipe(String remarque_equipe) {
        this.remarque_equipe = remarque_equipe;
    }

    public void setRemarque_product_owner(String remarque_product_owner) {
        this.remarque_product_owner = remarque_product_owner;
    }

    @Override
    public String toString() {
        return "SprintReview{" + "id_sprintreview=" + id_sprintreview + ", id_sprint=" + id_sprint + ", id_equipe=" + id_equipe + ", id_product_owner=" + id_product_owner + ", id_projet=" + id_projet + ", remarque_equipe=" + remarque_equipe + ", remarque_product_owner=" + remarque_product_owner + '}';
    }

   
    
}
