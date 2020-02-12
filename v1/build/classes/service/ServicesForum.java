/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Forum;
import Utils.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youss
 */
public class ServicesForum {
     private Connection con = ConnectionBD.getInstance().getCnx();
    
     
      public void ajouterForum(Forum f)
     {
        {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into forum (ide_projet,ide_equipe)"
        + " values ( ?, ?)");
           
            pt.setInt(1,f.getId_projet());
            pt.setInt(2,f.getId_equipe());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesForum.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

     }
     
     public void afficherForum()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from forum");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Forum {id:"+rs.getInt(1)+" ,ide_projet:"+rs.getInt(2)+" ,ide_equipe:"+rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesForum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     public void modifierForum (int id,int id_projet,int id_equipe)
     {
         try {
            PreparedStatement pt= con.prepareStatement("update forum set ide_projet=? , ide_equipe=?  where id_forum=?");
            pt.setInt(1,id_projet);
            pt.setInt(2,id_equipe);
            pt.setInt(3, id);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesForum.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerForum(int id_forum)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from forum where id_forum=?" );
            pt.setInt(1,id_forum);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesForum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}
