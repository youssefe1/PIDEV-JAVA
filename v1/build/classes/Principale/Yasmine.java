/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasmine;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Section;
import entities.Backlog_produit;

import entities.User_storybp;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import services.Pdf;
import services.Barchart;
import services.Servicebacklog_pd;

import services.Serviceuser_storybp;
import services.Sound;
/**
 *
 * @author Asus
 */
public class Yasmine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try
        { 
            
            int i=0;
            
            Sound audioPlayer =  
                           new Sound(); 
            
              
            
            
            Scanner sc = new Scanner(System.in); 
              
            while (true) 
            { 
                System.out.println("1. pause"); 
                System.out.println("2. resume"); 
                System.out.println("3. restart"); 
                System.out.println("4. stop"); 
                System.out.println("5. Jump to specific time"); 
                int c = sc.nextInt(); 
                audioPlayer.gotoChoice(c); 
                if (c == 4) 
                break; 
            } 
            sc.close(); 
        }  
          
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
          }
       
      
        User_storybp u1=new User_storybp(1,"yasmine",1);
             User_storybp u2=new User_storybp(28,"yasmine",5);
        Serviceuser_storybp userstory =new Serviceuser_storybp();
      // userstory.ajouteruserstory(u2);
       //userstory.modifieruserstory(16,25,"jj",5);
       //userstory.supprimeruserstory(16);
       userstory.afficheruserstory();
       ///////////////////////////////////////
       /*Features f=new Features(12,"12.1");
       Servicefeatures feat=new Servicefeatures();
      feat.ajouterfeature(f);
       feat.afficherfeatures();
      feat.supprimerfeatures(25);
      feat.modifierfeatures( 25,12, "aaaa");
       //////////////////////////////////////
       Backlog_produit b=new Backlog_produit("eeeee");
        Servicebacklog_pd b1 =new Servicebacklog_pd();
       /* b1.ajouterbacklog_produit(b);
        b1.afficherbacklog_produit();
        b1.modifierfeatures(1, "iste");
        b1.supprimerbacklog_produit(1);
        b1.afficheravancement(12,1 );
         //new Convetir().export();
    }*/
     try
        { 
            
            int i=0;
            
            Yasmine menue =  
                           new Yasmine(); 
            
              
            
            Scanner sc = new Scanner(System.in); 
              
            while (true) 
            { 
                System.out.println("1. ajouter"); 
                System.out.println("2. modifier"); 
                System.out.println("3. afficher"); 
                System.out.println("4. supprimer"); 
                System.out.println("5. exel"); 
                 System.out.println("6. pdf"); 
                 System.out.println("7. quitter"); 
                int c = sc.nextInt(); 
                menue.gotoChoice(c); 
                if (c == 7) 
                break; 
            } 
            sc.close(); 
        }  
          
        catch (Exception ex)  
        { 
            System.out.println("Error "); 
            ex.printStackTrace(); 
          
          } 
    } 
      
    // Work as the user enters his choice 
      
    public void gotoChoice(int c) 
            throws IOException, LineUnavailableException, UnsupportedAudioFileException  
    {   try {
        Sound audioPlayer =
                new Sound();
        Serviceuser_storybp userstory =new Serviceuser_storybp();
        User_storybp u1=new User_storybp(34,"en tant",2);
        User_storybp u2=new User_storybp(34,"en tant",5);
        User_storybp u3=new User_storybp(34,"en tant",5);
        
        
        Backlog_produit b=new Backlog_produit(1,"acces systeme");
        Servicebacklog_pd b1 =new Servicebacklog_pd();
        
        switch (c)
        {
            case 1: 
                
                
                audioPlayer.play();
                //b1.ajouterbacklog_produit(b);
                
                //feat.ajouterfeature(f);
                
                //feat.ajouterfeature(f1);
                userstory.ajouteruserstory(u1);
                userstory.ajouteruserstory(u2);
                userstory.ajouteruserstory(u3);
                
                
                break;
            case 2:
                
                audioPlayer.play();
                
                //userstory.modifieruserstory(51,34,"jj",5);
                //feat.modifierfeatures( 41,29, "47,49");
                // feat.modifierfeature_liste(23, "1,2,3");//id feature
                //b1.modifierbacklog(1,34,"loginplm");
                
                
                break;
            case 3:
                audioPlayer.play();
                
                //b1.afficherbacklog(1);
                ///userstory.afficheruserstory(34);
                //b1.afficherbacklog_produit(1);
                Barchart h=new Barchart();
                //h.countuserstoryBypriority(1,5);
                
                
                
                
                
                break;
            case 4:
                audioPlayer.play();
                //b1.supprimerbacklog_produit(33);
                //feat.supprimerfeatures(38);
                userstory.supprimeruserstory(51);
                
                
                
                break;
            case 5:
                audioPlayer.play(); 
                //Exel e=new Exel();
                
                //e.convertir(1);
                break;
                
            case 6:
                audioPlayer.play();
                Pdf p=new Pdf();
                Section subCatPart = null;
                p.createTable(subCatPart,1);
                break;
        } 
        } catch (BadElementException ex) {
            Logger.getLogger(Yasmine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Yasmine.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    } 
}
