package com.example.demo.Service_Interface;

import java.util.Map;

import com.example.demo.Model.Product;

public interface Store_Service_Interface {

    
    //add new product by Admin
    public void addProduct();

    //delete product by Admin
    public void removeProduct();

    //display list of products 
    public void dispsallProduct();

    //display list of products 
    public void displaybyCategory();
    
    //search product by name
    public void searchbyProductId();

    //search product by name
    public void searchbyProductName();

    //display total expenses 
    public void totalExpenses();

    //display total profit 
    public void profitbyCategory();

    //sort by price low to high
    public void sortbyPrice();

}
