/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerSeguimientoAuto.Service;

import TallerSeguimientoAuto.DTO.AutoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class AutoServlet extends HttpServlet {

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
        AutoDTO car = new AutoDTO();
        ArrayList<AutoDTO> cars;
        try {
            cars = car.allAutos();
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("pages/insertAuto.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AutoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        
    //int idAuto = Integer.parseInt(request.getParameter("idAuto"));
    String patente = request.getParameter("patente");
    String marca = request.getParameter("marca");
    String modelo = request.getParameter("modelo");
    //Date añoFabricacion = Date.valueOf(request.getParameter("añoFabricacion"));

    String path =  "pages/insertAuto.jsp";
         AutoDTO car = new AutoDTO();
         //car.setIdAuto(idAuto);
         car.setPatente(patente);
         car.setMarca(marca);
         car.setModelo(modelo);

        
        try {
            car.insertAuto(car);
            doGet(request,response);
        } catch (Exception ex) {
            Logger.getLogger(AutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
//        request.setAttribute("idAuto",car.getIdAuto());
//        request.setAttribute("patente",car.getPatente());
//        request.setAttribute("marca",car.getMarca());
//        request.setAttribute("modelo",car.getModelo());
//        request.setAttribute("añoFabricacion",car.getAñoFabricacion());
//        request.getRequestDispatcher(path).forward(request, response);
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
