/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Employees;
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
public class DAOEmployees extends DBConnection{
    public int insertEmployees(Employees emp){
        int n=0;
        String sql="INSERT INTO [dbo].[Employees]\n" +
"           ([LastName]\n" +
"           ,[FirstName]\n" +
"           ,[Title]\n" +
"           ,[TitleOfCourtesy]\n" +
"           ,[BirthDate]\n" +
"           ,[HireDate]\n" +
"           ,[Address]\n" +
"           ,[City]\n" +
"           ,[Region]\n" +
"           ,[PostalCode]\n" +
"           ,[Country]\n" +
"           ,[HomePhone]\n" +
"           ,[Extension]\n" +
"           ,[Photo]\n" +
"           ,[Notes]\n" +
"           ,[ReportsTo]\n" +
"           ,[PhotoPath]\n" +
"           ,[EmployeeStatus])\n" +                
"     VALUES('"+emp.getLastName()+"','"+emp.getFirstName()+"','"+emp.getTitle()+"','"+emp.getTitleOfCourtesy()+"'\n" +
"           ,'"+emp.getBirthDate()+"','"+emp.getHireDate()+"','"+emp.getAddress()+"','"+emp.getCity()+"'\n" +
"           ,'"+emp.getRegion()+"','"+emp.getPostalCode()+"','"+emp.getCountry()+"','"+emp.getHomePhone()+"'\n" +
"           ,'"+emp.getExtension()+"','"+emp.getPhoto()+"','"+emp.getNotes()+"','"+emp.getReportsTo()+"','"+emp.getPhotoPath()+"','"+emp.getEmployeeStatus()+"')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public void changeStatus(int eid,int newValue){
        String sql="update Employees set EmployeeStatus="+newValue+" where EmployeeID="+eid;
        try {
            Statement state = conn.createStatement();
            state.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int deleteEmployees(int eid){
        int n=0;
        String sqlCheck = "select * from Orders where EmployeeID="+eid;
        ResultSet rs= getData(sqlCheck);
        try {
        if(rs.next()){
            changeStatus(eid, 0);
            return 0;
        }
        String sql = "delete from Employees where EmployeeID="+eid;
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
   public Vector<Employees> getEmployeeses(String sql){
        Vector<Employees> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
//                private int EmployeeID;
//	private String LastName,FirstName,Title,TitleOfCourtesy,BirthDate,HireDate;
//	private String Address,City,Region,PostalCode,Country,HomePhone,Extension,Photo,Notes;
//	private int ReportsTo;
//	private String PhotoPath;
            int EmployeeID =rs.getInt("EmployeeID");
            String LastName=rs.getString("LastName");
            String FirstName=rs.getString("FirstName");
            String Title=rs.getString("Title");
            String TitleOfCourtesy=rs.getString("TitleOfCourtesy");
            String BirthDate=rs.getString("BirthDate");
            String HireDate=rs.getString("HireDate");
            String Address=rs.getString("Address");
            String City=rs.getString("City");
            String Region=rs.getString("Region");
            String PostalCode=rs.getString("PostalCode");
            String Country=rs.getString("Country");
            String HomePhone=rs.getString("HomePhone");
            String Extension=rs.getString("Extension");
            String Photo=rs.getString("Photo");
            String Notes=rs.getString("Notes");
            int ReportsTo=rs.getInt("ReportsTo");
            String PhotoPath=rs.getString("PhotoPath").trim();
            int EmployeeStatus=rs.getInt("EmployeeStatus");
            Employees em = new Employees(EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath,EmployeeStatus);
            vector.add(em);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
   public Employees loginEmployees(int userName, String pass){
       Employees emp = null;
       String sql = "select * from Employees where EmployeeID = ? and FirstName=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, userName);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                 emp = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                         rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
                         rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(17), rs.getString(18), rs.getInt(19));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
       return emp;
   }
    public static void main(String[] args) {
        DAOEmployees dao = new DAOEmployees();
//        int n=dao.insertEmployees(new Employees("Xuan", "Hanh", "G", "A", "2004", "2024", "HaDong", "HaNoi", "A", "A", "VietNam", "011", "a", "0xx1", "A", 1, "A",1));
//        if (n>0){
//            System.out.println("inserted");
//        }
    Vector<Employees>vector=dao.getEmployeeses("Select * from Employees");
    Employees emp = dao.loginEmployees(1, "Nancy");
    if(emp == null){
        System.out.println("null");
    }else{
        System.out.println(emp);
    }
    }
}
