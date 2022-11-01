package ex1;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String query = "CREATE DATABASE PROVA";
		//Statement st = Conexion.createStatement();
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX1";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE fabricantes("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100)"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE articulos("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "precio INT,"
				+ "fabricante INT,"
				+ "FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO fabricantes(nombre) VALUES ('nvidia'), ('AMD'), ('intel'), ('gygabite'), ('evga');";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO articulos(nombre, precio, fabricante) VALUES ('tarjeta gráfica', 412, 1), ('procesador', 290, 2 ), ('placa base', 90, 3), ('memoria RAM', 40, 4), ('disco SSD 500 gb', 70, 5) ;";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
