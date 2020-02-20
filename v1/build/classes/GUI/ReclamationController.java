/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Documentation;
import Entities.Reclamation;
import Services.Notif;
import Services.SendMail;
import Services.ServiceDocumentation;
import Services.ServiceReclamation;
import Services.pdfWriter;
import Utils.ConnectionDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReclamationController implements Initializable {
            
    @FXML
    private TextField tfId;
     @FXML
    private TextField tfPersonnel;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;
    
   @FXML
    private TextField tfEtat;
     @FXML
    private Button btModifier;
    
    @FXML
    private Button btAjouter;
            
     @FXML
    private Button btSupprimer;
    
    @FXML
       private TableView<Reclamation> table;
      
       @FXML
       private TableColumn<Reclamation,Integer> col_id;
       @FXML
       private TableColumn<Reclamation,String> col_personne;
       @FXML
       private TableColumn<Reclamation,String> col_sujet;
       @FXML
       private TableColumn<Reclamation,String> col_descrip;
       @FXML
       private TableColumn<Reclamation,Integer> col_etat;
       
       
       ObservableList<Reclamation> oblist = FXCollections.observableArrayList();
       
           
        @FXML
    private void ajouter(ActionEvent event) {
        
            try{
            int idP = Integer.parseInt(tfPersonnel.getText());
            String sujet = tfSujet.getText();
            String descrip = tfDescription.getText();
            int etat = Integer.parseInt(tfEtat.getText());
            Reclamation rc = new Reclamation(idP, sujet, etat, descrip);
            ServiceReclamation srv = new ServiceReclamation(); 
            srv.ajouterReclamation(rc);
            
            Notif n = new Notif(); 
            n.notif();
            
            SendMail mail = new SendMail(); 
            mail.mail();
    
    }catch(Exception e){
                System.err.println("erreu");
            
            
            }
               
    }
        
        @FXML
    private void modifier(ActionEvent event) {
        
            try{
            int idP = Integer.parseInt(tfId.getText());
            String sujet = tfSujet.getText();
            String descrip = tfDescription.getText();
            ServiceReclamation srv = new ServiceReclamation(); 
            srv.modification(idP,descrip);
            
            

            
    
    }catch(Exception e){
                System.err.println("erreu");
            
            
            }
               
    }
       
    
    
         
        @FXML
    private void supprimer(ActionEvent event) {
        
            try{
            int idP = Integer.parseInt(tfId.getText());
            ServiceReclamation srv = new ServiceReclamation(); 
            srv.supprimer(idP);
            
            

            
    
    }catch(Exception e){
                System.err.println(e);
            
            
            }
               
    }
       
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            
            Connection c = ConnectionDB.getinstance().getCnx();
            
            ResultSet rs = c.createStatement().executeQuery("select p.Nom,r.* from reclamation r INNER JOIN personnel p ON r.ide_personnel= p.id_Personnel");
            
            while (rs.next()){
                oblist.add(new Reclamation(rs.getInt("etat_reclamation"), rs.getInt("id_reclamation"), rs.getString("sujet_reclamation"), rs.getString("description_reclamation"), rs.getString("Nom")));
            }
          
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_reclamation"));
            col_personne.setCellValueFactory(new PropertyValueFactory<>("Nom_personnel"));
            col_sujet.setCellValueFactory(new PropertyValueFactory<>("sujet_reclamation"));
            col_descrip.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
            col_etat.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
            table.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
