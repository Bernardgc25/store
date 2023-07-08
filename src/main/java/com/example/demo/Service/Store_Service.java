package com.example.demo.Service;

import com.example.demo.DAO.StoreDAO;
import com.example.demo.Model.Product;
import com.example.demo.Service_Interface.Store_Service_Interface;
 

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


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

        Map<Integer, Product> map_product = new HashMap<Integer, Product>();
       
        //invoke serviceDAO
        map_product = sdao.displayallProducts();
        
        boolean notDone = true;
        //////
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();   

        
        while(notDone){
            
            if(map_product.isEmpty()){
                System.out.println("list is empty!! ");
            }
            else{
                //display all products in table format
                //System.out.println("list of products:"); 

                System.out.printf("%-20s %-22s %-22s %-15s %-20s %-20s \n", "Product id", "Product Name", "Category", "Qty", "Buying Price", "Selling Price");  
                System.out.println("");

                //iterate over by value hashmap 
                Set<Map.Entry<Integer, Product>> pset = map_product.entrySet();
                for(Map.Entry<Integer, Product> p: pset){
                    //System.out.print(+p.getKey());
                    Product pobj = p.getValue();
             
                    System.out.printf("%-20d %-22s %-22s %-15d %-20.2f %-20.2f \n",  pobj.getProductId(),  pobj.getProductName(), pobj.getCategory(),
                                    pobj.getAvailQty(), pobj.getBuyingPrice(),  pobj.getSellingPrice());
                }
               
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

        /////
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
                Product pobj = i.getValue();


                
            System.out.printf("%-20d %-22s %-22s %-15d %-20.2f %-20.2f \n",  pobj.getProductId(),  pobj.getProductName(), pobj.getCategory(),
                                    pobj.getAvailQty(), pobj.getBuyingPrice(),  pobj.getSellingPrice());
                    

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

        Map<Integer, Product> map_product = new HashMap<Integer, Product>();
       
        //invoke serviceDAO
        map_product = sdao.displayallProducts();
        
        boolean notDone = true;
        //////
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();   

        
        while(notDone){
            
            if(map_product.isEmpty()){
                System.out.println("list is empty!! ");
            }
            else{
                //display all products in table format
                System.out.printf("%-22s %-20s \n", "Category", "Expenses");  
                System.out.println("");

                //sum variables
                double Tsum = 0.0;
                double Vsum = 0.0;
                double Gsum = 0.0;
                double Ssum = 0.0;
                double Esum = 0.0;

                //iterate over by value hashmap 
                Set<Map.Entry<Integer, Product>> pset = map_product.entrySet();
                for(Map.Entry<Integer, Product> p: pset){
                    //System.out.print(+p.getKey());
                    Product pobj = p.getValue();
                    
                    //get sum of each category 
                    if(pobj.getCategory().equals("Toiletry")){
                        Tsum = Tsum  + (pobj.getAvailQty() * pobj.getBuyingPrice());
                        Esum = Esum + (pobj.getAvailQty() * pobj.getBuyingPrice());
                    }
                    else if(pobj.getCategory().equals("Vegetables")){
                        Vsum = Vsum  + (pobj.getAvailQty() * pobj.getBuyingPrice());
                        Esum = Esum + (pobj.getAvailQty() * pobj.getBuyingPrice());
                    }
                    else if(pobj.getCategory().equals("Grocery")){
                        Gsum = Gsum  + (pobj.getAvailQty() * pobj.getBuyingPrice());
                        Esum = Esum + (pobj.getAvailQty() * pobj.getBuyingPrice());
                    }
                    else if(pobj.getCategory().equals("Stationary")){
                        Ssum = Ssum  + (pobj.getAvailQty() * pobj.getBuyingPrice());
                        Esum = Esum + (pobj.getAvailQty() * pobj.getBuyingPrice());
                    }
                    
                    
                }
                    //display profit by category wise, 2 decimal 
                    System.out.printf("%-22s %-20.2f \n", "Toiletry: " , Tsum );
                    System.out.printf("%-22s %-20.2f \n", "Vegetables: " , Vsum );
                    System.out.printf("%-22s %-20.2f \n", "Grocery " , Gsum );
                    System.out.printf("%-22s %-20.2f \n", "Stationary: " , Ssum );
                    
                    System.out.println("");
                    System.out.printf("%-22s %-20.2f \n", "Total Expenses: " , Esum );
                    
                
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


    }

    @Override
    public void profitbyCategory() {

        Map<Integer, Product> map_product = new HashMap<Integer, Product>();
       
        //invoke serviceDAO
        map_product = sdao.displayallProducts();
        
        boolean notDone = true;
        //////
        //clear screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();   

        
        while(notDone){
            
            if(map_product.isEmpty()){
                System.out.println("list is empty!! ");
            }
            else{
                //display all products in table format
                System.out.printf("%-22s %-20s \n", "Category", "Profit");  
                System.out.println("");

                double Tsum = 0.0;
                double Vsum = 0.0;
                double Gsum = 0.0;
                double Ssum = 0.0;
                double Psum = 0.0;

                //iterate over by value hashmap 
                Set<Map.Entry<Integer, Product>> pset = map_product.entrySet();
                for(Map.Entry<Integer, Product> p: pset){
                    //System.out.print(+p.getKey());
                    Product pobj = p.getValue();
                    
                    //get sum of each category 
                    if(pobj.getCategory().equals("Toiletry")){
                        Tsum = Tsum  + (pobj.getAvailQty() * pobj.getSellingPrice());
                        Psum = Psum + (pobj.getAvailQty() * pobj.getSellingPrice());
                    }
                    else if(pobj.getCategory().equals("Vegetables")){
                        Vsum = Vsum  + (pobj.getAvailQty() * pobj.getSellingPrice());
                        Psum = Psum + (pobj.getAvailQty() * pobj.getSellingPrice());
                    }
                    else if(pobj.getCategory().equals("Grocery")){
                        Gsum = Gsum  + (pobj.getAvailQty() * pobj.getSellingPrice());
                        Psum = Psum + (pobj.getAvailQty() * pobj.getSellingPrice());
                    }
                    else if(pobj.getCategory().equals("Stationary")){
                        Ssum = Ssum  + (pobj.getAvailQty() * pobj.getSellingPrice());
                        Psum = Psum + (pobj.getAvailQty() * pobj.getSellingPrice());
                    }
                    
                    
                }
                    //profit by category wise, 2 decimal 
                    System.out.printf("%-22s %-20.2f \n", "Toiletry: " ,Tsum );
                    System.out.printf("%-22s %-20.2f \n", "Vegetables: " ,Vsum );
                    System.out.printf("%-22s %-20.2f \n", "Grocery " , Gsum );
                    System.out.printf("%-22s %-20.2f \n", "Stationary: " ,Ssum );

                    System.out.println("");
                    System.out.printf("%-22s %-20.2f \n", "Total Profits: " ,Psum );
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

    }

    @Override
    public void sortbyPrice() {
      //code here
    }

}
