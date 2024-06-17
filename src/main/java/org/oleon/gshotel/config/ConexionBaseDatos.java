package org.oleon.gshotel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBaseDatos {
//
    

    public static Connection getConnection() throws SQLException {
            Connection con = null;
            String conexionURL
            = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=bd_hotel;integratedSecurity=false;"
            + "encrypt=false;trustServerCertificate=true;"
            + "user=user_uno;"
            + "password=usuario+123;"
           + "loginTimeout=30";
            
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(conexionURL);
            return con;
            
        } catch (ClassNotFoundException | SQLException e) {

            return null;
        }

    }
}
