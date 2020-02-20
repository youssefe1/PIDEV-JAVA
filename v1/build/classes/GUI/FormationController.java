/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Documentation;
import Entities.Formation;
import Services.ServiceDocumentation;
import Services.ServiceFormation;
import Services.ServiceIntervention;
import Services.pdfWriter;
import Utils.ConnectionDB;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class FormationController implements Initializable {
    
      @FXML
    private JFXTimePicker jfxtimeDebut;
      @FXML
    private JFXTimePicker jfxtimeFin;
      
      @FXML
    private TextField tfId;
     @FXML
    private TextField tfNom;
      @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfPersonne;
    
    @FXML
    private JFXDatePicker datepicker;
    
    
     @FXML
    private Button btModifier;
    
    @FXML
    private Button btAjouter;
            
     @FXML
    private Button btSupprimer;
     
     @FXML
       private TableView<Formation> table;
      
       @FXML
       private TableColumn<Formation,Integer> col_id;
       @FXML
       private TableColumn<Formation,String> col_nom;
       @FXML
       private TableColumn<Formation,String> col_sujet;
       @FXML
       private TableColumn<Formation,String> col_personne;
       
       @FXML
       private TableColumn<Formation,String> col_date;
       
       @FXML
       private TableColumn<Formation,String> col_HDebut;
       
        @FXML
       private TableColumn<Formation,String> col_heureFin;
       
       ObservableList<Formation> oblist = FXCollections.observableArrayList();
      
      
      @FXML
    private void ajouter(ActionEvent event) {
        
            try{
            String dateDebut = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String timeDebut = jfxtimeDebut.getValue().format(DateTimeFormatter.ofPattern("hh:mm"));
            String timeFin = jfxtimeFin.getValue().format(DateTimeFormatter.ofPattern("hh:mm"));
            int idP = Integer.parseInt(tfPersonne.getText());
            String nomP = tfNom.getText();
            String sujet = tfSujet.getText();
            
            ServiceFormation srv = new ServiceFormation(); 
            Formation f = new Formation(idP, nomP, sujet, timeDebut, timeFin, dateDebut);
            srv.ajouterFormation(f);    
    
    }catch(Exception e ){
                System.err.println(e);
            
            
            }
               
    }
    
    @FXML
    public void modifier (ActionEvent event){
        try{
        int id = Integer.parseInt(tfId.getText());
        String dsc = tfSujet.getText();
        //String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ServiceFormation srv = new ServiceFormation();
        srv.modificationFormation(id,dsc);
          }catch (Exception e){
            System.err.println("ee");
          
          }  
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        
          int idR = Integer.parseInt(tfId.getText());
                ServiceFormation srv = new ServiceFormation();
                srv.supprimerFormation(idR);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            
             Connection c = ConnectionDB.getinstance().getCnx();
             
            ResultSet rs = c.createStatement().executeQuery("select * from formation");
            
            while (rs.next()){
                oblist.add(new Formation(rs.getInt("id_formation"),rs.getInt("liste_personne"), rs.getString("nom_formation"), rs.getString("sujet_formation"), rs.getString("time_debut"), rs.getString("time_fin"),rs.getString("Date")));
            }
            
            
        } catch(SQLException E){
            System.out.println("errrr");
        }
    
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_formation"));
        col_sujet.setCellValueFactory(new PropertyValueFactory<>("sujet_formation"));
        col_personne.setCellValueFactory(new PropertyValueFactory<>("id_equipe"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        col_HDebut.setCellValueFactory(new PropertyValueFactory<>("time_debut"));
        col_heureFin.setCellValueFactory(new PropertyValueFactory<>("time_fin"));
        table.setItems(oblist);
    }    
    
}
