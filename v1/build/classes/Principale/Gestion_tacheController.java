/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Entities.Tache;
import Services.Service_Backlog_sprint;
import Services.Service_Tache;
import Services.Service_notif;
import Services.Service_pdf;
import Services.Service_user_story_bs;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Gestion_tacheController implements Initializable {

    @FXML
    private Pane pane2;
    @FXML
    private ComboBox<?> combo2;
    @FXML
    private TextField t2;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private JFXRadioButton r1;
    @FXML
    private JFXRadioButton r2;
    @FXML
    private JFXRadioButton r3;
    @FXML
    private TextField t3;
    @FXML
    private JFXDatePicker date1;
    @FXML
    private JFXDatePicker date2;
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
    private TableColumn<?, ?> C9;
    @FXML
    private TableColumn<?, ?> C10;
    @FXML
    private JFXDatePicker date3;
    @FXML
    private JFXDatePicker date4;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private Pane pane1;
    @FXML
    private Button go;
    @FXML
    private TextField pass;

    /**
     * Initializes the controller class.
     */
    Service_user_story_bs srv = new Service_user_story_bs();
       Service_Backlog_sprint srvb = new Service_Backlog_sprint();
       Service_Tache srvt = new Service_Tache();
       Service_notif srvnot = new Service_notif();
       Service_pdf srvpdf = new Service_pdf();
       
    @FXML
    private ComboBox<?> combo0;
    @FXML
    private ComboBox<?> combo3;
    @FXML
    private TableView<?> table;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pane2.setVisible(false);
        ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r1.setSelected(true);
        ObservableList obList1= FXCollections.observableList(srv.displaysm());
        //System.out.println(obList1);
        combo0.setPromptText("Select your id");
        combo0.getItems().clear();
        combo0.setItems(obList1);
        
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, 1);
 
        spinner.setValueFactory(valueFactory);
        

    }    

    @FXML
    private void valider(ActionEvent event) throws AWTException {
        String k="" ;
        if (r1.isSelected())
        k=r1.getText();
        if (r2.isSelected())
        k=r2.getText();
        if (r3.isSelected())
        k=r3.getText();
        
        
        Tache t= new Tache(0, srv.id_userstory(""+combo3.getValue()), "id_Sprint",""+date1.getValue(), ""+date2.getValue(), t2.getText(), k, "", t3.getText(), ""+spinner.getValue(), ""+spinner.getValue());
    srvt.ajoutertache(t);
        
    clear();
       afficher(srv.id_userstory(""+combo3.getValue()));
       srvnot.notif(t2.getText());

    
    }

    @FXML
    private void set_tab(MouseEvent event) {
        String desc=(C4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String nom=(C7.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        t4.setText(desc);
        t5.setText(nom);
    }

    @FXML
    private void update(ActionEvent event) {
        t4.getText();
        t5.getText();
      String  d1=""+date3.getValue();
      String  d2 =""+date4.getValue();
        String nom=(C4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        int l=srvt.id_tache(nom);
        srvt.modifiertache1(l, t4.getText(), t5.getText(), d1, d2);
        afficher(srv.id_userstory(""+combo3.getValue()));


    }

    @FXML
    private void go(ActionEvent event) {
        pane1.setVisible(false);
        pane2.setVisible(true);
        ObservableList obList1 = FXCollections.observableList(srv.displaysp(srvb.id_sm((String) combo0.getValue()) ));
       // System.out.println(obList1);
        combo2.setPromptText("Select your Sprint");
        combo2.getItems().clear();
        combo2.setItems(obList1);
        afficher(srv.id_userstory(""+combo3.getValue()));
        
        
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
        
            String nom=(C4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            deletejdida(srvt.id_tache(nom));
        afficher(srv.id_userstory(""+combo3.getValue()));
    }
});
         
        afficher(srv.id_userstory(""+combo3.getValue()));

        
    }

    @FXML
    private void go_combo(ActionEvent event) {
        combo3.setPromptText("Select your user_story");
        System.out.println(srv.displayuser_story(srv.id_sprint(""+combo2.getValue())));
        ObservableList obList1 = FXCollections.observableList(srv.displayuser_story(srv.id_sprint(""+combo2.getValue())));
        combo3.setItems(obList1);
    }
    
    public void clear()
    {
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        
    }
    public void afficher(int k)
    {
          Service_Backlog_sprint bs=new Service_Backlog_sprint();

            ObservableList obeListe = FXCollections.observableList(srvt.displayAll1(k));
            
        C1.setCellValueFactory(new PropertyValueFactory<>("id_user_story_bs"));
        C2.setCellValueFactory(new PropertyValueFactory<>("date_debut_tache"));
        C3.setCellValueFactory(new PropertyValueFactory<>("date_fin_tache"));
        C4.setCellValueFactory(new PropertyValueFactory<>("nom_tache"));
        C5.setCellValueFactory(new PropertyValueFactory<>("type_tache"));
        C6.setCellValueFactory(new PropertyValueFactory<>("description_tache"));
        C7.setCellValueFactory(new PropertyValueFactory<>("liste_nbre_heure"));
        C8.setCellValueFactory(new PropertyValueFactory<>("liste_Personnel"));
        C9.setCellValueFactory(new PropertyValueFactory<>("moyenne_estimation"));
        C10.setVisible(false);
        
        

        table.setItems(obeListe);
    }

    @FXML
    private void go_combo3(ActionEvent event) {
      afficher(srv.id_userstory(""+combo3.getValue()));

    }
    public void deletejdida(int id)
    {
        srvt.supprimertache1(id);
    }

    @FXML
    private void pdf(ActionEvent event) throws SQLException, DocumentException, IOException {
        srvpdf.FacturePdf();
    }
    
}
