package com.example.demo.Model;

public class Admin extends User{
    
    //constructors
    public Admin(){
        super();
    }

    //posting a new account to database
    public Admin(char[] fname, char[] lname, char[] uname,  char[] uemail, char[]pwd){
        super(fname, lname, uname, uemail, pwd);
    }

    //retrieving an account from database
    public Admin(String Username, String Password){
        super(Username, Password);
    }

    public Admin(String Username){
        super(Username);
     
    }


}
