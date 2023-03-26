/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package finalphase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class FXMLCostSceneController implements Initializable {

//    @FXML
//    private Button LogoutB;
    @FXML
    private Label Total;
    @FXML
    private Label Points;
    @FXML
    private Label Status;

    Singleton s = Singleton.getInstance();
    State state;
    
    @FXML
    private Button logoutB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Total.setText(Integer.toString(s.total));
        String status;
        if(s.currentCustomer.getPoints() < 1000 ){
            state=new SilverState();
            status = state.getState();
        } 
        else {
            state=new GoldState();
            status = state.getState();
        }
        Status.setText(status);
        Points.setText(Integer.toString(s.currentCustomer.getPoints()));
    }    

    @FXML
    private void handleLogoutB(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLProject.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    
}

