/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package finalphase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class FXMLCustomerSceneController implements Initializable {

    @FXML
    private Label welcomeL;
    @FXML
    private TableView tableView;
    @FXML
    private Button Buy;
    @FXML
    private Button RedBuy;
    @FXML
    private Button Logout;
    
    State state;
    

    Singleton s = Singleton.getInstance(); 
    private int selectedIndex = -1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String status;
        if(s.currentCustomer.getPoints() < 1000 ){
            state=new SilverState();
            status = state.getState();
        } 
        else {
            state=new GoldState();
            status = state.getState();
        }
        welcomeL.setText("Welcome " + s.currentCustomer.getUsername() + ". \nPoints: " + s.currentCustomer.getPoints() + ". Status: " + status);
        
        final ObservableList<Books> data = FXCollections.observableArrayList(s.bookList);
        BookNameCol.setCellValueFactory(new PropertyValueFactory<Books, String>("Name"));
        BookPriceCol.setCellValueFactory(new PropertyValueFactory<Books, String>("Price"));
        SelectCol.setCellValueFactory(new PropertyValueFactory<Books, String>("select"));
        tableView.setItems(data);  

        
    }    

    @FXML
    private TableColumn BookNameCol;
    @FXML
    private TableColumn BookPriceCol;
    @FXML
    private TableColumn SelectCol;
    
    @FXML
    private void handleBuyB(ActionEvent event) throws IOException {
        
        int i, sum=0;
        ArrayList<Integer> remove_list = new ArrayList();
        for(i=0;i<s.bookList.size();i++){
            if (s.bookList.get(i).select.isSelected()){
                sum=sum+s.bookList.get(i).Price;
                remove_list.add(i);
            }
        }
        
        for (i=0;i<remove_list.size();i++){
            int x = (int)remove_list.get(i);
            s.bookList.remove(x-i);
        }
        int newPoints = s.currentCustomer.getPoints() + 10*sum;
        s.currentCustomer.setPoints(newPoints);
        s.total=sum;
        s.ExportBooksData();
        s.ExportCustomersData();
       
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCostScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    private void handleR_B(ActionEvent event) throws IOException {
        int i, sum=0, sum2, remainder=0, total=0;
        ArrayList<Integer> remove_list = new ArrayList();
        for(i=0;i<s.bookList.size();i++){
            if (s.bookList.get(i).select.isSelected()){
                sum=sum+s.bookList.get(i).Price;
                remove_list.add(i);
            }
        }
        
        remainder=s.currentCustomer.getPoints()%100;
        sum2=s.currentCustomer.getPoints()/100;
        
        if (sum>sum2){
            total=sum-sum2;
            s.currentCustomer.setPoints(remainder);
        }
        else{
            total=0;
            s.currentCustomer.setPoints((sum2-sum)*100+remainder);
        }
        
        for (i=0;i<remove_list.size();i++){
            int x = (int)remove_list.get(i);
            s.bookList.remove(x-i);
        }
        s.total=total;
        s.ExportBooksData();
        s.ExportCustomersData();
       
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCostScene.fxml"));
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
        window.setScene(scene);
        window.show();
    }
    
}

