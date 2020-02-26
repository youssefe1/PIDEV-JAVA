/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import services.Barchart;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class TestController implements Initializable {

    @FXML
    private LineChart<?,?> burndownchart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");       
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
                                
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        
        series.getData().add(new LineChart.Data("Jan", 23));
        series.getData().add(new LineChart.Data("Feb", 14));
        series.getData().add(new LineChart.Data("Mar", 15));
        series.getData().add(new LineChart.Data("Apr", 24));
        series.getData().add(new LineChart.Data("May", 34));
        series.getData().add(new LineChart.Data("Jun", 36));
        series.getData().add(new LineChart.Data("Jul", 22));
        series.getData().add(new LineChart.Data("Aug", 45));
        series.getData().add(new LineChart.Data("Sep", 43));
        series.getData().add(new LineChart.Data("Oct", 17));
        series.getData().add(new LineChart.Data("Nov", 29));
        series.getData().add(new LineChart.Data("Dec", 25));
        
        
        
        lineChart.getData().add(series);
    }    
    
}
