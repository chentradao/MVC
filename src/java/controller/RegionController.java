/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Employees;
import entity.Region;
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
import model.DAORegion;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name="RegionController", urlPatterns={"/RegionURL"})
public class RegionController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAORegion dao = new DAORegion();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if(service.equals("deleteRegion")){
                dao.deleteRegion(Integer.parseInt(request.getParameter("rid")));
                response.sendRedirect("RegionURL?service=listAllRegion");
            }
            if(service.equals("updateRegion")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int rid = Integer.parseInt(request.getParameter("rid"));
                    Vector<Region> vector = dao.getRegions("select * from Region where RegionID="+rid);
                    request.setAttribute("vector", vector);
                    request.getRequestDispatcher("/update-jsp/updateRegion.jsp").forward(request, response);
                }else{
                int RegionID = Integer.parseInt(request.getParameter("RegionID"));
                String RegionDescription = request.getParameter("RegionDescription");
                int RegionStatus = Integer.parseInt(request.getParameter("RegionStatus"));
                
                Region re = new Region(RegionID, RegionDescription, RegionStatus);
                
                dao.updateRegion(re);
                response.sendRedirect("RegionURL?service=listAllRegion");
                }
            }
            if(service.equals("insertRegion")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    request.getRequestDispatcher("/insert-jsp/insertRegion.jsp").forward(request, response);
                }else{
                int RegionID = Integer.parseInt(request.getParameter("RegionID"));
                String RegionDescription = request.getParameter("RegionDescription");
                int RegionStatus = Integer.parseInt(request.getParameter("RegionStatus"));
                
                Region re = new Region(RegionID, RegionDescription, RegionStatus);
                
                dao.insertRegion(re);
                response.sendRedirect("RegionURL?service=listAllRegion");
                }
            }
            if (service.equals("listAllRegion")) {
                String sql;
                String submit = request.getParameter("submit");
                if (submit == null) {
                    sql = "SELECT * FROM Region";
                } else {
                    String rname = request.getParameter("rname");
                    sql = "SELECT * FROM Region WHERE RegionDescription LIKE '%" + rname + "%'";
                }
                Vector<Region> vector = dao.getRegions(sql);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayRegion.jsp");
                request.setAttribute("data", vector);
                request.setAttribute("emp", emp);
                request.setAttribute("title", "Region manager");
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
