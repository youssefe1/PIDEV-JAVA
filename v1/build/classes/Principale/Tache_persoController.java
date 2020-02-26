/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Entities.Conflit;
import Services.Service_Backlog_sprint;
import Services.Service_Personnel;
import Services.Service_Sm;
import Services.Service_Tache;
import Services.Service_conflit;
import Services.Service_notif;
import Services.Service_user_story_bs;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Tache_persoController implements Initializable {

    @FXML
    private Label lab0;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox<?> combo0;
    @FXML
    private ComboBox<?> combo1;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> C1;
    @FXML
    private TableColumn<?, ?> C2;
    @FXML
    private TableColumn<?, ?> C3;
    @FXML
    private TableColumn<?, ?> C4;
    @FXML
    private TableColumn<?, ?> C5;
    @FXML
    private TableColumn<?, ?> C6;
    @FXML
    private TableColumn<?, ?> C7;
    @FXML
    private TableColumn<?, ?> C8;
    @FXML
    private Label lab1;
    @FXML
    private TextField text1;
    @FXML
    private Button estimer;
      Service_user_story_bs srv = new Service_user_story_bs();
       Service_Backlog_sprint srvb = new Service_Backlog_sprint();
       Service_Tache srvt = new Service_Tache();
       Service_notif srvnot = new Service_notif();
       Service_Personnel srvp = new Service_Personnel();
       Service_Sm srvsm = new Service_Sm();
       String user_name ="mazen" ;
       int id_user =srvp.displayid(user_name);
    @FXML
    private TableColumn<?, ?> C9;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lab0.setText(user_name);
        
        ObservableList obList1 = FXCollections.observableList(srv.displaysp1(srvp.displayidequipe(id_user)));
       // System.out.println(obList1);
        combo0.setPromptText("Select your Sprint");
        combo0.getItems().clear();
        combo0.setItems(obList1);
        text1.setDisable(true);
        
    }    

    @FXML
    private void setcombo0(ActionEvent event) {
        combo1.setPromptText("Select your user_story");
        ObservableList obList1 = FXCollections.observableList(srv.displayuser_story(srv.id_sprint(""+combo0.getValue())));
        combo1.setItems(obList1);
    }

    @FXML
    private void setcombo1(ActionEvent event) {
        afficher(srv.id_userstory((String)combo1.getValue()));
    }

    @FXML
    private void contribuer(ActionEvent event) {
        Service_conflit srvc=new Service_conflit();

        int k = Integer.valueOf(C9.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String liste = (C6.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        
       int pos = liste.indexOf(user_name, 0);
       if (pos!=-1)
       {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Choix incorecte");
                            alert.setHeaderText(null);
                            alert.setContentText("vous avez déja contribué ");
                            Optional<ButtonType> action = alert.showAndWait();
 
       }
       else srvt.liste1(k,user_name);
       
       if (!liste.isEmpty())
       {
       Conflit c1= new Conflit(srvp.displayidequipe(id_user), srvsm.afficher_sm_equipe(srvp.displayidequipe(id_user)), "les utilisateur"+" "+liste+" ont contirubué sur la meme tache", 0, 0);
       srvc.ajouterConflit(c1);
 
       }
//System.out.println(pos);
        afficher(srv.id_userstory((String)combo1.getValue()));
    }

    @FXML
    private void settable(MouseEvent event) {
        String nom_tache=(C1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
       lab1.setText(nom_tache);
       text1.setDisable(false);
    }
    public void afficher (int k)
    {
        Service_Backlog_sprint bs=new Service_Backlog_sprint();

            ObservableList obeListe = FXCollections.observableList(srvt.displayAll1(k));
            
        C1.setCellValueFactory(new PropertyValueFactory<>("nom_tache"));
        C2.setCellValueFactory(new PropertyValueFactory<>("description_tache"));
        C3.setCellValueFactory(new PropertyValueFactory<>("date_debut_tache"));
        C4.setCellValueFactory(new PropertyValueFactory<>("date_fin_tache"));
        C5.setCellValueFactory(new PropertyValueFactory<>("type_tache"));
        C6.setCellValueFactory(new PropertyValueFactory<>("liste_Personnel"));
        C7.setCellValueFactory(new PropertyValueFactory<>("liste_nbre_heure"));
        C8.setCellValueFactory(new PropertyValueFactory<>("moyenne_estimation"));
        C9.setCellValueFactory(new PropertyValueFactory<>("id_Tache"));
        C9.setVisible(false);

        table.setItems(obeListe);
    }

    @FXML
    private void estimer(ActionEvent event) {
        
        String var = text1.getText();
        int k = Integer.valueOf(C9.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String lel = (C7.getCellData(table.getSelectionModel().getSelectedIndex()).toString());

        int pos = lel.indexOf(var, 0);
       if (pos!=-1)
       {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Choix incorecte");
                            alert.setHeaderText(null);
                            alert.setContentText("cette estimation existe déja  ");
                            Optional<ButtonType> action = alert.showAndWait();
 
       }
       if (pos==-1)
       {
         srvt.liste2(k, var);
 
       }
       
       if (Integer.parseInt(var)>9)
       {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Choix incorecte");
                            alert.setHeaderText(null);
                            alert.setContentText("cette estimation dépasse les 10 heures pensez à subdiviser cette tache  ");
                            Optional<ButtonType> action = alert.showAndWait();
 
       }
       
       
       
       srvt.inserer_estim(k, srvt.estimer(k));
        afficher(srv.id_userstory((String)combo1.getValue()));
        text1.setDisable(true);
        

    }
    
}
