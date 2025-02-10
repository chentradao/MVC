/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Cart;
import entity.Customer;
import entity.Employees;
import entity.Order;
import entity.OrderDetail;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOOrder;
import java.sql.ResultSet;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Enumeration;
import model.DAOOrderDetail;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nguye
 */
@WebServlet(name="OrderController", urlPatterns={"/OrderURL"})
public class OrderController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Customer cus= (Customer)session.getAttribute("cus");
        Employees emp = (Employees)session.getAttribute("emp");
        System.out.println(cus);
        DAOOrder dao = new DAOOrder();
        DAOOrderDetail da = new DAOOrderDetail();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            /* TODO output your page here. You may use following sample code. */
            if(service == null){
                service = "listAllOrders";
            }
            if(service.equals("deleteOrder")){
                dao.deleteOrder(Integer.parseInt(request.getParameter("oid")));
                response.sendRedirect("OrderURL?service=listAllOrders");
            }
            if(service.equals("updateOrder")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int oid = Integer.parseInt(request.getParameter("oid"));
                    Vector<Order> vector = dao.getOrders("select * from Orders where OrderID="+oid);
                    request.setAttribute("vector", vector);
                    ResultSet rsCus = dao.getData("select CustomerID,CompanyName from Customers");
                    ResultSet rsShip = dao.getData("SELECT ShipperID,CompanyName FROM Shippers");
                    ResultSet rsEmp= dao.getData("select EmployeeID,FirstName from Employees");
                    request.setAttribute("rsCus", rsCus);
                    request.setAttribute("rsShip", rsShip);
                    request.setAttribute("rsEmp", rsEmp);
                    request.getRequestDispatcher("/update-jsp/updateOrder.jsp").forward(request, response);
                }else{
                int OrderID = Integer.parseInt(request.getParameter("OrderID"));
                String CustomerID = request.getParameter("CustomerID");
                int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
                String OrderDate = request.getParameter("OrderDate");
                String RequiredDate = request.getParameter("RequiredDate");
                String ShippedDate = request.getParameter("ShippedDate");
                int ShipVia = Integer.parseInt(request.getParameter("ShipVia"));
                double Freight = Double.parseDouble(request.getParameter("Freight"));
                String ShipName = request.getParameter("ShipName");
                String ShipAddress = request.getParameter("ShipAddress");
                String ShipCity = request.getParameter("ShipCity");
                String ShipRegion = request.getParameter("ShipRegion");
                String ShipPostalCode = request.getParameter("ShipPostalCode");
                String ShipCountry = request.getParameter("ShipCountry");
                int OrderStatus = Integer.parseInt(request.getParameter("OrderStatus"));
                
                Order or = new Order(OrderID, CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry, OrderStatus);
                int n=dao.updateOrder(or);
                response.sendRedirect("OrderURL?service=listAllOrders");
                }
            }
            
            if(service.equals("insertOrder")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rsCus = dao.getData("select CustomerID,CompanyName from Customers");
                    ResultSet rsShip = dao.getData("SELECT ShipperID,CompanyName FROM Shippers");
                    ResultSet rsEmp= dao.getData("select EmployeeID,FirstName from Employees");
                    request.setAttribute("rsCus", rsCus);
                    request.setAttribute("rsShip", rsShip);
                    request.setAttribute("rsEmp", rsEmp);
                    request.getRequestDispatcher("/insert-jsp/insertOrder.jsp").forward(request, response);
                }else{
                String CustomerID = request.getParameter("CustomerID");
                int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
                String OrderDate = request.getParameter("OrderDate");
                String RequiredDate = request.getParameter("RequiredDate");
                String ShippedDate = request.getParameter("ShippedDate");
                int ShipVia = Integer.parseInt(request.getParameter("ShipVia"));
                double Freight = Double.parseDouble(request.getParameter("Freight"));
                String ShipName = request.getParameter("ShipName");
                String ShipAddress = request.getParameter("ShipAddress");
                String ShipCity = request.getParameter("ShipCity");
                String ShipRegion = request.getParameter("ShipRegion");
                String ShipPostalCode = request.getParameter("ShipPostalCode");
                String ShipCountry = request.getParameter("ShipCountry");
                int OrderStatus = Integer.parseInt(request.getParameter("OrderStatus"));
                Order ord = new Order(CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry, OrderStatus);
                int n = dao.insertOrder(ord);
                response.sendRedirect("OrderURL?service=listAllOrders");
                }
            }
            if(service.equals("updateStatus")){
                    int status = Integer.parseInt(request.getParameter("Status"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vector<Order> vector = dao.getOrders("select * from Orders where OrderID ="+id);
                    for(Order or : vector){
                        or.setOrderStatus(status);
                        dao.updateOrder(or);
                    }
                    response.sendRedirect("OrderURL?service=listAllOrders");
                
            }
            if(service.equals("findCustomer")){
                String cid = request.getParameter("cid");
                Vector<Order> vector = dao.getOrders("select OrderID, CustomerID,EmployeeID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,FORMAT(ShippedDate, 'dd/MM/yyyy') AS ShippedDate,\n" +
"ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,OrderStatus \n" +
"from Orders Where CustomerID ='"+cid+"'");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayOrder.jsp");
            request.setAttribute("data", vector);
            request.setAttribute("title", "List of Order");
            dispatcher.forward(request, response);
            }
            if(service.equals("purchase")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    if(cus == null){
                        request.getRequestDispatcher("CustomerURL?service=loginCustomer").forward(request, response);
                    }else{
                    ResultSet rsShip = dao.getData("SELECT ShipperID,CompanyName FROM Shippers");
                    ResultSet rsEmp= dao.getData("select EmployeeID,FirstName from Employees");
                    request.setAttribute("rsShip", rsShip);
                    request.setAttribute("rsEmp", rsEmp);
                    request.setAttribute("cus", cus);
                request.getRequestDispatcher("/jsp/purchase.jsp").forward(request, response);
                    }
                }else{
                    LocalDate currentDate = LocalDate.now();
                String EmployeeID=request.getParameter("EmployeeID");
                String OrderDate=currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String RequiredDate=request.getParameter("RequiredDate");
                String ShippedDate=request.getParameter("ShippedDate");
                String ShipVia=request.getParameter("ShipVia");
                String Freight=request.getParameter("Freight");
                String ShipName=request.getParameter("ShipName");
                String ShipAddress=request.getParameter("ShipAddress");
                String ShipCity=request.getParameter("ShipCity");
                String ShipRegion=request.getParameter("ShipRegion");
                String ShipPostalCode=request.getParameter("ShipPostalCode");
                String ShipCountry=request.getParameter("ShipCountry");
                
                
                //double check
                //convert
                int EmployeeId =Integer.parseInt(EmployeeID);
                int ShipViA=Integer.parseInt(ShipVia);
                double FreighT=Double.parseDouble(Freight);
                int OrderStatus= 1;
                
                Order or = new Order(cus.getCustomerID(), EmployeeId, OrderDate, RequiredDate, ShippedDate, ShipViA, FreighT, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry, OrderStatus);
                int n=dao.insertOrder(or);
                if (n > 0) {
            // Insert các mục giỏ hàng vào OrderDetails
            Enumeration<String> enu = session.getAttributeNames();
            while (enu.hasMoreElements()) {
                String key = enu.nextElement();
                Object obj = session.getAttribute(key);
                
                if (obj instanceof Cart) {
                    Cart cart = (Cart) obj;
                    dao.addToOrder(cart);  
                    session.removeAttribute(key);
                }
            }
            response.sendRedirect("indexURL");
        } 
                }
            }
            if(service.equals("listAllOrders")){
            String sql = "select OrderID, CustomerID,EmployeeID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,FORMAT(ShippedDate, 'dd/MM/yyyy') AS ShippedDate,\n" +
"ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,OrderStatus \n" +
                     " from Orders";
            String submit = request.getParameter("submit");
            if (submit == null) {
                //default
                sql = "select OrderID, CustomerID,EmployeeID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,FORMAT(ShippedDate, 'dd/MM/yyyy') AS ShippedDate,\n" +
"ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,OrderStatus \n" +
                        " from Orders";
            } else {
                String pname = request.getParameter("pname");
                sql = "select OrderID, CustomerID,EmployeeID,FORMAT(OrderDate, 'dd/MM/yyyy') AS OrderDate,\n" +
"FORMAT(RequiredDate, 'dd/MM/yyyy') AS RequiredDate,FORMAT(ShippedDate, 'dd/MM/yyyy') AS ShippedDate,\n" +
"ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry,OrderStatus \n" +
                        "from Orders Where CustomerID like '%" + pname + "%'";
            }
            Vector<Order> vector = dao.getOrders(sql);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/displayOrder.jsp");
            request.setAttribute("data", vector);
            request.setAttribute("emp", emp);
            request.setAttribute("title", "Order manager");
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
