package control;

import data.DataBaseInjection;
import user.GetData;
import utilities.Utilities;

/**
 * @description This class contains the methods that creates a SQL statement for each CRUD functionality.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 08/05/2023
 */
public class SqlTransform {

	/**
	 * <ul>
	 * <li>This function receives the object and creates a SQL string with the data.
	 * </ul>
	 *
	 * @param newWeb a WebPage object.
	 * @return sql The SQL string.
	 */
	public static String webToSQL(WebPage newWeb) {
		String sql;
		sql = "INSERT INTO webpage (webName, url, budget) VALUES (" + "'" + newWeb.getWebName() + "', " + "'"
				+ newWeb.getUrl() + "', " + newWeb.getBudget() + ")";

		return sql;
	}

	/**
	 * <ul>
	 * <li>This function receives the object and creates a SQL string with the data.
	 * </ul>
	 *
	 * @param newTech a Technology object.
	 * @return sql The SQL string.
	 */
	public static String techToSQL(Technology newTech) {
		String sql;
		sql = "INSERT INTO technology (techName, techType, purpose, releaseYear, license) VALUES (" + "'"
				+ newTech.getTechName() + "', " + "'" + newTech.getTechType() + "', " + "'" + newTech.getPurpose()
				+ "', " + newTech.getReleaseYear() + ", " + "'" + newTech.getLicense() + "'" + ")";

		return sql;
	}

	/**
	 * <ul>
	 * <li>This function receives the object and creates a SQL string with the data.
	 * </ul>
	 *
	 * @param newWeb a WebPage object.
	 * @param id the id of the row to be updated
	 * @return sql The SQL string.
	 */
	public static String updateWeb(WebPage newWeb, int id) {
		String sql;

		if (id >= 0) {
			sql = "UPDATE practica2programacion.website SET webName = '" + newWeb.getWebName() + "', url = '"
					+ newWeb.getUrl() + "', budget = " + newWeb.getBudget() + " WHERE website.webid = " + id + ";";

		} else {
			sql = "";
		}
		return sql;
	}

	/**
	 * <ul>
	 * <li>This function receives the object and creates a SQL string with the data.
	 * </ul>
	 *
	 * @param newTech a Technology object.
	 * @param id The id of the row to be updated
	 * @return sql The SQL string.
	 */
	public static String updateTech(Technology newTech, int id) {
		String sql;
		sql = "UPDATE practica2programacion.technology SET techName = '" + newTech.getTechName() + "', techType = '"
				+ newTech.getTechType() + "', purpose = '" + newTech.getPurpose() + "', releaseYear = "
				+ newTech.getReleaseYear() + ", license = '" + newTech.getLicense() + "' WHERE technology.techid = "
				+ id + ";";

		return sql;
	}

	/**
	 * <ul>
	 * <li>This function receives the id of the object that will be removed in the website table.
	 * </ul>
	 *
	 * @param id The id of the row to be removed
	 * @return sql The SQL string.
	 */
	public static String removeWeb(int id) {
		String sql;

		sql = "DELETE FROM practica2programacion.website WHERE website.webid = " + id + ";";

		return sql;
	}

	/**
	 * <ul>
	 * <li>This function receives the id of the object that will be removed in the Technology table.
	 * </ul>
	 *
	 * @param id The id of the row to be removed
	 * @return sql The SQL string.
	 */
	public static String removeTech(int id) {
		String sql;
		sql = "DELETE FROM practica2programacion.technology WHERE technology.techid = " + id + ";";
		return sql;
	}

}
