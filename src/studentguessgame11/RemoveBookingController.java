/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentguessgame11;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dawar Mustaqeem
 */
public class RemoveBookingController implements Initializable {
    @FXML
    private ImageView imageview;
    @FXML
    private TextArea Student_name_text;
    @FXML
    private Button STARTOVER_BUTTON;

    /**
     * Initializes the controller class.
     */    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Image image = new Image("/studentguessgame11/download.png");
        this.imageview.setImage(image);
        String read2;
        FileReader file2 = null;
        Scanner in2 = null;
        
        try {
            
        file2 = new FileReader("st_name.txt");
        in2 = new Scanner(file2);

        while (in2.hasNext()) {
            
            read2 = in2.nextLine();
            this.Student_name_text.setText(read2);
        }

        in2.close();
        file2.close();
        }
        catch(Exception ee){   
            JOptionPane.showMessageDialog(null, "Exception Caught STUDENT NAME DISPLAY FXML");
        }

    }    

    @FXML
    private void STARTOVER_BU_PRESSED(ActionEvent event) {
        
           Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainDisplay.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Student Guess Game");
        stage.setScene(scene);
        stage.show();

        Stage stage1 = (Stage) STARTOVER_BUTTON.getScene().getWindow();
        stage1.close();
    
    
    
    }
    
}
