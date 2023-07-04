package com.example.demo.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.demo.Service.User_Service;


public class Login { //System.out.println("");

    Scanner scanner = new Scanner(System.in);
    
    public void login_menu(int opt) {
        User_Service logIn = new User_Service(); 
        boolean notDone = true;

        while(notDone){
            //clearscreen
            System.out.print("\033[H\033[2J");  
            System.out.flush();  

            System.out.println("Login.java");
            System.out.println("Log-In Menu");
            System.out.println("");
            System.out.println("Type of user account:");
            System.out.println("0 - Back");
            System.out.println("1 - Admin");
            System.out.println("2 - Customer");

            System.out.println("");
            System.out.print("Enter a choice: ");
            
            try {
                opt = scanner.nextInt();
                //clearscreen
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            
                switch (opt) {
                //login as Admin 
                    case 0:
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        notDone = false; 
                        break; 
                    case 1:
                        logIn.Admin_login();
                        break;
                
                    //login as customer
                    case 2:
                        logIn.Customer_login();
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
        
    }
}
