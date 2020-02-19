/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author user
 */
public class Barchart {
    
    private ConnexionBD connexion;
    private PreparedStatement pst;
    private ResultSet rst;

    public Barchart() {
       
        
    
    }
    
    public long countNbOfferByCpriority(int prio)
    {   long x=0;
        try {
         
            Connection c=ConnexionBD.getinstance().getcnx();
            PreparedStatement pt =c.prepareStatement("SELECT COUNT(*)\n" +
"                    FROM projet P\n" +
"                    INNER JOIN backlog_produit B\n" +
"                    ON p.id_projet=b.ide_projet\n" +
"                    INNER JOIN user_story_backlog_produit u\n" +
"                    ON b.id_backlog_feature=u.ide_backlog_feat\n" +
"                    where  u.priority_bp=?");
            //pt.setInt(1, id_p);
            pt.setInt(1, prio);
            
            ResultSet res= pt.executeQuery();
            /*  ResultSet rec2=st.executeQuery("SELECT COUNT (*) FROM MATABLE");
            rec2.next();*/
            while(res.next())
            {
                // x=(int)res.getObject(1);
              x=res.getInt(1);
             
                
            }
              
               System.out.println(x);
        } catch (SQLException ex) {
            Logger.getLogger(Barchart.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
      
        
        return x ;
    }
    
}

/*PreparedStatement pt =c.prepareStatement("SELECT COUNT(*)\n" +
                    "FROM projet P\n" +
                    "INNER JOIN backlog_produit B\n" +
                    "ON p.id_projet=b.ide_projet\n" +
                    "INNER JOIN user_story_backlog_produit u\n" +
                    "ON b.id_backlog_feature=u.ide_backlog_feat\n" +
                    " and u.priority_bp=?");*/
