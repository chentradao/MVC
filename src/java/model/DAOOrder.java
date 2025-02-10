/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Order;
import entity.Cart;
import entity.OrderDetail;
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
public class DAOOrder extends DBConnection {
    public int insertOrder(Order o) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry]\n"
                + "           ,[OrderStatus])\n"
                + "     VALUES('" + o.getCustomerID() + "','" + o.getEmployeeID() + "','" + o.getOrderDate() + "','" + o.getRequiredDate() + "'\n"
                + "           ,'" + o.getShippedDate() + "','" + o.getShipVia() + "','" + o.getFreight() + "','" + o.getShipName() + "'\n"
                + "           ,'" + o.getShipAddress() + "','" + o.getShipCity() + "','" + o.getShipRegion() + "','" + o.getShipPostalCode() + "'\n"
                + "           ,'" + o.getShipCountry() + "','" + o.getOrderStatus() + "')";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public void changeStatus(int oid, int newNumber) {
        String sql = "update Orders set OrderStatus=" + newNumber + " where OrderID=" + oid;
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int deleteOrder(int oid) {
        int n = 0;
        String sqlCheck = "Select * from [Order Details] where OrderID=" + oid;
        ResultSet rs = getData(sqlCheck);
        try {
            if (rs.next()) {
                changeStatus(oid, 0);
                return 0;
            }
            String sql = "Delete from Orders where OrderID=" + oid;

            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrder(Order or) {
        int n = 0;
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [CustomerID] = ?, [EmployeeID] = ?,[OrderDate] = ?,[RequiredDate] = ?\n"
                + "      ,[ShippedDate] = ?,[ShipVia] = ?,[Freight] = ?\n"
                + "      ,[ShipName] = ?,[ShipAddress] = ?,[ShipCity] = ?\n"
                + "      ,[ShipRegion] = ?,[ShipPostalCode] = ?,[ShipCountry] = ?\n"
                + "      ,[OrderStatus] = ?\n"
                + " WHERE [OrderID] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setObject(1, or.getCustomerID());
            pre.setObject(2, or.getEmployeeID());
            pre.setObject(3, or.getOrderDate());
            pre.setObject(4, or.getRequiredDate());
            pre.setObject(5, or.getShippedDate());
            pre.setObject(6, or.getShipVia());
            pre.setObject(7, or.getFreight());
            pre.setObject(8, or.getShipName());
            pre.setObject(9, or.getShipAddress());
            pre.setObject(10, or.getShipCity());
            pre.setObject(11, or.getShipRegion());
            pre.setObject(12, or.getShipPostalCode());
            pre.setObject(13, or.getShipCountry());
            pre.setObject(14, or.getOrderStatus());
            pre.setObject(15, or.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Order> getOrders(String sql) {
        Vector<Order> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                String OrderDate = rs.getString("OrderDate"),
                        RequiredDate = rs.getString("RequiredDate"),
                        ShippedDate = rs.getString("ShippedDate");
                int ShipVia = rs.getInt("ShipVia");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName"),
                        ShipAddress = rs.getString("ShipAddress"),
                        ShipCity = rs.getString("ShipCity"),
                        ShipRegion = rs.getString("ShipRegion"),
                        ShipPostalCode = rs.getString("ShipPostalCode"),
                        ShipCountry = rs.getString("ShipCountry");
                int OrderStatus = rs.getInt("OrderStatus");
                Order or = new Order(OrderID, CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry, OrderStatus);
                vector.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public void addToOrder(Cart cart){
        String sql ="select top 1 OrderID from Orders order by OrderID desc";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
        if(rs.next()){
            int oid = rs.getInt(1);
            String sql2 = "INSERT INTO [dbo].[Order Details]\n" +
"           ([OrderID]\n" +
"           ,[ProductID]\n" +
"           ,[UnitPrice]\n" +
"           ,[Quantity]\n" +
"           ,[Discount])\n" +
"     VALUES(?,?,?,?,?)";
            PreparedStatement state = conn.prepareStatement(sql2);
            state.setObject(1, oid);
            state.setObject(2, cart.getProductID());
            state.setObject(3, cart.getUnitPrice());
            state.setObject(4, cart.getQuantity());
            state.setObject(5, cart.getDiscount());
            state.executeQuery();
        }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
//        int n = dao.insertOrder(new Order("ABC", 1, "2020", "2021", "2021", 1, 1.2, "Hanh", "AB", "Hanoi", "Viet", "AB", "Vietnam",1));
//        int n = dao.deleteOrder(11079);
        int n = dao.updateOrder(new Order(11119, "ANATR", 1, "2021-01-01 00:00:00.0", "2022-01-01 00:00:00.0", "2022-01-01 00:00:00.0", 1, 20, "Ana Trujillo Emparedados y helados	", "Avda. de la Constitución 2222", "México D.F.", "null", "05021", "Mexico", 1));
                if (n > 0) {
            System.out.println("updated");
        }
        Vector<Order> vector = dao.getOrders("select OrderID, CustomerID,EmployeeID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,FORMAT(ShippedDate, 'dd/MM/yyyy') AS ShippedDate,\n" +
"ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,OrderStatus \n" +
"from Orders");
        for (Order or : vector) {
            System.out.println(or);
        }
    }
}
