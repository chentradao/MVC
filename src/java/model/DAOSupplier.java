/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Supplier;
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
public class DAOSupplier extends DBConnection {

    public int insertSupplier(Supplier sup) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Suppliers]\n"
                + "           ([CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax]\n"
                + "           ,[HomePage]\n"
                + "           ,[SupplierStatus])\n"
                + "     VALUES('" + sup.getCompanyName() + "','" + sup.getContactName() + "','" + sup.getContactTitle() + "','" + sup.getAddress() + "',\n"
                + "            '" + sup.getCity() + "','" + sup.getRegion() + "','" + sup.getPostalCode() + "','" + sup.getCountry() + "'\n"
                + "           ,'" + sup.getPhone() + "','" + sup.getFax() + "','" + sup.getHomePage() + "','" + sup.getSupplierStatus() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void changeStatus(int sid, int newValue) {
        String sql = "update Suppliers set SupplierStatus=" + newValue + " where SupplierID=" + sid;
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int deleteSupplier(int sid) {
        int n = 0;
        String sqlCheck = "select * from Products where SupplierID="+sid;
        ResultSet rs = getData(sqlCheck);
        try {
            if(rs.next()){
                changeStatus(sid, 0);
                return 0;
            }
            String sql ="delete from Suppliers where SupplierID="+sid;
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateSupplier(Supplier sup){
        int n = 0;
        String sql = "UPDATE [dbo].[Suppliers]\n" +
"   SET [CompanyName] = ?,[ContactName] = ?,[ContactTitle] = ?,[Address] = ?\n" +
"      ,[City] = ?,[Region] = ?,[PostalCode] = ?,[Country] = ?\n" +
"      ,[Phone] = ?,[Fax] = ?,[HomePage] = ?,[SupplierStatus] = ?\n" +
" WHERE [SupplierID] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setObject(1, sup.getCompanyName());
            pre.setObject(2, sup.getContactName());
            pre.setObject(3, sup.getContactTitle());
            pre.setObject(4, sup.getAddress());
            pre.setObject(5, sup.getCity());
            pre.setObject(6, sup.getRegion());
            pre.setObject(7, sup.getPostalCode());
            pre.setObject(8, sup.getCountry());
            pre.setObject(9, sup.getPhone());
            pre.setObject(10, sup.getFax());
            pre.setObject(11, sup.getHomePage());
            pre.setObject(12, sup.getSupplierStatus());
            pre.setObject(13, sup.getSupplierID());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public Vector<Supplier> getSuppliers(String sql) {
        Vector vector = new Vector<Supplier>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int SupplierID = rs.getInt("SupplierID");
                String CompanyName = rs.getString("CompanyName"),
                        ContactName = rs.getString("ContactName"),
                        ContactTitle = rs.getString("ContactTitle"),
                        Address = rs.getString("Address"),
                        City = rs.getString("City"),
                        Region = rs.getString("Region"),
                        PostalCode = rs.getString("PostalCode"),
                        Country = rs.getString("Country"),
                        Phone = rs.getString("Phone"),
                        Fax = rs.getString("Fax"),
                        HomePage = rs.getString("HomePage");
                int SupplierStatus=rs.getInt("SupplierStatus");
                Supplier sup = new Supplier(SupplierID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage, SupplierStatus);
                vector.add(sup);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOSupplier dao = new DAOSupplier();
//        int n=dao.insertSupplier(new Supplier("ABC", "Hank", "A", "aB", "Hanoi", "Vie", "012", "VietNam", "012", "120", "Home",1));
//        int n=dao.deleteSupplier(35);
        int n = dao.updateSupplier(new Supplier(30,"ABC", "Hank", "A", "aB", "Hanoi", "Vie", "012", "VietNam", "012", "120", "HA",1));
        if(n>0){
            System.out.println("updated");
        }
        Vector<Supplier> vector = dao.getSuppliers("select * from Suppliers");
        for (Supplier sub : vector) {
            System.out.println(sub);
        }
    }
}
