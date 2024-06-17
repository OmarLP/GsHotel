package org.oleon.gshotel.claseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.oleon.gshotel.config.ConexionBaseDatos;
import org.oleon.gshotel.modelo.Cliente;



public class ClienteDAO {
    ConexionBaseDatos cn = new ConexionBaseDatos();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    
    int r;
    
    // Listar para tabla principal
    public List listar(){
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setTipoDocuemnto(rs.getString("tipoDocuemnto"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                listaCliente.add(cliente);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaCliente;
    }
    
    
    //guardar
    public int guardar(Cliente cliente){
        String sql = "INSERT INTO cliente([tipoDocuemnto], [documento], [nombres], "
                + "[apellidoPaterno], [apellidoMaterno], [telefono], [correo]"
                + ") VALUES(?,?,?,?,?,?,?)";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getTipoDocuemnto());
            ps.setString(2, cliente.getDocumento());
            ps.setString(3, cliente.getNombres());
            ps.setString(4, cliente.getApellidoPaterno());
            ps.setString(5, cliente.getApellidoMaterno());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getCorreo());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
    }
    
    //Eliminar
    public void eliminar(int id){
        String sql = "DELETE FROM cliente where idCliente=" + id;
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
