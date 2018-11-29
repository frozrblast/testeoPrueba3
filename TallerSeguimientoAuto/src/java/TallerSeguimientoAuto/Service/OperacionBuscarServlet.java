/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerSeguimientoAuto.Service;

import TallerSeguimientoAuto.DTO.OperacionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
public class OperacionBuscarServlet extends HttpServlet {

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
        
            OperacionDTO ope = new OperacionDTO();
            ArrayList<OperacionDTO> opes;


            try {
                opes = ope.allOperacion();
                request.setAttribute("opes", opes);
                request.getRequestDispatcher("pages/searchOperacion.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(OperacionBuscarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
        
            int idOperacion = Integer.parseInt(request.getParameter("idOperacion"));
        String path =  "pages/searchOperacion.jsp";
        OperacionDTO opet = new OperacionDTO();
        opet.setIdOperacion(idOperacion);
            try {
                opet = opet.readOperacion(idOperacion);
                request.setAttribute("opet", opet);
                request.getRequestDispatcher(path).forward(request, response);
                doGet(request,response);
            } catch (Exception ex) {
                Logger.getLogger(OperacionBuscarServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
