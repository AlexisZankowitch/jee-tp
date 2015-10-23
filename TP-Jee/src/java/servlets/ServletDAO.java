/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.BeanBonusDAO;
import dao.BonusDAO;
import java.io.IOException;
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
@WebServlet(name = "ServletDAO", urlPatterns = {"/ServletDAO"})
public class ServletDAO extends HttpServlet {

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
        List <BeanBonusDAO> lBonusDAO = new ArrayList();
        BonusDAO bdao = BonusDAO.getInstance();
        
        //recuperation des valeurs en entrée
        while (enumeration.hasMoreElements()){
            String nomParam = (String) enumeration.nextElement();
            String[] valParam = request.getParameterValues(nomParam);
            l.add(valParam);
        }
        
        //parcours liste des parcours
        for(int i=0;i<l.size()+1;i++){
            BeanBonusDAO beanBonusDAO = new BeanBonusDAO(l.get(0)[i], l.get(1)[i]);
            beanBonusDAO.setBonus(doMultiplication(beanBonusDAO.getSsn(), beanBonusDAO.getMultiplier()));
            bdao.create(beanBonusDAO);
            lBonusDAO.add(beanBonusDAO);
        }
        
        request.setAttribute("name", "TP-DAO");
        request.setAttribute("bonus_list", lBonusDAO);
        //find selon un id 
        request.setAttribute("find", bdao.findById("1"));
        //find selon un ssn
        request.setAttribute("findSsn",bdao.findBySsn("1"));
        this.getServletContext().getRequestDispatcher( "/affichage_dao.jsp" ).forward( request, response );
               
        
    }
    
    private String doMultiplication(String ssn, String multiplication){
         try {
            return String.valueOf(Integer.parseInt(multiplication) * Integer.parseInt(ssn));
         } catch (Exception e) {
            return "vide";
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
