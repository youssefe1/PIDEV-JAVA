/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Documentation;
import Entities.Reclamation;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceDocumentation {
    
    Connection c = ConnectionDB.getinstance().getCnx();
    
    
    public void ajouterDocumentation(Documentation d){
    
        try {
            PreparedStatement st = c.prepareStatement("insert into documentation(id_documentation,nom_documentation,contenu_documentation,ide_admin) values(?,?,?,?)");
            
            
            st.setInt(1,d.getId_documentation());
            st.setString(2,d.getNom_documentation());
            st.setString(3,d.getContenu_documentation());
            st.setInt(4,d.getIde_admin());
            
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void  afficherDocumentation (){
    
        try {
            PreparedStatement st = c.prepareStatement("select * from  documentation");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                
                System.out.println("Documentation { id_Documentation : " + rs.getInt(1)   + "nom_documentation : " +rs.getString(2)  + " ,contenu_documentation: "+ rs.getString(3)  +"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void modificationDocumentation(int id_doc,String descrip){
        
        try {
            PreparedStatement pt = c.prepareStatement("update  documentation set contenu_documentation = ? where id_documentation = ?");
            pt.setString(1,descrip);
            pt.setInt(2,id_doc);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
   public void supprimerDocumentation(int i){

        try {
            PreparedStatement pt = c.prepareStatement("delete from documentation where id_documentation =?");
            pt.setInt(1,i);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
   
    
}
