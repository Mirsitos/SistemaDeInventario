package Metodos_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Metodos_sql {
	
	public static ConexionBD conexion = new ConexionBD();
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero = 0;
	
	
	public int guardar(String usuario, String email, String contraseña) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = ("INSERT INTO usuarios (usuario,email,contraseña) VALUES (?,?,?)");
		
		try{
			
			conexion = ConexionBD.conectar();
			
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1, usuario);
			sentencia_preparada.setString(2, email);
			sentencia_preparada.setString(3, contraseña);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
			conexion.close();
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		return resultado;
		
	}
	
	
	public static String buscarNombre(String usuario) {
	    String busqueda_nombre = null;
	    Connection conexion = null;

	    try {
	        conexion = ConexionBD.conectar();
	        String sentencia_buscar = "SELECT usuario FROM usuarios WHERE usuario = ?";
	        sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
	        sentencia_preparada.setString(1, usuario); // Asignar el nombre de usuario como parámetro
	        resultado = sentencia_preparada.executeQuery();

	        if (resultado.next()) {
	            String nombreUsuario = resultado.getString("usuario");
	            busqueda_nombre = nombreUsuario;
	        }

	        conexion.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return busqueda_nombre;
	}
	
	public static String buscarUsuarioRegistrado(String usuario, String contraseña) {
	    String busqueda_usuario = null;
	    Connection conexion = null;

	    try {
	        conexion = ConexionBD.conectar();
	        String sentencia_buscar_usuario = "SELECT usuario, contraseña FROM usuarios WHERE usuario = ? AND contraseña = ?";
	        sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
	        sentencia_preparada.setString(1, usuario);
	        sentencia_preparada.setString(2, contraseña); 
	        resultado = sentencia_preparada.executeQuery();

	        if (resultado.next()) {
	            busqueda_usuario = "usuario encontrado";
	        } else {
	            busqueda_usuario = "usuario no encontrado";
	        }

	        conexion.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return busqueda_usuario;
	}

}
