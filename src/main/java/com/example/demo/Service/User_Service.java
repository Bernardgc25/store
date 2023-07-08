package com.example.demo.Service;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Customer;
import com.example.demo.DAO.AdminDAO;
import com.example.demo.DAO.CustomerDAO;
import com.example.demo.OptionMenu.optionMenu;
import com.example.demo.Service_Interface.User_Service_Interface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User_Service implements User_Service_Interface{
    //user input 
    char[] firstName, lastName; 
    char[] un, useremail, pwd;

    Scanner scanner;
    
    //AdminList_Service admL; 
    //CustomerList_Service custL; 
    
    AdminDAO adao;
    CustomerDAO cdao;
    
    public User_Service()
    {
        //allows to read input including spaces  
        scanner = new Scanner(System.in).useDelimiter("\\n");
  
        //admL = new AdminList_Service();
        adao = new AdminDAO(); 
        cdao = new CustomerDAO();



        //custL = new CustomerList_Service();
    }
                        

    @Override
    public void register_menu(int opt) {
        boolean notDone = true;
        char choice = '\0';

        while(notDone){
            //clearscreen
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            
            System.out.println("UserDA0implement.java");  
            System.out.println("Register Menu:");
            System.out.println("");
            System.out.println("0 - Back to Login-Menu");
            System.out.println("1 - register as a Admin");
            System.out.println("2 - register as a Customer");

            System.out.println("");
            System.out.print("Enter your option: ");

            //try and catch here
            try {
                opt = scanner.nextInt();

                System.out.print("\033[H\033[2J");  
                System.out.flush();  

                //register an Admin account
                switch(opt){
                    //exit menu
                    case 0:
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        notDone = false; 
                    break; 
                    //register as Admin 
                    case 1:
                        //admin object
                        Admin ad = new Admin();

                        System.out.println("you are registering for an Admin account");
                        System.out.println("");
                        //save input into variable including spaces 
                        //scanner.nextLine(); 
                        
                        //read character array as input, read including spaces
                        //char[] Name = scanner.nextLine().toCharArray();

                        System.out.print("Enter firstName: ");
                        ad.setFirstname(scanner.next().toCharArray());

                        System.out.print("Enter lastName: ");
                        ad.setLastname(scanner.next().toCharArray());

                        System.out.print("Enter Email: ");
                        ad.setUsername(scanner.next().toCharArray());
                        
                        System.out.print("Enter userName: ");
                        ad.setEmail(scanner.next().toCharArray());
                        
                        System.out.print("Enter password: ");
                        ad.setPassword(scanner.next().toCharArray());


                        //create account to database
                        adao.insertAdmin(ad); 

                        //add to Administrator list
                        //admL.insertAdmin(ad);

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        //display info
                        System.out.println("you have succesfully register an Admin account");
                        System.out.println("press a character and Enter to continue");
                     
                        choice = scanner.next().charAt(0);
                        if((choice == 'c') || (choice == 'C')){
                            System.out.println("Back to Option Menu");
                            notDone = true; 
                        } 

                    break;
                
                    //register as customer
                    case 2:
                        Customer cu = new Customer();    

                        System.out.println("you are registering for an Customer account");
                        System.out.println("");
                        //save input into variable including spaces 
                        //scanner.nextLine(); 
                        
                        //read character array as input, read including spaces
                        //char[] Name = scanner.nextLine().toCharArray();

                        System.out.print("Enter firstName: ");
                        cu.setFirstname(scanner.next().toCharArray());

                        System.out.print("Enter lastName: ");
                        cu.setLastname(scanner.next().toCharArray());

                        System.out.print("Enter Email: ");
                        cu.setUsername(scanner.next().toCharArray());
                        
                        System.out.print("Enter userName: ");
                        cu.setEmail(scanner.next().toCharArray());
                        
                        System.out.print("Enter password: ");
                        cu.setPassword(scanner.next().toCharArray());

                        //add to customerlist invoke CustomerDAO
                        cdao.insertCustomer(cu);
                
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        //display info
                        System.out.println("you have succesfully register an Customer account");
                        System.out.println("press a character and Enter to continue");
                        choice = scanner.next().charAt(0);
                        if((choice == 'c') || (choice == 'C')){
                            System.out.println("Back to Option Menu");
                            notDone = true; 
                        } 

                    break;
                }                
            } 
            catch (InputMismatchException e) {
                //clear screen
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");
            
                choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                    notDone = true; 
                } 
            }
        }
    }

    @Override
    public void Admin_login() {
        //validate admin credentials 
        optionMenu adMenu = new optionMenu(); 
      
        System.out.print("Enter username: ");
        un = scanner.next().toCharArray();

        System.out.print("Enter password: ");
        pwd = scanner.next().toCharArray();
        
        System.out.print("\033[H\033[2J");  
		System.out.flush();  

        //validate user credentials          
        Admin adminValidated = adao.validateAdmin(un, pwd);

            //username and password does not exist in database
            if (adminValidated == null){
                System.out.println("Incorrect Username or Password");    
                
                //ask user again
                System.out.println("press a character and Enter to continue");
                char choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                }

            }
            //username and password exist in database
            else {
                System.out.println("Login in Successful");   
                
                
            //menu option for administrator
            int adMenu_Value; 
            int opt = 0; 

                //admin option 
                boolean notdone = true; 
                    while(notdone){
                    adMenu_Value =  adMenu.adminMenu(opt);

                        if (adMenu_Value == 0 ){
                            notdone = false; 
                        }    
                        //clearscreen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();          
                    }
            }
                
    }

    @Override
    public void Customer_login() {

        //validate admin credentials 
        optionMenu cuMenu = new optionMenu(); 
      
        System.out.print("Enter username: ");
        un = scanner.next().toCharArray();

        System.out.print("Enter password: ");
        pwd = scanner.next().toCharArray();
        
        System.out.print("\033[H\033[2J");  
		System.out.flush();  

        //validate user credentials          
        Customer customerValidated = cdao.validateCustomer(un, pwd);

            //username and password does not exist in database
            if (customerValidated == null){
                System.out.println("Incorrect Username or Password");    
                
                //ask user again
                System.out.println("press a character and Enter to continue");
                char choice = scanner.next().charAt(0);
                if((choice == 'c') || (choice == 'C')){
                    System.out.println("Back to Option Menu");
                }

            }
            //username and password exist in database
            else {
                System.out.println("Login in Successful");   
                
                
            //menu option for administrator
            int cuMenu_Value; 
            int opt = 0; 

                //admin option 
                boolean notdone = true; 
                    while(notdone){
                    cuMenu_Value =  cuMenu.customerMenu(opt);

                        if (cuMenu_Value == 0 ){
                            notdone = false; 
                        }    
                        //clearscreen
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();          
                    }
            }
                
    
    }
    
}
