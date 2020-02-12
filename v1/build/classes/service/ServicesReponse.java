/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reponse;
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
public class ServicesReponse {
     private Connection con = ConnectionBD.getInstance().getCnx();
     
        public void ajouterReponse(Reponse r)
     {
         {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into reponse (ide_question,ide_personnel,image_reponse,text_reponse,nbr_up,nbr_down)"
        + " values (?, ?, ? ,?, ?, ?)");
            
            pt.setInt(1,r.getId_question());
            pt.setInt(2,r.getId_personnel());
            pt.setString(3,r.getImage_reponse());
            pt.setString(4,r.getText_reponse());
            pt.setInt(5,r.getNbr_up());
            pt.setInt(6,r.getNbr_down());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     }
     
     public void afficherReponse()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from reponse");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("reponse {id:"+rs.getInt(1)+" ,ide_question:"+rs.getInt(2)+" ,ide_personnel:"+rs.getInt(3)+" ,image_reponse:"+rs.getString(4)+" ,text_reponse:"+rs.getString(5)+" ,nbr up :"+rs.getInt(6)+" ,nbr down :"+rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierReponse(int id ,String image_reponse , String text_reponse , int nbr_up , int nbr_down)
     {
         try {
            PreparedStatement pt= con.prepareStatement("update reponse set image_reponse=? , text_reponse=? , nbr_up=? , nbr_down=? where id_reponse=?");
            pt.setString(1,image_reponse);
            pt.setString(2,text_reponse);
            pt.setInt(3,nbr_up);
            pt.setInt(4,nbr_down);
            pt.setInt(5, id);
            
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerReponse(int id_reponse)
     {
          try {
            PreparedStatement pt =con.prepareStatement("delete from reponse where id_reponse=?" );
            pt.setInt(1,id_reponse);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
