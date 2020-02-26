/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Entities.User_story_bs;
import Services.Service_Backlog_sprint;
import Services.Service_Sprint;
import Services.Service_user_story_bp;
import Services.Service_user_story_bs;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.JSType;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Gestion_userstoryController implements Initializable {

    @FXML
    private Label lab1;
    @FXML
    private JFXComboBox<?> combo;
    @FXML
    private Button setid;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane pane;
    @FXML
    private Pane pane2;
    @FXML
    private Label lab3;
    @FXML
    private JFXTextField text1;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private JFXTextField text2;
    @FXML
    private Button update;
    @FXML
    private ComboBox<?> combo2;

    /**
     * Initializes the controller class.
     */
       Service_user_story_bs srv = new Service_user_story_bs();
       Service_Backlog_sprint srvb = new Service_Backlog_sprint();
       Service_user_story_bp srvez = new Service_user_story_bp();

       int b;
    @FXML
    private TableView<?> table2;
    @FXML
    private TableColumn<?, ?> C1;
    @FXML
    private TableColumn<?, ?> C2;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         combo.setPromptText("Select your name");
        
        ObservableList obList2 = FXCollections.observableList(srv.displaysm());

        combo.getItems().clear();

        combo.setItems(obList2);

        pane2.setVisible(false);

    }    


    @FXML
    private void setid(ActionEvent event) throws IOException {
       
        lab3.setText("welcome"+" "+combo.getValue());
        pane.setVisible(false);
        pane2.setVisible(true);
        ObservableList obList1 = FXCollections.observableList(srv.displaysp(srvb.id_sm((String) combo.getValue()) ));
        System.out.println(obList1);
        combo2.setPromptText("Select your Sprint");
        combo2.getItems().clear();
        combo2.setItems(obList1);
        
                ContextMenu cm = new ContextMenu();
MenuItem mi1 = new MenuItem("supprimer");
cm.getItems().add(mi1);
table.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent t) {
        if(t.getButton() == MouseButton.SECONDARY) {
            cm.show(table, t.getScreenX(), t.getScreenY());
           
        }
    }
});
 mi1.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        System.out.println("Supprimer");
        
            String desc=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            deletejdida(desc);
        afficher(srvb.id_sm((String) combo.getValue()) );
    }
});
         afficher2(srvez.id_projet(srvb.id_sm((String) combo.getValue())));
        afficher(srvb.id_sm((String) combo.getValue()) );

        
    }
    

    @FXML
    private void test5(ActionEvent event) {
        String k=""+combo.getValue();
        System.out.println(k);
    }

    @FXML
    private void tab_up(MouseEvent event) {
        String desc=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        text2.setText(desc);
    }

    @FXML
    private void submit(ActionEvent event) {
        User_story_bs c = new User_story_bs(srv.id_sprint((String) combo2.getValue()), text1.getText());
        srv.ajouterUser_story_bs(c);
       int k;
        k = Integer.valueOf(C2.getCellData(table2.getSelectionModel().getSelectedIndex()).toString());

        srvez.update_set(k);
        afficher(srvb.id_sm((String) combo.getValue()) );
        afficher2(srvez.id_projet(srvb.id_sm((String) combo.getValue())));
        
    }
    public void afficher (int u)
    {
        ObservableList obeListe = FXCollections.observableList(srv.displayAll(u));
        c1.setCellValueFactory(new PropertyValueFactory<>("id_sprint"));
        c2.setCellValueFactory(new PropertyValueFactory<>("description_user_story_bs"));
        table.setItems(obeListe);
    }
     public void afficher2 (int u)
    {
        ObservableList obeListe = FXCollections.observableList(srvez.displayAll(u));
        C1.setCellValueFactory(new PropertyValueFactory<>("userstory"));
        C2.setCellValueFactory(new PropertyValueFactory<>("id"));
        C2.setVisible(false);
        table2.setItems(obeListe);
        srvez.displayAll(1);
    }
    

    @FXML
    private void update(ActionEvent event) {
        String desc=(c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        srv.modifierUser_story_bs(srv.id_userstory(desc), text2.getText());
        afficher(srvb.id_sm((String) combo.getValue()));

    }
    
    public void deletejdida(String desc)
    {
        String k;
        k = (c2.getCellData(table.getSelectionModel().getSelectedIndex()).toString());

        srvez.update_set2(k);
        afficher2(srvez.id_projet(srvb.id_sm((String) combo.getValue())));
        srv.supprimerUser_story_bs1(desc);
    }

    @FXML
    private void settab2(MouseEvent event) {
     String desc=(C1.getCellData(table2.getSelectionModel().getSelectedIndex()).toString());
     System.out.print(desc);
     text1.setText(desc);

    }
    
    
}
