/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Categories;
import entity.Order;
import entity.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOCategories;
import model.DAOOrder;
import model.DAOProduct;

/**
 *
 * @author nguye
 */
@WebServlet(name="MenuController", urlPatterns={"/MenuURL"})
public class MenuController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCategories da =new DAOCategories();
        DAOProduct dao = new DAOProduct();
        DAOOrder d = new DAOOrder();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if(service.equals("findCategories")){
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    Vector<Product> catList =dao.getProducts("select * from Products Where CategoryID =" + cid+" and Discontinued = 1 order by UnitPrice desc");
                RequestDispatcher dispath=request.getRequestDispatcher("/jsp/index.jsp");
                //set data
                request.setAttribute("catList", catList);
                request.setAttribute("title", "List of Product");
                //run-view
                dispath.forward(request, response);
            }
            
            if (service.equals("Shopping")) {               
                String sql ;
                String submit = request.getParameter("submit");
                Vector<Categories> data = da.getCategories("select * from Categories");
                if (submit == null) { //chua nhan submit -->khong search--> sql default
                    sql = "select * from Products  Where Discontinued = 1 order by UnitPrice desc";
                } else {
                    String pname = request.getParameter("pname");
                    sql = "select * from Products Where Discontinued = 1 and ProductName like '%" + pname + "%' order by UnitPrice desc";
                }
                Vector<Product> vector = dao.getProducts(sql);
                //select view
                RequestDispatcher dispath=request.getRequestDispatcher("/jsp/ProductID.jsp");
                //set data
                request.setAttribute("vector", vector);
                request.setAttribute("data", data);
                request.setAttribute("title", "List of Product");
                //run-view
                dispath.forward(request, response);
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
