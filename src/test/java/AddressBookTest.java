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
    @Test
    public void when_Save_Details_To_New_File_Entered_Should_Return_False() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = new Person();
        addressBookManager.add("RAMESH", "SURESH", "9468679751", "Akola", "MH", "444002");
        Assert.assertEquals(true,addressBookManager.saveEntries());

    }
    @Test
    public void when_Read_From_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = new Person();
        Assert.assertEquals(true,addressBookManager.readJsonDataConvertIntoList("Govandi.json"));

    }
    @Test
    public void when_Edit_To_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = new Person();
        addressBookManager.add("RAMESH", "SURESH", "9468679751", "Akola", "MH", "444002");
        Assert.assertEquals(true,addressBookManager.editByParticularFields("RANA","9468679751","LastName"));

    }

}
