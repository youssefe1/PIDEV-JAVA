/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yousseff;

import Entities.Absence;
import Entities.TableAbsence;
import Entities.Tableuser;
import Services.ServiceAbsence;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class TestController implements Initializable {

    @FXML
    private TableView<Tableuser> tableview1;
    @FXML
    private TableColumn<Tableuser, Integer> id;
    @FXML
    private TableColumn<Tableuser, String> nom;
    @FXML
    private TableColumn<Tableuser, String> prenom;
    @FXML
    private TableColumn<Tableuser, String> mail;
    
    ObservableList<Tableuser> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<Absence> table2;
    @FXML
    private JFXTextField id_u;
    @FXML
    private JFXTextField nom_u;
    @FXML
    private JFXButton badd;
    @FXML
    private JFXTextField nbra;
    @FXML
    private JFXTextField heuree;
    @FXML
    private JFXDatePicker dattee;
    @FXML
    private TableColumn<Absence, Integer> id_user;
    @FXML
    private TableColumn<Absence, String> nom_user;
    @FXML
    private TableColumn<Absence, String> date_t;
    @FXML
    private TableColumn<Absence, String> heure_t;
    @FXML
    private TableColumn<Absence, String> nbr_t;
    @FXML
    private TableColumn<Absence, Integer> id_t;
    
    ObservableList<Absence> oblist1 = FXCollections.observableArrayList();
    Connection c=ConnexionBD.getinstance().getcnx();
    @FXML
    private JFXButton bedit;
    @FXML
    private JFXDatePicker h;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        try {
           ResultSet rs = c.createStatement().executeQuery("SELECT id, Nom, prenom, E_mail from users");
            
            while(rs.next()){
                oblist.add(new Tableuser(rs.getInt("id"), rs.getString("Nom"), rs.getString("prenom"), rs.getString("E_mail")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<>("E_mail"));
        
        tableview1.setItems(oblist);
        
        try {
            PreparedStatement pt =c.prepareStatement("select id_absence, users.id, users.Nom, date, heure, nbre from absence inner join users on users.id=absence.ide_user");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                oblist1.add(new Absence(rs.getInt("id_absence"), rs.getInt("id"), rs.getString("Nom"), rs.getString("date"), rs.getString("heure"), rs.getInt("nbre")));
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        id_t.setCellValueFactory(new PropertyValueFactory<>("id_Absence"));
        id_user.setCellValueFactory(new PropertyValueFactory<>("ide_user"));
        nom_user.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        date_t.setCellValueFactory(new PropertyValueFactory<>("date"));
        heure_t.setCellValueFactory(new PropertyValueFactory<>("heure"));
        nbr_t.setCellValueFactory(new PropertyValueFactory<>("nbre"));
        table2.setItems(oblist1);       
        
    }    

    @FXML
    private void ADD(ActionEvent event) throws SQLException {
        
        /*int id_user = Integer.valueOf(id_u.getText());
            
            String date = ( dattee.getValue()!= null ? dattee.getValue().toString() : "");
        //String date = datee.getText();
        String heure = heuree.getText();
        int nbr = Integer.valueOf(nbra.getText());
        PreparedStatement pt= c.prepareStatement(" insert into absence (ide_user,date,heure,nbre)"
        + " values (?, ?, ?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setInt(1,id_user);
            pt.setString(2,date);
            pt.setString(3,heure);
            pt.setInt(4,nbr);
            
            pt.execute();
            int i = pt.executeUpdate();
            if(i == 1)
            {
                System.out.println("ajout c'est bon");
            }*/
        
        //String date = datee.getText();
        /*String heure = heuree.getText();
        
            ServiceAbsence sa = new ServiceAbsence();
            Absence a = new Absence(1,"null", heure, 4);
            sa.ajouterabsence(a);*/
        /*Connection c=ConnexionBD.getinstance().getcnx();
        PreparedStatement pt= c.prepareStatement(" insert into absence (ide_user,date,heure,nbre)"
        + " values (?, ?, ?, ?)");*/
         int id_user = Integer.valueOf(id_u.getText());
         String date = ( dattee.getValue()!= null ? dattee.getValue().toString() : "");
         String heure = heuree.getText();
         //String hh = (h.getValue()!= null ? h.getValue().toString() : "");
         
         int nbr = Integer.valueOf(nbra.getText());
        
            
       
        
        ServiceAbsence srva = new ServiceAbsence();
        Absence a = new Absence(id_user,date,heure,nbr);
        srva.ajouterabsence(a);
        refreshTable();
        clearfields();
       
            /*pt.setString(1,id_user);
            pt.setString(2,date);
            pt.setString(3,heure);
            pt.setString(4,nbr);*/
            
            /*int i = pt.executeUpdate();
            if(i == 1)
            {
                System.out.println("ajout c'est bon");
            }*/
        
        
    }
    
    private Tableuser tab;

    @FXML
    private void selectedr(MouseEvent event) {
        
        tab = tableview1.getSelectionModel().getSelectedItem();
        
        if(tab !=null){
            
            id_u.setText(String.valueOf(tab.getId()));
            nom_u.setText(tab.getNom());
            
            
        }
            
            
        
    }

    @FXML
    private void ADD1(MouseEvent event) throws SQLException {
        

    }
    private Absence tab1;
    @FXML
    private void selectedr2(MouseEvent event) {
        
        tab1 = table2.getSelectionModel().getSelectedItem();
        
        if(tab1 !=null){
            
            id_u.setText(String.valueOf(tab1.getIde_user()));
            nom_u.setText(String.valueOf(tab1.getNom()));
            heuree.setText(String.valueOf(tab1.getHeure()));
            nbra.setText(String.valueOf(tab1.getNbre()));
            //nom_u.setText(tab.getNom());
            
            
        }
    }
    
    @FXML
    private void Edit(ActionEvent event) {
        
         /*int id_user = Integer.valueOf(id_u.getText());
        String date = ( dattee.getValue()!= null ? dattee.getValue().toString() : "");
         String heure = heuree.getText();
         int nbr = Integer.valueOf(nbra.getText());
         
         ServiceAbsence srva = new ServiceAbsence();
        Absence a = new Absence(id_user,date,heure,nbr);
        srva.modifierabsence(a.getId_Absence(), id_user, date, heure, nbr);*/
         
         int id_user = Integer.valueOf(id_u.getText());
        String date = ( dattee.getValue()!= null ? dattee.getValue().toString() : "");
         String heure = heuree.getText();
         int nbr = Integer.valueOf(nbra.getText());
         
         try {
            PreparedStatement pt= c.prepareStatement("update absence set ide_user=? , date= ? , heure= ?  , nbre= ? where id_absence=?");
            pt.setInt(1,id_user);
            pt.setString(2,date);
            pt.setString(3,heure);
            pt.setInt(4,nbr);
            pt.setInt(5,tab1.getId_Absence());
            
            pt.executeUpdate();
            int i = pt.executeUpdate();
            if(i == 1)
            {
                System.out.println("modifier c'est bon");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshTable(){
        oblist1.clear();
        try {
            PreparedStatement pt =c.prepareStatement("select id_absence, users.id, users.Nom, date, heure, nbre from absence inner join users on users.id=absence.ide_user");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                oblist1.add(new Absence(rs.getInt("id_absence"), rs.getInt("id"), rs.getString("Nom"), rs.getString("date"), rs.getString("heure"), rs.getInt("nbre")));
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void clearfields(){
        id_u.clear();
        nom_u.clear();
        heuree.clear();
        nbra.clear();
        
        
    }
    
}
