/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Documentation;
import Entities.Intervention;
import Services.ServiceDocumentation;
import Services.ServiceIntervention;
import Services.pdfWriter;
import Utils.ConnectionDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InterventionController implements Initializable {
    
    
    @FXML
    private TextField tfId;
     @FXML
    private TextField tfSM;
    @FXML
    private TextField tfDescrip;
    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField tfReclamation;
    
    
     @FXML
    private Button btModifier;
    
    @FXML
    private Button btAjouter;
            
     @FXML
    private Button btSupprimer;
     @FXML
    private Button btPdf;
     
     @FXML
       private TableView<Intervention> table;
      
       @FXML
       private TableColumn<Intervention,Integer> col_id;
       @FXML
       private TableColumn<Intervention,String> col_scrum;
       @FXML
       private TableColumn<Intervention,String> col_descrip;
       @FXML
       private TableColumn<Intervention,String> col_date;
       @FXML
       private TableColumn<Intervention,String> col_reclamation;
       
       ObservableList<Intervention> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
     
      
        @FXML
    private void ajouter(ActionEvent event) {
        
            try{
            int scrum = Integer.parseInt(tfSM.getText());
            String description = tfDescrip.getText();
            int reclamation = Integer.parseInt(tfReclamation.getText());
            String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
           
           ServiceIntervention svr = new ServiceIntervention();
           Intervention i = new Intervention(scrum, reclamation, description, date);
           svr.ajouterIntervention(i);
            
            
    
    }catch(Exception e){
                System.err.println("erreu");
            
            
            }
               
    }
    
    
    @FXML
    public void modifier (ActionEvent event){
        try{
        int id = Integer.parseInt(tfId.getText());
        String dsc = tfDescrip.getText();
        //String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ServiceIntervention srv = new ServiceIntervention();
        srv.modificationIntervention(id,dsc);
          }catch (Exception e){
            System.err.println("ee");
          
          }  
    }
    
    
     @FXML
    private void supprimer(ActionEvent event) {
        
          int idR = Integer.parseInt(tfId.getText());
                ServiceIntervention srv =new ServiceIntervention(); 
                srv.supprimerIntervention(idR);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        try {
            
             Connection c = ConnectionDB.getinstance().getCnx();
             
            ResultSet rs = c.createStatement().executeQuery("select s.Nom,r.sujet_reclamation,i.* from intervention i "
                    + "INNER JOIN reclamation r ON i.ide_reclamation = r.id_reclamation"
                    + " INNER JOIN sm s ON i.ide_sm = s.id");
            
            while (rs.next()){
                oblist.add(new Intervention(rs.getInt("id_intervention"), rs.getString("decription_intervention"), rs.getString("date_intevention"), rs.getString("Nom"), rs.getString("sujet_reclamation")));
            }
            
            
        } catch(SQLException E){
            System.out.println(E);
        }
        
        
         col_id.setCellValueFactory(new PropertyValueFactory<>("id_intervention"));
        col_scrum.setCellValueFactory(new PropertyValueFactory<>("scrum"));
        col_descrip.setCellValueFactory(new PropertyValueFactory<>("decription_intervention"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_intevention"));
        col_reclamation.setCellValueFactory(new PropertyValueFactory<>("nomReclamation"));
        table.setItems(oblist);
    }    
    
    
}
