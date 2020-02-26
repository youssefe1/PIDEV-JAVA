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
public class User_storybp {
    private int id;
       private int idbacklog_feat;
       private String userstory;
       private int priority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdbacklog_feat() {
        return idbacklog_feat;
    }

    public void setIdbacklog_feat(int idbacklog_feat) {
        this.idbacklog_feat = idbacklog_feat;
    }

    public String getUserstory() {
        return userstory;
    }

    public void setUserstory(String userstory) {
        this.userstory = userstory;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public User_storybp(int idbacklog_feat, String userstory, int priority) {
        
        this.idbacklog_feat = idbacklog_feat;
        this.userstory = userstory;
        this.priority = priority;
    }

    public User_storybp(int id, int idbacklog_feat, String userstory, int priority) {
        this.id = id;
        this.idbacklog_feat = idbacklog_feat;
        this.userstory = userstory;
        this.priority = priority;
    }

   
    
    
}
