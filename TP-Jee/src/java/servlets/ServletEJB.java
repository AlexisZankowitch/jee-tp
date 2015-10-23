/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.BonusList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.EJB_Bonus;
import session.EJB_BonusLocal;

/**
 *
 * @author azank
 */
@WebServlet(name = "ServletEJB", urlPatterns = {"/ServletEJB"})
public class ServletEJB extends HttpServlet {
@EJB
private EJB_BonusLocal Ejb; //mettre un E majuscule sinon ça marche pas... TROLOLOLO

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
       BonusList bonusList = new BonusList();
        
        Enumeration enumeration = request.getParameterNames();
        List <String[]> l = new ArrayList();

        //recuperation des valeurs en entrée
        while (enumeration.hasMoreElements()){
            String nomParam = (String) enumeration.nextElement();
            String[] valParam = request.getParameterValues(nomParam);
            l.add(valParam);
        }

        for(int i=0;i<l.size()+1;i++){
            Map<String,String> map = new HashMap<>();
            map.put("ssn", l.get(0)[i]);
            map.put("multiplicator", l.get(1)[i]);
            map.put("amount", Ejb.doMultiplication(l.get(0)[i],l.get(1)[i]));
            bonusList.setList(map);
        }
        
        request.setAttribute("name", "TP-EJB");
        request.setAttribute("bonus_list", bonusList);
        this.getServletContext().getRequestDispatcher( "/affichage_table.jsp" ).forward( request, response );
        
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
