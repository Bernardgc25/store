package com.example.demo.Model;

public class Customer extends User{

    public Customer(){
        super();

        //default value as welcome bonus
        superCoins = 100;
    }



    public Customer(char[] firstname, char[] lastname, char[] username,  char[] email, char[] password){
        super(firstname, lastname, username, email, password);
           
    }

    //retrieving an account from database
    public Customer(String username, String password){
        super(username, password);

    }
}
