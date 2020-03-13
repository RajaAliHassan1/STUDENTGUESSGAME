/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentguessgame11;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raja Ali Hassan
 */
public class MainDisplayController implements Initializable {
    @FXML
    private Button start_b;
    @FXML
    private ImageView photo;

    /**
     * Initializes the controller class.
     */   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("/studentguessgame11/download.png");
        photo.setImage(image);
        
    }    

    @FXML
    private void StartButtonPressed(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Student Guess Game");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) start_b.getScene().getWindow();
        stage1.close();
    
    }
}
