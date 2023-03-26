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
import javafx.stage.Stage;


public class FXMLOwnerSceneController implements Initializable {

    @FXML
    private Button bookB;
    @FXML
    private Button customerB;
    @FXML
    private Button logoutB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bookB.setText("Books");
        customerB.setText("Customers");
        logoutB.setText("Logout");
    }    

    @FXML
    private void handleBookB(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLOwnerBooks.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //window.setTitle("Prject2");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void handleCustomerB(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLOwnerCustomers.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void handleLogoutB(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLProject.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //window.setTitle("Prject2");
        window.setScene(scene);
        window.show();
    }
    
}
