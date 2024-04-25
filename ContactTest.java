import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

public class ContactTest {

	@Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Son", contact.getFirstName());
        assertEquals("Goku", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("411 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Son", "Goku", "1234567890", "411 Main St");
        });
    }

    @Test
    public void testInvalidContactId_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Son", "Goku", "1234567890", "411 Main St");
        });
    }

    @Test
    public void testInvalidFirstName_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Goku", "1234567890", "411 Main St");
        });
    }

    @Test
    public void testInvalidFirstName_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "SonSonSonSon", "Goku", "1234567890", "411 Main St");
        });
    }

    @Test
    public void testInvalidLastName_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Son", null, "1234567890", "411 Main St");
        });
    }

    @Test
    public void testInvalidLastName_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Son", "GokuGokuGoku", "1234567890", "411 Main St");
        });
    }

    @Test
    public void testInvalidPhone_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Son", "Goku", null, "411 Main St");
        });
    }

    @Test
    public void testInvalidPhone_WrongLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Son", "Goku", "123456789", "411 Main St");
        });
    }

    @Test
    public void testInvalidAddress_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Son", "Goku", "1234567890", null);
        });
    }

    @Test
    public void testInvalidAddress_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Son", "Goku", "1234567890", "411 Main St, too long of an address");
        });
    }
}