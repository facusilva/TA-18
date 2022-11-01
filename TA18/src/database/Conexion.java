package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	Connection c;
	
	public Conexion () {
		
	}
	
	public Connection realizarConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://192.168.1.172:3306?useTimezone=true&serverTimezone=UTC","remote","Kappa323232!");
			System.out.println("Conexión realizada con éxito");
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar a la base de datos");
			System.out.println(ex);
		}
		return c;
	}
	
	public void cerrarConexion() {
		try {
			c.close();
			System.out.println("Se ha finalizado al conexión con éxito");
		}catch(SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	public void crearDB(String nombre) {
		String query = "CREATE DATABASE "+nombre;
		Statement st;
		try {
			st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Se ha creado la base de datos "+nombre);
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
			System.out.println("prova");
		}
	}
	
	public void dropDB(String nombre) {
		String query = "DROP DATABASE "+nombre;
		Statement st;
		try {
			st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("Se ha borrado la base de datos "+nombre);
			
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	public void usarDB(String nombre) {
		String query = "USE "+nombre;
		Statement st;
		try {
			st = c.createStatement();
			st.executeUpdate(query);
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	public void lanzarCRUD(String query) {
		Statement st;
		try {
			st = c.createStatement();
			st.executeUpdate(query);
			System.out.println("CRUD realizado con éxito");
			
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
}
