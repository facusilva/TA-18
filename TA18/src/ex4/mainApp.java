package ex4;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX4";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE peliculas("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "calificacion_edad INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE salas("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "pelicula INT,"
				+ "FOREIGN KEY (pelicula) REFERENCES peliculas(codigo) ON DELETE CASCADE ON UPDATE SET NULL"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO peliculas(nombre, calificacion_edad) VALUES ('el padrino', 18), ('solo en casa', 3), ('E.T', 3), ('interestellar', 7), ('midsommar', 18);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO salas(nombre, pelicula) VALUES ('SALA01', 1), ('SALA02', 2),('SALA03', 3),('SALA04', 4),('SALA05', 5) ;";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
