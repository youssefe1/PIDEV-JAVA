/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reclamation;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceReclamation {
    
    Connection c = ConnectionDB.getinstance().getCnx();
    
    
    public void ajouterReclamation (Reclamation r){
    
        try {
            PreparedStatement st = c.prepareStatement("insert into reclamation(ide_personnel,sujet_reclamation,etat_reclamation,description_reclamation) values(?,?,?,?)");
            st.setInt(1,r.getId_personnel());
            st.setString(2,r.getSujet_reclamation());
            st.setInt(3,r.getEtat_reclamation());
            st.setString(4,r.getDescription_reclamation());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void  afficher (){
    
        try {
            PreparedStatement st = c.prepareStatement("select * from reclamation");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                
                System.out.println("Reclamation { id_reclamation : " + rs.getInt(1)   + "id_personnel" +rs.getInt(2)  + " ,Sujet: "+ rs.getString(3) + " ,Etat: " + rs.getInt(4) + " ,Description: " + rs.getString(5) +"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void modification(int id_req,String descrip){
        
        try {
            PreparedStatement pt = c.prepareStatement("update reclamation set description_reclamation = ? where id_reclamation = ?");
            pt.setString(1,descrip);
            pt.setInt(2,id_req);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
   public void supprimer(int i){

        try {
            PreparedStatement pt = c.prepareStatement("delete from reclamation where id_reclamation =?");
            pt.setInt(1,i);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
   
   
  
}
