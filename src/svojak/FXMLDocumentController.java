/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svojak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private GridPane gridpaneMain;
    @FXML 
    private Label lblTheme1;
    @FXML 
    private Label lblTheme2;
    @FXML 
    private Label lblTheme3;
    @FXML 
    private Label lblTheme4;
    @FXML 
    private Label lblTheme5;
    
    
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addgridlbl();
    }    
    
    private void addgridlbl(){
    short tournum = ClassProperty.getInstance().TourNumGet();
        for ( int i = 0; i < 5; i++) {
            for ( int j = 0; j < 5; j++) {
                AnchorPane anchorpane = new AnchorPane();                
                Label lblcell = new Label(String.valueOf((j+1)*10*tournum));                
                anchorpane.getChildren().add(lblcell);                
                AnchorPane.setBottomAnchor(lblcell, 0.0);
                AnchorPane.setRightAnchor(lblcell, 0.0);
                AnchorPane.setTopAnchor(lblcell, 0.0);
                AnchorPane.setLeftAnchor(lblcell, 0.0);                
                gridpaneMain.add(anchorpane, j+1, i);
                lblcell.setAlignment(Pos.CENTER);                
                lblcell.setOnMouseClicked(new EventHandler<MouseEvent>(){ 
                  @Override
                  public void handle(MouseEvent arg0) {
                      if (arg0.getButton()== MouseButton.PRIMARY){
                      Label l= (Label)arg0.getSource();
                      l.setText(null);
                      }
                      if (arg0.getButton()== MouseButton.SECONDARY){
                      propertyform();                          
                      }
                }});
            }
        } 
    
    }
    
    private void propertyform(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_property.fxml"));
            Scene scene = new Scene(root);
            Stage secondStage = new Stage(StageStyle.UTILITY);
            secondStage.setTitle("Своя Игра");
            secondStage.setScene(scene);                        
            secondStage.showAndWait();
            
            gridpaneMain.getChildren().remove(6, 31);
            
            lblTheme1.setText(ClassProperty.getInstance().ThemeNameGet(1)); 
            lblTheme2.setText(ClassProperty.getInstance().ThemeNameGet(2)); 
            lblTheme3.setText(ClassProperty.getInstance().ThemeNameGet(3)); 
            lblTheme4.setText(ClassProperty.getInstance().ThemeNameGet(4)); 
            lblTheme5.setText(ClassProperty.getInstance().ThemeNameGet(5));
            
            addgridlbl();
            
            } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }            
    }

    
  
    
}

