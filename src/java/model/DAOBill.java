/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Bill;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class DAOBill extends DBConnection{
    public  Vector<Bill> getBills(String sql){
        Vector<Bill> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int OrderID = rs.getInt("OrderID");
                String OrderDate = rs.getString("OrderDate");
                String RequiredDate = rs.getString("RequiredDate");
                String CustomerID = rs.getString("CustomerID");
                String ContactName = rs.getString("ContactName");
                int EmployeeID=rs.getInt("EmployeeID");
                String FirstName = rs.getString("FirstName");
                int ProductID=rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity=rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                Bill b = new Bill(OrderID, OrderDate, RequiredDate, CustomerID, ContactName, EmployeeID, FirstName, ProductID, ProductName, UnitPrice, Quantity, Discount);
                vector.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
        DAOBill dao = new DAOBill();
        Vector<Bill> vector = dao.getBills("select *\n" +
"from Orders o join [Order Details] od on o.OrderID = od.OrderID \n" +
"join Customers c on o.CustomerID = c.CustomerID \n" +
"join Products p on od.ProductID = P.ProductID \n" +
"join Employees e on e.EmployeeID=o.EmployeeID");
        for(Bill b : vector){
            System.out.println(b);
        }
    }
}
