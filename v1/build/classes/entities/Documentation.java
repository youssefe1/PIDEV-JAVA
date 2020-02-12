/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Documentation {
    
    int id_documentation,ide_admin; 
    String nom_documentation, contenu_documentation; 

    public int getIde_admin() {
        return ide_admin;
    }

    public void setIde_admin(int ide_admin) {
        this.ide_admin = ide_admin;
    }

    public int getId_documentation() {
        return id_documentation;
    }

    public void setId_documentation(int id_documentation) {
        this.id_documentation = id_documentation;
    }

    public String getNom_documentation() {
        return nom_documentation;
    }

    public void setNom_documentation(String nom_documentation) {
        this.nom_documentation = nom_documentation;
    }

    public String getContenu_documentation() {
        return contenu_documentation;
    }

    public void setContenu_documentation(String contenu_documentation) {
        this.contenu_documentation = contenu_documentation;
    }

    public Documentation(int ide_admin, String nom_documentation, String contenu_documentation) {
        this.ide_admin = ide_admin;
        this.nom_documentation = nom_documentation;
        this.contenu_documentation = contenu_documentation;
    }

    
    
    @Override
    public String toString() {
        return "Documentation{" + "id_documentation=" + id_documentation + ", ide_admin=" + ide_admin + ", nom_documentation=" + nom_documentation + ", contenu_documentation=" + contenu_documentation + '}';
    }

    
    
    
    
    
}
