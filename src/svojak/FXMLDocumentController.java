/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svojak;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    List<Integer> bonusList = new ArrayList<Integer>();
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addgridlbl();
    }    
    
    private void addgridlbl(){
    short tournum = ClassProperty.getInstance().TourNumGet();
    int maxTheme = countTheme();
    arrBonus(maxTheme);
        for ( int i = 0; i < maxTheme; i++) {
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
                        if (arg0.getButton() == MouseButton.PRIMARY) {
                            Label lbl = (Label) arg0.getSource();
                            if (bonusList.get(0) == 0) {
                                lbl.setText(null);
                            }
                            else {
                               switch (bonusList.get(0)){
                                   case 1:
                                       Image image = new Image(getClass().getResourceAsStream("auc.png"));
                                       ImageView img = new ImageView(image);
                                       img.fitHeightProperty().bind(lbl.heightProperty());
                                       img.fitWidthProperty().bind(lbl.heightProperty());
                                       lbl.setGraphic(img);
                                       break;
                                   case 2 :
                                       Image image1 = new Image(getClass().getResourceAsStream("cat.png"));
                                       ImageView img1 = new ImageView(image1);
                                       img1.fitHeightProperty().bind(lbl.heightProperty());
                                       img1.fitWidthProperty().bind(lbl.heightProperty());
                                       lbl.setGraphic(img1);
                                    break;
                                   case 3 :
                                       Image image2 = new Image(getClass().getResourceAsStream("gift.png"));
                                       ImageView img2 = new ImageView(image2);
                                       img2.fitHeightProperty().bind(lbl.heightProperty());
                                       img2.fitWidthProperty().bind(lbl.heightProperty());
                                       lbl.setGraphic(img2);
                                    break;
                               }
                               lbl.setText(null);
                            }
                            bonusList.remove(0);                            
                        }
                        if (arg0.getButton() == MouseButton.SECONDARY) {
                            propertyform();
                        }
                }});
            }
        } 
    if (maxTheme<5){
     for ( int i = maxTheme; i < 5; i++) {
            for ( int j = 0; j < 5; j++) {
                AnchorPane anchorpane = new AnchorPane();                
                Label lblcell = new Label("-");                
                anchorpane.getChildren().add(lblcell);                
                AnchorPane.setBottomAnchor(lblcell, 0.0);
                AnchorPane.setRightAnchor(lblcell, 0.0);
                AnchorPane.setTopAnchor(lblcell, 0.0);
                AnchorPane.setLeftAnchor(lblcell, 0.0);                
                gridpaneMain.add(anchorpane, j+1, i);
                lblcell.setAlignment(Pos.CENTER);                
            }
        } 
    }
    }
    private int countTheme(){
    int i = 0;
        if (lblTheme1.getText().length()==0) {
            return i = 0;           
        } else if (lblTheme2.getText().length()==0) {
            return i = 1;
        } else if (lblTheme3.getText().length()==0) {
            return i = 2;
        } else if (lblTheme4.getText().length()==0) {
            return i = 3;
        } else if (lblTheme5.getText().length()==0) {
            return i = 4;
        } else {
            return i = 5;
        }     
    }
    
    
    private void propertyform() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_property.fxml"));
            Scene scene = new Scene(root);
            Stage secondStage = new Stage(StageStyle.UTILITY);
            secondStage.setTitle("Своя Игра");
            secondStage.setScene(scene);
            secondStage.showAndWait();
            if (!(ClassProperty.getInstance().cancelGet())) {
                gridpaneMain.getChildren().remove(6, 31);

                lblTheme1.setText(ClassProperty.getInstance().ThemeNameGet(1));
                lblTheme2.setText(ClassProperty.getInstance().ThemeNameGet(2));
                lblTheme3.setText(ClassProperty.getInstance().ThemeNameGet(3));
                lblTheme4.setText(ClassProperty.getInstance().ThemeNameGet(4));
                lblTheme5.setText(ClassProperty.getInstance().ThemeNameGet(5));

                addgridlbl();
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void arrBonus(int max){
        int iMaxElem = max*5;
        for (int i=0; i<iMaxElem; i++){
         bonusList.add(0);         
        }
        if (ClassProperty.getInstance().bonusAucGet()){
            int randomInt = randomNumber(iMaxElem);
            while(bonusList.get(randomInt)!=0)
                randomInt = randomNumber(iMaxElem);
            bonusList.set(randomInt, 1);            
        }
        if (ClassProperty.getInstance().bonusBlCatGet()){
            int randomInt = randomNumber(iMaxElem);
            while(bonusList.get(randomInt)!=0)
                randomInt = randomNumber(iMaxElem);
            bonusList.set(randomInt, 2);            
        }
        if (ClassProperty.getInstance().bonusSponsorGet()){
            int randomInt = randomNumber(iMaxElem);
            while(bonusList.get(randomInt)!=0)
                randomInt = randomNumber(iMaxElem);
            bonusList.set(randomInt, 3);            
        }
    }
    private int randomNumber(int max){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(max); 
        return randomInt;
    }
    
}

