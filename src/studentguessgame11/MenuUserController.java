/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentguessgame11;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dawar Mustaqeem
 */
public class MenuUserController implements Initializable {
    @FXML
    private TextField QUESTION;
    @FXML
    private Button NextQuestion_B;
    @FXML
    private ImageView imageview;
    @FXML
    private CheckBox YES_BUTTON;
    @FXML
    private CheckBox RADIO_NO;

    Tree tree;
    Vertex temp;
    int  i =0;
        
    /**
     * Initializes the controller class.
     */@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.RADIO_NO.setSelected(false);
        this.YES_BUTTON.setSelected(false);
        Image image = new Image ("/studentguessgame11/download.png");
        this.imageview.setImage(image);
        tree = new Tree();
        //populating the Tree with questions

        String read;
        String[] parsed = new String[10];
        FileReader file = null;
        Scanner in = null;

        try {

            file = new FileReader("TreeData.txt");
            in = new Scanner(file);

            while (in.hasNext()) {

                read = in.nextLine();

                parsed = read.split("&");
                Vertex new_vertex = new Vertex(parsed[1], Integer.parseInt(parsed[0]));
                this.tree.add(new_vertex);

                parsed = null; // Clearing the Array of String
            }

            in.close();
            file.close();
        } catch (Exception ee) {

            JOptionPane.showMessageDialog(null, "Exception Caught IN POPULATING TREE");
        }

        //POPULATING THE TREE WITH THE ACTIONS(ADDING STUDENTS IN THE LEAF NODES)
        String read2 = null;
        FileReader file2 = null;
        Scanner in2 = null;

        try {

            file2 = new FileReader("StudentData.txt");
            in2 = new Scanner(file2);

            while (in2.hasNext()) {

                read2 = in2.nextLine();
        
                this.tree.addStudent(read2);

            }

            in2.close();
            file2.close();
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Exception Caught IN POPULATING STUDENT");
        }

        this.temp = tree.root;
        this.QUESTION.setText(temp.data);

    }

    @FXML
    private void NextQ_Pressed(ActionEvent event) {
    //right is no 
        //left is yes

        i++;
        if (this.YES_BUTTON.isSelected()) {
            
            this.RADIO_NO.setSelected(false);
            this.YES_BUTTON.setSelected(false);
        
            //nodata handling 
         
            if(this.temp.left == null){
            
           
                JOptionPane.showMessageDialog(null, "NO SUCH STUDENT IN THE DATABASE");
            
            }
            
            if (this.temp.left.isStudent) {

                PrintWriter writer;

                try {
                  
                    writer = new PrintWriter("st_name.txt");
                    writer.println(this.temp.left.data);
                    writer.close();
                }
                
                catch (Exception ee) {
                }

                Next_gui();

            } 
            
            else {

                this.temp = this.temp.left;
                this.QUESTION.setText(this.temp.data);
            }
 }
        if (RADIO_NO.isSelected()) {
          
          
            
            this.RADIO_NO.setSelected(false);
            this.YES_BUTTON.setSelected(false);
        
            //nodata handling 
         
            if(this.temp.right == null){
            
                JOptionPane.showMessageDialog(null, "NO SUCH STUDENT IN THE DATABASE");
            
            }
            
            if (this.temp.right.isStudent) {
          
            
                //Print Student Name
                PrintWriter writer;

                try {

                    writer = new PrintWriter("st_name.txt");
                    writer.println(this.temp.right.data);
                
                    writer.close();
                } catch (Exception ee) {
                    
                }

                Next_gui();

            } else {

                this.temp = this.temp.right;
                this.QUESTION.setText(this.temp.data);
                this.QUESTION.autosize();
                
            }
        }
        
    }


    @FXML
    private void Next_gui() {


        
        ActionEvent event;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("RemoveBooking.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setTitle("Student Guess Game");
        stage.setScene(scene);
        stage.show();

    }

}