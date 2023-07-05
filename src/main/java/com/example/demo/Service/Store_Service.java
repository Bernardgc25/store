package com.example.demo.Service;

import java.lang.*;
import com.example.demo.DAO.AdminDAO;
import com.example.demo.DAO.StoreDAO;
import com.example.demo.Model.Item;
import com.example.demo.Model.Product;
import com.example.demo.Service_Interface.Store_Service_Interface;
 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Store_Service implements Store_Service_Interface{
    Scanner scanner;
    StoreDAO sdao; 

    //constructor
    public Store_Service(){
        scanner = new Scanner(System.in);
        sdao = new StoreDAO();
    }


    @Override
    public void addProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public void removeProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProduct'");
    }

    @Override
    public void dispsallProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispsallProduct'");
    }

    @Override
    public void displaybyCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displaybyCategory'");
    }

    @Override
    public void searchbyProductId() {

        boolean searchnotDone = true;
        
        while(searchnotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter productId to search: ");
            
            try {
                int prodId = scanner.nextInt();

                //search product id database
                Product sp = sdao.searchProdId(prodId);

                //product Id does not exist in database
                if (sp == null){
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    
                    System.out.println("Product Id does not exist");    

                    //ask user again
                    System.out.println("press a character and Enter to continue");
                    char choice = scanner.next().charAt(0);

                    //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();

                }
                //product Id found
                //display info
                else {
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
             
                    //display in table format, and 2 decimal places
                    System.out.printf("%-20s %-22s %-22s %-15s %-20s %-20s \n", "Product id", "Product Name", "Category", "Qty", "Buying Price", "Selling Price");  
                    System.out.println("");
                    
                     
                    System.out.printf("%-20d %-22s %-22s %-15d %-20.2f %-20.2f \n",  sp.getProductId(),  sp.getProductName(), sp.getCategory(),
                                    sp.getAvailQty(), sp.getBuyingPrice(),  sp.getSellingPrice());
                    
                   
                }        

            } catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input, integer only");
            }
               
                //only accepts s or m
                boolean wrongcharacter = true;  
                while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.println("(S) search for product Id");
                    System.out.println("(M) go back to menu: ");
                    System.out.println("");
                    System.out.print("Enter a choice: ");

                    char choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                    Character s = 's';
                    Character S = 'S';
                
                    if (m.equals(choice) || M.equals(choice)){
                        searchnotDone = false; 
                        wrongcharacter = false; 
                    }
                    else if (s.equals(choice) || S.equals(choice)) {
                        searchnotDone = true;
                        wrongcharacter = false; 
                    }
                    else{
                         //clear screen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        
                        System.out.println("Invalid Character !");
                        wrongcharacter = true; 
                    }
                }                    
        }     

    }

    @Override
    public void searchbyProductName() {
    boolean searchnotDone = true;
        
        while(searchnotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            System.out.print("Enter product Name to search: ");
     
            
            try {
            
                //String productName = scanner.nextLine(); 
                //scanner.nextLine();
                
                //String productName = scanner.next(); 
                //scanner.nextLine();

                //char[] productName = scanner.nextLine().toCharArray();
                char[] productName = scanner.nextLine().toCharArray();
          

                //search product id database
                Product sp = sdao.searchProductName(productName);

                //product Id does not exist in database
                if (sp == null){
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    
                    System.out.println("Product Name does not exist");    

                    //ask user again
                    System.out.println("press a character and Enter to continue");
                    char choice = scanner.next().charAt(0);

                    //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
            
                }
                //product Id found
                //display info
                else {
                     //clear screen
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                     
                    //display in table format, and 2 decimal places
                    System.out.printf("%-20s %-22s %-22s %-15s %-20s %-20s \n", "Product id", "Product Name", "Category", "Qty", "Buying Price", "Selling Price");  
                    System.out.println("");
                    
                     
                    System.out.printf("%-20d %-22s %-22s %-15d %-20.2f %-20.2f \n",  sp.getProductId(),  sp.getProductName(), sp.getCategory(),
                                    sp.getAvailQty(), sp.getBuyingPrice(),  sp.getSellingPrice());
                    
                    
            
                    System.out.println("");
                    
                }        
      
            } catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input");
            }

            
                //only accepts s or m
               // boolean wrongcharacter = true;  
               // while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.println("(S) search for product Name");
                    System.out.println("(M) go back to menu: ");
                    System.out.println("");
                    System.out.print("Enter a choice: ");

                    char choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                    Character s = 's';
                    Character S = 'S';
                
                    if (m.equals(choice) || M.equals(choice)){
                        searchnotDone = false; 
                        //wrongcharacter = false; 
                    }
                    else if (s.equals(choice) || S.equals(choice)) {
                        searchnotDone = true;
                        //wrongcharacter = false; 
                    }
                    else{
                         //clear screen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        
                        System.out.println("Invalid Character !");
                        searchnotDone = true;
                        
                        //wrongcharacter = true; 
                    }
                //}
               
       
                    
              
            
        }     

     
    }

    @Override
    public void totalExpenses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalExpenses'");
    }

    @Override
    public void profitbyCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'profitbyCategory'");
    }

    @Override
    public void sortbyPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortbyPrice'");
    }

}
