package user;

import control.Technology;
import control.WebPage;
import utilities.Utilities;

public class GetData {

	// SIN EL ID
	public static Technology newTech() {
		Technology newTech = new Technology(Utilities.getString("Set Technology name: "),
				Utilities.getString("Set Technology type: "), Utilities.getString("Set Technology purpose: "),
				Utilities.getIntBetween(1900, 2050, "Introduce the Technology release year: "),
				Utilities.getString("Set Technology license: "));
		return newTech;
	}

	// SIN EL ID
	public static WebPage newWeb() {
		WebPage newWeb = new WebPage(Utilities.getString("Introduce Webpage name: "),
				Utilities.getString("Introduce the URL: "),
				Utilities.getIntBetween(1, 999999999, "Introduce the budget for the web project: "));
		return newWeb;
	}

	public static String techField() {
		String chosenField;
		int columnNumber;

		columnNumber= Utilities.getIntBetween(1, 5,
				"Enter 1, 2, 3, 4 or 5 to search by: id, name, type, purpose, release year or license");
		if(columnNumber==1) {
			chosenField="webname";
		}else if(columnNumber==2){
			///////////////////////
		}
		return "";
	}

	public static String webField(String message) {

		return "";
	}

}
