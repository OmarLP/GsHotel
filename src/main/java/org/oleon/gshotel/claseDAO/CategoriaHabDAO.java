package org.oleon.gshotel.claseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.oleon.gshotel.config.ConexionBaseDatos;
import org.oleon.gshotel.modelo.CategoriaHab;

public class CategoriaHabDAO {

    ConexionBaseDatos cn = new ConexionBaseDatos();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;

    int r;

    // Listar para tabla principal
    public List listar() {
        List<CategoriaHab> listaCategoriaHab = new ArrayList<>();
        String sql = "SELECT * FROM categoriaHabitacion";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaHab categoriaHab = new CategoriaHab();
                categoriaHab.setIdCategoria(rs.getInt("idCategoria"));
                categoriaHab.setNombreCategoria(rs.getString("nombreCategoria"));
                listaCategoriaHab.add(categoriaHab);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCategoriaHab;
    }

    //guardar
    public int guardar(CategoriaHab categoriaHab) {
        String sql = "INSERT INTO categoriaHabitacion(nombreCategoria) VALUES(?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoriaHab.getNombreCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    //Eliminar
    public void eliminar(int id) {
        String sql = "DELETE FROM categoriaHabitacion where IdCategoria=" + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
