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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FXMLOwnerCustomersController implements Initializable {

    @FXML
    private ListView<Customers> customersView;
    @FXML
    private Label label;
    @FXML
    private Button deleteB;
    @FXML
    private Button backB;
    @FXML
    private TextField usernameTextF;
    @FXML
    private TextField passwordTextF;
    @FXML
    private Button AddB;
    @FXML
    private Text errortxt;

    Singleton s = Singleton.getInstance();
    private int selectedIndex = -1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        customersView.getItems().addAll(s.customersList);
    }    

    @FXML
    private void handleDeleteB(ActionEvent event) {
       selectedIndex = customersView.getSelectionModel().getSelectedIndex();
       s.customersList.remove(selectedIndex);
       customersView.getItems().remove(selectedIndex);
       //label.setText("List Size: " + Integer.toString(s.bookList.size()));
       s.ExportCustomersData();
    }

    @FXML
    private void handleBackB(ActionEvent event) throws IOException {
        //booksView.getItems().removeAll();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLOwnerScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        //window.setTitle("Prject");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void handleAddB(ActionEvent event) {
        int inputcheck=0, i;
        String username = usernameTextF.getText();
        String password = passwordTextF.getText();
        for (i=0;i<s.customersList.size();i++){
            if (s.customersList.get(i).Username.equals(username)){
                inputcheck=1;
            }
        }
        if (username.isEmpty()||password.isEmpty()){
            inputcheck=2;
        }
        
        switch(inputcheck){
            case 1:
                errortxt.setText("user name already exist in data base, please enter a different one");
                break;
            case 2:
                errortxt.setText("please fill both user name and passward boxes");
                break;
            default:
                Customers tem = new Customers(username, password, 0);
                s.customersList.add(tem);
                customersView.getItems().add(tem);
                s.ExportCustomersData();
                errortxt.setText("");
        }
        
        
    }
    
}

