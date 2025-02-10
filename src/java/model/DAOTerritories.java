/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Territories;
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
public class DAOTerritories extends DBConnection{
    public int insertTerritories(Territories t){
        int n=0;
        String sql="INSERT INTO [dbo].[Territories]\n" +
"           ([TerritoryID]\n" +
"           ,[TerritoryDescription]\n" +
"           ,[RegionID]\n" +
"           ,[TerritoryStatus])\n" +                
"     VALUES('"+t.getTerritoryID()+"','"+t.getTerritoryDescription()+"','"+t.getRegionID()+"','"+t.getTerritoryStatus()+"')";
        try {
            Statement state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateTerritories(Territories t){
        int n=0;
        String sql="UPDATE [dbo].[Territories]\n" +
"   SET [TerritoryDescription] = ?,[RegionID] = ?,[TerritoryStatus] = ?\n" +
" WHERE TerritoryID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, t.getTerritoryDescription());
            pre.setInt(2, t.getRegionID());
            pre.setInt(3, t.getTerritoryStatus());
            pre.setString(4, t.getTerritoryID());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    void changeStatus(String tid, int newValue){
        String sql ="update Territories set TerritoryStatus="+newValue+" where TerritoryID="+tid;
         try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int deleteTerritories(String tid){
        int n=0;
        String sqlCheck="select * from EmployeeTerritories where TerritoryID="+tid;
        ResultSet rs = getData(sqlCheck);
        try {
        if(rs.next()){
            changeStatus(tid, 0);
            return 0;
        }
        String sql="DELETE FROM Territories WHERE TerritoryID="+tid;
        
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public Vector<Territories> getTerritorieses(String sql){
        Vector<Territories> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(sql);
            while(rs.next()){
               String TerritoryID =rs.getString("TerritoryID").trim();
               String TerritoryDescription=rs.getString("TerritoryDescription").trim();
               int RegionID=rs.getInt("RegionID");
               int TerritoryStatus = rs.getInt("TerritoryStatus");
               Territories ter = new Territories(TerritoryID, TerritoryDescription, RegionID,TerritoryStatus);
               vector.add(ter);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
        DAOTerritories dao = new DAOTerritories();
//        int n=dao.insertTerritories(new Territories("9900", "Ha", 1));
//        int n=dao.updateTerritories(new Territories("0100", "Hanh", 2));
        int n=dao.deleteTerritories("'0999'");
        if(n>0){
            System.out.println("deleted");
        }
        Vector<Territories> vector=dao.getTerritorieses("Select * from Territories");
        for(Territories ter:vector){
            System.out.println(ter);
        }
    }
}
