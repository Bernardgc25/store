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
        //allows to read input including spaces  
        scanner = new Scanner(System.in).useDelimiter("\\n");
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
	
    HashMap<String, Product> map_Product = new HashMap<>();
        /*logic option starts here*/ 
        String category = " ";
        int opt; 

        //prompt user for category
        /*logic option starts here*/ 
        boolean choicenotDone = true;
        while(choicenotDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            //System.out.println("Choose your option: ");
            System.out.println("Category list");
            System.out.println("1 - Display by Grocery");
            System.out.println("2 - Display by Stationary");  
            System.out.println("3 - Display by Toiletry");
            System.out.println("4 - Display by Vegetables");
                
            System.out.println("");
            System.out.print("Enter a choice: ");
            try {
                opt = scanner.nextInt();

                switch (opt){
                    //Display by Grocery
                    case 1: 
                        category = "Grocery";
                        choicenotDone = false; 
                        break;
                    //Display by Stationary
                    case 2:  
                        category = "Stationary";
                        choicenotDone = false;
                        break;
                    //Display by Toiletry
                    case 3:
                        category = "Toiletry";
                        choicenotDone = false;    
                        break;
                    //Display by Vegetables
                    case 4:
                        category = "Vegetables";
                        choicenotDone = false;   
                        break;           

                    default: 
                        choicenotDone = true; 
                       
                    }       
            
                    
            } 
            
            //wrong input, choose only 0-4
            catch (InputMismatchException e) {
                 
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                     
                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");
        
                char choice = scanner.next().charAt(0);
                    if((choice == 'c') || (choice == 'C')){
                        System.out.println("Back to Option Menu");
                        choicenotDone = true; 
                    }
                   
            }         
                
        }
        

        /*Display category logic start here*/
         
        //invoke DAO
   
        map_Product = sdao.displaybyCategory(category);

        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();   
        
        
        boolean notDone = true;
        while(notDone){
            //System.out.println("list is NOT EMPTY!! ");
              
            //display all products in table format
            System.out.printf("%-20s %-22s %-22s %-15s %-20s %-20s \n", "Product id", "Product Name", "Category", "Qty", "Buying Price", "Selling Price");  
            System.out.println("");
                    
                     
                  

            //iterate over by value hashmap 
            //Map<String, Item> map_item = new HashMap<>();
            Set<Map.Entry<String, Product>> iset = map_Product.entrySet();
            for(Map.Entry<String, Product> i: iset){
                Product iobj = i.getValue();


                
            System.out.printf("%-20d %-22s %-22s %-15d %-20.2f %-20.2f \n",  iobj.getProductId(),  iobj.getProductName(), iobj.getCategory(),
                                    iobj.getAvailQty(), iobj.getBuyingPrice(),  iobj.getSellingPrice());
                    

            //System.out.printf("%-20s %-22s %.2f \n", iobj.getItemname(), iobj.getCategory(), iobj.getBuyingPrice()); 
            //System.out.println("");
            
            }
        
               
            
          
                //only accepts m
                boolean wrongcharacter = true;  
                while(wrongcharacter){
                    //prompt user to search again
                    System.out.println("");
                    System.out.print("(M) go back to menu: ");
                    //System.out.println("");
                    //System.out.print("Enter a choice: ");

                    char choice = scanner.next().charAt(0);
                    Character m = 'm';
                    Character M = 'M';
                
                    if (m.equals(choice) || M.equals(choice)){
                        notDone = false;
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
         /*Display category logic ends here*/

       
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
                //allows to read input including spaces  
                //scanner = new Scanner(System.in).useDelimiter("\\n");
                String productName = scanner.next();            

                Product sp = sdao.searchProductName(productName);
                

                //product Name does not exist in database
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
                //product Name found
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
      
                    }
                    else if (s.equals(choice) || S.equals(choice)) {
                        searchnotDone = true;
           
                    }
                    else{
                         //clear screen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        
                        System.out.println("Invalid Character !");
                        searchnotDone = true;
                        
               
                    }
  
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
