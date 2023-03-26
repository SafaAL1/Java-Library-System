/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package finalphase;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FXMLOwnerBooksController implements Initializable {

    @FXML//takes info from FXML
    private ListView<Books> booksView;
    //LinkedList bookList = new LinkedList();
    Singleton s = Singleton.getInstance();
    @FXML
    private Label label;
    @FXML
    private Button deleteB;
    
    private int selectedIndex = -1;
    @FXML
    private Button backB;
    @FXML
    private TextField bookNameTextF;
    @FXML
    private TextField bookPriceTextF;
    @FXML
    private Button AddB;
    @FXML
    private Text errortxt;
    //ObservableList<Books> list = 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        booksView.getItems().addAll(s.bookList);

    }    

    
    
    @FXML
    private void handleDeleteB(ActionEvent event) {
       selectedIndex = booksView.getSelectionModel().getSelectedIndex();
       s.bookList.remove(selectedIndex);
       booksView.getItems().remove(selectedIndex);
       s.ExportBooksData();
    }

    @FXML
    private void handleBackB(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLOwnerScene.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void handleAddB(ActionEvent event) {
        int inputcheck=0;
        String name = bookNameTextF.getText();
        String p = bookPriceTextF.getText();
        
        try{
            int price = Integer.parseInt(p);
            if (price<1){
                inputcheck=2;
            }
        }
        catch (Exception e){
            inputcheck=2;
        }
        if (name.isEmpty()||p.isEmpty()){
            inputcheck=1;
        }
        
        switch(inputcheck){
            case 1:
                errortxt.setText("please fill both book name and book price boxes");
                break;
            case 2:
                errortxt.setText("please enter a integer value more than $0 as price");
                break;
            default:
                Books tem = new Books(name, Integer.parseInt(p));
                s.bookList.add(new Books(name, Integer.parseInt(p)));
                booksView.getItems().add(tem);
                s.ExportBooksData();
                errortxt.setText("");
                break;
        }
        
    }
    
}
