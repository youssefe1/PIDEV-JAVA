/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Backlog_produit;
import entities.User_storybp;
import java.io.IOException;
import static java.lang.Math.E;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import services.Servicebacklog_pd;
import services.Serviceuser_storybp;
import services.Sound;
import utils.ConnexionBD;
import utils.NotificationsPush;
import utils.SoundClick;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Afficher_backlog_produitController implements Initializable {
  Servicebacklog_pd ps=new Servicebacklog_pd();
  Serviceuser_storybp u1=new Serviceuser_storybp();
//   NotificationsPush np = new NotificationsPush();
//    NotificationsPush np1 = new NotificationsPush();
    SoundClick sound = new SoundClick();
    private TextField feat;
    @FXML
    private ComboBox<?> cbfeat;
    private TextField userstory;
    @FXML
    private TextField prio;
    @FXML
    private TableView<?> tablefeat;
    @FXML
    private TableColumn<?, ?> numfeature;
    @FXML
    private TableColumn<?, ?> feature;
    @FXML
    private TextField nom_projet;
    @FXML
    private TableColumn<?, ?> id_pro;
    @FXML
    private TableColumn<?, ?> id_f;
    @FXML
    private TableColumn<?, ?> id_u;
    @FXML
    private TableColumn<?, ?> users;
    @FXML
    private TableView<?> tableuser;
    @FXML
    private TableColumn<?, ?> priority;
    @FXML
    private TextField feat1;
    @FXML
    private TextField featmodif;
    @FXML
    private TextArea userstoryarea;
    @FXML
    private TextArea userstorymodif;
    @FXML
    private TextField priomodif;
    @FXML
    private JFXComboBox<?> cbp1;
    @FXML
    private JFXTextField featadd;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton editbtn;
    @FXML
    private JFXButton deletbnt;
    @FXML
    private JFXButton addbtn1;
    @FXML
    private JFXButton editbtn1;
    @FXML
    private JFXButton deletbnt1;
         
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        try {
         
            
        
            Connection c=ConnexionBD.getinstance().getcnx();
          //cbp.setPromptText("Select project");
            cbfeat.setPromptText("Select feature");
            ///affichage de bcklog
            
            ObservableList  obslist = FXCollections.observableList(ps.displayAll());
            numfeature.setCellValueFactory(new PropertyValueFactory<>("id"));
            
            feature.setCellValueFactory(new PropertyValueFactory<>("feature"));
            id_pro.setCellValueFactory(new PropertyValueFactory<>("ide_projet"));
            
            
            
            tablefeat.setItems(obslist);
           
    
    ///affichage des users stories
    
    ObservableList  obslist1 = FXCollections.observableList(u1.displayAll());
    id_u.setCellValueFactory(new PropertyValueFactory<>("id"));
    id_f.setCellValueFactory(new PropertyValueFactory<>("idbacklog_feat"));
    users.setCellValueFactory(new PropertyValueFactory<>("userstory"));
     priority.setCellValueFactory(new PropertyValueFactory<>("priority"));
    
    tableuser.setItems(obslist1);
            
            
            ////select name from combo
            List<String> list=new ArrayList<String>();
            
            list=ps.parcours();
            ObservableList oblist=FXCollections.observableList(list);
            cbp1.getItems().clear();
            cbp1.setItems(oblist);
            //////
            //////select id from combo
            List<String> list1=new ArrayList<String>();
            PreparedStatement pt1;
           list1=u1.parcours1();
            ObservableList oblist2=FXCollections.observableList(list1);
            cbfeat.getItems().clear();
            cbfeat.setItems(oblist2);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        //////
        
        
    }    
//**ajouuter 
   /* private void addf(ActionEvent event) {
      sound.playClick();
          int k=ps.id_projet(cbp1);
          cbp1.getValue();
          String c=featadd.getText();
          Backlog_produit bp=new Backlog_produit(k,c);
           if (featadd.getText().isEmpty() ) {
            sound.playClick();   
            //np.notifpushno("Erreur","Verifier les champs ");
        }
           else{
              ps.ajouterbacklog_produit(bp);}
              
          
          clearFields();
          afficher();
          
            //np.notifpush("feature Ajoutee", "feature ajoutee avec succes");
       
        
    }*/
    
    
public void afficher()  ///affichage de bcklog
    
{       try {
    Servicebacklog_pd ps=new Servicebacklog_pd();
    
  
    ObservableList  obslist = FXCollections.observableList(ps.displayAll());
    numfeature.setCellValueFactory(new PropertyValueFactory<>("id"));
    id_pro.setCellValueFactory(new PropertyValueFactory<>("ide_projet"));
    feature.setCellValueFactory(new PropertyValueFactory<>("feature"));
    
    tablefeat.setItems(obslist);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
    @FXML
    private void updateaction(ActionEvent event) { //modifier backlog
      
          
          int k=0;
          int id_projet=Integer.valueOf(id_pro.getCellData(tablefeat.getSelectionModel().getSelectedIndex()).toString());
          String featur=featmodif.getText();
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Comfirmation");
          alert.setHeaderText(null);
          alert.setContentText("Êtes-vous sûr de Modifier?");
          Optional<ButtonType> action = alert.showAndWait();
          if (action.get() == ButtonType.OK) {
              
              ps.modifierbacklog(ps.return_id_bp(id_projet), featur);
             // sound.playClick();
//         np.notifpush("feature Modifiee", "feature modifiee avec succes");
         }
          
          afficher();
          clearFields();
      }  
    

    @FXML
    private void deleteaction(ActionEvent event) { //supprimer backlog
        
      
          int id_projet=Integer.valueOf(id_pro.getCellData(tablefeat.getSelectionModel().getSelectedIndex()).toString());
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Comfirmation");
          alert.setHeaderText(null);
          alert.setContentText("Êtes-vous sûr de supprimer?");
          Optional<ButtonType> action = alert.showAndWait();
          if (action.get() == ButtonType.OK) {
              
              ps.supprimerbacklog_produit(ps.return_id_bp(id_projet));
          //sound.playClick();
           // np.notifpush("feature Deleted", "feature Deleted avec sucees");
          }
          
          
          afficher();
         clearFields();
      
    }

   
    
    ////////////////////////usrstory
    public void afficheruser()
{       try {
    Serviceuser_storybp ps=new Serviceuser_storybp();
    
    ///affichage de bcklog
    
    ObservableList  obslist = FXCollections.observableList(ps.displayAll());
    id_f.setCellValueFactory(new PropertyValueFactory<>("id"));
    id_u.setCellValueFactory(new PropertyValueFactory<>("idbacklog_feat"));
    users.setCellValueFactory(new PropertyValueFactory<>("userstory"));
     priority.setCellValueFactory(new PropertyValueFactory<>("priority"));
    
    tableuser.setItems(obslist);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_backlog_produitController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
    

    @FXML
    private void adduser(ActionEvent event) {
       
      
          int idf=u1.id_bf(cbfeat);
          String c=userstoryarea.getText();
          int p =Integer.parseInt( prio.getText());//convertir a int
           if (prio.getText().isEmpty() || c.isEmpty()) {
            
            //np.notifpushno("Erreur","Verifier les champs ");
           }
           else{
          if(p>=1 && p<=90)
          {User_storybp u=new User_storybp( idf,c,p);
          
              
              u1.ajouteruserstory(u);
               //sound.playClick();
            //np.notifpush("user story Ajouter", "user story ajouter avec succes");
         
          }
          else
          {Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information");
alert.setHeaderText(null);
alert.setContentText("sasir un nombre entre 1 et 90");

alert.showAndWait();}
          
          
          afficheruser();
      
      
      }
            clearFields();
    }

    
    @FXML
    private void updateuser(ActionEvent event) {
        
        User_storybp userstory = (User_storybp) tableuser.getSelectionModel().getSelectedItem();
      
          Connection c=ConnexionBD.getinstance().getcnx();
          
          
         
          int k=0;
          int id_fb=Integer.valueOf(id_f.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());
          String user=userstorymodif.getText();
          int pr =Integer.valueOf(priomodif.getText());
           if(pr>=1 && pr<=90)
           { Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Comfirmation");
          alert.setHeaderText(null);
          alert.setContentText("Êtes-vous sûr de Modifier?");
          Optional<ButtonType> action = alert.showAndWait();
          if (action.get() == ButtonType.OK) {
              
              u1.modifieruserstory(userstory.getId(),userstory.getIdbacklog_feat(), user,pr);
               //sound.playClick();
           // np.notifpush("user story modifier", "user story modifier avec succes");
              
        
          }}
           else
           {Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information");
alert.setHeaderText(null);
alert.setContentText("sasir un nombre entre 1 et 90");

alert.showAndWait();}
          
          afficheruser();
             clearFields();
         
      }
        
        
        
        
        
    

    @FXML
    private void deleteuser(ActionEvent event) {
      
         
          int id_bf=Integer.valueOf(id_u.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Comfirmation");
          alert.setHeaderText(null);
          alert.setContentText("Êtes-vous sûr de supprimer?");
          Optional<ButtonType> action = alert.showAndWait();
          if (action.get() == ButtonType.OK) {
              
              u1.supprimeruserstory(u1.return_id_feat(id_bf));}
          //sound.playClick();
           // np.notifpush("user story Deleted", "user story Deleted avec sucees");
          afficheruser();
          clearFields();
      }  
    
    
    
    




    
    
    public void clearFields(){ //refresh champs
          
          
         nom_projet.clear();
          prio.clear();
          featadd.clear();
          feat1.clear();
          featmodif.clear();
          userstoryarea.clear();
          userstorymodif.clear();
          priomodif.clear();
       
          
      }

    @FXML
    private void table_set(MouseEvent event) { //prendre des valeurs de table view user story
         int id_fb ;
        String usr="";
        int pr;
        id_fb=Integer.valueOf(id_u.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());//cle etrangere
                usr=(String) users.getCellData(tableuser.getSelectionModel().getSelectedIndex());//
                pr=Integer.valueOf(priority.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());
                
                feat1.setText(""+id_fb);
                userstorymodif.setText(usr);
                priomodif.setText(""+pr);
    }

    @FXML
    private void setf(MouseEvent event) { //prendre les valeurs de tableview backlog
        Connection c=ConnexionBD.getinstance().getcnx();
                 String k="";

        int id_projet ;
        String featu="";
                id_projet=Integer.valueOf(id_pro.getCellData(tablefeat.getSelectionModel().getSelectedIndex()).toString());//cle etrangere
                featu=(String) feature.getCellData(tablefeat.getSelectionModel().getSelectedIndex());//
        String id=""+id_projet;
        
        
         k=ps.chercher1(id_projet);
        
        
                nom_projet.setText(k);
                
                featmodif.setText(featu);
    }

    @FXML
    private void addfeature(ActionEvent event) {
        
           int k=ps.id_projet(cbp1);
          cbp1.getValue();
          String c=featadd.getText();
          Backlog_produit bp=new Backlog_produit(k,c);
           if (featadd.getText().isEmpty() ) {
            //sound.playClick();   
            //np.notifpushno("Erreur","Verifier les champs ");
        }
           else{
              ps.ajouterbacklog_produit(bp);}
              
          
          clearFields();
          afficher();
          
            //np.notifpush("feature Ajoutee", "feature ajoutee avec succes");
      } 
    }
    

