/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import static com.itextpdf.text.Annotation.FILE;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import entities.Backlog_produit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.Barchart;
import services.Pdf;
import static services.Pdf.addContent;
import static services.Pdf.addMetaData;
import static services.Pdf.addTitlePage;
import services.Servicebacklog_pd;
import services.Sound;
import utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PdfgenererController implements Initializable {
    private static String FILE = "C:\\Users\\Asus\\Desktop\\archive\\doc.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
Servicebacklog_pd ps=new Servicebacklog_pd();
        ObservableList<Backlog_produit> obslist;
    @FXML
    private ComboBox<?> combobp;
    @FXML
    private BarChart<?, ?> OffersChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton editbtn;
    private BarChart<?, ?> avanc;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection c=ConnexionBD.getinstance().getcnx();
            List<String> list=new ArrayList<String>();
            PreparedStatement pt;
            combobp.setPromptText("Select project");
            
            
            /*Barchart bcs = new Barchart();
            XYChart.Series set1 = new XYChart.Series<>();
              
             int k=ps.id_projet(combobp);
               System.out.println(k);
            set1.getData().add(new XYChart.Data<>("priorité num 1",bcs.countNbOfferByCpriority(k,1)));
            set1.getData().add(new XYChart.Data<>("priorité num 30",bcs.countNbOfferByCpriority(k,30)));
            set1.getData().add(new XYChart.Data<>("priorité num 60",bcs.countNbOfferByCpriority(k,60)));
            
            
            
            OffersChart.getData().addAll(set1);*/
            
            list=ps.parcourspdf();
            
            
            
            ObservableList oblist=FXCollections.observableList(list);
            combobp.getItems().clear();
            combobp.setItems(oblist);
           
          
        } catch (SQLException ex) {
            Logger.getLogger(PdfgenererController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
         
            
        
               
               
            } 
           
        
 
    @FXML
    private void okpdf(ActionEvent event) throws BadElementException, SQLException {
        
         
      try {
          
          
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);      
            int k=ps.id_projet(combobp);
            addContent(document,k);//generer pdf selon le projet
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void back(ActionEvent event) throws IOException {
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

    @FXML
    private void stat(ActionEvent event) {
         Barchart bcs = new Barchart();
            XYChart.Series set1 = new XYChart.Series<>();
                 OffersChart.getData().clear();
         
             int k=ps.id_projet(combobp);
               System.out.println(k);
            set1.getData().add(new XYChart.Data<>("nb sprint projet num"+k,bcs.avancementsprint(k)));
            /*set1.getData().add(new XYChart.Data<>("priorité num 30",bcs.countNbOfferByCpriority(k,30)));
            set1.getData().add(new XYChart.Data<>("priorité num 60",bcs.countNbOfferByCpriority(k,60)));*/
            
            
            
            OffersChart.getData().addAll(set1);
            
            
  }


}

    
    

       

   
