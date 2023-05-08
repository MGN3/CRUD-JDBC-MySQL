package control;

import data.DataBaseInjection;
import user.GetData;
import utilities.Utilities;

public class SqlTransform {

	// Posibilidad de hacer métodos no estáticos, mencionado en clase.
	public static String webToSQL(WebPage newWeb) {
		String sql;
		sql = "INSERT INTO webpage (webName, url, budget) VALUES (" + "'" + newWeb.getWebName() + "', " + "'"
				+ newWeb.getUrl() + "', " + newWeb.getBudget() + ")";

		return sql;
	}

	public static String techToSQL(Technology newTech) {
		String sql;
		sql = "INSERT INTO technology (techName, techType, purpose, releaseYear, license) VALUES (" + "'"
				+ newTech.getTechName() + "', " + "'" + newTech.getTechType() + "', " + "'" + newTech.getPurpose()
				+ "', " + newTech.getReleaseYear() + ", " + "'" + newTech.getLicense() + "'" + ")";

		return sql;
	}

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

	public static String updateTech(Technology newTech, int id) {
		String sql;
		sql = "UPDATE practica2programacion.technology SET techName = '" + newTech.getTechName() + "', techType = '"
				+ newTech.getTechType() + "', purpose = '" + newTech.getPurpose() + "', releaseYear = "
				+ newTech.getReleaseYear() + ", license = '" + newTech.getLicense() + "' WHERE technology.techid = "
				+ id + ";";

		return sql;
	}

	public static String removeWeb(int id) {
		String sql;

		sql = "DELETE FROM practica2programacion.website WHERE website.webid = " + id + ";";

		return sql;
	}

	public static String removeTech(int id) {
		String sql;
		sql = "DELETE FROM practica2programacion.technology WHERE technology.techid = " + id + ";";
		return sql;
	}

}
