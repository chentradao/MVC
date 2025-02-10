/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Employees;
import entity.Territories;
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
import model.DAOTerritories;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name = "TerritorieController", urlPatterns = {"/TerritorieURL"})
public class TerritorieController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOTerritories dao = new DAOTerritories();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("deleteTerritories")) {
                dao.deleteTerritories(request.getParameter("tid"));
                response.sendRedirect("TerritorieURL?service=listAllTerritories");
            }
            if (service.equals("updateTerritories")) {
                String submit = request.getParameter("submit");
                if(submit == null){
                    String tid = request.getParameter("tid");
                    Vector<Territories> vector = dao.getTerritorieses("select * from Territories where TerritoryID='" +tid+"'");
                    request.setAttribute("vector", vector);
                    ResultSet rsRe=dao.getData("SELECT RegionID,RegionDescription FROM Region");
                    request.setAttribute("rsRe", rsRe);
                    request.getRequestDispatcher("/update-jsp/updateTerritories.jsp").forward(request, response);
                }else{
                String TerritoryID = request.getParameter("TerritoryID");
                String TerritoryDescription = request.getParameter("TerritoryDescription");
                String RegionID = request.getParameter("RegionID");

                int RegionId = Integer.parseInt(RegionID);
                int TerritoryStatus = Integer.parseInt(request.getParameter("TerritoryStatus"));
                Territories ter = new Territories(TerritoryID, TerritoryDescription, RegionId,TerritoryStatus);
                int n = dao.updateTerritories(ter);
                response.sendRedirect("TerritorieURL?service=listAllTerritories");
                }
            }
            if (service.equals("insertTerritories")) {
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rsRe=dao.getData("SELECT RegionID,RegionDescription FROM Region");
                    request.setAttribute("rsRe", rsRe);
                    request.getRequestDispatcher("/insert-jsp/insertTerritories.jsp").forward(request, response);
                }else{
                String TerritoryID = request.getParameter("TerritoryID");
                String TerritoryDescription = request.getParameter("TerritoryDescription");
                String RegionID = request.getParameter("RegionID");

                int RegionId = Integer.parseInt(RegionID);
                int TerritoryStatus = Integer.parseInt(request.getParameter("TerritoryStatus"));
                Territories ter = new Territories(TerritoryID, TerritoryDescription, RegionId,TerritoryStatus);
                int n = dao.insertTerritories(ter);
                response.sendRedirect("TerritorieURL?service=listAllTerritories");
                }
            }
            if (service.equals("listAllTerritories")) {
                String sql= "select * from Territories";
                String submit = request.getParameter("submit");
                if (submit == null) {
                    sql = "select * from Territories";
                } else {
                    String tname = request.getParameter("tname");
                    sql = "select * from Territories where TerritoryDescription like '%" + tname + "%'";
                }
                Vector<Territories> vector = dao.getTerritorieses(sql);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayTerritories.jsp");
                 request.setAttribute("data", vector);
                 request.setAttribute("emp", emp);
                 request.setAttribute("title", "Territories manager");
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
