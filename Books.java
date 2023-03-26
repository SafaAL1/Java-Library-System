/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalphase;

import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Safa
 */
public class Books {
    public String Name; 
    public int Price; 
    int amountOfBooks;
    public CheckBox select;
    
    public Books(String Name,int Price){
        this.Name = Name; 
        this.Price =Price; 
        amountOfBooks=1;
        this.select = new CheckBox();      
        
    }
    public String getName(){
        return Name;
    }
    public int getPrice(){
        return Price;
    }
    public CheckBox getSelect(){
        return select;
    }
    @Override
    public String toString(){
        return Name + " $" + Price;
    }
    
}
