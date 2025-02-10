/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Bill;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import model.DAOBill;
import java.util.Vector;

/**
 *
 * @author nguye
 */
@WebServlet(name="BillController", urlPatterns={"/BillURL"})
public class BillController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOBill dao = new DAOBill();
        try (PrintWriter out = response.getWriter()) {
           String service = request.getParameter("service");
           if(service.equals("findBill")){
               int oid = Integer.parseInt(request.getParameter("oid"));
               Vector<Bill> vector = dao.getBills("select o.OrderID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,c.CustomerID,c.ContactName,\n" +
"e.EmployeeID,e.FirstName,p.ProductID,p.ProductName,od.UnitPrice,od.Quantity,od.Discount\n" +
"from Orders o join [Order Details] od on o.OrderID = od.OrderID \n" +
"join Customers c on o.CustomerID = c.CustomerID \n" +
"join Products p on od.ProductID = P.ProductID \n" +
"join Employees e on e.EmployeeID=o.EmployeeID Where o.OrderID like '%" + oid + "%'");
               ResultSet rsOrd = dao.getData("SELECT  OrderID,OrderDate,RequiredDate FROM Orders");
               ResultSet rsCus = dao.getData("SELECT  ContactName FROM Customers");
               ResultSet rsEmp = dao.getData("SELECT  FirstName FROM Employees");
               request.setAttribute("rsOrd", rsOrd);
               request.setAttribute("rsCus", rsCus);
               request.setAttribute("rsEmp", rsEmp);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayBill.jsp");
            request.setAttribute("data", vector);
            dispatcher.forward(request, response);
           }
           if(service.equals("listAllBill")){
            String sql = "select o.OrderID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,c.CustomerID,c.ContactName,\n" +
"e.EmployeeID,e.FirstName,p.ProductID,p.ProductName,od.UnitPrice,od.Quantity,od.Discount\n" +
"from Orders o join [Order Details] od on o.OrderID = od.OrderID \n" +
"join Customers c on o.CustomerID = c.CustomerID \n" +
"join Products p on od.ProductID = P.ProductID \n" +
"join Employees e on e.EmployeeID=o.EmployeeID";
               
            Vector<Bill> vector = dao.getBills(sql);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayBill.jsp");
            request.setAttribute("data", vector);
            dispatcher.forward(request, response);
           }
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
