package ex7;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX7";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE cientificos("
				+ "DNI varchar(8) PRIMARY KEY,"
				+ "nom_apels varchar(255)"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE proyecto("
				+ "id char(4) PRIMARY KEY,"
				+ "nombre varchar(255),"
				+ "horas INT"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE asignado_a("
				+ "cientifico varchar(8),"
				+ "proyecto char(4),"
				+ "KEY (cientifico, proyecto),"
				+ "FOREIGN KEY (cientifico) REFERENCES cientificos(DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO cientificos VALUES ('55472834', 'Javier Gomez'), ('43192567', 'Jose Martinez'), "
				+ " ('54392323', 'Pedro Rosas'), ('58432956', 'Elisabet García'), ('21395482', 'Marcelo Gomez');";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO proyecto (id, nombre, horas) values ('EM01','Estudio microbios',45), ('EB04','Estudio biomas',68), ('PX03','Proyecto X',120),('TWP1','El proyecto salvaje',450), ('EI09','Estudio idiomas',200);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO asignado_a VALUES ('55472834', 'PX03'), ('43192567', 'TWP1'), ('54392323', 'EB04'), ('58432956', 'EI09'), "
				+ " ('21395482', 'EM01');";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
