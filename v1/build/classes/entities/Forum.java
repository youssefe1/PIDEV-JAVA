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
public class Forum {
    private int id_forum;
    private int id_projet;
    private int id_equipe;

    public Forum(int id_forum, int id_projet, int id_equipe) {
        this.id_forum = id_forum;
        this.id_projet = id_projet;
        this.id_equipe = id_equipe;
    }
    
    

    public Forum(int id_projet, int id_equipe) {
        this.id_projet = id_projet;
        this.id_equipe = id_equipe;
    }

    public Forum(int id_forum) {
        this.id_forum = id_forum;
    }

    
    
    public int getId_forum() {
        return id_forum;
    }

    public int getId_projet() {
        return id_projet;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    @Override
    public String toString() {
        return "Forum{" + "id_forum=" + id_forum + ", id_projet=" + id_projet + ", id_equipe=" + id_equipe + '}';
    }
    
}
