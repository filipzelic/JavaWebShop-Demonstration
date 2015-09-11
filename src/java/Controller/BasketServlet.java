/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Basket;
import Model.Product;
import Model.Repository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author filipzelic
 */
@WebServlet(name = "BasketServlet", urlPatterns = {"/basket"})
public class BasketServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("basket") != null) {
            request.setAttribute("isEmptyBasket", false);
            Basket basket = (Basket)session.getAttribute("basket");
            request.setAttribute("productsInBasket", basket.getAmountAndProductsInBasket());
        }
        else {
            request.setAttribute("isEmptyBasket", true);
        }
        request.getRequestDispatcher("basket.jsp").forward(request, response);
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
        if(request.getParameter("add") != null) {
            addToBasket(request, response);
        }
        else if(request.getParameter("remove") != null) {
            removeFromBasket(request, response); 
        }
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

    private void addToBasket(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Repository repository = new Repository();
        Basket basket;
        Integer amount = Integer.parseInt(request.getParameter("productAmount"));
        Product product = repository.getProduct(Integer.parseInt(request.getParameter("productId")));
        
        if(session.getAttribute("basket") == null) {
            basket = new Basket();
        }
        else {
            basket = (Basket)session.getAttribute("basket");
        }
        
        basket.addProductWithAmountToBasket(amount, product);
        session.setAttribute("basket", basket);
        response.sendRedirect("basket");
    }
    
    private void removeFromBasket(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Repository repository = new Repository();
        Product product = repository.getProduct(Integer.parseInt(request.getParameter("productId")));
        
        if(session.getAttribute("basket") == null) {
            Basket basket = (Basket)session.getAttribute("basket");
            basket.removeProduct(product);
        }
        response.sendRedirect("basket");
    }
}
