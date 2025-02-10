/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Region;
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
public class DAORegion extends DBConnection {

    public int insertRegion(Region r) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Region]\n"
                + "           ([RegionID]\n"
                + "           ,[RegionDescription]\n"
                + "           ,[RegionStatus])\n"
                + "     VALUES('" + r.getRegionID() + "','" + r.getRegionDescription() + "','" + r.getRegionStatus() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateRegion(Region r) {
        int n = 0;
        String sql = "UPDATE [dbo].[Region]\n"
                + "   SET [RegionDescription] = ?,[RegionStatus] = ?\n"
                + " WHERE RegionID=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, r.getRegionDescription());
            pre.setInt(2, r.getRegionStatus());
            pre.setInt(3, r.getRegionID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void changeStatus(int rid, int newValue) {
        String sql = "update Region set RegionStatus =" + newValue + " where RegionID=" + rid;
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int deleteRegion(int rid) {
        int n = 0;
        String sqlCheck = "select * from Territories where RegionID=" + rid;
        ResultSet rs = getData(sqlCheck);
        try {
            if (rs.next()) {
                changeStatus(rid, 0);
                return 0;
            }
            String sql = "DELETE FROM [dbo].[Region]\n"
                    + "      WHERE RegionID=" + rid;
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Region> getRegions(String sql) {
        Vector<Region> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int RegionID = rs.getInt("RegionID");
                String RegionDescription = rs.getString("RegionDescription").trim();
                int RegionStatus = rs.getInt("RegionStatus");
                Region re = new Region(RegionID, RegionDescription, RegionStatus);
                vector.add(re);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAORegion dao = new DAORegion();
        int n=dao.insertRegion(new Region(5,"Hanoi", 1));
//        int n=dao.updateRegion(new Region(0,"Danang"));
//        int n=dao.deleteRegion(0);
        if(n>0){
            System.out.println("updated");
        }
        String sql ="select * from Region";
        Vector<Region> vector = dao.getRegions(sql);
        for (Region re : vector) {
            System.out.println(re);
        }
    }
}
