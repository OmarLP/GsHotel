package org.oleon.gshotel.claseDAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.oleon.gshotel.config.ConexionBaseDatos;
import org.oleon.gshotel.modelo.Personal;

public class PersonalDAO {

    ConexionBaseDatos cn = new ConexionBaseDatos();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;

    int r;

    //Validar usuario
    public Personal validar(String usuario, String password) {
        Personal personal = new Personal();
        String sql = "SELECT * FROM personal WHERE documento=? AND clave=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                personal.setDocumento(rs.getString("documento"));
                personal.setClave(rs.getString("clave"));
                personal.setNombres(rs.getString("nombres"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return personal;
    }

    // Listar para tabla principal
    public List listar() {
        List<Personal> listaPersonal = new ArrayList<>();
        String sql = "SELECT * FROM personal";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Personal personal = new Personal();
                personal.setIdPersonal(rs.getInt("idPersonal"));
                personal.setTipoDocumento(rs.getString("tipoDocumento"));
                personal.setDocumento(rs.getString("documento"));
                personal.setNombres(rs.getString("nombres"));
                personal.setApellidoPaterno(rs.getString("apellidoPaterno"));
                personal.setApellidoMaterno(rs.getString("apellidoMaterno"));
                personal.setTelefono(rs.getString("telefono"));
                personal.setCorreo(rs.getString("correo"));
                personal.setClave(rs.getString("clave"));
                personal.setEstado(rs.getString("estado"));
                listaPersonal.add(personal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPersonal;
    }

    //guardar
    public int guardar(Personal personal) {
        String sql = "INSERT INTO personal(tipoDocumento, documento, nombres, apellidoPaterno, "
                + "apellidoMaterno, telefono, correo, clave, estado"
                + ") VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, personal.getTipoDocumento());
            ps.setString(2, personal.getDocumento());
            ps.setString(3, personal.getNombres());
            ps.setString(4, personal.getApellidoPaterno());
            ps.setString(5, personal.getApellidoMaterno());
            ps.setString(6, personal.getTelefono());
            ps.setString(7, personal.getCorreo());
            ps.setString(8, personal.getClave());
            ps.setString(9, personal.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    //Eliminar
    public void eliminar(int id) {
        String sql = "DELETE FROM personal where idPersonal=" + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
