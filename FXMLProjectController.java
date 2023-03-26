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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLProjectController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private Label userName;
    @FXML
    private Label password;
    @FXML
    private TextField userNameTextF;
    @FXML
    private TextField passwordTextF;

    Singleton s = Singleton.getInstance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userName.setText("Username:");
        password.setText("Password:");
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        label.setText("WRONG INFORMATION");
        if(userNameTextF.getText().equals("ADMIN") && passwordTextF.getText().equals("ADMIN")){
            
            Parent root = FXMLLoader.load(getClass().getResource("FXMLOwnerScene.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        else{
            for (int i = 0; i < s.customersList.size(); i++){
                if(s.customersList.get(i).getUsername().equals(userNameTextF.getText())){
                    if(s.customersList.get(i).getPassword().equals(passwordTextF.getText())){
                        label.setText("Hi " + s.customersList.get(i).getUsername());
                        s.currentCustomer = s.customersList.get(i);
                        s.curCus = i;
                        //s.customersList.remove(i);
                        //s.ExportCustomersData();
                        Parent root = FXMLLoader.load(getClass().getResource("FXMLCustomerScene.fxml"));
                        Scene scene = new Scene(root);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene);
                        window.show();
                    }
                }
            }
        }
            
    }
    
}
