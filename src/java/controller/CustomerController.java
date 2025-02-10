/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import entity.Customer;
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
import model.DAOCustomer;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerURL"})
public class CustomerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOCustomer dao = new DAOCustomer();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            /* TODO output your page here. You may use following sample code. */
            if(service.equals("deleteCustomer")){
                dao.deleteCustomer(request.getParameter("cid"));
                response.sendRedirect("CustomerURL?service=listAllCustomers");
            }
            if(service.equals("updateCustomer")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    String cid = request.getParameter("cid");
                    Vector<Customer> vector = dao.getCustomers("select * from Customers where CustomerID= '"+cid+"'");
                    request.setAttribute("vector", vector);
                    request.getRequestDispatcher("/update-jsp/updateCustomer.jsp").forward(request, response);
                }else{
                String CustomerID = request.getParameter("CustomerID");
                String  CompanyName = request.getParameter("CompanyName"),
                        ContactName = request.getParameter("ContactName"),
                        ContactTitle = request.getParameter("ContactTitle"),
                        Address = request.getParameter("Address"), 
                        City = request.getParameter("City"), 
                        Region = request.getParameter("Region"),
                        PostalCode = request.getParameter("PostalCode"),
                        Country = request.getParameter("Country"), 
                        Phone = request.getParameter("Phone"), 
                        Fax = request.getParameter("Fax");
                int CustomerStatus= Integer.parseInt(request.getParameter("CustomerStatus"));
                Customer cus = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address, 
                        City, Region, PostalCode, Country, Phone, Fax, CustomerStatus);
                dao.updateCustomer(cus);
                response.sendRedirect("CustomerURL?service=listAllCustomers");
                }
            }
            if(service.equals("insertCustomer")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    
                    request.getRequestDispatcher("/insert-jsp/insertCustomer.jsp").forward(request, response);
                }else{
                String CustomerID = request.getParameter("CustomerID");
                String  CompanyName = request.getParameter("CompanyName"),
                        ContactName = request.getParameter("ContactName"),
                        ContactTitle = request.getParameter("ContactTitle"),
                        Address = request.getParameter("Address"), 
                        City = request.getParameter("City"), 
                        Region = request.getParameter("Region"),
                        PostalCode = request.getParameter("PostalCode"),
                        Country = request.getParameter("Country"), 
                        Phone = request.getParameter("Phone"), 
                        Fax = request.getParameter("Fax");
                int CustomerStatus= Integer.parseInt(request.getParameter("CustomerStatus"));
                Customer cus = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address, 
                        City, Region, PostalCode, Country, Phone, Fax, CustomerStatus);
                dao.insertCustomer(cus);
                response.sendRedirect("CustomerURL?service=listAllCustomers");
                }
            }
            
            if(service.equals("loginCustomer")){
                String login = request.getParameter("Login");
            if(login==null){
                request.getRequestDispatcher("/jsp/loginCustomer.jsp").forward(request, response);
            }else{
                Customer cus=dao.login(request.getParameter("userName"), request.getParameter("pass"));
                if(cus == null){
                    request.setAttribute("error", "Invalid username or password");
                    request.getRequestDispatcher("/jsp/loginCustomer.jsp").forward(request, response);
                }else{
                    session.setAttribute("cus", cus);
                    System.out.println(cus);
                    request.getRequestDispatcher("indexURL?service=listAllMenu").forward(request, response);
                }
            }               
            }
            if(service.equals("logout")){
                session.invalidate();
                response.sendRedirect("indexURL");
            }
            if (service.equals("listAllCustomers")) {
            String sql = "select * from Customers";
            String submit = request.getParameter("submit");
            
            if(submit==null){
                sql = "select * from Customers";
            }else{
                String cname=request.getParameter("cname");
                sql="select * from Customers where ContactName like '%"+cname+"%'";
            }
            
            Vector<Customer> vector = dao.getCustomers(sql);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayCustomer.jsp");
            request.setAttribute("data", vector);
            request.setAttribute("emp", emp);
            request.setAttribute("title", "Customer manager");
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
