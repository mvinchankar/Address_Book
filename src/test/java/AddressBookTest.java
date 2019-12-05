import com.bridgelabz.AddressBook.controller.Driver;
import com.bridgelabz.AddressBook.model.Address;
import com.bridgelabz.AddressBook.model.Person;
import com.bridgelabz.AddressBook.services.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    @Test
    public void when_Correct_New_FileName_Entered_Should_Return_false() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(false, addressBookManager.createNewAddressBook("Kurla"));

    }

    @Test
    public void when_Incorrect_New_FileName_Entered_Should_Return_true() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.createNewAddressBook("Govandi"));

    }

    @Test
    public void when_Add_Details_To_New_File_Entered_Should_Return_true() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = new Person();
        Assert.assertEquals("946867975", addressBookManager.add("RAMESH", "SURESH", "946867975", "Akola", "MH", "444002").getMobileNumber());

    }

    @Test
    public void when_Add_Details_To_New_File_Entered_Should_Return_False() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = new Person();
        addressBookManager.add("RAMESH", "SURESH", "946867975", "Akola", "MH", "444002");
        Assert.assertEquals("94686795", addressBookManager.add("RAMESH", "SURESH", "946867975", "Akola", "MH", "444002").getMobileNumber());

    }
}
