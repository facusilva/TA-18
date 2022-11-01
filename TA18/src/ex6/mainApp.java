package ex6;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX6";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE piezas("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100)"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE proveedores("
				+ "id char(4) PRIMARY KEY,"
				+ "nombre varchar(100)"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE suministra("
				+ "codigo_pieza INT,"
				+ "id_proveedor char(4),"
				+ "precio INT,"
				+ "KEY (codigo_pieza, id_proveedor),"
				+ "FOREIGN KEY (codigo_pieza) REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE SET NULL,"
				+ "FOREIGN KEY (id_proveedor) REFERENCES proveedores(id) ON DELETE CASCADE ON UPDATE SET NULL"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO piezas (nombre) VALUES ('tornillo'), ('tuerca'),('gato hidraulico'),('anilla'), ('arandela');";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO proveedores VALUES ('ENF1', 'proovedor ENF1'), ('END6', 'proovedor END6'), ('1ASE', 'proovedor 1ASE'),"
				+ "('UI34', 'proovedor UI34'), ('JASL', 'proovedor JASL');";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO suministra VALUES (4, 'ENF1', 3), (5, 'END6', 2), (1, '1ASE', 6), (2, 'UI34', 9),"
				+ "(3, 'JASL', 5);";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
