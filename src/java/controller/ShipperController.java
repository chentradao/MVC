/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Employees;
import entity.Shipper;
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
import model.DAOShipper;

/**
 *
 * @author nguye
 */
@WebServlet(name = "ShipperController", urlPatterns = {"/ShipperURL"})
public class ShipperController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOShipper dao = new DAOShipper();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            /* TODO output your page here. You may use following sample code. */
            if(service.equals("deleteShipper")){
                dao.deleteShipper(Integer.parseInt(request.getParameter("sid")));
                response.sendRedirect("ShipperURL?service=listAllShippers");
            }
            if(service.equals("updateShipper")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int sid = Integer.parseInt(request.getParameter("sid"));
                    Vector<Shipper> vector = dao.getShippers("select * from Shippers where ShipperID="+sid);
                    request.setAttribute("vector", vector);
                    request.getRequestDispatcher("/update-jsp/updateShipper.jsp").forward(request, response);
                }else{
                int ShipperID=Integer.parseInt(request.getParameter("ShipperID"));
                String CompanyName =request.getParameter("CompanyName");
                String Phone = request.getParameter("Phone");
                String ShipperStatus=request.getParameter("ShipperStatus");
                if(CompanyName.equals("")){
                    out.print("Company name can not be null");
                }
                int ShipperStatuS=Integer.parseInt(ShipperStatus);
                Shipper ship = new Shipper(ShipperID,CompanyName, Phone,ShipperStatuS);
                int n = dao.updateShipper(ship);
                response.sendRedirect("ShipperURL?service=listAllShippers");
                }
            }
            if(service.equals("insertShipper")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    request.getRequestDispatcher("/insert-jsp/insertShipper.jsp").forward(request, response);
                }else{
                String CompanyName =request.getParameter("CompanyName");
                String Phone = request.getParameter("Phone");
                String ShipperStatus=request.getParameter("ShipperStatus");
                if(CompanyName.equals("")){
                    out.print("Company name can not be null");
                }
                int ShipperStatuS=Integer.parseInt(ShipperStatus);
                Shipper ship = new Shipper(CompanyName, Phone,ShipperStatuS);
                int n = dao.insertShipper(ship);
                response.sendRedirect("ShipperURL?service=listAllShippers");
                }
            }
            if(service.equals("listAllShippers")){
            String sql = "select * from Shippers";
            String submit = request.getParameter("submit");
            if(submit ==null){
                sql="select * from Shippers";
            }else{
                String sname=request.getParameter("sname");
                sql ="select * from Shippers where CompanyName like '%"+ sname +"%'";
            }
            Vector<Shipper> vector = dao.getShippers(sql);         
                RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/displayShipper.jsp");
                
                request.setAttribute("data", vector);
                request.setAttribute("emp", emp);
                request.setAttribute("title", "Shipper manager");
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
