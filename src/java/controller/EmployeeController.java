/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
import model.DAOEmployees;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeURL"})
public class EmployeeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees empl = (Employees)session.getAttribute("emp");
        DAOEmployees dao = new DAOEmployees();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if(service == null){
                service ="listAllEmployees";
            }
            if(service.equals("deleteEmployees")){
                dao.deleteEmployees(Integer.parseInt(request.getParameter("eid")));
                response.sendRedirect("EmployeeURL?service=listAllEmployees");
            }
            if (service.equals("insertEmployees")) {
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rsRep=dao.getData("select DISTINCT  e.EmployeeID, e.FirstName\n" +
"from Employees e join Employees es on e.EmployeeID = es.ReportsTo");
                    request.setAttribute("rsRep", rsRep);
                    request.getRequestDispatcher("/insert-jsp/insertEmployee.jsp").forward(request, response);
                }else{
                String LastName = request.getParameter("LastName");
                String FirstName = request.getParameter("FirstName");
                String Title = request.getParameter("Title");
                String TitleOfCourtesy = request.getParameter("TitleOfCourtesy");
                String BirthDate = request.getParameter("BirthDate");
                String HireDate = request.getParameter("HireDate");
                String Address = request.getParameter("Address");
                String City = request.getParameter("City");
                String Region = request.getParameter("Region");
                String PostalCode = request.getParameter("PostalCode");
                String Country = request.getParameter("Country");
                String HomePhone = request.getParameter("HomePhone");
                String Extension = request.getParameter("Extension");
                String Photo = request.getParameter("Photo");
                String Notes = request.getParameter("Notes");
                int ReportsTo = Integer.parseInt(request.getParameter("ReportsTo"));
                String PhotoPath = request.getParameter("PhotoPath");
                int EmployeeStatus = Integer.parseInt(request.getParameter("EmployeeStatus"));

                Employees emp = new Employees(LastName, FirstName, Title, TitleOfCourtesy, BirthDate, 
                        HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension,
                        Photo, Notes, ReportsTo, PhotoPath, EmployeeStatus);
                        int n = dao.insertEmployees(emp);
                response.sendRedirect("EmployeeURL?service=listAllEmployees");
                }
            }
            if(service.equals("loginEmployees")){
                String login = request.getParameter("Login");
                if(login == null){
                    request.getRequestDispatcher("/jsp/loginEmployees.jsp").forward(request, response);
                }else{
                    String userName = request.getParameter("userName");
                    int n = userName.length();
                    if(n < 1){
                        request.setAttribute("error", "User name cannot be empty");
                        request.getRequestDispatcher("/jsp/loginEmployees.jsp").forward(request, response);
                    }else{
                    Employees emp = dao.loginEmployees(Integer.parseInt(userName), request.getParameter("pass"));
                    if(emp == null){
                        request.setAttribute("error", "Invalid userName or password");
                        request.getRequestDispatcher("/jsp/loginEmployees.jsp").forward(request, response);
                        
                    }else{
                        session.setAttribute("emp", emp);
                        request.getRequestDispatcher("adminIndexURL?service=listAll").forward(request, response);
                    }
                }
                }
            }
            
            if (service.equals("listAllEmployees")) {
                String sql = "select * from Employees";
                String submit = request.getParameter("submit");
                if (submit == null) {
                    sql = "select * from Employees";
                } else {
                    String ename = request.getParameter("ename");
                    sql = "select * from Employees where LastName like '%" + ename + "%' or FirstName like '%" + ename + "%'";
                }
                Vector<Employees> vector = dao.getEmployeeses(sql);
                RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/displayEmployee.jsp");
                
                request.setAttribute("data", vector);
                request.setAttribute("emp", empl);
                request.setAttribute("title", "Employees manager");
                dispatch.forward(request, response);
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
