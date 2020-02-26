/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Asus
 */
/*import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.ConnexionBD;

    

/**
 *
 * @author user
 */
/*public class Pdf {
    //Connection c=ConnexionBD.getinstance().getcnx();
    
    public void pdffile (int id_p){
    
       try{
        
          
        
       String file = "C:\\Users\\Asus\\Desktop\\archive\\doc.pdf";
       Document dc = new Document();
      
        PdfWriter.getInstance(dc, new FileOutputStream(file));
        
        
        dc.open();
        
          Connection c=ConnexionBD.getinstance().getcnx();
           
            PreparedStatement ps = null; 
            ResultSet rs = null ;
            
            String query = ("SELECT user_story_backlog_produit.ide_backlog_feat,backlog_produit.feature ,"
                    + " user_story_backlog_produit.id_user_story_backlog_produit,user_story_backlog_produit.user_story_bp,user_story_backlog_produit.priority_bp "
                    + "FROM user_story_backlog_produit INNER JOIN backlog_produit ON backlog_produit.id_backlog_feature=user_story_backlog_produit.ide_backlog_feat where backlog_produit.ide_projet=? ");
          
            ps = c.prepareStatement(query);
              ps.setInt(1,id_p);
            rs=ps.executeQuery();
            
            while (rs.next()){
            Paragraph para = new Paragraph("num feature:" +rs.getInt(1)+", feature:"+rs.getString(2)+",num user story:"+rs.getInt(3)+" ,userstory:"+rs.getString(4)+" ,priority:"+rs.getInt(5)+ "du projet"+id_p);
            dc.add(para);
            
            }
     
        
        //dc.add(Image.getInstance("C:\\Users\\user\\Desktop\\Document\\010.jpg"));
        
        dc.close();
        
            System.out.println("finished");
        
     
        } catch(Exception e){
            System.err.println(e);
        
        };
     
    
    }
    
}*/
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConnexionBD;


public class Pdf {
     
    private static String FILE = "C:\\Users\\Asus\\Desktop\\archive\\doc.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

   /* public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document,1);//generer pdf selon le projet
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    public static void addMetaData(Document document) {
        document.addTitle("Backlog produit");
        document.addSubject("D'apres le product owner :");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("yasmine");
        document.addCreator("yasmine");
    }

    public static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Backlog produit", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph(
                "This document describes the backlog product of this followinf project ",
                smallBold));

        addEmptyLine(preface, 8);

        preface.add(new Paragraph(
                "the backlog product describes what the client want exactlly from the application",
                redFont));

        document.add(preface);
        // Start a new page
        document.newPage();
    }

    public static void addContent(Document document,int idp) throws DocumentException, SQLException {
        Anchor anchor = new Anchor(" le projet numero "+idp, catFont);
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Backlog du  projet numero"+idp, subFont);
        Section subCatPart = catPart.addSection(subPara);
        /*subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);*/
        subCatPart.add(new Paragraph(""));
        //subCatPart.add(new Paragraph("Paragraph 2"));
        //subCatPart.add(new Paragraph("Paragraph 3"));

        // add a list
        //createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createTable(subCatPart,idp);

        // now add all this to the document
        document.add(catPart);

        // Next section
        //anchor = new Anchor("Second Chapter", catFont);
        //anchor.setName("Second Chapter");

        // Second parameter is the number of the chapter
        /*catPart = new Chapter(new Paragraph(anchor), 1);

        subPara = new Paragraph("Subcategory", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("This is a very important message"));*/

        // now add all this to the document
       // document.add(catPart);

    }

    public static void createTable(Section subCatPart,int idp)
            throws BadElementException, SQLException {
        Connection c=ConnexionBD.getinstance().getcnx();
        PdfPTable table = new PdfPTable(5);

        //t.setBorderColor(BaseColor.BLUE);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("num feature"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("feature "));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("num user story"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
         c1 = new PdfPCell(new Phrase("user story "));
        c1.setVerticalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("priority"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
PreparedStatement pt1 =c.prepareStatement("SELECT user_story_backlog_produit.ide_backlog_feat,backlog_produit.feature ,"
                    + " user_story_backlog_produit.id_user_story_backlog_produit,user_story_backlog_produit.user_story_bp,user_story_backlog_produit.priority_bp "
                    + "FROM user_story_backlog_produit INNER JOIN backlog_produit ON backlog_produit.id_backlog_feature=user_story_backlog_produit.ide_backlog_feat where backlog_produit.ide_projet=? ");
                   pt1.setInt(1,idp);
                     ResultSet rs1= pt1.executeQuery();
                     while(rs1.next())
                     {table.addCell(rs1.getString(1));
        table.addCell(rs1.getString(2));
        table.addCell(rs1.getString(3));
        table.addCell(rs1.getString(4));
        table.addCell(rs1.getString(5));
        

       
                     }
                     subCatPart.add(table);
    }

    /*public static void createList(Section subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }*/

    public static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}




