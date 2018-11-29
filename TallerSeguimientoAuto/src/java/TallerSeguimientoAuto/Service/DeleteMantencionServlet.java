/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerSeguimientoAuto.Service;

import TallerSeguimientoAuto.DTO.MantencionDTO;
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
public class DeleteMantencionServlet extends HttpServlet {

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
        
        String path = "pages/searchMantencion.jsp";
            MantencionDTO man = new MantencionDTO();
            ArrayList<MantencionDTO> mans;

            try {
                mans = man.allMantencion();
                request.setAttribute("mans", mans);
                request.getRequestDispatcher("pages/searchMantencion.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(DeleteMantencionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
         String path = "pages/searchMantencion.jsp";
        int idMantencion =Integer.parseInt(request.getParameter("idElimnar"));
        String mensajeError;
        MantencionDTO man = new MantencionDTO();
        man.setIdMantencion(idMantencion);
        try {
            man.deleteMantencion(idMantencion);
            request.setAttribute("idMantencion", idMantencion);
            request.getRequestDispatcher(path).forward(request, response);
            //doGet(request,response);
        } catch (Exception ex) {
            Logger.getLogger(DeleteMantencionServlet.class.getName()).log(Level.SEVERE, null, ex);
            mensajeError="No se pudo eliminar, "+ex.getMessage();
            request.setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher(path).forward(request, response);
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
