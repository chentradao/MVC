/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Cart;
import entity.Customer;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Vector;
import model.DAOCart;
import model.DAOOrder;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author nguye
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartURL"})
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCart dao = new DAOCart();
        DAOOrder da = new DAOOrder();
        HttpSession session = request.getSession(true);
        Customer cus= (Customer)session.getAttribute("cus");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service.equals("add2cart")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Cart newCart = dao.getCart(pid);
                if (session.getAttribute(pid + "") == null) {
                    newCart.setQuantity(1);
                    session.setAttribute(pid + "", newCart);
                } else {
                    Cart oldCart = (Cart) session.getAttribute(pid + "");
                    oldCart.setQuantity(oldCart.getQuantity() + 1);
                    session.setAttribute(pid + "", oldCart);
                }
                response.sendRedirect("indexURL?service=listAllMenu");
            }
            if (service.equals("showCart")) {
                Vector<Cart> vector = new Vector<>();
                Enumeration enu = session.getAttributeNames(); //lay lai cot key
                while (enu.hasMoreElements()) {
                    String key = (String) enu.nextElement();
                    Object obj = session.getAttribute(key);

                    if (obj instanceof Cart) {
                        Cart cart = (Cart) obj;
                        vector.add(cart);
                    }
                }
                request.setAttribute("vectorCart", vector);
                request.getRequestDispatcher("/jsp/showCart.jsp").forward(request, response);
            }
            if(service.equals("removeCart")){
                int pid = Integer.parseInt(request.getParameter("pid"));
                Enumeration enu = session.getAttributeNames();
                while(enu.hasMoreElements()){
                    String key = (String)enu.nextElement();
                    Object obj = session.getAttribute(key);
                    if(obj instanceof Cart){
                        Cart cart = (Cart)obj;
                        if(cart.getProductID() == pid){
                        session.removeAttribute(key);
                        }
                    }  
                }
                response.sendRedirect("CartURL?service=showCart");
            }
            if(service.equals("updateCart")){
                String submit = request.getParameter("submit");
                if(submit != null){
                Enumeration enu = session.getAttributeNames();
                while(enu.hasMoreElements()){
                    String key = (String)enu.nextElement();
                    Object obj = session.getAttribute(key);
                    if(obj instanceof Cart){
                        Cart cart = (Cart)obj;
                        int pid = cart.getProductID();
                        int Quantity = Integer.parseInt(request.getParameter("Quantity_"+pid));
                        if(Quantity == 0){
                        session.removeAttribute(key);
                        }else{
                            cart.setQuantity(Quantity);
                            session.setAttribute(key, cart);
                        }
                    }
                }
                response.sendRedirect("CartURL?service=showCart");
            }
          }
        }
    }
    
    
//    if(service.equals("showCart")){
//                Vector<Cart> vector = new Vector<>();
//                Enumeration enu = session.getAttributeNames(); //lay lai cot key
//                while(enu.hasMoreElements()){
//                    String key = (String)enu.nextElement();
//                    Cart cart = (Cart)session.getAttribute(key);
//                    vector.add(cart);
//                }
//                request.setAttribute("vectorCart", vector);
//                request.getRequestDispatcher("/jsp/showCart.jsp").forward(request, response);
//            }
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
