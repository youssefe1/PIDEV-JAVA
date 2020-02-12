/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.LigneTableauBlanc;
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
public class ServicesLigneTableauBlanc {
     private Connection con = ConnectionBD.getInstance().getCnx();
     
     public void ajouterLigneTableauBlanc(LigneTableauBlanc ltb)
     {
         {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into ligne_tab (ide_tableau_blanc,ide_personnel,nom_tache,etat_tache,date_ajout_ligne)"
        + " values ( ?, ? , ? , ? , ?)");
            
            pt.setInt(1,ltb.getId_TableauBlanc());
            pt.setInt(2,ltb.getId_personnel());
            pt.setString(3,ltb.getNom_tache());
            pt.setString(4,ltb.getEtat_tache());
            pt.setString(5,ltb.getDate_ajout_ligne());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesLigneTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
     }
     
     public void afficherLigneTableauBlanc()
     {
          try {
            PreparedStatement pt =con.prepareStatement("select * from ligne_tab");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Ligne TableaBlanc {id:"+rs.getInt(1)+" ,id_tableau_blanc:"+rs.getInt(2)+" ,id_personnel:"+rs.getInt(3)+" ,nom_tache:"+rs.getString(4)+" ,etat_tache:"+rs.getString(5)+",date_ajout_ligne="+rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesLigneTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierLigneTableauBlanc( int id_personnel , String nom_tache , String etat_tache ,String date_ajout_ligne )
     {
          try {
            PreparedStatement pt= con.prepareStatement("update ligne_tab set ide_personnel=? , nom_tache=? , etat_tache=? , date_ajout_ligne=?");
            
            pt.setInt(1,id_personnel);
            pt.setString(2,nom_tache);
            pt.setString(3,etat_tache);
            pt.setString(4,date_ajout_ligne);
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesLigneTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void supprimerLigneTableauBlanc(int id_ligne_tableau_blanc)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from ligne_tab where id_ligne_tab=?" );
            pt.setInt(1,id_ligne_tableau_blanc);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesLigneTableauBlanc.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
