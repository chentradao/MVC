/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Customer;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class DAOCustomer extends DBConnection {

    public int insertCustomer(Customer cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([CustomerID]\n"
                + "           ,[CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax]\n"
                + "           ,[CustomerStatus])\n"
                + "     VALUES\n"
                + "           ('" + cus.getCustomerID() + "','" + cus.getCompanyName() + "','" + cus.getContactName() + "','" + cus.getContactTitle() + "'\n"
                + "           ,'" + cus.getAddress() + "','" + cus.getCity() + "','" + cus.getRegion() + "','" + cus.getPostalCode() + "'\n"
                + "           ,'" + cus.getCountry() + "','" + cus.getPhone() + "','" + cus.getFax() + "','" + cus.getCustomerStatus()+ "')";
        //System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public void changeStatus(String cid, int newValue){
        String sql ="update Customers set CustomerStatus="+newValue+" where CustomerID="+cid;
        try {
            Statement state=conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int deleteCustomer(String cid) {
        int n = 0;
        String sqlCheck ="select * from Orders where CustomerID="+cid;
        ResultSet rs =getData(sqlCheck);
        try {
        if(rs.next()){
            changeStatus(cid, 0);
            return 0;
        }
        String sql = "delete from Customers where CustomerID=" + cid;
 
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);             
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomer(Customer c) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [CompanyName] = ?,[ContactName] = ?,[ContactTitle] = ?,"
                + "[Address] = ?,[City] = ?,[Region] = ?,"
                + "	[PostalCode] = ?,[Country] = ?,[Phone] = ?,[Fax] = ?,[CustomerStatus] = ? \n"
                + "Where CustomerID=? ";
        System.out.println(sql);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, c.getCompanyName());
            pre.setString(2, c.getContactName());
            pre.setString(3, c.getContactTitle());
            pre.setString(4, c.getAddress());
            pre.setString(5, c.getCity());
            pre.setString(6, c.getRegion());
            pre.setString(7, c.getPostalCode());
            pre.setString(8, c.getCountry());
            pre.setString(9, c.getPhone());
            pre.setString(10, c.getFax());
            pre.setInt(11, c.getCustomerStatus());
            pre.setString(12, c.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
   
    public Vector<Customer> getCustomers(String sql) {
        Vector<Customer> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String CustomerID = rs.getString("CustomerID"), 
                        CompanyName = rs.getString("CompanyName"),
                        ContactName = rs.getString("ContactName"),
                        ContactTitle = rs.getString("ContactTitle"),
                        Address = rs.getString("Address"), 
                        City = rs.getString("City"), 
                        Region = rs.getString("Region"),
                        PostalCode = rs.getString("PostalCode"),
                        Country = rs.getString("Country"), 
                        Phone = rs.getString("Phone"), 
                        Fax = rs.getString("Fax");
                int CustomerStatus=rs.getInt("CustomerStatus");
                Customer c = new Customer(CustomerID, CompanyName, ContactName,
                        ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax,CustomerStatus);
                vector.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public Customer login(String userName, String pass){
        Customer cus = null;
        String sql = "select * from Customers where CustomerID =? and CompanyName = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                cus = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cus;
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
//            int n= dao.insertCustomer(new Customer("ABCD","Hank","Hanh","Owner",
//                    "Hadong","Hanoi","Null","1","Vietnam","01","01"));
//            int n=dao.updateCustomer(new Customer("ABC", "Hank", "Hanh", "Owner",
//                    "Hadong", "Hanoi", "Null", "1", "Vietnam", "01", "01", 1));
//            int n=dao.deleteCustomer("'ALFKI'");
            Customer n = dao.login("ALFKI", "Alfreds Futterkiste");
//            if(n>0){
//                System.out.println("deleted");
//            }
        Vector<Customer> vector = dao.getCustomers("select * from Customers");
        if(n==null){
            System.out.println("null");
        }else{
//        for (Customer c : vector) {
//            System.out.println(c);
//        }
System.out.println(n);
        }
    }
}
