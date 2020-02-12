/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.SprintRetrospective;
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
public class ServicesSprintRetrospective {
    
      private Connection con = ConnectionBD.getInstance().getCnx();
    
    public void ajouterSprintRetrospective( SprintRetrospective spr)
    {
       {
        try 
        {
      PreparedStatement pt= con.prepareStatement(" insert into sprint_retrospective (ide_sprint,ide_equipe,ide_projet,description_TODO)"
        + " values (?,?,?,?)");
      
            pt.setInt(1,spr.getId_sprint());
            pt.setInt(2,spr.getId_equipe());
            pt.setInt(3,spr.getId_projet());
            pt.setString(4,spr.getDescription_todo());
          
           
            
            
            pt.executeUpdate();

      // execute the preparedstatement
      
        } catch (SQLException ex)
        {
            Logger.getLogger(ServicesSprintRetrospective.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    }
    
    
    public void afficherSprintReptrospective()
    {
       try {
            PreparedStatement pt =con.prepareStatement("select * from sprint_retrospective");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("sprint retrospective {id:"+rs.getInt(1)+" ,ide_sprint:"+rs.getInt(2)+" ,ide_equipe:"+rs.getInt(3)+" ,ide_projet:"+rs.getInt(4)+" ,description_todo:"+rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesSprintRetrospective.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifierSprintRetrospective(int id, int ide_sprint , int ide_equipe , int ide_projet ,String description_todo)
    {
       try {
            PreparedStatement pt= con.prepareStatement("update sprint_retrospective set ide_sprint=?,ide_equipe=?,ide_projet=?,description_TODO=? where id_sprint_retrospective=?");
            pt.setInt(1,ide_sprint);
            pt.setInt(2,ide_equipe);
            pt.setInt(3,ide_projet);
            pt.setString(4,description_todo);
            pt.setInt(5, id);
            
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesSprintRetrospective.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerSprintRetrospective(int id_sprint_retrospective)
    {
         try {
            PreparedStatement pt =con.prepareStatement("delete from sprint_retrospective where id_sprint_retrospective=?" );
            pt.setInt(1,id_sprint_retrospective);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicesSprintRetrospective.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
