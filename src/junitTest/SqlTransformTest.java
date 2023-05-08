package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import data.DataBaseInjection;
import control.SqlTransform;
import control.Technology;
import control.WebPage;

/**
 * Every method of this class tests one thing: The returned String must match
 * the exact SQL statement expected.
 * 
 * @version 1.0
 * @author Marcelino Gil
 */
class SqlTransformTest {

	private WebPage webTest = new WebPage("testa", "testb", 10);
	private Technology techTest = new Technology("testa", "testa", "testa", 1901, "testa");
	private String sql;
	private final int id=1;

	
	/**The test makes sure that the String output is the proper SQL statement*/
	@Test
	public void testWebToSQL() {

		sql = SqlTransform.webToSQL(webTest);

		assertTrue(sql.equals("INSERT INTO webpage (webName, url, budget) VALUES (" + "'" + webTest.getWebName() + "', "
				+ "'" + webTest.getUrl() + "', " + webTest.getBudget() + ")"));
	}

	/**The test makes sure that the String output is the proper SQL statement*/
	@Test
	public void testTechToSQL() {

		sql = SqlTransform.techToSQL(techTest);

		assertTrue(sql.equals("INSERT INTO technology (techName, techType, purpose, releaseYear, license) VALUES ("
				+ "'" + techTest.getTechName() + "', " + "'" + techTest.getTechType() + "', " + "'"
				+ techTest.getPurpose() + "', " + techTest.getReleaseYear() + ", " + "'" + techTest.getLicense() + "'"
				+ ")"));
	}

	/**The test makes sure that the String output is the proper SQL statement*/
	@Test
	public void testUpdateWeb() {
		sql = SqlTransform.updateWeb(webTest, id);
		
		assertTrue(sql.equals("UPDATE practica2programacion.website SET webName = '" + webTest.getWebName() + "', url = '"
					+ webTest.getUrl() + "', budget = " + webTest.getBudget() + " WHERE website.webid = " + id + ";"));
	}

	/**The test makes sure that the String output is the proper SQL statement*/
	@Test
	public void testUpdateTech() {
		sql = SqlTransform.updateTech(techTest, id);
		assertTrue(sql.equals("UPDATE practica2programacion.technology SET techName = '" + techTest.getTechName() + "', techType = '"
				+ techTest.getTechType() + "', purpose = '" + techTest.getPurpose() + "', releaseYear = "
				+ techTest.getReleaseYear() + ", license = '" + techTest.getLicense() + "' WHERE technology.techid = "
				+ id + ";"));
	}

	/**The test makes sure that the String output is the proper SQL statement*/
	@Test
	public void testRemoveWeb() {
		sql = SqlTransform.removeWeb(id);
		assertTrue(sql.equals("DELETE FROM practica2programacion.website WHERE website.webid = " + id + ";"));
	}

	/**The test makes sure that the String output is the proper SQL statement*/
	@Test
	public void testRemoveTech() {
		sql = SqlTransform.removeTech(id);
		assertTrue(sql.equals("DELETE FROM practica2programacion.technology WHERE technology.techid = " + id + ";"));
		
	}

}
