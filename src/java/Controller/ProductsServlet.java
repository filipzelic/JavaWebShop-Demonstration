/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Model.Repository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author filipzelic
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/products"})
public class ProductsServlet extends HttpServlet {

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
        if(request.getParameter("id") != null) {
            getProduct(request, response);
        }
        else if(request.getParameter("category") != null) {
            getProductsForCategory(request, response, request.getParameter("category"));
        }
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
        
    }
    
    private void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        Product product = repository.getProduct(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getProductsForCategory(HttpServletRequest request, HttpServletResponse response, String category) throws ServletException, IOException {
        Repository repository = new Repository();

        List<Product> products = repository.getProductsByCategory(category);

        if(products.size() > 0) {
            request.setAttribute("products", products);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
//            throw new javax.servlet.ServletException(RESOURCE_NOT_FOUND_MESSAGE);
        }
    }
}
