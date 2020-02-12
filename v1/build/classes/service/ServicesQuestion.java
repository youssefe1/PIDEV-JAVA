/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Question;
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
public class ServicesQuestion {
     private Connection con = ConnectionBD.getInstance().getCnx();
     
     
       public void ajouterQuestion(Question q)
     {
          {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into question (ide_forum,ide_personnel,image_question,text_question,nbr_like)"
        + " values ( ?, ? , ?, ?, ?)");
  
            pt.setInt(1,q.getId_forum());
            pt.setInt(2,q.getId_personnel());
            pt.setString(3,q.getImage_question());
            pt.setString(4,q.getText_question());
            pt.setInt(5,q.getNbr_like());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
     }
     
     public void afficherQuestion()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from question");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Question {id:"+rs.getInt(1)+" ,id_forum:"+rs.getInt(2)+" ,id_personnel:"+rs.getInt(3)+" ,image:"+rs.getString(4)+" ,text:"+rs.getString(5)+" ,nbr like :"+rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierQuestion(int id , int id_personnel , String image_question , String text_question, int nbr_like)
     {
          try {
            PreparedStatement pt= con.prepareStatement("update question set  ide_personnel=? , image_question=? , text_question=? , nbr_like=? where id_question=?");
            
            pt.setInt(1,id_personnel);
            pt.setString(2,image_question);
            pt.setString(3,text_question);
            pt.setInt(4,nbr_like);
            pt.setInt(5, id);
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerQuestion(int id_question)
     {
          try {
            PreparedStatement pt =con.prepareStatement("delete from question where id_question=?" );
            pt.setInt(1,id_question);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
