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

    


}