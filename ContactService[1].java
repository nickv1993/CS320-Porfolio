import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts = new HashMap<>();

	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Invalid or Duplicate Contact");
		}
		contacts.put(contact.getContactId(), contact);
	}

	public void deleteContact(String contactId) {
		contacts.remove(contactId);
	}

	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null)
			throw new IllegalArgumentException("Contact Not Found");

		if (firstName != null && !firstName.equals(""))
			contact.setFirstName(firstName);
		if (lastName != null && !lastName.equals(""))
			contact.setLastName(lastName);
		if (phone != null && !phone.equals(""))
			contact.setPhone(phone);
		if (address != null && !address.equals(""))
			contact.setAddress(address);
	}

	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}
