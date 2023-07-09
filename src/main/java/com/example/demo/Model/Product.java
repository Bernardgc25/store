package com.example.demo.Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class Product extends Item implements Comparable<Product>{

    protected int productId;
    protected String productName; 
    protected double sellingPrice;
    protected int availQty;


    //constructors
    public Product(){
        
    }

    //constructor when posting new product in database
    public Product(int productId, String productName, String Category, int availQty, double buyingPrice) {
        super(productName, Category, buyingPrice);

        this.productId = productId; 
        this.productName = productName;
        this.availQty = availQty; 
        this.buyingPrice = buyingPrice; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }

    //constructor when retrieving product from database
    public Product(int productId, String productName, String Category, int availQty, double buyingPrice, double sellingPrice) {
        super(productName, Category, buyingPrice);

        this.productId = productId; 
        this.productName = productName;
        this.availQty = availQty; 
        this.buyingPrice = buyingPrice; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }

    //constructor when retrieving product from database
    public Product(String Category, int availQty, double buyingPrice, double sellingPrice) {
        super(Category);

        this.availQty = availQty; 
        this.buyingPrice = buyingPrice; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    

    public String getCategory() {
        return Category;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getAvailQty() {
        return availQty;
    }

    public void setAvailQty(int availQty) {
        this.availQty = availQty;
    }

    /* 
    @Override
    public int compareTo(Product arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    */

    
    
    //compare by price 
    @Override
    public int compareTo(Product p) {
       
     //   return Double.compare(this.getSellingPrice(), p.sellingPrice);
     return 0; 
    }
    
    
    
  
}