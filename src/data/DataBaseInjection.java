package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import utilities.Utilities;

public class DataBaseInjection {

	/**
	 * <ul>
	 * <li>This function executes sql statements that are not queries.
	 * <li>Confirmation via console required.
	 * </ul>
	 *
	 * @param sql The SQL sentence to be carried out.
	 */
	public static void executeSQL(String sql) {

		Connection connection = null;
		Statement sqlStatement = null;
		int result;// Could be usefull in further implementations
		char confirm;

		try {
			// First, stablishing the connection
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practica2programacion", "root", "");

			// Creation of the statement (will be preferred "preparedStatement" for
			// security).
			sqlStatement = connection.createStatement();

			// Confirmaton required to execute the statement.
			confirm = Utilities.getCharMenu('y', 'n', "Confirm the operation");
			if (confirm == 'y') {
				// result variable could be usefull for further implementations. In this case
				// "result" has no utility.
				result = sqlStatement.executeUpdate(sql);
			} else {
				System.out.println("Operation discarded");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Shutting down resources.
			try {
				connection.close();
				sqlStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	/**
	 * <ul>
	 * <li>This metehod has no input and the outcome is the result of the query
	 * SELECT * FROM simulation_full_outer. The
	 * <li>VIEW contains all the data of the database, but the output int he console
	 * shows only certain data to make it more readeable (Aux table id's are not
	 * shown).
	 * </ul>
	 */
	public static void querySQL() {

		Connection connection = null;
		Statement sqlStatement = null;
		ResultSet rs;
		String sql = "";

		try {
			// First, stablishing the connection
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practica2programacion", "root", "");

			// Creation of the statement (will be preferred "preparedStatement" for
			// security).
			sqlStatement = connection.createStatement();

			// Query to the VIEW
			sql = "SELECT * FROM simulation_full_outer";

			// Executing the previous query
			rs = sqlStatement.executeQuery(sql);

			// Only if the ResultSet contains data the while loop will iterate throught it.
			if (rs.next()) {
				while (rs.next()) {
					System.out.println("Web id:'" + rs.getInt(1) + "'  Name:'" + rs.getString(2) + "'  URL:'"
							+ rs.getString(3) + "'  Budget:'" + rs.getInt(4) + "' \n"
							+ "Related to the following Technology: \n" + "Tech id:'" + rs.getInt(8) + "'  Tech Name:'"
							+ rs.getString(9) + "'  Tech Type:'" + rs.getString(10) + "'  Purpose:'" + rs.getString(11)
							+ "'  Release Year:'" + rs.getInt(12) + "'  License:'" + rs.getString(13) + "' \n\n");
				}
			} else {
				System.out.println("No data found");
			}

		} catch (

		SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Shutting down resources.
			try {
				connection.close();
				sqlStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * <ul>
	 * <li>This method creates a customized query that search a specific input in a
	 * specific table and field.
	 * <li>To show the variable results from different tables, the metadata of the
	 * resultSet is required to do it properly whitout looking into specific data
	 * fields with specific data types.
	 * </ul>
	 *
	 * @param table The table where the data will be searched.
	 * @param field The field where the data will be searched.
	 * 
	 * @return int The id of the row where the first match occurs.
	 */
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
			// First, stablishing the connection
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practica2programacion", "root", "");

			// Collecting the data requested
			dataRequest = Utilities.getString("What do you want to find?: ");

			// Creation of the statement (will be preferred "preparedStatement" for
			// security).
			sqlStatement = connection.createStatement();

			// Creation of the SQL query.
			sql = "SELECT * FROM " + table + " WHERE LOWER(" + table + "." + field + ") LIKE '%" + dataRequest + "%';";

			// Chain initialization of different objects
			rs = sqlStatement.executeQuery(sql); // Result set where table is stored.
			metaData = rs.getMetaData(); // Metadata of the resultSet.
			columnCount = metaData.getColumnCount(); // One of the metadata: amount of columns.

			// If there is at least one row:
			if (rs.next()) {
				// For loop to print every column of the row where the data was found.
				System.out.println("The first item found for '" + dataRequest + "' in the field '" + field + "' is:");
				for (int i = 1; i <= columnCount; i++) {
					columnName = metaData.getColumnName(i);
					value = rs.getObject(i);// Generic Object for different datatypes returned.
					System.out.println("-" + columnName + ": " + value);
				}
				// The id of the first result will be collected here and then returned
				id = rs.getInt(1);

				// No row returned
			} else {
				System.out.println("'" + dataRequest + "' not found.");
				// IMPORTANT, if the data requested is not found, the id returned will be -1.
				id = -1;

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// IMPORTANT, if an exception occurs, id returned will be -1
			id = -1;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// IMPORTANT, if an exception occurs, id returned will be -1
			id = -1;
		} finally {
			// Shutting down resources.
			try {
				connection.close();
				sqlStatement.close();
				// rs.close(); Cant be closed: "May not have been initialiced"
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("\n");

		}
		// The id will be -1 if nothing was found or an exception occurred or the row's
		// id for the first match of the data requested.
		return id;
	}

}
