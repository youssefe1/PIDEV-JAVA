/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Fxml.Afficher_backlog_produitController;
import entities.Backlog_produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import static org.apache.poi.hssf.usermodel.HeaderFooter.tab;
import utils.ConnexionBD;

/**
 *
 * @author Asus
 */
public class Servicebacklog_pd {
    Connection c=ConnexionBD.getinstance().getcnx();

  
    
    public void ajouterbacklog_produit(Backlog_produit b)
    {
   
     try 
        {
      PreparedStatement pt= c.prepareStatement(" insert into backlog_produit (ide_projet,feature)  "
        + " values (?,?)");
     
          
            pt.setInt(1,b.getIde_projet());
            pt.setString(2,b.getFeature());
           
           
            
           
            pt.execute();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(Servicebacklog_pd.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public void afficherbacklog_produit(int id_p)
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from backlog_produit where ide_projet=?");
            pt.setInt(1,id_p);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println(" num feature:"+rs.getInt(1)+" ,feature:"+rs.getString(2)+"du projet num "+id_p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicebacklog_pd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerbacklog_produit(int id)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from backlog_produit where id_backlog_feature=?" );
            pt.setInt(1,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Servicebacklog_pd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierbacklog (int idf,String feature)
    {
        try {
            
            PreparedStatement pt= c.prepareStatement("update backlog_produit set feature=?  where id_backlog_feature=?");
            
            pt.setString(1,feature);
          pt.setInt(2,idf);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    
 public void afficherbacklog(int id_p)
         {try {
           
            PreparedStatement pt1 =c.prepareStatement("SELECT user_story_backlog_produit.ide_backlog_feat,backlog_produit.feature ,"
                    + " user_story_backlog_produit.id_user_story_backlog_produit,user_story_backlog_produit.user_story_bp,user_story_backlog_produit.priority_bp "
                    + "FROM user_story_backlog_produit INNER JOIN backlog_produit ON backlog_produit.id_backlog_feature=user_story_backlog_produit.ide_backlog_feat where backlog_produit.ide_projet=?");
                    pt1.setInt(1,id_p);
                     ResultSet rs1= pt1.executeQuery();
                     
            
                    
            while(rs1.next() )
            {   
                
                System.out.println("backlog produit {  feature:"+rs1.getString(2)+",num user story:"+rs1.getInt(3)+" ,userstory:"+rs1.getString(4)+" ,priority:"+rs1.getInt(5)+ "du projet"+id_p);
             
            }
         }catch (SQLException ex) {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         }
  public List<Backlog_produit> displayAll() throws SQLException {
        //a changer avec id de la session du user connecter
        ArrayList <Backlog_produit> tab = new ArrayList ();
        try{
                 
         PreparedStatement pt =c.prepareStatement("SELECT * from  backlog_produit ");
                    //pt.setInt(1,id_p);
                     ResultSet rs= pt.executeQuery();
         
             
             while(rs.next())
                 
             {
                 Backlog_produit o = new Backlog_produit(rs.getInt(1),rs.getInt(2),rs.getString(3));
                 System.out.println("Affichage "+o);
                 tab.add(o);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(Servicebacklog_pd.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


public int return_id_bp (int id_projet) 
             {
                  Connection c=ConnexionBD.getinstance().getcnx();

    int k=0;
        
        try {
            PreparedStatement pt =c.prepareStatement("select id_backlog_feature from backlog_produit where ide_projet=?");
            pt.setInt(1, id_projet);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               k = rs.getInt(1);
            }
              } catch (SQLException ex) {
            Logger.getLogger(Servicebacklog_pd.class.getName()).log(Level.SEVERE, null, ex);
        }
             return k;
             }
public String chercher1(int num)
{String k="";
   try {
            PreparedStatement pt =c.prepareStatement("select nom_projet from projet where id_projet=?");//condition clé etrtang
            pt.setInt(1, num);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               k = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicebacklog_pd.class.getName()).log(Level.SEVERE, null, ex);
        }
return k;}
 public List<String> parcours()
 {PreparedStatement pt;
 List<String> list=new ArrayList<String>();
            try {
                pt = c.prepareStatement("select * from projet");
                ResultSet rs= pt.executeQuery();
                while(rs.next())
                {
                    list.add(rs.getString(3));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
            }
 return  list;}
 public int id_projet(ComboBox cbp)
{ Connection c=ConnexionBD.getinstance().getcnx();
int k=0;
PreparedStatement pt;
 try {
            pt = c.prepareStatement("select id_projet from projet where nom_projet=?");
            pt.setString(1, (String)cbp.getValue());
            ResultSet rs= pt.executeQuery();
             while(rs.next())
            {
                k=rs.getInt(1);            }
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
        }
return k;
}
 public List<String> parcourspdf() throws SQLException
 {List<String> list=new ArrayList<String>();
  PreparedStatement pt;
 
     
                pt = c.prepareStatement("select * from projet");
                ResultSet rs= pt.executeQuery();
                while(rs.next())
                {
                    list.add(rs.getString(3));
                }
 return list;}
}
