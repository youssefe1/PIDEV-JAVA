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
public class TableauBlanc {
    private int id_tableau;
    private int id_projet;
    private int id_equipe;
    private int id_sprint;

    public TableauBlanc(int id_tableau, int id_projet, int id_equipe, int id_sprint) {
        this.id_tableau = id_tableau;
        this.id_projet = id_projet;
        this.id_equipe = id_equipe;
        this.id_sprint = id_sprint;
    }

    public TableauBlanc(int id_projet, int id_equipe, int id_sprint) {
        this.id_projet = id_projet;
        this.id_equipe = id_equipe;
        this.id_sprint = id_sprint;
    }
    
    

    public int getId_tableau() {
        return id_tableau;
    }

    public int getId_projet() {
        return id_projet;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public int getId_sprint() {
        return id_sprint;
    }

    public void setId_tableau(int id_tableau) {
        this.id_tableau = id_tableau;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setId_sprint(int id_sprint) {
        this.id_sprint = id_sprint;
    }

    @Override
    public String toString() {
        return "TableauBlanc{" + "id_tableau=" + id_tableau + ", id_projet=" + id_projet + ", id_equipe=" + id_equipe + ", id_sprint=" + id_sprint + '}';
    }
    
    
}
