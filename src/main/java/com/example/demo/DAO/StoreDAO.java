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

    



}
