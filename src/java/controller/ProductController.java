/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Employees;
import entity.Product;
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
import model.DAOProduct;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductURL"})
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Employees emp = (Employees)session.getAttribute("emp");
        DAOProduct dao = new DAOProduct();
//        display all product
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if(service==null){
                service="listAllProducts";
            }
            
            if(service.equals("deleteProduct")){
                dao.deleteProduct(Integer.parseInt(request.getParameter("pid")));
                response.sendRedirect("ProductURL?service=listAllProducts");
            }
            if (service.equals("updateProduct")) {
                String submit = request.getParameter("submit");
                if(submit==null){//show form
                    int pid=Integer.parseInt(request.getParameter("pid"));
                    Vector<Product> vector = dao.getProducts("select * from Products where ProductID ="+pid);
                    request.setAttribute("vector", vector);
                    ResultSet rsSup = dao.getData("SELECT  SupplierID,CompanyName FROM Suppliers");
                    ResultSet rsCat = dao.getData("SELECT  CategoryID,CategoryName FROM Categories");
                    request.setAttribute("rsSup", rsSup);
                    request.setAttribute("rsCat", rsCat);
                    request.getRequestDispatcher("/update-jsp/updateProduct.jsp").forward(request, response);
                }else{
                //if(submit != null){
                int ProductID = Integer.parseInt(request.getParameter("ProductID"));
                String ProductName = request.getParameter("ProductName");
                String SupplierID = request.getParameter("SupplierID");
                String CategoryID = request.getParameter("CategoryID");
                String QuantityPerUnit = request.getParameter("QuantityPerUnit");
                String UnitPrice = request.getParameter("UnitPrice");
                String UnitsInStock = request.getParameter("UnitsInStock");
                String UnitsOnOrder = request.getParameter("UnitsOnOrder");
                String ReorderLevel = request.getParameter("ReorderLevel");
                String Discontinued = request.getParameter("Discontinued");
//                    check data(double check)
                if (ProductName.equals("")) {
                    out.print("product name is not empty");
                }
//                    convert
                int SupplierId = Integer.parseInt(SupplierID),
                        CategoryId = Integer.parseInt(CategoryID);
                double UnitPricE = Double.parseDouble(UnitPrice);
                int UnitsInStocK = Integer.parseInt(UnitsInStock),
                        UnitsOnOrdeR = Integer.parseInt(UnitsOnOrder),
                        ReorderLeveL = Integer.parseInt(ReorderLevel);
                boolean DiscontinueD = (Integer.parseInt(Discontinued) == 1 ? true : false);
                Product pro = new Product(ProductID, ProductName, SupplierId, CategoryId, QuantityPerUnit, UnitPricE, UnitsInStocK, UnitsOnOrdeR, ReorderLeveL, DiscontinueD);
                int n = dao.updateProduct(pro);
                response.sendRedirect("ProductURL?service=listAllProducts");
                }              
            }
            if (service.equals("insertProduct")) {
                String submit = request.getParameter("submit");
                if(submit==null){//show form
                    ResultSet rsSup = dao.getData("SELECT  SupplierID,CompanyName FROM Suppliers");
                    ResultSet rsCat = dao.getData("SELECT  CategoryID,CategoryName FROM Categories");
                    request.setAttribute("rsSup", rsSup);
                    request.setAttribute("rsCat", rsCat);
                    request.getRequestDispatcher("/insert-jsp/insertProduct.jsp").forward(request, response);
                }else{
                //if(submit != null){
                    String ProductName = request.getParameter("ProductName");
                String SupplierID = request.getParameter("SupplierID");
                String CategoryID = request.getParameter("CategoryID");
                String QuantityPerUnit = request.getParameter("QuantityPerUnit");
                String UnitPrice = request.getParameter("UnitPrice");
                String UnitsInStock = request.getParameter("UnitsInStock");
                String UnitsOnOrder = request.getParameter("UnitsOnOrder");
                String ReorderLevel = request.getParameter("ReorderLevel");
                String Discontinued = request.getParameter("Discontinued");
//                    check data(double check)
                if (ProductName.equals("")) {
                    out.print("product name is not empty");
                }
//                    convert
                int SupplierId = Integer.parseInt(SupplierID),
                        CategoryId = Integer.parseInt(CategoryID);
                double UnitPricE = Double.parseDouble(UnitPrice);
                int UnitsInStocK = Integer.parseInt(UnitsInStock),
                        UnitsOnOrdeR = Integer.parseInt(UnitsOnOrder),
                        ReorderLeveL = Integer.parseInt(ReorderLevel);
                boolean DiscontinueD = (Integer.parseInt(Discontinued) == 1 ? true : false);
                Product pro = new Product(ProductName, SupplierId, CategoryId, QuantityPerUnit, UnitPricE, UnitsInStocK, UnitsOnOrdeR, ReorderLeveL, DiscontinueD);
                int n = dao.addProduct(pro);
                response.sendRedirect("ProductURL?service=listAllProducts");
                }              
            }
            if(service.equals("findCategories")){
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    Vector<Product> vector =dao.getProducts("select * from Products Where CategoryID =" + cid);
                RequestDispatcher dispath=request.getRequestDispatcher("/jsp/displayProduct.jsp");
                //set data
                request.setAttribute("vector", vector);
                request.setAttribute("title", "List of Product");
                //run-view
                dispath.forward(request, response);
            }
            if(service.equals("findSupplier")){
                    int sid = Integer.parseInt(request.getParameter("sid"));
                    Vector<Product> vector =dao.getProducts("select * from Products Where SupplierID =" + sid);
                RequestDispatcher dispath=request.getRequestDispatcher("/jsp/displayProduct.jsp");
                //set data
                request.setAttribute("data", vector);
                request.setAttribute("title", "Product manager");
                //run-view
                dispath.forward(request, response);
            }
            if(service.equals("ProductID")){
                Vector<Product> vector = dao.getProducts("select * from Products  Where Discontinued = 1 order by UnitPrice desc");
                request.setAttribute("vector", vector);
                request.getRequestDispatcher("/jsp/Content.jsp").forward(request, response);
            }
            if (service.equals("listAllProducts")) {               
                String sql = "select * from Products order by UnitPrice desc";
                String submit = request.getParameter("submit");
                if (submit == null) { //chua nhan submit -->khong search--> sql default
                    sql = "select * from Products order by UnitPrice desc";
                } else {
                    String pname = request.getParameter("pname");
                    sql = "select * from Products Where ProductName like '%" + pname + "%'";
                }
                Vector<Product> vector = dao.getProducts(sql);
                //select view
                RequestDispatcher dispath=request.getRequestDispatcher("/jsp/displayProduct.jsp");
                //set data
                request.setAttribute("vector", vector);
                request.setAttribute("emp", emp);
                request.setAttribute("title", "Product manager");
                //run-view
                dispath.forward(request, response);
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
