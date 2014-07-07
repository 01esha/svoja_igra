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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    
    
    private short tournum = 1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    addgridlbl();
    
    }    
    private void addgridlbl(){
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
                //gridpaneMain.setHalignment(lblcell, HPos.CENTER);                
                //lblcell.setMinWidth(Region.USE_PREF_SIZE);
                //lblcell.setMaxWidth(Region.USE_PREF_SIZE);
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
            /*
            GridPane gridPane = new GridPane();
            Scene secondScene = new Scene(gridPane, 400, 400);
            Stage secondStage = new Stage(StageStyle.UTILITY);
            secondStage.setTitle("Настройки");
            secondStage.setScene(secondScene);
            secondStage.setResizable(false);
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            VBox vb = new VBox();
            vb.setSpacing(5.0);
            HBox hbox1 = new HBox();
            Label lblpropTheme1 = new Label("Тема 1:");
            TextField tfTheme1 = new TextField();
            hbox1.getChildren().addAll(lblpropTheme1, tfTheme1);
            HBox hbox2 = new HBox();
            Label lblpropTheme2 = new Label("Тема 2:");
            TextField tfTheme2 = new TextField();
            hbox2.getChildren().addAll(lblpropTheme2, tfTheme2);
            HBox hbox3 = new HBox();
            Label lblpropTheme3 = new Label("Тема 3:");
            TextField tfTheme3 = new TextField();
            hbox3.getChildren().addAll(lblpropTheme3, tfTheme3);
            HBox hbox4 = new HBox();
            Label lblpropTheme4 = new Label("Тема 4:");
            TextField tfTheme4 = new TextField();
            hbox4.getChildren().addAll(lblpropTheme4, tfTheme4);
            HBox hbox5 = new HBox();
            Label lblpropTheme5 = new Label("Тема 5:");
            TextField tfTheme5 = new TextField();
            hbox5.getChildren().addAll(lblpropTheme5, tfTheme5);
            CheckBox cbAuc = new CheckBox();
            cbAuc.setText("Включить в случайное поле 'Аукцион'");
            cbAuc.setSelected(false);
            CheckBox cbBlack = new CheckBox();
            cbBlack.setText("Включить в случайное поле 'Черная кошка'");
            cbBlack.setSelected(false);
            CheckBox cbPrice = new CheckBox();
            cbPrice.setText("Включить в случайное поле 'Вопрос от спонсора'");
            cbPrice.setSelected(false);
            
            
            Button okButton = new Button("Сохранить настройки");
            okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
            
            secondStage.close();
            }
            });
            
            Button noButton = new Button("Отмена");
            noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
            secondStage.close();
            }
            });
            GridPane innergrid = new GridPane();
            innergrid.setAlignment(Pos.CENTER);
            innergrid.add(okButton, 0, 0);
            innergrid.add(noButton, 1, 0);
            vb.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, cbAuc, cbBlack, cbPrice, innergrid);
            gridPane.add(vb, 0, 0);
            secondStage.show();*/
            Parent root = FXMLLoader.load(getClass().getResource("FXML_property.fxml"));
            Scene scene = new Scene(root);
            Stage secondStage = new Stage(StageStyle.UTILITY);
            secondStage.setTitle("Своя Игра");
            secondStage.setScene(scene);
            
            
            secondStage.show();
            
            } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }            
    }
    
}
