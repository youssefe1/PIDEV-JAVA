/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.DailyMeeting;
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
public class ServicesDailyMeeting {
     private Connection con = ConnectionBD.getInstance().getCnx();
    
     public void ajouterDailyMeeting(DailyMeeting dm)
     {
          {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into daily_meeting (heure,duree,ide_equipe,remarque)"
        + " values (?, ?, ?, ?)");
            
            pt.setString(1,dm.getHeure());
            pt.setInt(2,dm.getDuree());
            pt.setInt(3,dm.getId_equipe());
            pt.setString(4,dm.getRemarque());
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesDailyMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
         
     }
     
     public void afficherDailyMeeting()
     {
         try {
            PreparedStatement pt =con.prepareStatement("select * from daily_meeting");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Daily Meeting {id:"+rs.getInt(1)+" ,heure:"+rs.getString(2)+" ,duree:"+rs.getInt(3)+",equipe:"+rs.getInt(4)+",remarque:"+rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDailyMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void modifierDailyMeeting(int id,String heure , int duree , int id_equipe ,String remarque )
     {
          try {
            PreparedStatement pt= con.prepareStatement("update daily_meeting set heure=? , duree=? , ide_equipe=? , remarque=? where id_daily_meeting =?");
            pt.setString(1,heure);
            pt.setInt(2,duree);
            pt.setInt(3,id_equipe);
            pt.setString(4,remarque);
            pt.setInt(5, id);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDailyMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     public void supprimerDailyMeeting(int id_daily_meeting)
     {
         try {
            PreparedStatement pt =con.prepareStatement("delete from daily_meeting where id_daily_meeting=?" );
            pt.setInt(1,id_daily_meeting);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesDailyMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
