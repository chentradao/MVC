/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
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
public class DAOOrderDetail extends DBConnection{
    public int insertOrderDetail(OrderDetail o){
        int n=0;
        String sql="INSERT INTO [dbo].[Order Details]\n" +
"           ([OrderID]\n" +
"           ,[ProductID]\n" +
"           ,[UnitPrice]\n" +
"           ,[Quantity]\n" +
"           ,[Discount])\n" +
"     VALUES('"+o.getOrderID()+"','"+o.getProductID()+"','"+o.getUnitPrice()+"'\n" +
"           ,'"+o.getQuantity()+"','"+o.getDiscount()+"')";
        try {
            Statement state =conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return n;
    }
    public int deleteOrderDetail(int oid, int pid){
        int n=0;
        String sql="delete from [Order Details] where OrderID="+oid+" and ProductID="+pid;
        try {
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateOrderDetail(OrderDetail ord){
        int n = 0;
        String sql = "UPDATE [dbo].[Order Details]\n" +
"   SET [UnitPrice] = ?,[Quantity] = ?,[Discount] = ?\n" +
" WHERE [OrderID] = ? and[ProductID] = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setObject(1, ord.getUnitPrice());
            pre.setObject(2, ord.getQuantity());
            pre.setObject(3, ord.getDiscount());
            pre.setObject(4, ord.getOrderID());
            pre.setObject(5, ord.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public Vector<OrderDetail>getOrderDetails(String sql){
        Vector<OrderDetail> vector = new Vector<>();
        try {
            Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs =state.executeQuery(sql);
            while(rs.next()){
                int OrderID =rs.getInt("OrderID");
                int ProductID = rs.getInt("ProductID");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                OrderDetail or = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount);
                vector.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public static void main(String[] args) {
        DAOOrderDetail dao = new DAOOrderDetail();
//        int n=dao.insertOrderDetail(new OrderDetail(10248, 14, 10.1, 4, 0.11));
//        int n=dao.deleteOrderDetail(10248, 13);
        int n=dao.updateOrderDetail(new OrderDetail(10248, 14, 10.1, 5, 0.11));
        if(n>0){
            System.out.println("updated");
        }
        Vector<OrderDetail> vector=dao.getOrderDetails("select * from [Order Details]");
        for(OrderDetail or :vector){
            System.out.println(or);
        }
    }
}
