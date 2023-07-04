package com.example.demo.Model;

public class User{
    
    private char[] firstname, lastname;
    private char[] email, username, password;
    protected int superCoins;  
    
    String Username, Password;

    //constructors
    public User(){

    }

    //posting a new account to database
    public User(char[] firstname, char[] lastname, char[] username,  char[] email, char[] password){
        this.firstname = firstname; 
        this.lastname = lastname;
        this.username = username; 
        this.email = email; 
        this.password = password; 
    }

    //retrieving an account from database
    public User(String Username, String Password){
        this.username = Username.toCharArray();
        this.password = Password.toCharArray();
    }

    public User(String Username){
        this.username = Username.toCharArray();
     
    }



    //setters and getters
    public char[] getFirstname() {
        return firstname;
    }

    public void setFirstname(char[] firstname) {
        this.firstname = firstname;
    }

    public char[] getLastname() {
        return lastname;
    }

    public void setLastname(char[] lastname) {
        this.lastname = lastname;
    }

    public char[] getEmail() {
        return email;
    }

    public void setEmail(char[] email) {
        this.email = email;
    }

    public char[] getUsername() {
        return username;
    }

    public void setUsername(char[] username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }


}