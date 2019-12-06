import com.bridgelabz.AddressBook.model.Person;
import com.bridgelabz.AddressBook.services.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {
    @Test
    public void when_Correct_New_FileName_Entered_Should_Return_false() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.createNewAddressBook("Kurla"));

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
        Assert.assertEquals("946867975", addressBookManager.add("MANGESH", "SURESH", "946867975", "Akola", "MH", "444002").getMobileNumber());

    }

    //    @Test
//    public void when_Add_Details_To_New_File_Entered_Should_Return_False() throws IOException {
//        AddressBookManager addressBookManager = new AddressBookManager();
//        Person person = new Person();
//        Assert.assertEquals("Akola", addressBookManager.add("MANGESH", "SURESH", "946867975", "Akola", "MH", "444002").getCityName());
//
//    }
    @Test
    public void when_Save_Details_To_New_File_Entered_Should_Return_False() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = addressBookManager.add("MANGESH", "GILL", "123000000", "Akola", "MH", "444002");
        Assert.assertEquals(true, addressBookManager.saveEntries("Govandi.json", person));

    }

    @Test
    public void when_Read_From_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.openFile("Govandi.json"));

    }

    @Test
    public void when_Edit_To_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));

    }

    @Test
    public void when_Delete_Person_Details_From_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.deletePersonDetails("Govandi.json", "123000000"));

    }

    @Test
    public void when_Sort_By_Person_FirstName_From_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.sortByName());

    }


}
