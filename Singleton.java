/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalphase;
import java.io.*;
import java.util.*;
//import java.io.File;
import java.util.LinkedList;
//import java.util.Scanner;


public class Singleton {
    private static Singleton single_instance = null;
 
    // Declaring a variable of type String
    public LinkedList<Books> bookList = new LinkedList();
    public LinkedList<Customers> customersList = new LinkedList();
    public Customers currentCustomer;
    public int curCus;
    public int total;
    private Scanner readB;
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private Singleton()
    {
//        bookList.add(new Books("book1", 10));
//        bookList.add(new Books("book2", 40));
//        bookList.add(new Books("book3", 120));
        ImportBooksData();
        ImportCustomersData();
        //ExportBooksData();
    }
 
    // Static method
    // Static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
 
        return single_instance;
    }
    
    public void ImportBooksData(){
        try{
            readB = new Scanner(new File("books.txt"));
        }
        catch(Exception e){
            System.out.println("couldn't find the file");
        }
        
        while (readB.hasNext()){
            String name = readB.next();
            int price = Integer.parseInt(readB.next());
            bookList.add(new Books(name, price));
        }
        readB.close();
    }
    

    
    public void ExportBooksData(){
        try{
            BufferedWriter writeB = new BufferedWriter(new FileWriter("books.txt"));
            for(Books b: bookList){
                writeB.write(b.getName() + " " + b.getPrice());
                writeB.newLine();
            }
            
            writeB.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void ImportCustomersData(){
        try{
            readB = new Scanner(new File("customers.txt"));
        }
        catch(Exception e){
            System.out.println("couldn't find the file");
        }
        
        while (readB.hasNext()){
            String username = readB.next();
            String password = readB.next();
            int points = Integer.parseInt(readB.next());
            customersList.add(new Customers(username, password, points));
        }
        readB.close();
    }
    
    public void ExportCustomersData(){
        try{
            BufferedWriter writeB = new BufferedWriter(new FileWriter("customers.txt"));
            for(Customers c: customersList){
                writeB.write(c.getUsername() + " " + c.getPassword() + " " + c.getPoints());
                writeB.newLine();
            }
            
            writeB.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

