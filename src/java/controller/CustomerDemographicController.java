/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.CustomerDemographic;
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
import model.DAOCustomerDemographic;

/**
 *
 * @author nguye
 */
@WebServlet(name="CustomerDemographicController", urlPatterns={"/CustomerDemographicURL"})
public class CustomerDemographicController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOCustomerDemographic dao = new DAOCustomerDemographic();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if(service.equals("deleteCustomerDemo")){
                dao.deleteCustomerDemo(request.getParameter("cid"));
                response.sendRedirect("CustomerDemographicURL?service=listAllCustomerDemographics");
            }
            if(service.equals("updateCustomerDemo")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    String cid = request.getParameter("cid");
                    Vector<CustomerDemographic> vector = dao.getCustomerDemographics("select * from CustomerDemographics where CustomerTypeID='"+cid+"'");
                    request.setAttribute("vector", vector);
                    request.getRequestDispatcher("/update-jsp/updateCustomerDemo.jsp").forward(request, response);
                }else{
                String CustomerTypeID = request.getParameter("CustomerTypeID"),
                        CustomerDesc = request.getParameter("CustomerDesc");
                int DemographicStatus = Integer.parseInt(request.getParameter("DemographicStatus"));
                
                CustomerDemographic cus = new CustomerDemographic(CustomerTypeID, CustomerDesc, DemographicStatus);
                dao.updateCustomerDemo(cus);
                response.sendRedirect("CustomerDemographicURL?service=listAllCustomerDemographics");
                }
            }
            if(service.equals("insertCustomerDemo")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    request.getRequestDispatcher("/insert-jsp/insertCustomerDemo.jsp").forward(request, response);
                }else{
                String CustomerTypeID = request.getParameter("CustomerTypeID"),
                        CustomerDesc = request.getParameter("CustomerDesc");
                int DemographicStatus = Integer.parseInt(request.getParameter("DemographicStatus"));
                
                CustomerDemographic cus = new CustomerDemographic(CustomerTypeID, CustomerDesc, DemographicStatus);
                dao.insertCustomerDemo(cus);
                response.sendRedirect("CustomerDemographicURL?service=listAllCustomerDemographics");
                }
            }
            if(service.equals("listAllCustomerDemographics")){
                String sql;
                String submit = request.getParameter("submit");
                if (submit == null) {
                    sql = "select * from CustomerDemographics";
                } else {
                    String cname = request.getParameter("cname");
                    sql ="select * from CustomerDemographics where CustomerDesc like '%" + cname + "%'";
                }
                Vector<CustomerDemographic> vector = dao.getCustomerDemographics(sql);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayCustomerDemographic.jsp");
                request.setAttribute("data", vector);
                request.setAttribute("emp", emp);
                request.setAttribute("title", "CusDemo manager");
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
