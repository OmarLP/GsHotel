
package org.oleon.gshotel.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.oleon.gshotel.claseDAO.CategoriaHabDAO;
import org.oleon.gshotel.modelo.CategoriaHab;

@WebServlet(name = "CategoriaHabControlador", urlPatterns = {"/CategoriaHabControlador"})
public class CategoriaHabControlador extends HttpServlet{
    
    CategoriaHab categoriaHab = new CategoriaHab();
    CategoriaHabDAO categoriaHabDAO = new CategoriaHabDAO();
    int idch;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");

        if (menu.equals("CategoriaHab")) {
            switch (accion) {
                case "Listar":
                    JOptionPane.showMessageDialog(null, "Estas dentro de listar");
                    List listaCategoriaHab = categoriaHabDAO.listar();
                    req.setAttribute("listaCategoriaHab", listaCategoriaHab);
                    break;

                case "Eliminar":
                    idch = Integer.parseInt(req.getParameter("idnh"));
                    categoriaHabDAO.eliminar(idch);
                    
                    //se queda en el valor de la fila seleccionada
                    
                      resp.sendRedirect("CategoriaHabControlador?menu=CategoriaHab&&accion=Listar");  
                    
                    //resp.sendRedirect("principal.jsp");
                    //resp.sendRedirect("CategoriaHabControlador?menu=CategoriaHab&&accion=Listar");
                    break;

                default:
                    
                    break;
            }
            req.getRequestDispatcher("categoriaHab.jsp").forward(req, resp);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");
        String mensaje = "";
        int rpt;

        if (menu.equals("CategoriaHab")) {
            switch (accion) {
                case "Listar":
                    List listaCategoriaHab = categoriaHabDAO.listar();
                    req.setAttribute("listaCategoriaHab", listaCategoriaHab);
                    break;
                    
                case "Guardar":
                    String nombreCategoria = req.getParameter("nombreCategoria");
                    JOptionPane.showMessageDialog(null, "El parámetro en guardar es " + nombreCategoria);
                    categoriaHab.setNombreCategoria(nombreCategoria);
                    categoriaHabDAO.guardar(categoriaHab);

                    resp.sendRedirect("CategoriaHabControlador?menu=CategoriaHab&&accion=Listar");

                    break;

                default:
                    break;
            }
            //req.getRequestDispatcher("categoriaHab.jsp").forward(req, resp);
        }
    }

}

