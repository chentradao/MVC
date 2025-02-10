/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Categories;
import entity.Customer;
import entity.Order;
import entity.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOCategories;
import model.DAOOrder;
import model.DAOProduct;

/**
 *
 * @author nguye
 */
@WebServlet(name="IndexController", urlPatterns={"/indexURL"})
public class IndexController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Customer cus = (Customer)session.getAttribute("cus");
        DAOProduct dao = new DAOProduct();
        DAOCategories da = new DAOCategories();
        DAOOrder d = new DAOOrder();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if(service == null){
                service = "listAllMenu";
            }
            if(service.equals("findCategories")){
                int cid = Integer.parseInt(request.getParameter("cid"));
                    Vector<Product> catList =dao.getProducts("select * from Products Where CategoryID =" + cid+" and Discontinued = 1 order by UnitPrice desc");
                    Vector<Categories> data = da.getCategories("select * from Categories");                
                request.setAttribute("data", data);
                RequestDispatcher dispath=request.getRequestDispatcher("/jsp/index.jsp");
                //set data
                request.setAttribute("catList", catList);
                request.setAttribute("title", "List of Product");
                //run-view
                dispath.forward(request, response);
            }
            if(service.equals("Information")){
                request.setAttribute("cus", cus);
                request.getRequestDispatcher("/jsp/CustomerID.jsp").forward(request, response);
            }
            if(service.equals("findOrder")){
                String cid = request.getParameter("cid");
                Vector<Order> vector = d.getOrders("select OrderID, CustomerID,EmployeeID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,FORMAT(ShippedDate, 'dd/MM/yyyy') AS ShippedDate,\n" +
"ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,OrderStatus \n" +
"from Orders Where CustomerID ='"+cid+"'");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/OrderID.jsp");
            request.setAttribute("data", vector);
            request.setAttribute("title", "List of Order");
            dispatcher.forward(request, response);
            }
            if(service.equals("listAllMenu")){
                Vector<Categories> data = da.getCategories("select * from Categories");                
                request.setAttribute("data", data);
                Vector<Product> vector = dao.getProducts("select * from Products  Where Discontinued = 1 order by UnitPrice desc");
                request.setAttribute("cus", cus);
                request.setAttribute("vector", vector);
                request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
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
