/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Customer;
import entity.Employees;
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
import model.DAOEmployees;

/**
 *
 * @author nguye
 */
@WebServlet(name="AdminIndexController", urlPatterns={"/adminIndexURL"})
public class AdminIndexController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOEmployees dao = new DAOEmployees();
        DAOCustomer da = new DAOCustomer();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if(service == null){
                service = "listAll";
            }
            if(service.equals("listAll")){
                request.setAttribute("emp", emp);
                request.getRequestDispatcher("/admin/adminIndex.jsp").forward(request, response);
            }
            if(service.equals("login")){
                String login = request.getParameter("Login");
                if(login == null){
                    request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                }else{
                    String userName = request.getParameter("userName");
                    int n = userName.length();
                    if(n < 1){
                        request.setAttribute("error", "User name cannot be empty");
                        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                    }else{
                        if(userName.matches("\\d+")){
                          Employees empl = dao.loginEmployees(Integer.parseInt(userName), request.getParameter("pass"));
                            if(empl == null){
                        request.setAttribute("error", "Invalid userName or password");
                        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                        
                    }else{
                        session.setAttribute("emp", empl);
                        request.getRequestDispatcher("adminIndexURL?service=listAll").forward(request, response);
                    }
                        }else{
                    Customer cus=da.login(request.getParameter("userName"), request.getParameter("pass"));
                if(cus == null){
                    request.setAttribute("error", "Invalid username or password");
                    request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                }else{
                    session.setAttribute("cus", cus);
                    System.out.println(cus);
                    request.getRequestDispatcher("indexURL?service=listAllMenu").forward(request, response);
                }
                    }
                }
                }
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
