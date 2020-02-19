/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import entities.Backlog_produit;
import entities.User_storybp;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.Servicebacklog_pd;
import services.Serviceuser_storybp;
import services.Sound;
import utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Afficher_backlog_produitController implements Initializable {
  Servicebacklog_pd ps=new Servicebacklog_pd();
  Serviceuser_storybp u1=new Serviceuser_storybp();
    @FXML
    private ComboBox<?> cbp;
    @FXML
    private TextField feat;
    @FXML
    private ComboBox<?> cbfeat;
    @FXML
    private TextField userstory;
    @FXML
    private TextField prio;
    @FXML
    private Button addfeat;
    @FXML
    private TableView<?> tablefeat;
    @FXML
    private TableColumn<?, ?> numfeature;
    @FXML
    private TableColumn<?, ?> feature;
    @FXML
    private TextField nom_projet;
    @FXML
    private Button set;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableColumn<?, ?> id_pro;
    @FXML
    private Button bac;
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
    private Button addu;
    @FXML
    private Button setu;
    @FXML
    private Button updateu;
    @FXML
    private Button deleteu;
    @FXML
    private TextField feat1;
    @FXML
    private Label labelbk;
    @FXML
    private ImageView backim;
         
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        try {
         
            
        
            Connection c=ConnexionBD.getinstance().getcnx();
          cbp.setPromptText("Select project");
            cbfeat.setPromptText("Select feature");
            ///affichage de bcklog
            
            ObservableList  obslist = FXCollections.observableList(ps.displayAll());
            numfeature.setCellValueFactory(new PropertyValueFactory<>("id"));
            id_pro.setCellValueFactory(new PropertyValueFactory<>("ide_projet"));
            
            feature.setCellValueFactory(new PropertyValueFactory<>("feature"));
            
            
            tablefeat.setItems(obslist);
            //Serviceuser_storybp ps=new Serviceuser_storybp();
    
    ///affichage des users stories
    
    ObservableList  obslist1 = FXCollections.observableList(ps.displayAll());
    id_u.setCellValueFactory(new PropertyValueFactory<>("id"));
    id_f.setCellValueFactory(new PropertyValueFactory<>("idbacklog_feat"));
    users.setCellValueFactory(new PropertyValueFactory<>("userstory"));
     priority.setCellValueFactory(new PropertyValueFactory<>("priority"));
    
    tableuser.setItems(obslist1);
            
            
            ////select name from combo
            List<String> list=new ArrayList<String>();
            
            list=ps.parcours();
            ObservableList oblist=FXCollections.observableList(list);
            cbp.getItems().clear();
            cbp.setItems(oblist);
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
    @FXML
    private void addf(ActionEvent event) {
          
           int k=ps.id_projet(cbp);
        cbp.getValue();
        String c=feat.getText();
          Backlog_produit bp=new Backlog_produit(k,c);
       
        ps.ajouterbacklog_produit(bp);
        showAlertWithoutHeaderTextajout();
        //clearFields();
        afficher();
        
    }
    
    
public void afficher()
{       try {
    Servicebacklog_pd ps=new Servicebacklog_pd();
    
    ///affichage de bcklog
    
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
    private void actionset(ActionEvent event) {
        Connection c=ConnexionBD.getinstance().getcnx();
                 String k="";

        int id_projet ;
        String featu="";
                id_projet=Integer.valueOf(id_pro.getCellData(tablefeat.getSelectionModel().getSelectedIndex()).toString());//cle etrangere
                featu=(String) feature.getCellData(tablefeat.getSelectionModel().getSelectedIndex());//
        String id=""+id_projet;
        
        
         k=ps.chercher1(id_projet);
        
        
                nom_projet.setText(k);
                
                feat.setText(featu);
    }

    @FXML
    private void updateaction(ActionEvent event) {
        Connection c=ConnexionBD.getinstance().getcnx();

    int k=0;
        int id_projet=Integer.valueOf(id_pro.getCellData(tablefeat.getSelectionModel().getSelectedIndex()).toString());
        String featur=feat.getText();

       ps.modifierbacklog(ps.return_id_bp(id_projet), featur);
        System.out.println(ps.return_id_bp(id_projet));
        showAlertWithoutHeaderTextmodifier();
        afficher();
       //clearFields();
    }

    @FXML
    private void deleteaction(ActionEvent event) {
        int id_projet=Integer.valueOf(id_pro.getCellData(tablefeat.getSelectionModel().getSelectedIndex()).toString());
          ps.supprimerbacklog_produit(ps.return_id_bp(id_projet));
showAlertWithoutHeaderTextsup();
        afficher();
    }

    @FXML
    private void back(ActionEvent event) {
        try{
        Sound audioPlayer =
                new Sound();
         audioPlayer.play();
         Parent parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();}
        catch (Exception e) {
            e.printStackTrace();
        }
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
        String c=userstory.getText();
          int p =Integer.parseInt( prio.getText());//convertir a int
          User_storybp u=new User_storybp( idf,c,p);
       
        u1.ajouteruserstory(u);
        showAlertWithoutHeaderTextajout();
        //clearFields();
        afficheruser();
    }

    @FXML
    private void setuser(ActionEvent event) {
        Connection c=ConnexionBD.getinstance().getcnx();
                 String k="";

        int id_fb ;
        String usr="";
        int pr;
                id_fb=Integer.valueOf(id_f.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());//cle etrangere
                usr=(String) users.getCellData(tableuser.getSelectionModel().getSelectedIndex());//
                pr=Integer.valueOf(priority.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());
        String id=""+id_fb;
        String pr1=""+pr;
        
        System.out.println(id_fb);
        
         k=u1.chercher(id_fb);
        
        System.out.println(k);
                feat1.setText(k);
                
                userstory.setText(usr);
                prio.setText(pr1);
    }

    @FXML
    private void updateuser(ActionEvent event) {
         Connection c=ConnexionBD.getinstance().getcnx();

    int k=0;
       int id_fb=Integer.valueOf(id_f.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());
        String user=userstory.getText();
         int pr =Integer.valueOf(prio.getText());
       u1.modifieruserstory(u1.return_id_feat(id_fb), user,pr);
        showAlertWithoutHeaderTextmodifier();
        //clearFields();
        afficheruser();
        
        
        
        
    }

    @FXML
    private void deleteuser(ActionEvent event) {
        int id_bf=Integer.valueOf(id_u.getCellData(tableuser.getSelectionModel().getSelectedIndex()).toString());
          u1.supprimeruserstory(u1.return_id_feat(id_bf));
showAlertWithoutHeaderTextsup();
        afficheruser();
    }
    
    
    private void showAlertWithoutHeaderTextsup() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Suppresion");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Suppression obtenue aves succés!");
 
        alert.showAndWait();
    }
    private void showAlertWithoutHeaderTextajout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ajout");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Ajout obtenue aves succés!");
 
        alert.showAndWait();
    }
    private void showAlertWithoutHeaderTextmodifier() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Modification");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Modification obtenue aves succés!");
 
        alert.showAndWait();
    }
    /*public void clearFields(){
          feat.clear();
          userstory.clear();
         nom_projet.clear();
          prio.clear();
       
          
      }*/
    
}
