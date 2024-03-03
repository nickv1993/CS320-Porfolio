import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	private ContactService service;

	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}

	@Test
	public void testAddContact() {
		Contact contact = new Contact("ID12345678", "Sam", "Coe", "1239998010", "422 Central St");
		service.addContact(contact);
		assertEquals(contact, service.getContact("ID12345678"));
	}

	@Test
	public void testDeleteContact() {
		Contact contact = new Contact("ID12345678", "Sam", "Coe", "1239998010", "422 Central St");
		service.addContact(contact);
		service.deleteContact("ID12345678");
		assertNull(service.getContact("ID12345678"));
	}

	@Test
	public void testUpdateContact() {
		Contact contact = new Contact("ID12345678", "Sam", "Coe", "1239998010", "422 Central St");
		service.addContact(contact);
		service.updateContact("ID12345678", "Jessica", "Smith", "16176339934", "355 Main St");
		assertAll("update", () -> assertEquals("Jessica", contact.getFirstName()),
				() -> assertEquals("Smith", contact.getLastName()),
				() -> assertEquals("16176339934", contact.getPhone()),
				() -> assertEquals("355 Main St", contact.getAddress()));
	}
}
