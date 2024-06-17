
package org.oleon.gshotel.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.oleon.gshotel.claseDAO.ClienteDAO;
import org.oleon.gshotel.modelo.Cliente;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet{
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    int idc;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");

        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaCliente = clienteDAO.listar();
                    req.setAttribute("listaCliente", listaCliente);
                    break;

                case "Eliminar":
                    idc = Integer.parseInt(req.getParameter("idp"));
                    clienteDAO.eliminar(idc);
                    
                    //se queda en el valor de la fila seleccionada
//                    idc = 0;
//                    if (idc == 0) {
                      resp.sendRedirect("ClienteControlador?menu=Cliente&&accion=Listar");  
//                    }
                    //resp.sendRedirect("principal.jsp");
                    //resp.sendRedirect("ClienteControlador?menu=Cliente&&accion=Listar");
                    break;

                default:
                    
                    break;
            }
            req.getRequestDispatcher("cliente.jsp").forward(req, resp);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");
        String mensaje = "";
        int rpt;
                
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaCliente = clienteDAO.listar();
                    req.setAttribute("listaCliente", listaCliente);
                    break;
                    
                case "Guardar":
                    
                    String tipoDoc = req.getParameter("tipoDocC");
                    String documento = req.getParameter("nDocuemntoC");
                    String nombres = req.getParameter("nombresC");
                    String aPaterno = req.getParameter("aPaternoC");
                    String aMaterno = req.getParameter("aMaternoC");
                    String telefono = req.getParameter("telefonoC");
                    String correo = req.getParameter("correoC");

                    cliente.setTipoDocuemnto(tipoDoc);
                    cliente.setDocumento(documento);
                    cliente.setNombres(nombres);
                    cliente.setApellidoPaterno(aPaterno);
                    cliente.setApellidoMaterno(aMaterno);
                    cliente.setTelefono(telefono);
                    cliente.setCorreo(correo);

                    clienteDAO.guardar(cliente);

                    resp.sendRedirect("ClienteControlador?menu=Cliente&&accion=Listar");

                    break;

                default:
                    break;
            }
            //req.getRequestDispatcher("cliente.jsp").forward(req, resp);
        }
    }
}
