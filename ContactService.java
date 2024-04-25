import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (getContactById(contact.getContactId()) != null) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        Contact contact = getContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contact);
    }

    public void updateContactFirstName(String contactId, String newFirstName) {
        Contact contact = getContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setFirstName(newFirstName);
    }

    public void updateContactLastName(String contactId, String newLastName) {
        Contact contact = getContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setLastName(newLastName);
    }

    public void updateContactPhone(String contactId, String newPhone) {
        Contact contact = getContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        if (newPhone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        contact.setPhone(newPhone);
    }

    public void updateContactAddress(String contactId, String newAddress) {
        Contact contact = getContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setAddress(newAddress);
    }

    public Contact getContactById(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }
}