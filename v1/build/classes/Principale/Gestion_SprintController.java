/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Entities.Sprint;
import Services.Service_Backlog_sprint;
import Services.Service_Sprint;
import Services.Service_user_story_bs;
import Utils.ConnexionBD;
import com.gluonhq.charm.glisten.control.TextField;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import static java.util.logging.Level.parse;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Gestion_SprintController implements Initializable {


    @FXML
    private Slider slide;
    @FXML
    private ComboBox<?> combo3;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private JFXTextField text1;
    @FXML
    private TableColumn<?, ?> C1;
    @FXML
    private TableColumn<?, ?> C2;
    @FXML
    private TableColumn<?, ?> C4;
    @FXML
    private TableColumn<?, ?> C5;
    @FXML
    private TableColumn<?, ?> C3;

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private TableView<?> table;
    @FXML
    private TextField t3;
    @FXML
    private JFXDatePicker date3;
    @FXML
    private JFXDatePicker date4;
    
    
    
       Service_Sprint srv = new Service_Sprint();
        Service_Backlog_sprint srvb = new Service_Backlog_sprint();
               Service_user_story_bs srvu = new Service_user_story_bs();

    @FXML
    private TextField t4;
    @FXML
    private Pane pane2;
    @FXML
    private ComboBox<?> combo5;
    @FXML
     Button ok;
    @FXML
    private TextField mdp;
    @FXML
    private Pane pane1;
    @FXML
    private Label lab1;
    @FXML
    private Button up;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane1.setVisible(false);
        
        slide.setMajorTickUnit(1);
        slide.setMinorTickCount(0);
        slide.setShowTickMarks(true);
        slide.setShowTickLabels(true);
        slide.setMinHeight(Slider.USE_PREF_SIZE);
        
        
        ObservableList obList5 = FXCollections.observableList(srvu.displaysm());
        combo5.setPromptText("Select your id");
        combo5.getItems().clear();
        combo5.setItems(obList5);
        

        
        
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
        
                String desc=(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            deletejdida(desc);
                afficherjdida(srvb.id_sm((String) combo5.getValue()) );
    }
});
        
        
        
                afficherjdida(srvb.id_sm((String) combo5.getValue()) );
        
        
        
  
        
    }    

    @FXML
    private void valider(ActionEvent event) {
        System.out.println(date1.getValue());
      
        String k =""+combo3.getValue();
        System.out.println(k);
        double var =slide.getValue();
        int le = (int)var;
        String datedb=""+date1.getValue();
        String datefn=""+date2.getValue();
        Sprint s = new Sprint((Integer.parseInt(k)), datedb, datefn, le, text1.getText());
        srv.ajouterSprint(s);
        afficherjdida(srvb.id_sm((String) combo5.getValue()) );
        
    }


      private void afficher() {
          Service_Backlog_sprint bs=new Service_Backlog_sprint();

            ObservableList obeListe = FXCollections.observableList(srv.displayAll());
            
        C1.setCellValueFactory(new PropertyValueFactory<>("id_bs"));
        C2.setCellValueFactory(new PropertyValueFactory<>("date_debut_sprint"));
        C3.setCellValueFactory(new PropertyValueFactory<>("date_fin_sprint"));
        C4.setCellValueFactory(new PropertyValueFactory<>("liste_user_sroty_bs"));
        C5.setCellValueFactory(new PropertyValueFactory<>("Description"));

        table.setItems(obeListe);

    }



    @FXML
    private void update(ActionEvent event) {
     
        String desc;
        String desc1=t3.getText();
        String date1 =""+date3.getValue();
        String date2 =""+date4.getValue();
        
        
        desc=(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        srv.modifiersprint1(srv.return_id(desc), date1, date2,(Integer.parseInt(t4.getText())), desc1);
                afficherjdida(srvb.id_sm((String) combo5.getValue()) );
        
    }

    @FXML
    private void delete(ActionEvent event) {
          
                String desc=(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());

           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Suppresion");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous vraiment supprimer cet article ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK)
                            {srv.supprimerSprint(srv.return_id(desc));
                            
                            }
                                
                              
                afficherjdida(srvb.id_sm((String) combo5.getValue()) );
    }
     private void deletejdida(String k) {
          

           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Suppresion");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous vraiment supprimer cet article ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK)
                            {srv.supprimerSprint(srv.return_id(k));
                            
                            }
         
        afficher();
    }

    @FXML
    private void setC(MouseEvent event) {
        String k="";
                 String desc;
                k=(C4.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
                desc=(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
       
        t3.setText(desc);
        t4.setText(k);
    }

    @FXML
    private void ok(ActionEvent event) {
        
                pane1.setVisible(true);
                pane2.setVisible(false);
                combo3.setPromptText("Select backlog");
        Service_Sprint srv = new Service_Sprint();
        
        ObservableList obList2 = FXCollections.observableList(srv.displaybs(srvb.id_sm((String) combo5.getValue())));

        combo3.getItems().clear();

        combo3.setItems(obList2);
                afficherjdida(srvb.id_sm((String) combo5.getValue()) );

        
        
    }
    private void afficherjdida(int u) {
          Service_Backlog_sprint bs=new Service_Backlog_sprint();

            ObservableList obeListe = FXCollections.observableList(srv.displayAll1(u));
            
        C1.setCellValueFactory(new PropertyValueFactory<>("id_bs"));
        C2.setCellValueFactory(new PropertyValueFactory<>("date_debut_sprint"));
        C3.setCellValueFactory(new PropertyValueFactory<>("date_fin_sprint"));
        C4.setCellValueFactory(new PropertyValueFactory<>("liste_user_sroty_bs"));
        C5.setCellValueFactory(new PropertyValueFactory<>("Description"));

        table.setItems(obeListe);
        
    }
    
     int ok(){
        int k = 6;
    return k;
}
    
}
