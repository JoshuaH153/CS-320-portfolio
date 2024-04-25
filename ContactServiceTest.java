import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContactById("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertEquals(null, contactService.getContactById("1234567890"));
    }

    @Test
    public void testUpdateContactFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        contactService.updateContactFirstName("1234567890", "NewFirstName");
        assertEquals("NewFirstName", contactService.getContactById("1234567890").getFirstName());
    }

    @Test
    public void testUpdateContactLastName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        contactService.updateContactLastName("1234567890", "NewLastName");
        assertEquals("NewLastName", contactService.getContactById("1234567890").getLastName());
    }

    @Test
    public void testUpdateContactPhone() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        contactService.updateContactPhone("1234567890", "1234567899");
        assertEquals("1234567899", contactService.getContactById("1234567890").getPhone());
    }

    @Test
    public void testUpdateContactAddress() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        contactService.updateContactAddress("1234567890", "NewAddress");
        assertEquals("NewAddress", contactService.getContactById("1234567890").getAddress());
    }

    @Test
    public void testAddContact_DuplicateId() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    @Test
    public void testDeleteContact_NonexistentId() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1234567890");
        });
    }

}
