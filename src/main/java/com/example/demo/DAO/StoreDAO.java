package com.example.demo.DAO;

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
    
    Connection con; 

    public StoreDAO(){
        con = DataConnect.getconnect(); 
       
    }

    Scanner scanner = new Scanner(System.in);

}
