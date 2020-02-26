/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import services.Barchart;
import services.Servicebacklog_pd;
import utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AvancementController implements Initializable {
Servicebacklog_pd ps=new Servicebacklog_pd();
    @FXML
    private BarChart<?, ?> sprint;
    @FXML
    private BarChart<?, ?> tache;
    @FXML
    private JFXComboBox<?> cbp;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton addbtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        Connection c=ConnexionBD.getinstance().getcnx();
        List<String> list=new ArrayList<String>();
        PreparedStatement pt;
        list=ps.parcourspdf();
        
        
        
        ObservableList oblist=FXCollections.observableList(list);
        cbp.getItems().clear();
        cbp.setItems(oblist);
        
        
    } catch (SQLException ex) {
        Logger.getLogger(AvancementController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    

    @FXML
    private void affsprint(ActionEvent event) {
         Barchart bcs = new Barchart();
            XYChart.Series set1 = new XYChart.Series<>();
                 sprint.getData().clear();
         
             int k=ps.id_projet(cbp);
               System.out.println(k);
            set1.getData().add(new XYChart.Data<>("nb sprint projet num"+k,bcs.avancementsprint(k)));
            
            
            
            
            sprint.getData().addAll(set1);
    }

    @FXML
    private void afftache(ActionEvent event) {
         Barchart bcs = new Barchart();
            XYChart.Series set1 = new XYChart.Series<>();
                 tache.getData().clear();
         
             int k=ps.id_projet(cbp);
               System.out.println(k);
            set1.getData().add(new XYChart.Data<>("nb taches faites projet num"+k,bcs.avancementtache(k)));
            
            
            
            
            tache.getData().addAll(set1);
    }
    
}
