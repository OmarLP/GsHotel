
package org.oleon.gshotel.controlador;

import jakarta.enterprise.context.Initialized;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.oleon.gshotel.claseDAO.PersonalDAO;
import org.oleon.gshotel.modelo.Personal;

@WebServlet("/login")
public class Login extends HttpServlet{

    PersonalDAO personalDAO = new PersonalDAO();
    Personal personal = new Personal();
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        
        
        personal = personalDAO.validar(usuario, password);
              
        if (personal.getDocumento() != null) {
            sesion = req.getSession();
            sesion.setAttribute("personalSesion", personal);
            
            req.setAttribute("personalLogin", personal);
            req.getRequestDispatcher("principal.jsp").forward(req, resp);
            
        }else{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        
        
        
        
    }
    
    
    
}
