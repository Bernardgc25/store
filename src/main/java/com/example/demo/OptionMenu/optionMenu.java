package com.example.demo.OptionMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.demo.Client.Application;
import com.example.demo.Service.Store_Service;


public class optionMenu {
    
    public optionMenu(){

    }

    Scanner scanner = new Scanner(System.in);
    Store_Service sm = new Store_Service(); 

    //console menu
    public int adminMenu(int opt){
        boolean notDone = true;
        
        while(notDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            //System.out.println("Choose your option: ");
            System.out.println("Admin Option Menu");
            System.out.println("0 - Exit Option Menu");
            System.out.println("1 - Search a product by productID");
            System.out.println("2 - Search a product by productName");  
            System.out.println("3 - Display all products");
            System.out.println("4 - Display products by Category");
            System.out.println("5 - Display total Expenses");
            System.out.println("6 - Display total Profits");
            
            
            System.out.println("");
            System.out.print("Enter a choice: ");
            try {
                opt = scanner.nextInt();

                switch (opt){
                //Exit Option Menu
                case 0: 
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();

                    notDone = false; 
                    break; 
                //Search a product by productID
                case 1: 
                    sm.searchbyProductId();
                    break;
                //Search a product by productName
                case 2:  
                    sm.searchbyProductName();
                    break;
                //Display all products
                case 3:
                    sm.dispsallProduct();
                    break;
                //Display products by Category
                case 4:
                    sm.displaybyCategory(); 
                    break;
                //Display total Expenses
                case 5:
                    sm.totalExpenses(); 
                    break;
                //Display Profits
                case 6:
                    sm.profitbyCategory();
                    break;                    
                }       
            } 
            catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");
    
                char choice = scanner.next().charAt(0);

                choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                    notDone = true; 
                }
            }

            
        }
        
        return opt;    
    }


    public int customerMenu(int opt){
    boolean notDone = true;
        
        while(notDone){
            //clear screen
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            //System.out.println("Choose your option: ");
            System.out.println("Customer Option Menu");
            System.out.println("0 - Exit Option Menu");
            System.out.println("1 - Display products by price (sorted low-high)");
            System.out.println("2 - Display products by Category");
                        
            System.out.println("");
            System.out.print("Enter a choice: ");
            try {
                opt = scanner.nextInt();

                switch (opt){
                //Exit Option Menu
                case 0: 
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();

                    notDone = false; 
                    break; 
                //Search a product by productID
                case 1: 
                   // sm.searchbyProductId();
                    break;
                //Display products by Category
                case 2:
                   // sm.displaybyCategory(); 
                    break;
                }       
            } 
            catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");
    
                char choice = scanner.next().charAt(0);

                choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                    notDone = true; 
                }
            }
        }
        
        return opt;   
    }



}

