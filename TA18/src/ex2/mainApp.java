package ex2;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String query = "CREATE DATABASE PROVA";
		//Statement st = Conexion.createStatement();
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX2";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE departamentos("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "presupuesto INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE empleados("
				+ "DNI varchar(8) PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "apellidos varchar(255),"
				+ "departamento INT,"
				+ "FOREIGN KEY (departamento) REFERENCES departamentos(codigo) ON DELETE CASCADE ON UPDATE SET NULL"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO departamentos (nombre, presupuesto) VALUES ('DEP01', 28), ('DEP02', 65), ('DEP03', 44), ('DEP04', 59), ('DEP05', 37);";
		conexion.lanzarCRUD(sql); 
		sql = "INSERT INTO empleados VALUES ('21384956', 'palito', 'pereira', 01),"
				+ "('28193475', 'cebolla', 'rodriguez', 02),"
				+ "('53829106', 'diego', 'lugano', 03),"
				+ "('43222096', 'diego', 'laxalt', 04),"
				+ "('75940219', 'diego', 'forlán', 05)";
		conexion.lanzarCRUD(sql); 
		conexion.cerrarConexion();
	}

}
