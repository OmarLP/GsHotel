package org.oleon.gshotel.controlador;

import jakarta.persistence.Column;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.oleon.gshotel.claseDAO.PersonalDAO;
import org.oleon.gshotel.modelo.Personal;


@WebServlet(name = "PersonalControlador", urlPatterns = {"/PersonalControlador"})
public class PersonalControlador extends HttpServlet {

    Personal personal = new Personal();
    PersonalDAO personalDAO = new PersonalDAO();
    int idp;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");

        if (menu.equals("Personal")) {
            switch (accion) {
                case "Listar":
                    List listaPersonal = personalDAO.listar();
                    req.setAttribute("listaPersonal", listaPersonal);
                    break;

                case "Eliminar":
                    idp = Integer.parseInt(req.getParameter("idp"));
                    personalDAO.eliminar(idp);

                    //se queda en el valor de la fila seleccionada
                    idp = 0;
                    if (idp == 0) {
                        resp.sendRedirect("PersonalControlador?menu=Personal&&accion=Listar");
                    }
                    //resp.sendRedirect("principal.jsp");
                    //resp.sendRedirect("PersonalControlador?menu=Personal&&accion=Listar");
                    break;

                case "ExportarExcel":
                    JOptionPane.showMessageDialog(null, menu + "  " + accion);

                    String excelFileName = "d:/personal.xlsx";//name of excel file

                    String sheetName = "Sheet1";//name of sheet

                    XSSFWorkbook wb = new XSSFWorkbook();
                    XSSFSheet sheet = wb.createSheet(sheetName);

                    //para agregar la lista
                    List<Personal> listaPer = personalDAO.listar();
                    
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(4).setCellValue("Listado de Personal");
                    
                    Row tituloTabla = sheet.createRow(1);
                    tituloTabla.createCell(0).setCellValue("idPersonal");
                    tituloTabla.createCell(1).setCellValue("TipoDocumento");
                    tituloTabla.createCell(2).setCellValue("Documento");
                    tituloTabla.createCell(3).setCellValue("Nombres");
                    tituloTabla.createCell(4).setCellValue("ApellidoPaterno");
                    tituloTabla.createCell(5).setCellValue("ApellidoMaterno");
                    tituloTabla.createCell(6).setCellValue("Telefono");
                    tituloTabla.createCell(7).setCellValue("Correo");
                    tituloTabla.createCell(8).setCellValue("Estado");
                    
                    
                    int rowNum = 2;
                    for (Personal p : listaPer) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(p.getIdPersonal());
                        row.createCell(1).setCellValue(p.getTipoDocumento());
                        row.createCell(2).setCellValue(p.getDocumento());
                        row.createCell(3).setCellValue(p.getNombres());
                        row.createCell(4).setCellValue(p.getApellidoPaterno());
                        row.createCell(5).setCellValue(p.getApellidoMaterno());
                        row.createCell(6).setCellValue(p.getTelefono());
                        row.createCell(7).setCellValue(p.getCorreo());
                        row.createCell(8).setCellValue(p.getEstado());
                    }
                    
                    for (int i = 0; i < 11; i++) {
                        sheet.autoSizeColumn(i);
                    }
                    
                    //lista
                    FileOutputStream fileOut = new FileOutputStream(excelFileName);
                    
                    //escribiendo el libro en un outputstream
                    wb.write(fileOut);
                    fileOut.flush();
                    fileOut.close();

                    break;

                default:

                    break;
            }
            req.getRequestDispatcher("personal.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menu = req.getParameter("menu");
        String accion = req.getParameter("accion");
        String mensaje = "";
        int rpt;

        if (menu.equals("Personal")) {
            switch (accion) {
                case "Listar":
                    List listaPersonal = personalDAO.listar();
                    req.setAttribute("listaPersonal", listaPersonal);
                    break;

                case "Guardar":
                    String tipoDoc = req.getParameter("tipoDoc");
                    String documento = req.getParameter("nDocuemnto");
                    String nombres = req.getParameter("nombres");
                    String aPaterno = req.getParameter("aPaterno");
                    String aMaterno = req.getParameter("aMaterno");
                    String telefono = req.getParameter("telefono");
                    String correo = req.getParameter("correo");
                    String estado = req.getParameter("estado");
                    String password = req.getParameter("password");

                    personal.setTipoDocumento(tipoDoc);
                    personal.setDocumento(documento);
                    personal.setNombres(nombres);
                    personal.setApellidoPaterno(aPaterno);
                    personal.setApellidoMaterno(aMaterno);
                    personal.setTelefono(telefono);
                    personal.setCorreo(correo);
                    personal.setEstado(estado);
                    personal.setClave(password);

                    personalDAO.guardar(personal);

                    resp.sendRedirect("PersonalControlador?menu=Personal&&accion=Listar");

                    break;

                default:
                    break;
            }
            //req.getRequestDispatcher("personal.jsp").forward(req, resp);
        }
    }

}
