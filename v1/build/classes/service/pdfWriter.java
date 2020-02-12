/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.ConnectionDB;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class pdfWriter {
    Connection c = ConnectionDB.getinstance().getCnx();
    
    public void pdf (){
    
       try{
        
          
        
       String file = "C:\\Users\\user\\Desktop\\Document\\doc.pdf";
       Document dc = new Document();
      
        PdfWriter.getInstance(dc, new FileOutputStream(file));
        
        
        dc.open();
        
          Connection c = ConnectionDB.getinstance().getCnx();
           
            PreparedStatement ps = null; 
            ResultSet rs = null ;
            
            String query = "select a.Nom,d.* from documentation d INNER JOIN admin a ON d.ide_admin = a.id";
            ps = c.prepareStatement(query);
            rs=ps.executeQuery();
            
            while (rs.next()){
            Paragraph para = new Paragraph(rs.getInt("id_documentation") +":"+ " ,Nom doc :"+ rs.getString("nom_documentation") +", Contenu :"+rs.getString("contenu_documentation")+" Admin :"+rs.getString("Nom"));
            dc.add(para);
            
            }
     
        
        //dc.add(Image.getInstance("C:\\Users\\user\\Desktop\\Document\\010.jpg"));
        
        dc.close();
        
            System.out.println("finished");
        
     
        } catch(Exception e){
            System.err.println(e);
        
        };
     
    
    }
    
}
