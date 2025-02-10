/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Categories;
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
public class DAOCategories extends DBConnection {

    public int insertCategories(Categories c) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([CategoryName]\n"
                + "           ,[Description]\n"
                + "           ,[Picture]\n"
                + "           ,[CategoryStatus])\n"
                + "     VALUES('" + c.getCategoryName() + "','" + c.getDescription() + "','" + c.getPicture() + "','" + c.getCategoryStatus()+ "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    void changeStatus(int cid, int newValue){
        String sql ="update Categories set CategoryStatus="+newValue+" where CategoryID="+cid;
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int deleteCategories(int cid) {
        int n = 0;
        String sqlCheck="select * from Products where CategoryID="+cid;
        ResultSet rs = getData(sqlCheck);
        try {
        if(rs.next()){
            changeStatus(cid, 0);
            return 0;
        }
        String sql = "delete from Categories where CategoryID=" + cid;
        
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Categories> getCategories(String sql) {
        Vector<Categories> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName"),
                        Description = rs.getString("Description"),
                        Picture = rs.getString("Picture");
                int CategoryStatus = rs.getInt("CategoryStatus");
                Categories cat = new Categories(CategoryID, CategoryName, Description, Picture,CategoryStatus);
                vector.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOCategories dao = new DAOCategories();
//        int n=dao.insertCategories(new Categories("Beach","coconut","1x00",1));
//        int n=dao.deleteCategories(11);
//        if (n > 0) {
//            System.out.println("updated");
//        }
        Vector<Categories> vector = dao.getCategories("Select * from Categories");
        for (Categories cat : vector) {
            System.out.println(cat);
        }
    }
}
