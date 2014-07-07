/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svojak;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 *
 * @author user
 */
public class fxml_property_controller {
    @FXML 
    private Label lblThPr1; 
    
    private Stage dialogStage;
    
    @FXML
    private void initialize() {

    }   
    @FXML
    private void handleOk() {
        dialogStage.close();
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    
}
