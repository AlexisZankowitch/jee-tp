/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Bonus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azank
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //recuperation variable
        int ssn = convertInt(request.getParameter("socialnumber"));
        int multiplier = convertInt(request.getParameter("multiplier"));
        
        //TP1
        String bonus = multiplier(ssn, multiplier);
        request.setAttribute("bonus",bonus);
        request.setAttribute("ssn",ssn);
        request.setAttribute("multiplier",multiplier);
        
        
        //TP BEAN
        Bonus beanBonus = new Bonus(ssn,multiplier);
        beanBonus.setBonus(multiplier(beanBonus.getSsn(), beanBonus.getMultiplier()));
        request.setAttribute("beanBonus", beanBonus);
       
        
        this.getServletContext().getRequestDispatcher( "/affichage.jsp" ).forward( request, response );
    }
    
    private int convertInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return -1;
        }
    }
    
    private String multiplier(int ssn, int multiplier){
        
        return (ssn<0 || multiplier <0) ? "null" : String.valueOf(ssn * multiplier);
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
