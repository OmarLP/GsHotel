
package org.oleon.gshotel.claseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.oleon.gshotel.config.ConexionBaseDatos;
import org.oleon.gshotel.modelo.NivelHab;


public class NivelHabDAO {
    ConexionBaseDatos cn = new ConexionBaseDatos();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    int r;
    
    // Listar para tabla principal
    public List listar(){
        List<NivelHab> listaNivelHab = new ArrayList<>();
        String sql = "SELECT * FROM nivelHabitacion";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                NivelHab nivelHab = new NivelHab();
                nivelHab.setIdNivel(rs.getInt("idNivel"));
                nivelHab.setNombreNivel(rs.getString("NombreNivel"));
                listaNivelHab.add(nivelHab);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaNivelHab;
    }
    
    
    //guardar
    public int guardar(NivelHab nivelHab){
        String sql = "INSERT INTO nivelHabitacion(NombreNivel) VALUES(?)";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nivelHab.getNombreNivel());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
    }
    
    //Eliminar
    public void eliminar(int id){
        String sql = "DELETE FROM nivelHabitacion where IdNivel=" + id;
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
