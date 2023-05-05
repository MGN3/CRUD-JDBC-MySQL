package control;

public class SqlTransform {

	//Posibilidad de hacer métodos no estáticos, mencionado en clase.
	public static String webToSQL(WebPage newWeb) {
		String sql = "INSERT INTO webpage (webName, url, budget) VALUES (" + "'" + newWeb.getWebName() + "', " + "'"
				+ newWeb.getUrl() + "', " + newWeb.getBudget() + ")";

		return sql;
	}

	public static String techToSQL(Technology newTech) {

		String sql = "INSERT INTO technology (techName, techType, purpose, releaseYear, license) VALUES (" + "'"
				+ newTech.getTechName() + "', " + "'" + newTech.getTechType() + "', " + "'" + newTech.getPurpose()
				+ "', " + newTech.getReleaseYear() + ", " + "'" + newTech.getLicense() + "'" + ")";

		return sql;
	}

	

}
