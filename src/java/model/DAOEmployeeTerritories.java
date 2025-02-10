/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.EmployeeTerritories;
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
public class DAOEmployeeTerritories extends DBConnection{
    public int insertEmployeeTe(EmployeeTerritories e){
        int n=0;
        String sql="INSERT INTO [dbo].[EmployeeTerritories]\n" +
"           ([EmployeeID]\n" +
"           ,[TerritoryID])\n" +
"     VALUES('"+e.getEmployeeID()+"','"+e.getTerritoryID()+"')";
        try {
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int deleteEmployeeTerritorieses(int eid, String tid){
        int n=0;
        String sql = "delete from EmployeeTerritories where EmployeeID="+eid+" and TerritoryID="+tid;
        try {
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployeeTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public Vector<EmployeeTerritories>getEmployeeTerritories(String sql){
        Vector<EmployeeTerritories> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs =state.executeQuery(sql);
            while(rs.next()){
            int EmployeeID = rs.getInt("EmployeeID");
            String TerritoryID = rs.getString("TerritoryID");
            EmployeeTerritories e = new EmployeeTerritories(EmployeeID, TerritoryID);
            vector.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployeeTerritories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
        DAOEmployeeTerritories dao = new DAOEmployeeTerritories();
//        int n =dao.insertEmployeeTe(new EmployeeTerritories(10, "01581"));
        int n=dao.deleteEmployeeTerritorieses(10,"");
        if(n>0){
            System.out.println("inserted");
        }
//    Vector<EmployeeTerritories> vector=dao.getEmployeeTerritories("Select * from EmployeeTerritories");
//    for(EmployeeTerritories emp :vector){
//        System.out.println(emp);
//    }
    }
}
