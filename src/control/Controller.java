package control;

import data.DataBaseInjection;
import user.GetData;
import utilities.Utilities;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebPage web;
		Technology tech;
		String sql;
		// web = GetData.newWeb();

		// Technology tech;
		// tech=GetData.newTech();

		// String sql = SqlTransform.webToSQL(web);
		// String sql2=SqlTransform.techToSQL(tech);
		//DataBaseInjection.querySQL();

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
						"Press '1' to add a new web. \nPress '2' to add a new tech. \nPress '3' Show and add premade Techs. \nPress '4' to exit submenu.");

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

				case 4:
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
						"Press '1' to find the first match. \nPress '2' to find all the matches. \nPress '3' to show all the Web data. \nPress '4' to search by category. \\nPress '5' to exit submenu");
				switch (menuChoice) {

				case 1:
					// Shows the first 
					DataBaseInjection.querySQL();
					break;

				case 2:
					// Shows all the matches found.
					DataBaseInjection.querySQL("website", "webName");
					break;

				case 3:
					// Call to predefined toString method for the main WebPage object

					break;

				case 4:
					/*
					 * Same method but applying overload, in this case, the parameters are the data
					 * request and the category/attribute to fetch the requested data. The
					 * output/return from findFirstMatch is not needed so it wont be collected.
					 */

					break;

				case 5:
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
						"Press '1' to update a Technology. \nPress '2' to update a specific data of the Technology. \nPress '3' to exit submenu.");
				switch (menuChoice) {

				case 1:
					// To overwrite Technology's attributes where the first match is found.

					/**
					 * Calling the method with the same object that is going to be used as a
					 * parameter seems wierd but it was an easier way to reuse the object method:
					 * ".findFirstMatch()".
					 */

					break;

				case 2:
					/*
					 * This option changes a single attribute of the Technology where the data
					 * requested has first been found.
					 * 
					 */

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
						"Press '1' to remove the first match found. \nPress '2' to remove the entire list of Technologies. \nPress '3' to exit submenu.");
				switch (menuChoice) {

				case 1:
					// Removes a specific Technology out of the ArrayList.

					break;

				case 2:
					// Removes all the Technologies objects inside the ArrayList.

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
