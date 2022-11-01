package ex9;
import java.sql.Connection;

import database.Conexion;

public class mainApp {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		conexion.realizarConexion();
		String db = "TA18_EX9";
		conexion.crearDB(db);
		conexion.usarDB(db);
		String sql = "CREATE TABLE facultad("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre varchar(100)"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE investigadores("
				+ "DNI varchar(8) PRIMARY KEY,"
				+ "nom_apels varchar(255),"
				+ "facultad INT,"
				+ "FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE equipos("
				+ "num_serie char(4) PRIMARY KEY,"
				+ "nombre varchar(100),"
				+ "facultad INT,"
				+ "FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "CREATE TABLE reserva("
				+ "DNI varchar(8),"
				+ "num_serie char(4),"
				+ "comienzo datetime,"
				+ "fin datetime,"
				+ "FOREIGN KEY (DNI) REFERENCES investigadores(DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (num_serie) REFERENCES equipos(num_serie) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO facultad (nombre) VALUES ('medicina'), ('biologia'), ('química'), ('matemáticas'), ('física');";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO investigadores VALUES ('55483947','Jorge Tabet',3), ('63728394','Kim Angel',1), ('47382934','Victor Valdivia',4), ('47283495', 'Hugo Van Dammne',5),"
				+ " ('75829345','Alex Eubank',2);";
		conexion.lanzarCRUD(sql);
		sql = " INSERT INTO equipos VALUES ('EQ01', 'equipo 1', 2), ('EQ02', 'equipo 2', 4), ('EQ03', 'equipo 3', 1), ('EQ04', 'equipo 4', 3), ('EQ05', 'equipo 5', 2);";
		conexion.lanzarCRUD(sql);
		sql = "INSERT INTO reserva VALUES ('55483947', 'EQ04', '2022-10-22 19:10:50', '2024-09-30 18:20:50'), ('63728394', 'EQ02', '2021-03-11 15:22:09', '2023-09-30 18:20:50'), "
				+ " ('47382934', 'EQ03', '2020-12-11 09:19:50', '2024-10-30 11:55:23'), ('47283495', 'EQ01', '2022-04-25 16:45:42', '2025-03-14 19:50:45'), "
				+ " ('75829345', 'EQ05', '2019-09-30 18:20:50', '2022-11-15 17:28:43');";
		conexion.lanzarCRUD(sql);
		conexion.cerrarConexion();
	}

}
