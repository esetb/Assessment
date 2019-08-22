package ie.eamonnsweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Name;


/**
 * The Class NameTest.
 */
class NameTest {

	/** The name. */
	private Name name;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		name = new Name("Mr", "Donald", "Duck");
	}

	/**
	 * Test name.
	 */
	@Test
	void testName() {
		assertEquals(name, new Name("Mr", "Donald", "Duck"));
	}

	/**
	 * Test get title.
	 */
	@Test
	void testGetTitle() {
		assertEquals("Mr", name.getTitle());
	}

	/**
	 * Test set title.
	 */
	@Test
	void testSetTitle() {
		name.setTitle("Mrs");
		assertEquals("Mrs", name.getTitle());
	}

	/**
	 * Test get first name.
	 */
	@Test
	void testGetFirstName() {
		assertEquals("Donald", name.getFirstName());
	}

	/**
	 * Test set first name.
	 */
	@Test
	void testSetFirstName() {
		name.setFirstName("Scrooge");
		assertEquals("Scrooge", name.getFirstName());
	}

	/**
	 * Test get last name.
	 */
	@Test
	void testGetLastName() {
		assertEquals("Duck", name.getLastName());
	}

	/**
	 * Test set last name.
	 */
	@Test
	void testSetLastName() {
		name.setLastName("McDuck");
		assertEquals("McDuck", name.getLastName());
	}

	/**
	 * Test equals object.
	 */
	@Test
	void testEqualsObject() {
		assertTrue(name.equals(new Name("Mr", "Donald", "Duck")));
	}

}
