/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Fxml.Afficher_backlog_produitController;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entities.Backlog_produit;
import entities.User_storybp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import utils.ConnexionBD;

/**
 *
 * @author Asus
 */
public class Serviceuser_storybp {
    Connection c=ConnexionBD.getinstance().getcnx();
    public void ajouteruserstory(User_storybp u)
    {
   
     try 
        {
      PreparedStatement pt= c.prepareStatement(" insert into  user_story_backlog_produit (ide_backlog_feat, user_story_bp,priority_bp)  "
        + " values (?, ?, ?)");
     
          
            pt.setInt(1,u.getIdbacklog_feat());
            pt.setString(2,u.getUserstory());
            pt.setInt(3,u.getPriority());
            
           
            pt.execute();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public void afficheruserstory(int idfeat)
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from user_story_backlog_produit where 	ide_backlog_feat=?");
             pt.setInt(1,idfeat);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {    
                System.out.println("user story {num :"+rs.getInt(1)+" ,usr story:"+rs.getString(3)+"priority "+rs.getInt(4)+" du feature num"+idfeat);
               
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void modifieruserstory (int id,int idf,String user,int priority)//a revoir
    {
        try {
            
            PreparedStatement pt= c.prepareStatement("update  user_story_backlog_produit set ide_backlog_feat=?,user_story_bp=? , priority_bp= ?  where id_user_story_backlog_produit=?");
        
            

            pt.setInt(1,idf);
            pt.setString(2,user);
            pt.setInt(3,priority);
            pt.setInt(4,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }}
     /*public void modifieruserstory (int id,String user,int priority)//a revoir
    {
        try {
            
            PreparedStatement pt= c.prepareStatement("update  user_story_backlog_produit set user_story_bp=? , priority_bp= ?  where id_user_story_backlog_produit=?");
        
            

           // pt.setInt(1,idbf);
            pt.setString(1,user);
            pt.setInt(2,priority);
            pt.setInt(3,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }}*/
     
         public void supprimeruserstory(int id)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from user_story_backlog_produit where id_user_story_backlog_produit=?" );
            pt.setInt(1,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public List<User_storybp> displayAll() throws SQLException {
        //a changer avec id de la session du user connecter
        ArrayList <User_storybp> tab = new ArrayList ();
        try{
                 
         PreparedStatement pt =c.prepareStatement("SELECT * from  user_story_backlog_produit ");
                    //pt.setInt(1,id_p);
                     ResultSet rs= pt.executeQuery();
         
             
             while(rs.next())
                 
             {
                 User_storybp o = new User_storybp(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                 System.out.println("Affichage "+o);
                 tab.add(o);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(Serviceuser_storybp.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         public int return_id_feat (int id_bf) 
             {
                  Connection c=ConnexionBD.getinstance().getcnx();

    int k=0;
        
        try {
            PreparedStatement pt =c.prepareStatement("select 	id_user_story_backlog_produit from  user_story_backlog_produit where ide_backlog_feat=?");
            pt.setInt(1, id_bf);
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

public String chercher(int num)
{String k="";
    try {
            PreparedStatement pt =c.prepareStatement("select feature from backlog_produit where id_backlog_feature=?");//condition clé etrtang
            pt.setInt(1, num);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               k = rs.getString(1);
               System.out.println(k);
            }
        } catch (SQLException ex) {
         
            Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
        }
return k;}
public List<String> parcours1()
 {PreparedStatement pt;
 List<String> list=new ArrayList<String>();
             try {
                pt = c.prepareStatement("select * from backlog_produit");
                ResultSet rs1= pt.executeQuery();
                while(rs1.next())
                {
                    list.add(rs1.getString(3));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
            }
 return  list;}
 public int id_bf(ComboBox cbfeat)
{ Connection c=ConnexionBD.getinstance().getcnx();
int k=0;
PreparedStatement pt;
 try {
            pt = c.prepareStatement("select id_backlog_feature from backlog_produit where feature=?");
            pt.setString(1, (String)cbfeat.getValue());
            ResultSet rs= pt.executeQuery();
             while(rs.next())
            {
                k=rs.getInt(1);            }
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
        }
return k;
}
}

        
        

