/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Intervention;
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
public class ServiceIntervention {
    Connection c = ConnectionDB.getinstance().getCnx();
    
    
    public void ajouterIntervention (Intervention i){
    
        try {
            PreparedStatement st = c.prepareStatement("insert into  intervention  (id_intervention,ide_sm,decription_intervention,date_intevention,ide_reclamation) values(?,?,?,?,?)");
            st.setInt(1,i.getId_intervention());
            st.setInt(2,i.getId_sm());
            st.setString(3,i.getDecription_intervention());
            st.setString(4,i.getDate_intevention());
            st.setInt(5,i.getId_reclamation());

            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void  afficherIntervention (){
    
        try {
            PreparedStatement st = c.prepareStatement("select * from intervention");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                
                System.out.println("Intervention { id_intervention: " + rs.getInt(1)   + "id_sm" +rs.getInt(2)  + " ,decription_intervention: "+ rs.getString(3) + " ,date_intevention: " + rs.getInt(4) + " ,id_reclamation: " + rs.getString(5) +"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void modificationIntervention(int id_intervention,String descrip){
        
        try {
            PreparedStatement pt = c.prepareStatement("update intervention set decription_intervention = ? where id_intervention = ?");
            pt.setString(1,descrip);
            pt.setInt(2,id_intervention);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
   public void supprimerIntervention(int i){

        try {
            PreparedStatement pt = c.prepareStatement("delete from intervention where id_intervention =?");
            pt.setInt(1,i);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
