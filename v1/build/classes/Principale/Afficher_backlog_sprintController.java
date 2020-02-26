/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Entities.Backlog_sprint;
import Services.Service_Backlog_sprint;
import Services.Service_Sprint;
import Services.Service_user_story_bs;
import Utils.ConnexionBD;
import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Afficher_backlog_sprintController implements Initializable {
        Service_Backlog_sprint srvBs = new Service_Backlog_sprint();
         

    @FXML
    private Label Label1;
    @FXML
    private Slider Slide;
    @FXML
    private Label lab2;
    @FXML
    private Button btn;
    @FXML
    private ComboBox<?> combo;
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
    private JFXTextField text1;
    @FXML
    private JFXTextField text2;
    @FXML
    private Button update;
    @FXML
    private JFXButton delete;
    @FXML
    private ComboBox<?> combo2;
    @FXML
    private ComboBox<?> combo4;
    @FXML
    private JFXButton hoh;
    @FXML
    private TableColumn<?, ?> C5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label1.setText(srvBs.retour());
        Slide.setMajorTickUnit(1);
        Slide.setMinorTickCount(0);
        Slide.setShowTickMarks(true);
        Slide.setShowTickLabels(true);
        Slide.setMinHeight(Slider.USE_PREF_SIZE);
        combo.setPromptText("Select project");
        combo2.setPromptText("Select team");
        combo4.setPromptText("Select scrum_m");
        
        Service_Sprint srv = new Service_Sprint();
        Service_user_story_bs srvu = new Service_user_story_bs();

        ObservableList obList1 = FXCollections.observableList(srv.displayequipe());    
        combo2.getItems().clear();
        combo2.setItems(obList1);
        
        ObservableList obList2 = FXCollections.observableList(srvu.displaysm());    
        combo4.getItems().clear();
        combo4.setItems(obList2);

        
      
        ObservableList obList = FXCollections.observableList(srv.displayProject());
        combo.getItems().clear();
        combo.setItems(obList);
       
         
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
        
      int k=Integer.valueOf(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
            deletejdida(k);
            afficher();
    }
});
       afficher();
       
       
       delete.setVisible(false);
      
       
       Gestion_SprintController j = new Gestion_SprintController();
      lab2.setText("ahmed"+j.ok()); 
    }    

   @FXML
    private void submit(ActionEvent event) throws IOException {
        double var =Slide.getValue();
        combo.getValue();
        int le = (int)var;
        combo2.getValue();
        combo4.getValue();
        Backlog_sprint t= new Backlog_sprint(srvBs.return_id_eq((String) combo2.getValue()), srvBs.id_sm((String) combo4.getValue()), srvBs.id_projet((String) combo.getValue()), le);

        srvBs.ajouterBS(t);
         afficher();
        
       // redirect(event);
        
        
    }
       
       
       

    private void ok(ActionEvent event) {
        
        Connection c=ConnexionBD.getinstance().getcnx();
                 String k="";

        int id_projet ;
        int nbr_sprint;
                id_projet=Integer.valueOf(C1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
                nbr_sprint=Integer.valueOf(C3.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String id=""+id_projet;
        
        
         try {
            PreparedStatement pt =c.prepareStatement("select nom_projet from projet where id_projet=?");
            pt.setInt(1, id_projet);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               k = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_Sprint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                text1.setText(k);
                
                text2.setText(""+nbr_sprint);

    }
    public void afficher()
    {
            Service_Backlog_sprint bs=new Service_Backlog_sprint();

            ObservableList obeListe = FXCollections.observableList(srvBs.displayAll1());
            
        C1.setCellValueFactory(new PropertyValueFactory<>("sid_projet"));
        C2.setCellValueFactory(new PropertyValueFactory<>("sid_sm"));
        C3.setCellValueFactory(new PropertyValueFactory<>("liste_sprint"));
        C4.setCellValueFactory(new PropertyValueFactory<>("sid_equipe"));
        C5.setCellValueFactory(new PropertyValueFactory<>("id_bs"));
        

        table.setItems(obeListe);
        
    }

    @FXML
    private void update(ActionEvent event) {

    int k=0;
        int id_bs=Integer.valueOf(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        int nbr_sprint=Integer.valueOf(text2.getText());

        srvBs.modifierbs(id_bs, nbr_sprint);

        afficher();
        
    }

    @FXML
    private void delete(ActionEvent event) {
      int id_projet=Integer.valueOf(C5.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
          
          
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Suppresion");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous vraiment supprimer cet article ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK)
                            {srvBs.supprimerbs(id_projet);
                            
                            }
                                
                               
                                

        afficher();
    }
    private void deletejdida(int k) {
          
          
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Suppresion");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous vraiment supprimer cet article ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK)
                            {srvBs.supprimerbs(k);
                            
                            }
                                
                               
                                

        afficher();
    }

    @FXML
    private void setc(MouseEvent event) {
        
        Connection c=ConnexionBD.getinstance().getcnx();
                 String k="";

        String id_projet ;
        int nbr_sprint;
                id_projet=(C1.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
                nbr_sprint=Integer.valueOf(C3.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
        String id=""+id_projet;
        
        
        
        
        
                text1.setText(id_projet);
                
                text2.setText(""+nbr_sprint);
    }

    @FXML
    private void hoh(ActionEvent event) {
    }
    
    
   
    
    }
    
    
    



   
    

