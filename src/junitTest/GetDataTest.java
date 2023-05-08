package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import control.Technology;
import control.WebPage;
import user.GetData;

/*Enter the following data in the console:
 * 
 * 1
 * 
 * testa testb testc 2000 testd
 * 
 * testa testb 2000
 * 
 * 1
 * 
 * 
 * **/

class GetDataTest {
	Technology testTech = new Technology("testa", "testb", "testc", 2000, "testd");
	WebPage testWeb = new WebPage("testa", "testb", 2000);
	String fieldReturned;

	/* Enter: testa testb testc 2000 testd */
	@Test
	public void testNewTech() {
		Technology technology;
		technology = GetData.newTech();

		assertTrue(technology.toString().equals(testTech.toString()));
	}

	/* Enter: testa testb 2000 */
	@Test
	public void testNewWeb() {
		WebPage webpage;
		webpage = GetData.newWeb();
		assertTrue(webpage.toString().equals(testWeb.toString()));

	}

	/** Enter the number: 1 */
	@Test
	public void testTechField() {
		fieldReturned = GetData.techField();

		assertTrue(fieldReturned.equals("techid"));
	}

	/** Enter the number: 1 */
	@Test
	public void testWebField() {
		fieldReturned = GetData.webField();

		assertTrue(fieldReturned.equals("webid"));
	}

}
