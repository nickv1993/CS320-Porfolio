import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

	@Test
	public void testContact() {
		Contact contact = new Contact("ID12345678", "Sam", "Coe", "1239998010", "422 Central St");

		assertAll("contact", () -> assertEquals("ID12345678", contact.getContactId(), "Contact ID mismatch"),
				() -> assertEquals("Sam", contact.getFirstName(), "First Name mismatch"),
				() -> assertEquals("Coe", contact.getLastName(), "Last Name mismatch"),
				() -> assertEquals("1239998010", contact.getPhone(), "Phone mismatch"),
				() -> assertEquals("422 Central St", contact.getAddress(), "Address mismatch"));
	}

	@Test
	public void testContactException() {
		assertAll("constructor exceptions",
				() -> assertThrows(IllegalArgumentException.class,
						() -> new Contact(null, "Sam", "Coe", "1239998010", "422 Central St"),
						"Exception not thrown for null Contact ID"),
				() -> assertThrows(IllegalArgumentException.class,
						() -> new Contact("ID12345678", null, "Coe", "1239998010", "422 Central St"),
						"Exception not thrown for null First Name"));
	}
}
