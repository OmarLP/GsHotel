
package org.oleon.gshotel.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.oleon.gshotel.claseDAO.NivelHabDAO;
import org.oleon.gshotel.modelo.NivelHab;

@WebServlet(name = "NivelHabControlador", urlPatterns = {"/NivelHabControlador"})
public class NivelHabControlador extends HttpServlet{
    NivelHab nivelHab = new NivelHab();
    NivelHabDAO nivelHabDAO = new NivelHabDAO();
    int idnh;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");

        if (menu.equals("NivelHab")) {
            switch (accion) {
                case "Listar":
                    List listaNivelHab = nivelHabDAO.listar();
                    req.setAttribute("listaNivelHab", listaNivelHab);
                    break;

                case "Eliminar":
                    idnh = Integer.parseInt(req.getParameter("idnh"));
                    nivelHabDAO.eliminar(idnh);
                    
                    //se queda en el valor de la fila seleccionada
                    idnh = 0;
                    if (idnh == 0) {
                      resp.sendRedirect("NivelHabControlador?menu=NivelHab&&accion=Listar");  
                    }
                    //resp.sendRedirect("principal.jsp");
                    //resp.sendRedirect("NivelHabControlador?menu=NivelHab&&accion=Listar");
                    break;

                default:
                    
                    break;
            }
            req.getRequestDispatcher("nivelHab.jsp").forward(req, resp);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");
        String mensaje = "";
        int rpt;

        if (menu.equals("NivelHab")) {
            switch (accion) {
                case "Listar":
                    List listaNivelHab = nivelHabDAO.listar();
                    req.setAttribute("listaNivelHab", listaNivelHab);
                    break;
                    
                case "Guardar":
                    String nombreNivel = req.getParameter("nombreNivel");

                    nivelHab.setNombreNivel(nombreNivel);
                    nivelHabDAO.guardar(nivelHab);

                    resp.sendRedirect("NivelHabControlador?menu=NivelHab&&accion=Listar");

                    break;

                default:
                    break;
            }
            //req.getRequestDispatcher("nivelHab.jsp").forward(req, resp);
        }
    }

}
