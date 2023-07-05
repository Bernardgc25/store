package com.example.demo.Model;

public class Product extends Item{

    protected int productId;
    protected String productName; 
    protected double sellingPrice;
    protected int availQty; 

    //constructors
    public Product(){
        
    }

    //constructor when posting new product in database
    public Product(String productName, String Category, int availQty, double buyingPrice) {
        super(productName, Category, buyingPrice);

        //this.productId = productId; 
        this.ItemName = productName;
        this.availQty = availQty; 
        this.buyingPrice = buyingPrice; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }

    //constructor when retrieving product from database
    public Product(int productId, String productName, String Category, int availQty, double sellingPrice) {
        //super(productName, Category, buyingPrice);

        this.productId = productId; 
        this.ItemName = productName;
        this.availQty = availQty; 
        //this.buyingPrice = buyingPrice; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }

    //constructor when retrieving product from database
    public Product(int productId, String productName, String Category, int availQty, double buyingPrice, double sellingPrice) {
        super(productName, Category, buyingPrice);

        this.productId = productId; 
        this.ItemName = productName;
        this.availQty = availQty; 
        //this.buyingPrice = buyingPrice; 
        this.sellingPrice = (buyingPrice * 0.5) + buyingPrice;
    }




}