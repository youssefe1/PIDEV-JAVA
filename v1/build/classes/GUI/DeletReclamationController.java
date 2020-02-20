/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ServiceDocumentation;
import Services.ServiceReclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DeletReclamationController implements Initializable {
    
     @FXML
    private TextField tfIdReclamation;
    
    @FXML
    private Button supprimerRec;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    
    public void supprimerRec(ActionEvent event){
                int idP = Integer.parseInt(tfIdReclamation.getText());
                ServiceReclamation srv = new ServiceReclamation();
                srv.supprimer(idP);
                    
    
    
    }
    
}
