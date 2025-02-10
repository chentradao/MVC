/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Shipper;
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
public class DAOShipper extends DBConnection {

    public int insertShipper(Shipper s) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Shippers]\n"
                + "           ([CompanyName]\n"
                + "           ,[Phone]\n"
                + "           ,[ShipperStatus])\n"
                + "     VALUES('" + s.getCompanyName() + "','" + s.getPhone() + "','" + s.getShipperStatus()+ "')";
        try {
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateShipper(Shipper s){
        int n=0;
        String sql="UPDATE [dbo].[Shippers]\n" +
"   SET [CompanyName] = ?,[Phone] = ?,[ShipperStatus] = ?\n" +
" WHERE ShipperID =?";
        try {
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1, s.getCompanyName());
            pre.setString(2, s.getPhone());
            pre.setInt(3, s.getShipperStatus());
            pre.setInt(4, s.getShipperID());           
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    void changeValue(int sid, int newValue){
        String sql = "update Shippers set ShipperStatus="+newValue+" where ShipperID="+sid;
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int deleteShipper(int sid){
        int n=0;
        String sqlCheck ="select * from Orders where ShipVia="+sid;
        ResultSet rs = getData(sqlCheck);
        try {
        if(rs.next()){
            changeValue(sid, 0);
            return 0;
        }
        String sql="DELETE FROM Shippers WHERE ShipperID="+sid;
        
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public Vector<Shipper>getShippers(String sql){
        Vector<Shipper> vector = new Vector<>();
        try {
            Statement state =conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int ShipperID = rs.getInt("ShipperID");
                String CompanyName = rs.getString("CompanyName");
                String Phone =rs.getString("Phone");
                int ShipperStatus=rs.getInt("ShipperStatus");
                Shipper ship = new Shipper(ShipperID, CompanyName, Phone,ShipperStatus);
                vector.add(ship);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return vector;
    }
    public static void main(String[] args) {
        DAOShipper dao = new DAOShipper();
//        int n=dao.insertShipper(new Shipper("ABC", "012"));
//        int n=dao.updateShipper(new Shipper(4,"AB", "012"));
        int n=dao.deleteShipper(1);
        if(n>0){
            System.out.println("deleted");
        }
        Vector<Shipper> vector =dao.getShippers("Select * from Shippers");
        for(Shipper ship:vector){
            System.out.println(ship);
        }
    }
}
