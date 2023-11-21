package Metodos_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionInventario {
    public static String url ="jdbc:mysql://localhost/Inventario";
    public static String usuario = "root";
    public static String contraseña = "T0NGA1M37456789";
    public static String clase = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName(clase);
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión establecida con la base de datos Inventario");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos Inventario");
        }
        return conexion;
    }
}
