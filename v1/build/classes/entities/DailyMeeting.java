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
public class DailyMeeting {
    private int id_daily_meeting;
    private String heure;
    private int duree;
    private int id_equipe;
    private String remarque;

    public DailyMeeting(int id_daily_meeting, String heure, int duree, int id_equipe, String remarque) {
        this.id_daily_meeting = id_daily_meeting;
        this.heure = heure;
        this.duree = duree;
        this.id_equipe = id_equipe;
        this.remarque = remarque;
    }

    public DailyMeeting(String heure, int duree, int id_equipe, String remarque) {
        this.heure = heure;
        this.duree = duree;
        this.id_equipe = id_equipe;
        this.remarque = remarque;
    }

    public int getId_daily_meeting() {
        return id_daily_meeting;
    }

    public String getHeure() {
        return heure;
    }

    public int getDuree() {
        return duree;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setId_daily_meeting(int id_daily_meeting) {
        this.id_daily_meeting = id_daily_meeting;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @Override
    public String toString() {
        return "DailyMeeting{" + "id_daily_meeting=" + id_daily_meeting + ", heure=" + heure + ", duree=" + duree + ", id_equipe=" + id_equipe + ", remarque=" + remarque + '}';
    }

     
    
}
