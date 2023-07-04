package com.example.demo.Service;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Admin;

public class AdminList_Service {
    private Scanner scanner; 
    private List<Admin> Adminlist;
    
    public AdminList_Service(){
        scanner = new Scanner(System.in);
        Adminlist = new ArrayList<Admin>();
    }

    //add admin user to list 
    public void insertAdmin(Admin ad){
        Adminlist.add(ad);
        
    }
    
    //validate admin credentials
    public boolean validate(char[] userName, char[]password){
        
        boolean loggedIn = false;
        for(Admin a : Adminlist) {
            if (a.getUsername().equals(userName) && a.getPassword().equals(password)) {
                loggedIn = true;
                System.out.println("login succesful");

            }
            else{
                System.out.println("invalid credentials !!!");    
                loggedIn = false;
            }
            
        }
        return loggedIn;
     
    }

    
    //display admin detail 
    public List<Admin> getAdminDetail(){
      
        return Adminlist; 
    }



}
