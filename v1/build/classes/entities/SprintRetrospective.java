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
public class SprintRetrospective {
    
    private int id_sprintretrospective;
    private int id_sprint;
    private int id_equipe;
    private int id_projet;
    private String description_todo;

    public SprintRetrospective(int id_sprintretrospective, int id_sprint, int id_equipe, int id_projet, String description_todo) {
        this.id_sprintretrospective = id_sprintretrospective;
        this.id_sprint = id_sprint;
        this.id_equipe = id_equipe;
        this.id_projet = id_projet;
        this.description_todo = description_todo;
    }

    public SprintRetrospective(int id_sprint, int id_equipe, int id_projet, String description_todo) {
        this.id_sprint = id_sprint;
        this.id_equipe = id_equipe;
        this.id_projet = id_projet;
        this.description_todo = description_todo;
    }
    
    

    public int getId_sprintretrospective() {
        return id_sprintretrospective;
    }

    public int getId_sprint() {
        return id_sprint;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public int getId_projet() {
        return id_projet;
    }

    public String getDescription_todo() {
        return description_todo;
    }

    public void setId_sprintretrospective(int id_sprintretrospective) {
        this.id_sprintretrospective = id_sprintretrospective;
    }

    public void setId_sprint(int id_sprint) {
        this.id_sprint = id_sprint;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public void setDescription_todo(String description_todo) {
        this.description_todo = description_todo;
    }

    @Override
    public String toString() {
        return "SprintRetrospective{" + "id_sprintretrospective=" + id_sprintretrospective + ", id_sprint=" + id_sprint + ", id_equipe=" + id_equipe + ", id_projet=" + id_projet + ", description_todo=" + description_todo + '}';
    }
    
    
    
}
