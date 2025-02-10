/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.EmployeeTerritories;
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
import model.DAOEmployeeTerritories;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name = "EmpTerritoryController", urlPatterns = {"/EmpTerritoryURL"})
public class EmpTerritoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOEmployeeTerritories dao = new DAOEmployeeTerritories();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if(service.equals("deleteEmployeeTerritorieses")){
                dao.deleteEmployeeTerritorieses(Integer.parseInt(request.getParameter("eid")), request.getParameter("tid"));
                response.sendRedirect("EmpTerritoryURL?service=listAllEmpTerritories");
            }
            if(service.equals("insertEmployeeTe")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rsEmp = dao.getData("select EmployeeID,FirstName from Employees");
                    ResultSet rsTe = dao.getData("select TerritoryID, TerritoryDescription from Territories");
                    request.setAttribute("rsEmp", rsEmp);
                    request.setAttribute("rsTe", rsTe);
                    request.getRequestDispatcher("/insert-jsp/insertEmployeeTe.jsp").forward(request, response);
                }else{
                String EmployeeID=request.getParameter("EmployeeID");
                String TerritoryID=request.getParameter("TerritoryID");
                
                int EmployeeId =Integer.parseInt(EmployeeID);
                
                EmployeeTerritories empt = new EmployeeTerritories(EmployeeId, TerritoryID);
                dao.insertEmployeeTe(empt);
                response.sendRedirect("EmpTerritoryURL?service=listAllEmpTerritories");
            }
            }
            if(service.equals("listAllEmpTerritories")){
            String sql = "Select * from EmployeeTerritories";
            String submit=request.getParameter("submit");
            if(submit==null){
                sql = "Select * from EmployeeTerritories";
            }else{
                String eid=request.getParameter("eid");
                sql="Select * from EmployeeTerritories where EmployeeID like '%"+eid+"%'";
            }
            Vector<EmployeeTerritories> vector = dao.getEmployeeTerritories(sql);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayEmpTerritory.jsp");
                request.setAttribute("data", vector);
                request.setAttribute("emp", emp);
                request.setAttribute("title", "EmpTerritory manager");
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
