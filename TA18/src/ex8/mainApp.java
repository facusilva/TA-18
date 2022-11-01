package ex8;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX8";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE productos("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "precio INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE cajeros("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nom_apels varchar(255)"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE maquinas_registradoras("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "piso INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE venta("
				+ "cajero INT,"
				+ "maquina INT,"
				+ "producto INT,"
				+ "KEY (cajero, maquina, producto),"
				+ "FOREIGN KEY (cajero) REFERENCES cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (producto) REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO productos (nombre, precio) VALUES ('patatas lays', 2), ('avena', 3), ('cereales chocolate', 5), ('pechuga de pollo', 7), ('vino tinto',4);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO cajeros (nom_apels) VALUES ('Jose Pereira'), ('Hugo Roldán'), ('Victor Perez'), ('Jay Cutler'), ('Ronnie Coleman');";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO maquinas_registradoras (piso) VALUES (4), (2), (3), (1), (2);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO venta VALUES (1,4,1), (2,2,5), (3,1,3), (4,3,2), (5,5,4);";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
