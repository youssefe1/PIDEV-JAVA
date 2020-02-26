/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class Backlog_produit {
    private int id;
     private int ide_projet;
    private String feature;
    private int numusert;
    private String user;
    private int prio;

    public Backlog_produit(int id, String feature, int numusert, String user, int prio) {
        this.id = id;
        this.feature = feature;
        this.numusert = numusert;
        this.user = user;
        this.prio = prio;
    }

    public Backlog_produit(int id, int ide_projet, String feature) {
        this.id = id;
        this.ide_projet = ide_projet;
        this.feature = feature;
    }

    public int getNumusert() {
        return numusert;
    }

    public void setNumusert(int numusert) {
        this.numusert = numusert;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public Backlog_produit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIde_projet() {
        return ide_projet;
    }

    public void setIde_projet(int ide_projet) {
        this.ide_projet = ide_projet;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Backlog_produit(int ide_projet, String feature) {
        
        this.ide_projet = ide_projet;
        this.feature = feature;
    }

   
}
