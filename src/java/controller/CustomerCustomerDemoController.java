/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.CustomerCustomerDemo;
import entity.Employees;
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
import model.DAOCustomerCustomerDemo;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name="CustomerCustomerDemoController", urlPatterns={"/CustomerCustomerDemoURL"})
public class CustomerCustomerDemoController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOCustomerCustomerDemo dao = new DAOCustomerCustomerDemo();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if(service.equals("deleteCustomerCus")){
                dao.deleteCustomerCus(request.getParameter("cid"), request.getParameter("ctid"));
                response.sendRedirect("CustomerCustomerDemoURL?service=listAllCustomerCustomerDemo");
            }
            
            if(service.equals("insertCustomerCus")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rsCus = dao.getData("select CustomerID,ContactName from Customers");
                    ResultSet rsGra = dao.getData("select CustomerTypeID,CustomerDesc from CustomerDemographics");
                    request.setAttribute("rsCus", rsCus);
                    request.setAttribute("rsGra", rsGra);
                    request.getRequestDispatcher("/insert-jsp/insertCustomerCus.jsp").forward(request, response);
                }else{
                String CustomerID = request.getParameter("CustomerID");
                String CustomerTypeID = request.getParameter("CustomerTypeID");
                
                CustomerCustomerDemo cus = new CustomerCustomerDemo(CustomerID, CustomerTypeID);
                dao.insertCustomerCus(cus);
                response.sendRedirect("CustomerCustomerDemoURL?service=listAllCustomerCustomerDemo");
                }
            }
            if(service.equals("listAllCustomerCustomerDemo")){
            String sql = "Select * from CustomerCustomerDemo";
            
                String submit = request.getParameter("submit");
                if (submit == null) {
                    sql = "select * from CustomerCustomerDemo";
                } else {
                    String cname = request.getParameter("cname");
                    sql = "select * from CustomerCustomerDemo where CustomerID like '%" + cname + "%'";
                }
            Vector<CustomerCustomerDemo> vector = dao.getCustomerCustomerDemos(sql);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayCustomerCustomerDemo.jsp");
            request.setAttribute("data", vector);
            request.setAttribute("emp", emp);
            request.setAttribute("title", "CusCus manager");
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
