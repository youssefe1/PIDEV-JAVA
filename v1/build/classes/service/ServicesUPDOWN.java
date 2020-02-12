/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.UPDOWN;
import Utils.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youss
 */
public class ServicesUPDOWN {
     private Connection con = ConnectionBD.getInstance().getCnx();
     
      public void ajouterUPDOWN(UPDOWN ud)
     {
         {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into up_down (ide_personnel,ide_reponse,etat_up_down)"
        + " values (?,?,?)");
      
            pt.setInt(1,ud.getId_reponse());
            pt.setInt(2, ud.getId_reponse());
            pt.setString(3,ud.getEtat_updown());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesUPDOWN.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
     }
     
     public void afficherUPDOWN()
     {
          try {
            PreparedStatement pt =con.prepareStatement("select * from up_down");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("up_down {id:"+rs.getInt(1)+" ,ide_personnel:"+rs.getInt(2)+" ,ide_reponse:"+rs.getInt(3)+",etat up down:"+rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUPDOWN.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierUPDOWN(int id ,String updown)
     {
         try {
            PreparedStatement pt= con.prepareStatement("update up_down set etat_up_down=? where id_up_down=?");
            pt.setString(1,updown);
            pt.setInt(2, id);
   
      
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUPDOWN.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerUPDOWN(int id_up_down)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from up_down where id_up_down=?" );
            pt.setInt(1,id_up_down);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUPDOWN.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     }
    

