/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Employees;
import entity.OrderDetail;
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
import model.DAOOrderDetail;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name = "OrderDetailController", urlPatterns = {"/OrderDetailURL"})
public class OrderDetailController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOOrderDetail dao = new DAOOrderDetail();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if(service.equals("deleteOrderDetail")){
                dao.deleteOrderDetail(Integer.parseInt(request.getParameter("oid")), 
                        Integer.parseInt(request.getParameter("pid")));
                response.sendRedirect("OrderDetailURL?service=listAllOrderDetails");
            }
            if (service.equals("updateOrderDetail")) {
                String submit = request.getParameter("submit");
                if(submit == null){
                    int oid= Integer.parseInt(request.getParameter("oid")); 
                    int pid= Integer.parseInt(request.getParameter("pid"));
                    Vector<OrderDetail> vector = dao.getOrderDetails("select * from [Order Details] where OrderID="+oid+" and ProductID="+pid);
                    request.setAttribute("vector", vector);
                    ResultSet rsOrd = dao.getData("select OrderID, CustomerID from Orders");
                    ResultSet rsPro = dao.getData("select ProductID,ProductName from Products");
                    request.setAttribute("rsOrd", rsOrd);
                    request.setAttribute("rsPro", rsPro);
                    request.getRequestDispatcher("/update-jsp/updateOrderDetail.jsp").forward(request, response);
                }else{
                int OrderID = Integer.parseInt(request.getParameter("OrderID")),
                        ProductID = Integer.parseInt(request.getParameter("ProductID"));
                double UnitPrice = Double.parseDouble(request.getParameter("UnitPrice"));
                int Quantity = Integer.parseInt(request.getParameter("Quantity"));
                double Discount = Double.parseDouble(request.getParameter("Discount"));

                OrderDetail od = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount);

                dao.updateOrderDetail(od);

                response.sendRedirect("OrderDetailURL?service=listAllOrderDetails");
                }
            }
            if (service.equals("insertOrderDetail")) {
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rsOrd = dao.getData("select OrderID, CustomerID from Orders");
                    ResultSet rsPro = dao.getData("select ProductID,ProductName from Products");
                    request.setAttribute("rsOrd", rsOrd);
                    request.setAttribute("rsPro", rsPro);
                    request.getRequestDispatcher("/insert-jsp/insertOrderDetail.jsp").forward(request, response);
                }else{
                int OrderID = Integer.parseInt(request.getParameter("OrderID")),
                        ProductID = Integer.parseInt(request.getParameter("ProductID"));
                double UnitPrice = Double.parseDouble(request.getParameter("UnitPrice"));
                int Quantity = Integer.parseInt(request.getParameter("Quantity"));
                double Discount = Double.parseDouble(request.getParameter("Discount"));

                OrderDetail od = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount);

                dao.insertOrderDetail(od);

                response.sendRedirect("OrderDetailURL?service=listAllOrderDetails");
                }
            }
            if (service.equals("listAllOrderDetails")) {
                String sql = "select * from [Order Details]";
                String submit = request.getParameter("submit");
                if (submit == null) {
                    sql = "select * from [Order Details]";
                } else {
                    String oid = request.getParameter("oid");
                    sql = "select * from [Order Details] where OrderID like '%" + oid + "%'";
                }
                Vector<OrderDetail> vector = dao.getOrderDetails(sql);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayOrderDetail.jsp");
                request.setAttribute("data", vector);
                request.setAttribute("emp", emp);
                request.setAttribute("title", "OrderDetail manager");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
