package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.DataBaseInjection;

/**
 * Run the class and enter the following in console:
 * 
 * 'y'
 * 
 * "TEST"
 * 
 * 123
 */
class DataBaseInjectionTest {

	/**
	 * The test checks the data that have been updated, so the id returned after
	 * querying the new row must be 22. ENTER 'y' and then "TEST"
	 */
	@Test
	public void testExecuteSQL() {
		String sql;
		int id;

		sql = "UPDATE practica2programacion.website SET webName = '" + "TEST" + "', url = '" + "TEST" + "', budget = "
				+ "123" + " WHERE website.webid = " + "22" + ";";

		// This is the method to be tested, the statement will UPDATE a test row
		// specificly created to that purpose.
		DataBaseInjection.executeSQL(sql);

		// If the data was updated correctly, the id returned from this query method
		// will be 22.
		id = DataBaseInjection.querySQL("website", "webName");
		assertTrue(id == 22);
	}

	/**
	 * The test must return the id=22 if you search the number 123 in the budget
	 * field.
	 * 
	 * ENTER 123
	 */
	@Test
	public void testQuerySQLStringString() {
		String sql;
		int idReturned;

		idReturned = DataBaseInjection.querySQL("website", "budget");

		assertTrue(idReturned == 22);
	}

}
