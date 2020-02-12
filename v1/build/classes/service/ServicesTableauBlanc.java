/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.TableauBlanc;
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
public class ServicesTableauBlanc {
     private Connection con = ConnectionBD.getInstance().getCnx();
     
     
         public void ajouterTableauBlanc(TableauBlanc tb)
     {
          {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into tableau_blanc (ide_projet, ide_equipe , ide_sprint)"
        + " values (?, ?, ?)");
    
            pt.setInt(1,tb.getId_projet());
            pt.setInt(2,tb.getId_equipe());
            pt.setInt(3,tb.getId_sprint());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
     }
     
     public void afficherTableauBlanc()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from tableau_blanc");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("tableau_blanc {id:"+rs.getInt(1)+" ,ide_projet:"+rs.getInt(2)+" ,ide_equipe:"+rs.getInt(3)+" ,ide_sprint:"+rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierTableauBlanc(int id,int ide_projet , int ide_equipe , int ide_sprint )
     {
          try {
            PreparedStatement pt= con.prepareStatement("update tableau_blanc set ide_projet=? , ide_equipe=? , ide_sprint=? where id_tableau_blanc=?");
            pt.setInt(1,ide_projet);
            pt.setInt(2,ide_equipe);
            pt.setInt(3,ide_sprint);
            pt.setInt(4, id);

            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerTableauBlanc(int id_tableau_blanc)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from tableau_blanc where id_tableau_blanc=?" );
            pt.setInt(1,id_tableau_blanc);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     }
    
