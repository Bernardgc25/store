package com.example.demo.Service;

import java.util.Scanner;
import java.util.ArrayList;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Customer;

public class CustomerList_Service {

    private Scanner scanner; 
    public ArrayList<Customer> customerdao = new ArrayList<Customer>();
    //customer functions 
    
    public CustomerList_Service(){
        scanner = new Scanner(System.in);
        customerdao = new ArrayList<Customer>();
    }


    public void insertCustomer(Customer cu){
        customerdao.add(cu);
        System.out.println("you have succesfully register a customer account");
        System.out.println("press a character and Enter to continue");

    }

    public ArrayList<Customer> getCustomerDetail(){
        System.out.println("verifying record from Customer database");  
        System.out.println("\n");  
        return customerdao;
    }

}
