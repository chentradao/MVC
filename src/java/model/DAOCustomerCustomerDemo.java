/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import entity.CustomerCustomerDemo;
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
public class DAOCustomerCustomerDemo extends DBConnection{
    public int insertCustomerCus(CustomerCustomerDemo c){
        int n=0;
        String sql ="INSERT INTO [dbo].[CustomerCustomerDemo]\n" +
"           ([CustomerID]\n" +
"           ,[CustomerTypeID])\n" +
"     VALUES('"+c.getCustomerID()+"','"+c.getCustomerTypeID()+"')";
        try {
            Statement state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }    public int addCustomerCus(CustomerCustomerDemo c) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerCustomerDemo]\n"
                + "           ([CustomerID]\n"
                + "           ,[CustomerTypeID])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, c.getCustomerID());
            pre.setString(2, c.getCustomerTypeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateCustomerCus(CustomerCustomerDemo c) {
        int n = 0;
        String sql = "UPDATE [dbo].[CustomerCustomerDemo]\n"
                + "   SET [CustomerTypeID] = ?\n"
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, c.getCustomerTypeID());
            pre.setString(2, c.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteCustomerCus(String cid, String ctid) {
        int n = 0;
        String sql = "DELETE FROM CustomerCustomerDemo WHERE CustomerID=" + cid+" and CustomerTypeID=" +ctid;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<CustomerCustomerDemo> getCustomerCustomerDemos(String sql) {
        Vector<CustomerCustomerDemo> vector = new Vector<CustomerCustomerDemo>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String CustomerID = rs.getString(1);
                String CustomerTypeID = rs.getString(2);
                CustomerCustomerDemo c = new CustomerCustomerDemo(CustomerID, CustomerTypeID);
                vector.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCustomerCustomerDemo dao = new DAOCustomerCustomerDemo();
//        int n=dao.insertCustomerCus(new CustomerCustomerDemo("ABC", "ABC"));      
//        int n=dao.updateCustomerCus(new CustomerCustomerDemo("WOLZA", "A"));
        int n=dao.deleteCustomerCus("'ABC'", "'ABC'");
        if(n>0){
            System.out.println("inserted");
        }
//         Vector<CustomerCustomerDemo> vector = dao.getCustomerCustomerDemos("Select * from CustomerCustomerDemo");
//        for(CustomerCustomerDemo c: vector){
//            System.out.println(c);
//        }
    }
}
