package control;

import data.DataBaseInjection;
import user.GetData;
import utilities.Utilities;

public class Controller {

	public static void main(String[] args) {

		// Aux object
		WebPage web;

		// Aux object
		Technology tech;

		// Aux sql statement
		String sql;

		// Aux id for SQL rows
		int id;

		// Selector for the main menu.
		int mainMenuChoice;

		// The selector for the sub menus.
		int menuChoice;

		// Another selector to confirm operations.
		char doSomethingElse;

		do {

			// Menu with the availeable options.
			Utilities.mainMenu();

			// Returns the option chosen by the user.
			mainMenuChoice = Utilities.getIntBetween(1, 5, "Select your choice");

			/*
			 * This is the main switch. Each option (execept exit) contain a certain number
			 * of different functionalities.
			 */
			switch (mainMenuChoice) {

			case 1:
				// ------------ CREATE ------------

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 4,
						"Press '1' to add a new web. \nPress '2' to add a new tech. \nPress '3' to exit submenu.");

				switch (menuChoice) {

				case 1:
					// INSERT INTO webpage
					web = GetData.newWeb();
					sql = SqlTransform.webToSQL(web);
					DataBaseInjection.executeSQL(sql);

					break;

				case 2:
					// INSERT INTO technology
					tech = GetData.newTech();
					sql = SqlTransform.techToSQL(tech);
					DataBaseInjection.executeSQL(sql);

					break;

				case 3:
					// Exits sub menu
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another action.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 2:
				// ------------ READ ------------

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 5,
						"Press '1' to show all the data. \nPress '2' to find a web. \nPress '3' to find a technology. \nPress '4' to exit submenu");
				switch (menuChoice) {

				case 1:
					// Shows all the data inside a VIEW made with joins.
					DataBaseInjection.querySQL();
					break;

				case 2:
					// Shows the first match for the data requested in the table website
					DataBaseInjection.querySQL("website", GetData.webField());
					break;

				case 3:
					// Shows the first match for the data requested int he table Technology
					DataBaseInjection.querySQL("technology", GetData.techField());
					break;

				case 4:
					// Exits sub menu
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 3:
				// ------------ UPDATE ------------

				// Requests and returns the desired option.
				menuChoice = Utilities.getIntBetween(1, 3,
						"Press '1' to update a web. \nPress '2' to update a technology. \nPress '3' to exit submenu.");
				switch (menuChoice) {

				case 1:
					// Updates a row from website table.
					id = DataBaseInjection.querySQL("website", GetData.webField());

					// If no matches found the id will be -1 and therefore the update is discarded.
					if (id >= 0) {
						web = GetData.newWeb();
						sql = SqlTransform.updateWeb(web, id);
						DataBaseInjection.executeSQL(sql);
					}
					break;

				case 2:
					// Updates a row from technology table.
					id = DataBaseInjection.querySQL("technology", GetData.techField());

					// If no matches found the id will be -1 and therefore the update is discarded.
					if (id >= 0) {
						tech = GetData.newTech();
						sql = SqlTransform.updateTech(tech, id);
						DataBaseInjection.executeSQL(sql);
					}
					break;

				case 3:
					// Exit option
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 4:
				// ------------ DELETE ------------

				// Request and return the desired option.
				menuChoice = Utilities.getIntBetween(1, 3,
						"Press '1' to remove a web. \nPress '2' to remove a Technology. \nPress '3' to exit submenu.");
				switch (menuChoice) {

				case 1:
					// Removes a row from website table if data requested is found.
					id = DataBaseInjection.querySQL("website", GetData.webField());
					if (id >= 0) {
						sql = SqlTransform.removeWeb(id);
						DataBaseInjection.executeSQL(sql);
					}
					break;

				case 2:
					// Removes a row from technology table if data requested is found.
					id = DataBaseInjection.querySQL("technology", GetData.techField());
					if (id >= 0) {
						sql = SqlTransform.removeTech(id);
						DataBaseInjection.executeSQL(sql);
					}
					break;

				case 3:
					// Exit option

					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			// MAIN MENU SWITCH ENDS HERE
			}

		} while (mainMenuChoice != 5);
		System.out.println('\n');
		System.out.println("\u001B[31m" + "+--PROGRAM SHUTDOWN--+");
		System.out.println('\n');
		System.out.println('\n');
	}

}
