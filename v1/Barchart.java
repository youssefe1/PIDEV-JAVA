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
    
    public long countNbOfferByCpriority(int id_p,int prio)
    {   long x=0;
        try {
         
            Connection c=ConnexionBD.getinstance().getcnx();
            PreparedStatement pt =c.prepareStatement("SELECT COUNT(*)\n" +
"                    FROM projet P\n" +
"                    INNER JOIN backlog_produit B\n" +
"                    ON p.id_projet=b.ide_projet\n" +
"                    INNER JOIN user_story_backlog_produit u\n" +
"                    ON b.id_backlog_feature=u.ide_backlog_feat\n" +
"                    where   b.ide_projet=? and u.priority_bp=? ");
            pt.setInt(1, id_p);
            pt.setInt(2, prio);
            
            ResultSet res= pt.executeQuery();
            /*  ResultSet rec2=st.executeQuery("SELECT COUNT (*) FROM MATABLE");
            rec2.next();*/
            while(res.next())
            {
                //x=(int)res.getObject(1);
              x=res.getInt(1);
             
                
            }
              
               //System.out.println(x);
        } catch (SQLException ex) {
            Logger.getLogger(Barchart.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
      
        
        return x ;
    }
    


public long avancementsprint(int id_p)//nb sprint 

{long x=0,x1=0;
        try {
         
            Connection c=ConnexionBD.getinstance().getcnx();
            PreparedStatement pt =c.prepareStatement("SELECT COUNT(*) from sprint INNER JOIN backlog_sprint on sprint.id_bs=backlog_sprint.id_bs "
+ "inner join projet on projet.id_projet=backlog_sprint.id_projet where projet.id_projet=?");
    
    pt.setInt(1, id_p);
    
       ResultSet res1= pt.executeQuery();
    while( res1.next())
            {
                //x=(int)res.getObject(1);
             
             x1=res1.getInt(1);
             
             //System.out.print(x1);
             
             
                
            }}
catch (SQLException ex) {
            Logger.getLogger(Barchart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x1;
    
}
public long avancementtache(int id_p)//nb tache done par projet

{long x=0;
        try {
         
            Connection c=ConnexionBD.getinstance().getcnx();
    PreparedStatement pt1 =c.prepareStatement("select count(*) from tache inner join user_story_backlog_sprint on tache.ide_user_story_bs=user_story_backlog_sprint.id_user_story_bs inner join sprint on sprint.id_sprint=user_story_backlog_sprint.id_sprint inner join backlog_sprint on backlog_sprint.id_bs=sprint.id_bs inner join projet"
            + " on backlog_sprint.id_projet=projet.id_projet where projet.id_projet=? and tache.etat='done'");
    
    pt1.setInt(1, id_p);
           
     
       ResultSet res1= pt1.executeQuery();
    while( res1.next())
            {
                //x=(int)res.getObject(1);
              
             x=res1.getInt(1);
                System.out.print(x);
                
            }}
catch (SQLException ex) {
            Logger.getLogger(Barchart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    
}

}
