/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Like;
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
public class ServicesLike {
     private Connection con = ConnectionBD.getInstance().getCnx();
     
     
       public void ajouterLike(Like l)
     {
         {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into like_question (ide_question,like_etat)"
        + " values (?, ?)");
      
            pt.setInt(1,l.getId_question());
            pt.setString(2,l.getLike_etat());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesLike.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
     }
     
     public void afficherLike()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from like_question");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Like {id:"+rs.getInt(1)+" ,id_question:"+rs.getInt(2)+" ,etat_like:"+rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesLike.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierLike(int id , String like_etat)
     {
          try {
            PreparedStatement pt= con.prepareStatement("update like_question set  like_etat=? where id_like=?");
        
  
            pt.setString(1,like_etat);
            pt.setInt(2, id);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesLike.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerLike(int id_like)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from like_question where id_like=?" );
            pt.setInt(1,id_like);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesLike.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
