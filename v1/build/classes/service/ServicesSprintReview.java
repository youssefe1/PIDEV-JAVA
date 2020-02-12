/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.SprintReview;
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
public class ServicesSprintReview {
    
    private Connection con = ConnectionBD.getInstance().getCnx();
    
    
     public void ajouterSprintReview(SprintReview sre)
     {
          {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into sprint_review (ide_sprint,ide_equipe,ide_projet,ide_product_owner,remarque_review_equipe,remarque_review_product_owner)"
        + " values (?, ?, ? ,? , ?, ?)");
      
            pt.setInt(1,sre.getId_sprint());
            pt.setInt(2,sre.getId_equipe());
            pt.setInt(3,sre.getId_projet());
            pt.setInt(4,sre.getId_product_owner());
            pt.setString(5,sre.getRemarque_equipe());
            pt.setString(6,sre.getRemarque_product_owner());
           
            
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesSprintReview.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     }
     
     public void afficherSprintReview()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from sprint_review");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("sprint review {id:"+rs.getInt(1)+" ,ide_sprint:"+rs.getInt(2)+" ,ide_equipe:"+rs.getInt(3)+" ,ide_projet:"+rs.getInt(4)+" ,ide_product_owner:"+rs.getInt(5)+" ,remarque_equipe :"+rs.getString(6)+" ,remarque_product_owner :"+rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesSprintReview.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierSprintReview(int id ,int ide_sprint , int ide_equipe , int ide_projet , int ide_product_owner , String review_equipe , String review_product_owner)
     {
         try {
            PreparedStatement pt= con.prepareStatement("update sprint_review set ide_sprint=?,ide_equipe=?,ide_projet=?,ide_product_owner=?,remarque_review_equipe=?,remarque_review_product_owner=? where id_sprint_review=?");
            pt.setInt(1,ide_sprint);
            pt.setInt(2,ide_equipe);
            pt.setInt(3,ide_projet);
            pt.setInt(4,ide_product_owner);
            pt.setString(5,review_equipe);
            pt.setString(6,review_product_owner);
            pt.setInt(7, id);
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesSprintReview.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerSprintReview(int id_sprint)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from sprint_review where id_sprint_review=?" );
            pt.setInt(1,id_sprint);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesSprintReview.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
