/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;


import Entities.Personnel;
import Entities.Sm;
import Services.Service_Backlog_sprint;
import Services.Service_Personnel;
import Services.Service_Sm;
import Services.Service_Sprint;
import Services.Service_generer_Qr_code;
import Services.Service_mail;
import Services.Service_notif;
import Services.Service_password;
import java.awt.AWTException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UsersController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private Label lab1;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private TableColumn<?, ?> c3;
    @FXML
    private TableColumn<?, ?> c4;
    @FXML
    private TableColumn<?, ?> c5;

    /**
     * Initializes the controller class.
     */
            Service_Sprint srv = new Service_Sprint();
            Service_password srvps = new Service_password();
            Service_Personnel srvp = new Service_Personnel();
            Service_Backlog_sprint srvbs = new Service_Backlog_sprint();
            Service_Sm srvm = new Service_Sm();
            Service_mail srvmail = new Service_mail();
            Service_generer_Qr_code srvqr = new Service_generer_Qr_code();
            Service_notif srvnot = new Service_notif();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        afficher();
   
    }

    @FXML
    private void gener(ActionEvent event) {
        lab1.setText(srvps.generer());
    }

    @FXML
    private void valider(ActionEvent event) throws AWTException {
        String var=lab1.getText();
         Personnel pa = new Personnel(t1.getText(), t2.getText(), ""+date1.getValue(),t3.getText(), 0, t4.getText(), t5.getText(), t6.getText(), var, "image_user", r1.getText(), 0);
         Sm s = new Sm(t1.getText(), t2.getText(), ""+date1.getValue(), t3.getText(), 1,  t4.getText(), t5.getText(), t6.getText(), var, "image_user", srvbs.id_projet((String) combo.getValue()));
        if (r2.isSelected()) {
           srvp.ajouterPersonnel(pa);
        }
        if (r1.isSelected()) {
           srvm.ajoutersm(s);
        }
        srvqr.create(t6.getText(), lab1.getText());
        srvmail.send_mail("azizsahnoun5@gmail.com", t6.getText());
        srvnot.notif(t6.getText());
        afficher();
    }

    @FXML
    private void r1(ActionEvent event) {
        combo.setPromptText("Select project");
        ObservableList obList = FXCollections.observableList(srv.displayProject());
        combo.getItems().clear();
        combo.setItems(obList);
    }

    @FXML
    private void r2(ActionEvent event) {
        combo.getItems().clear();
        combo.getItems().addAll(
            "technicien",
            "ingenieur",
            "designer"
        );
        combo.setPromptText("specialité");
    }
    
    public void afficher ()
    {
        ObservableList obeListe = FXCollections.observableList(srvp.displayAll1());

        c1.setCellValueFactory(new PropertyValueFactory<>("nom_u"));
        c2.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        c3.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
        c4.setCellValueFactory(new PropertyValueFactory<>("UID"));
        c5.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.setItems(obeListe);
    }

    
    
}
