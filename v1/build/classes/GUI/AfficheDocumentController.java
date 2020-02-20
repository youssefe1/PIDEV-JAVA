/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Documentation;
import Services.ServiceDocumentation;
import Services.ServiceReclamation;
import Services.pdfWriter;
import Utils.ConnectionDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficheDocumentController implements Initializable {
    
        
    @FXML
    private TextField tfId;
     @FXML
    private TextField tfNom;
    @FXML
    private TextField tfContenu;
    @FXML
    private TextField tfAdmin;
    
     @FXML
    private Button btModifier;
    
    @FXML
    private Button btAjouter;
            
     @FXML
    private Button btSupprimer;
     @FXML
    private Button btPdf;
    

      @FXML
       private TableView<Documentation> table;
      
       @FXML
       private TableColumn<Documentation,Integer> col_id;
       @FXML
       private TableColumn<Documentation,String> col_nom;
       @FXML
       private TableColumn<Documentation,String> col_contenu;
       @FXML
       private TableColumn<Documentation,String> col_admin;
       
       ObservableList<Documentation> oblist = FXCollections.observableArrayList();
      
    /**
     * 
     * Initializes the controller class.
     */
       
        @FXML
    private void ajouter(ActionEvent event) {
        
            try{
            int idP = Integer.parseInt(tfAdmin.getText());
            String nomP = tfNom.getText();
            String contenu = tfContenu.getText();
            ServiceDocumentation srd = new ServiceDocumentation(); 
            Documentation d = new Documentation(idP, nomP, contenu);
            srd.ajouterDocumentation(d); 
            
            pdfWriter pdf = new pdfWriter();
            pdf.pdf();
            
    
    }catch(Exception e){
                System.err.println("erreu");
            
            
            }
               
    }
       
            @FXML
    public void modifier (ActionEvent event){
        try {
            int idP = Integer.parseInt(tfId.getText());
            String contenu = tfContenu.getText();
            ServiceDocumentation srd = new ServiceDocumentation();
            srd.modificationDocumentation(idP, contenu);
            
            
            Parent root = FXMLLoader
                    .load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficheDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     @FXML
    private void supprimer(ActionEvent event) {
        
          int idR = Integer.parseInt(tfId.getText());
                ServiceDocumentation srv = new ServiceDocumentation();
                srv.supprimerDocumentation(idR);
    }
    
     @FXML
    private void pdf(ActionEvent event) {
        
          pdfWriter pdf = new pdfWriter();
            pdf.pdf();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        try {
            
             Connection c = ConnectionDB.getinstance().getCnx();
             
            ResultSet rs = c.createStatement().executeQuery("select a.Nom,d.* from documentation d INNER JOIN admin a ON d.ide_admin = a.id");
            
            while (rs.next()){
                oblist.add(new Documentation(rs.getInt("id_documentation"), rs.getString("nom_documentation"), rs.getString("contenu_documentation"), rs.getString("Nom")));
            }
            
            
        } catch(SQLException E){
            System.out.println("errrr");
        }
    
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_documentation"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_documentation"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu_documentation"));
        col_admin.setCellValueFactory(new PropertyValueFactory<>("NomRes"));
        table.setItems(oblist);
       
    }

  

    
    
    
    
    
    
}
