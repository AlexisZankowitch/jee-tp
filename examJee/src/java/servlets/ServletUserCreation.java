/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.UserDAO;
import beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azank
 */
@WebServlet(name = "ServletUserCreation", urlPatterns = {"/ServletUserCreation"})
public class ServletUserCreation extends HttpServlet {

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
        Enumeration enumeration = request.getParameterNames();
        List <String[]> l = new ArrayList();
        List <User> lUsers = new ArrayList();
        UserDAO udao = UserDAO.getInstance();
        
        //recuperation des valeurs en entrée
        while (enumeration.hasMoreElements()){
            String nomParam = (String) enumeration.nextElement();
            String[] valParam = request.getParameterValues(nomParam);
            l.add(valParam);
        }
        
        //création des beans user et insertion en base
        for(int i = 0; i<l.size()+1;i++){
            User user = new User(l.get(0)[i], l.get(1)[i], l.get(2)[i]);
            lUsers.add(user);//peut être pas utile...en fait si =)
            udao.create(user);
        }
        
        request.setAttribute("name", "User Created");
        request.setAttribute("userCreated", lUsers);
        request.setAttribute("userTotal", udao.findAllUsers().size());
        this.getServletContext().getRequestDispatcher( "/affichage.jsp" ).forward( request, response );
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
