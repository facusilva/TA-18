package ex3;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX3";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE almacenes("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "lugar varchar(100),"
				+ "capacidad INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE cajas("
				+ "num_referencia char(5) PRIMARY KEY,"
				+ "contenido varchar(100),"
				+ "valor INT,"
				+ "almacen INT,"
				+ "FOREIGN KEY (almacen) REFERENCES almacenes(codigo) ON DELETE CASCADE ON UPDATE SET NULL"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO almacenes(lugar, capacidad) VALUES ('ALM01', 348), ('ALM02', 227), ('ALM03', 118), ('ALM04', 430), ('ALM05', 370);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO cajas VALUES ('CAJ01', 'objetos puntiagudos', 499, 1), ('CAJ02', 'frutas y verduras', 340, 2), ('CAJ03', 'periféricos', 1230, 3), "
				+ "('CAJ04', 'tarjetas gráficas', 9999, 4), ('CAJ05', 'teléfonos móviles', 499, 5) ;";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
