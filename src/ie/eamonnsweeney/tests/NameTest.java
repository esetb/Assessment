package ie.eamonnsweeney.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.eamonnsweeney.app.models.Name;

class NameTest {

	private Name name;
	
	@BeforeEach
	void setUp() throws Exception {
		name = new Name("Mr", "Donald", "Duck");
	}

	@Test
	void testName() {
		assertEquals(name, new Name("Mr", "Donald", "Duck"));
	}

	@Test
	void testGetTitle() {
		assertEquals("Mr", name.getTitle());
	}

	@Test
	void testSetTitle() {
		name.setTitle("Mrs");
		assertEquals("Mrs", name.getTitle());
	}

	@Test
	void testGetFirstName() {
		assertEquals("Donald", name.getFirstName());
	}

	@Test
	void testSetFirstName() {
		name.setFirstName("Scrooge");
		assertEquals("Scrooge", name.getFirstName());
	}

	@Test
	void testGetLastName() {
		assertEquals("Duck", name.getLastName());
	}

	@Test
	void testSetLastName() {
		name.setLastName("McDuck");
		assertEquals("McDuck", name.getLastName());
	}

	@Test
	void testEqualsObject() {
		assertTrue(name.equals(new Name("Mr", "Donald", "Duck")));
	}

}
