/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Formation;
import Entities.Reclamation;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceFormation {
    Connection c = ConnectionDB.getinstance().getCnx();
    
    
    public void ajouterFormation(Formation f){
    
        try {
            PreparedStatement st = c.prepareStatement("insert into formation(id_formation,sujet_formation,ide_personne,date_time_debut,date_time_fin,nom_formation) values(?,?,?,?,?,?)");
            st.setInt(1,f.getId_formation());
            st.setString(2,f.getSujet_formation());
            st.setInt(3,f.getId_equipe());
            st.setString(4,f.getDate_time_debut());
            st.setString(5,f.getDate_time_fin());
            st.setString(6,f.getNom_formation());
            
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void  afficherFormation (){
    
        try {
            PreparedStatement st = c.prepareStatement("select * from formation");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                
                System.out.println("Formation { id_formation: " + rs.getInt(1)   + "sujet_formation" +rs.getString(2)  + " ,id_equipe "+ rs.getInt(3) + " ,date_time_debut: " + rs.getString(4) + " ,date_time_fin: " + rs.getString(5) +" ,nom_formation: " + rs.getString(6)+"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void modificationFormation(int id_for,String sujet){
        
        try {
            PreparedStatement pt = c.prepareStatement("update  formation set sujet_formation = ? where id_formation = ?");
            pt.setString(1,sujet);
            pt.setInt(2,id_for);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
   public void supprimerFormation(int i){

        try {
            PreparedStatement pt = c.prepareStatement("delete from formation where id_formation =?");
            pt.setInt(1,i);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
   
  public void modifiertache_liste (int id_tache,String liste_Personnel)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update formation set liste_Personne=? where id_formation=?");
            pt.setString(1,liste_Personnel);
            pt.setInt(2,id_tache);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public void liste()
       {
           String liste="";
     
             int var=0;
        try {
            PreparedStatement pt =c.prepareStatement("select * from personnel");
            ResultSet rs= pt.executeQuery();
            PreparedStatement pt1 =c.prepareStatement("select count(*) from personnel");
            ResultSet rs1= pt1.executeQuery();
            while(rs1.next()){
            var=rs1.getInt(1);
            }
           
            for (int i=0;i<var;i++)
            {
                while(rs.next())
            {
                if (liste.equals(""))
                liste=liste+rs.getInt(1);
                else {
                    liste=liste+","+rs.getInt(1);
                }
            }
            }
            }
            
         catch (SQLException ex) {
            Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
           //modifiertache_liste(6, liste);
           System.out.println(liste);
    }
    
    
       
       public void afficher_perso_par_id(int id_perso)
       {
               try {
            PreparedStatement pt =c.prepareStatement("select * from personnel where id_personnel=?");
            pt.setInt(1,id_perso);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Tache {id:"+rs.getInt(1)+" ,id_sprint:"+rs.getString(2)+" ,nom_tache:"+rs.getString(3)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
   
   
    
}
