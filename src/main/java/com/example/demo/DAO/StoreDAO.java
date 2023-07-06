package com.example.demo.DAO;

import java.io.CharArrayReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

import com.example.demo.Util.DataConnect;
import com.example.demo.Model.Item;
import com.example.demo.Model.Product;

import java.util.Scanner;

//this class will access database Store
public class StoreDAO {
    Scanner scanner = new Scanner(System.in);
    
    Connection con; 

    public StoreDAO(){
        con = DataConnect.getconnect(); 
       
    }

    //retrieve product by productID
    public Product searchProdId(int productId){
        
        try {
            String sql = "SELECT * from Product where productID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                
            ps.setInt(1, productId);
  
            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){
            
                return new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("Category"), 
                        rs.getInt("availQty"), rs.getDouble("buyingPrice"), rs.getDouble("sellingPrice"));
            }               
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }       
            return null;     
    }



    //retrieve product by productName
    public Product searchProductName(String productName){
    
        try {
            String sql = "SELECT * from Product where productName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                
            ps.setString(1, productName);
            
            //accept character array as parameter ex: char[] productName
            //ps.setCharacterStream(1, new CharArrayReader(productName));

            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){
              
                return new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("Category"), 
                        rs.getInt("availQty"), rs.getDouble("buyingPrice"), rs.getDouble("sellingPrice"));
            }       
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
            
            return null; 
    }


    //display item by category, hashamp return method 
    public HashMap<String, Product>displaybyCategory(String category){
        HashMap<String, Product> map_Product = new HashMap<>();
        Product p; 
    
        try {
            String sql = "select * from Product where Category = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            //database query 
            ps.setString(1, category);
  
            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){


               // return new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("Category"), 
               //         rs.getInt("availQty"), rs.getDouble("buyingPrice"), rs.getDouble("sellingPrice"));

                int ProductId = rs.getInt("productId");
                String productName = rs.getString("productName"); 
                String Category = rs.getString("Category");
                int availQty = rs.getInt("availQty");
                double buyingPrice = rs.getDouble("buyingPrice");
                //double sellingPrice = rs.getDouble("sellingPrice");

                //public Product(String productName, String Category, int availQty, double buyingPrice)
                p = new Product(ProductId, productName, Category, availQty, buyingPrice);

                //key value productName
                map_Product.put(productName, p);
            }
            return map_Product;
                        
        }
        catch (SQLException e) {
               System.out.println(e.getMessage());
        }
            
            return null;
         
    }



}
