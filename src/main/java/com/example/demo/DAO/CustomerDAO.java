package com.example.demo.DAO;

import java.io.CharArrayReader;
import java.sql.*;
import com.example.demo.Util.DataConnect;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Customer;


public class CustomerDAO {
    Connection con; 


    public CustomerDAO(){
        con = DataConnect.getconnect(); 
    }
  
    public void insertCustomer(Customer cu){
        try{
            String sql = "INSERT into Customer(firstname,lastname,username,email,password) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setCharacterStream(1, new CharArrayReader(cu.getFirstname()));
            ps.setCharacterStream(2, new CharArrayReader(cu.getLastname()));
            ps.setCharacterStream(3, new CharArrayReader(cu.getEmail()));
            ps.setCharacterStream(4, new CharArrayReader(cu.getUsername()));
            ps.setCharacterStream(5, new CharArrayReader(cu.getPassword()));
            
            ps.executeUpdate();
            
            int result = ps.executeUpdate();
            if(result>0){
				System.out.println("Insert successfully");
			}
			else{
				System.out.println("not inserted");
			}
            
        }
        catch(SQLException ex){
                System.out.println(ex.getMessage());
        }       
    }



    //retrieve username and password from database
    public Customer validateCustomer(char[] un, char[] pwd){
        
    
        try {
            String sql = "SELECT * FROM Customer  WHERE Username = ? and Password = ?";
                
            PreparedStatement ps = con.prepareStatement(sql);

            //ps.setCharacterStream(1, new CharArrayReader(userName));
            //ps.setCharacterStream(2, new CharArrayReader(password));
           
            ps.setString(1, String.valueOf(un));
            ps.setString(2, String.valueOf(pwd));

            ResultSet rs = ps.executeQuery(); 
                  
            while( rs.next() ){
                return new Customer(rs.getString("Username"), rs.getString("Password"));

            }
                
                
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            }
            
            return null;
         
        }


}
