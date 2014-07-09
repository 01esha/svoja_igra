/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svojak;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author user
 */
public class fxml_property_controller {
    @FXML 
    private TextField tfTheme1; 
    @FXML 
    private TextField tfTheme2;
    @FXML 
    private TextField tfTheme3;
    @FXML 
    private TextField tfTheme4;
    @FXML 
    private TextField tfTheme5;
    @FXML 
    private Button btnOK;
    
    
    @FXML
    private void initialize() {

    }   
    
    @FXML
    protected void handleOk() {
        //dialogStage.close();
    ClassProperty.getInstance().ThemeNameSet(tfTheme1.getText());
    Stage stage = (Stage) btnOK.getScene().getWindow();    
    stage.close();
    }
    
    @FXML
    private void handleCancel() {
       
    }
    
    
}
