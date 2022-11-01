package ex5;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String query = "CREATE DATABASE PROVA";
		//Statement st = Conexion.createStatement();
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX5";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE despachos("
				+ "numero INT PRIMARY KEY,"
				+ "capacidad INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE directores("
				+ "DNI varchar(8) PRIMARY KEY,"
				+ "nom_apels varchar(255),"
				+ "DNI_jefe varchar(8),"
				+ "despacho INT,"
				+ "FOREIGN KEY (DNI_jefe) REFERENCES directores(DNI) ON DELETE CASCADE ON UPDATE SET NULL,"
				+ "FOREIGN KEY (despacho) REFERENCES despachos(numero) ON DELETE CASCADE ON UPDATE SET NULL"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO despachos VALUES (01,45),(02,28),(03,33),(04,21),(05,18);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO directores VALUES ('55444333', 'pepito perez', '55444333', 01),\r\n"
				+ "('64593829', 'juan beltran', '55444333', 02),\r\n"
				+ "('93823946', 'jose gimenez', '64593829', 03),\r\n"
				+ "('73928456', 'federico valverde', '64593829', 04),\r\n"
				+ "('22304956', 'maxi gomez', '93823946', 05);";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
