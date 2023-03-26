/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalphase;
/**
 * FXML Controller class
 *
 * @author Safa
 */
public class Customers {
    String Username; 
    String Password; 
    int Points; 
    public Customers(String Username, String Password,int Points){
        this.Username =Username; 
        this.Password = Password; 
        this.Points = Points; 
    }
    public String getUsername(){
        return Username;
    }
    public String getPassword(){
        return Password;
    }
    public int getPoints(){
        return Points;
    }
    public void setPoints(int p){
        Points = p;
    }
    
    @Override
    public String toString(){
        return Username + " " + Password + " " + Points;
    }
    
}
