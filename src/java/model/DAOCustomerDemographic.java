/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.CustomerDemographic;
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
public class DAOCustomerDemographic extends DBConnection {

    public int insertCustomerDemo(CustomerDemographic c) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerDemographics]\n"
                + "           ([CustomerTypeID]\n"
                + "           ,[CustomerDesc]\n"
                + "           ,[DemographicStatus])\n"
                + "     VALUES('" + c.getCustomerTypeID() + "','" + c.getCustomerDesc() + "','" + c.getDemographicStatus()+ "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomerDemo(CustomerDemographic c) {
        int n = 0;
        String sql = "UPDATE [dbo].[CustomerDemographics]\n"
                + "   SET [DemographicStatus] = ?\n"
                + " WHERE [CustomerTypeID] = ? and [CustomerDesc] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(3, c.getCustomerDesc());
            pre.setInt(1, c.getDemographicStatus());
            pre.setString(2, c.getCustomerTypeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    void changeStatus(String cid, int newValue){
        String sql = "update CustomerDemographics set DemographicStatus="+newValue+" where CustomerTypeID="+cid;
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int deleteCustomerDemo(String cid) {
        int n = 0;
        String sqlCheck= "select * from CustomerCustomerDemo where CustomerTypeID="+cid;
        ResultSet rs = getData(sqlCheck);
        try {
        if(rs.next()){
            changeStatus(cid, 0);
            return 0;
        }
        String sql = "DELETE FROM CustomerDemographics WHERE CustomerTypeID=" + cid;
        
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<CustomerDemographic> getCustomerDemographics(String sql) {
        Vector<CustomerDemographic> vector = new Vector<CustomerDemographic>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String CustomerTypeID = rs.getString("CustomerTypeID").trim();
                String CustomerDesc = rs.getString("CustomerDesc");
                int DemographicStatus = rs.getInt("DemographicStatus");
                CustomerDemographic c = new CustomerDemographic(CustomerTypeID, CustomerDesc,DemographicStatus);
                vector.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCustomerDemographic dao = new DAOCustomerDemographic();
//        int n=dao.insertCustomerDemo(new CustomerDemographic("ABC", "A"));
//        int n=dao.addCustomerDemo(new CustomerDemographic("A", "A"));
        int n=dao.updateCustomerDemo(new CustomerDemographic("A", "ABC",0));
//        int n=dao.deleteCustomerDemo("'ABC'");
        if(n>0){
            System.out.println("updated");
        }
        Vector<CustomerDemographic> vector = dao.getCustomerDemographics("Select * from CustomerDemographics");
        for(CustomerDemographic c: vector){
            System.out.println(c);
        }
    }
}
