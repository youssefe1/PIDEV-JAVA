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
public class ResolutionConflit {
    private int id_resolution_conflit;
    private int ide_equipe;
    private int ide_conflit;
    private int ide_sm;
    private String description;
    private int ide_BS;

    public ResolutionConflit(int ide_equipe, int ide_conflit, int ide_sm, String description, int ide_BS) {
        this.ide_equipe = ide_equipe;
        this.ide_conflit = ide_conflit;
        this.ide_sm = ide_sm;
        this.description = description;
        this.ide_BS = ide_BS;
    }

    public int getId_resolution_conflit() {
        return id_resolution_conflit;
    }

    public int getIde_equipe() {
        return ide_equipe;
    }

    public int getIde_conflit() {
        return ide_conflit;
    }

    public int getIde_sm() {
        return ide_sm;
    }

    public String getDescription() {
        return description;
    }

    public int getIde_BS() {
        return ide_BS;
    }

    public void setId_resolution_conflit(int id_resolution_conflit) {
        this.id_resolution_conflit = id_resolution_conflit;
    }

    public void setIde_equipe(int ide_equipe) {
        this.ide_equipe = ide_equipe;
    }

    public void setIde_conflit(int ide_conflit) {
        this.ide_conflit = ide_conflit;
    }

    public void setIde_sm(int ide_sm) {
        this.ide_sm = ide_sm;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIde_BS(int ide_BS) {
        this.ide_BS = ide_BS;
    }

    

   
}
