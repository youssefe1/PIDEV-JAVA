/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Utils.ConnectionBD;
import java.sql.Connection;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dr-Eagle
 */
public class PDFconvert {
    private Connection con = ConnectionBD.getInstance().getCnx();
    
    
     public void pdf (){
    
       try{
        
          
        
         String file = "C:\\Users\\Dr-Eagle\\Desktop\\doc.pdf";
       Document dc = new Document();
      
        PdfWriter.getInstance(dc, new FileOutputStream(file));
        
        
        dc.open();
        
       
          
            PreparedStatement pt =con.prepareStatement("select * from ligne_tab");
            ResultSet rs= pt.executeQuery();
       
            
            while (rs.next()){
               
            Paragraph para = new Paragraph(rs.getInt("id_ligne_tab") +"   "+ "ide_tableau_blanc :"+ rs.getInt("ide_tableau_blanc") +"  ide_personnel :"+ rs.getInt("ide_personnel")+", Nom Tache :"+rs.getString("nom_tache")+"  "+rs.getString("etat_tache")+"date_ajout_tache  "+ rs.getString("date_ajout_ligne"));
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
