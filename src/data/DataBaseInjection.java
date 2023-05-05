package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import utilities.Utilities;

public class DataBaseInjection {

	public static void executeSQL(String sql) {

		Connection connection = null;
		Statement sqlStatement = null;
		int result;

		System.out.println("Conectado/desconectado");

		// ejecutar un count/sum/avg....

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practica2programacion", "root", "");
			// proporcionamos la dirección,el administrador y la clave

			// creamos sentencias ejecutables sobre esa conexión
			sqlStatement = connection.createStatement();

			result = sqlStatement.executeUpdate(sql);

			if (result >= 1) {
				System.out.println("Executed query");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				sqlStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Action finished.");
	}

	public static void querySQL() {

		Connection connection = null;
		Statement sqlStatement = null;
		ResultSet rs;
		int index;
		String sql = "";
		String dataRequest = "";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practica2programacion", "root", "");

			// creamos sentencias ejecutables sobre esa conexión
			sqlStatement = connection.createStatement();

			dataRequest = Utilities.getString("Which web do you want to find");

			sql = "SELECT webName, url, budget FROM simulation_full_outer WHERE LOWER(simulation_full_outer.webName) LIKE '%"
					+ dataRequest + "%';";
			// System.out.println(sql);

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			rs = sqlStatement.executeQuery(sql);

			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			if (rs.next()) {
				// Si hay resultados obtengo el valor.
				// ALTERNATIVA: capturar el valor del primer rs get string
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getInt(3));

				index = rs.getInt(1);
				System.out.println(index);
			} else {
				System.out.println(dataRequest + " not found.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				sqlStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Conectado/desconectado");

		}

	}

	public static int querySQL(String table, String field) {

		Connection connection = null;
		Statement sqlStatement = null;
		ResultSet rs;
		ResultSetMetaData metaData;
		Object value; // It's great that the object Object exists.
		String columnName;
		String sql = "";
		String dataRequest = "";

		int columnCount;
		int id;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practica2programacion", "root", "");

			sqlStatement = connection.createStatement();

			dataRequest = Utilities.getString("Which web do you want to find");

			sql = "SELECT * FROM " + table + " WHERE LOWER(" + table + "." + field + ") LIKE '%" + dataRequest + "%';";
			// System.out.println(sql);

			rs = sqlStatement.executeQuery(sql);
			metaData = rs.getMetaData();
			columnCount = metaData.getColumnCount();

			if (rs.next()) {

				for (int i = 1; i <= columnCount; i++) {
					columnName = metaData.getColumnName(i);
					value = rs.getObject(i);
					System.out.println(columnName + ": " + value);
				}

				id = rs.getInt(1);
				System.out.println(id);

				return id;
			} else {
				System.out.println(dataRequest + " not found.");
				id = -1;

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// IMPORTANT
			id = -1;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// IMPORTANT
			id = -1;
		} finally {
			try {
				connection.close();
				sqlStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Conectado/desconectado");

		}
		return id;
	}

}
