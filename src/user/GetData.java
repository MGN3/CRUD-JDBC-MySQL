package user;

import control.Technology;
import control.WebPage;
import utilities.Utilities;

/**
 * @description This class contains the functions that get data from console.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 09/05/2023
 */
public class GetData {

	/**
	 * <ul>
	 * <li>This is the basic method that collects input from console to fill the
	 * data required to create the object.
	 * </ul>
	 *
	 * @return newTech The object created with the console data.
	 */
	public static Technology newTech() {
		Technology newTech = new Technology(Utilities.getString("Set Technology name: "),
				Utilities.getString("Set Technology type: "), Utilities.getString("Set Technology purpose: "),
				Utilities.getIntBetween(1900, 2050, "Introduce the Technology release year: "),
				Utilities.getString("Set Technology license: "));
		return newTech;
	}

	/**
	 * <ul>
	 * <li>This is the basic method that collects input from console to fill the
	 * data required to create the object.
	 * </ul>
	 *
	 * @return newWeb The object created with the console data.
	 */
	public static WebPage newWeb() {
		WebPage newWeb = new WebPage(Utilities.getString("Introduce Webpage name: "),
				Utilities.getString("Introduce the URL: "),
				Utilities.getIntBetween(1, 999999999, "Introduce the budget for the web project: "));
		return newWeb;
	}

	/**
	 * <ul>
	 * <li>This returns the name of a specific field in the table.
	 * </ul>
	 *
	 * @return chosenField
	 */
	public static String techField() {
		String chosenField = "techName";
		int columnNumber;

		columnNumber = Utilities.getIntBetween(1, 5,
				"Enter 1, 2, 3, 4 or 5 to search a tech by: id, name, type, purpose, release year or license");
		switch (columnNumber) {
		case 1:
			chosenField = "techid";
			break;

		case 2:
			chosenField = "techName";
			break;

		case 3:
			chosenField = "techType";
			break;

		case 4:
			chosenField = "purpose";
			break;

		case 5:
			chosenField = "releaseYear";
			break;
		case 6:
			chosenField = "license";
			break;
		}

		return chosenField;
	}

	/**
	 * <ul>
	 * <li>This returns the name of a specific field in the table.
	 * </ul>
	 *
	 * @return chosenField
	 */
	public static String webField() {
		String chosenField = "techName";
		int columnNumber;

		columnNumber = Utilities.getIntBetween(1, 5, "Enter 1, 2, 3 or 4 to search a web by: id, name, url or budget.");
		switch (columnNumber) {
		case 1:
			chosenField = "webid";
			break;

		case 2:
			chosenField = "webName";
			break;

		case 3:
			chosenField = "url";
			break;

		case 4:
			chosenField = "budget";
			break;

		}

		return chosenField;
	}

}
