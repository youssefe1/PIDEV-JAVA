/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Dr-Eagle
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private VBox sidebar;
    @FXML
    private Pane MainPane;
    @FXML
    private Pane TopBar;
    @FXML
    private JFXButton homebtn;
    @FXML
    private JFXButton BS;
    @FXML
    private JFXButton sprint;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        try {
         //  TopBar.getChildren().clear();
            Parent parent = FXMLLoader.load(getClass().getResource("Topbar.fxml"));
            TopBar.getChildren().add(parent);
            TopBar.toFront();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void homebtna(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("test.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void Gestion_backlog_sprint(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Afficher_backlog_sprint.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
        
    }

    @FXML
    private void sprint(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Gestion_Sprint.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void userstory(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Gestion_userstory.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void tache(MouseEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Gestion_tache.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
        
    }

    @FXML
    private void users(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Users.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    @FXML
    private void mestaches(ActionEvent event) throws IOException {
        MainPane.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("Tache_perso.fxml"));
        MainPane.getChildren().add(parent);
        MainPane.toFront();
    }

    
}
