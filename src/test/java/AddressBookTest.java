import com.bridgelabz.AddressBook.model.Person;
import com.bridgelabz.AddressBook.services.AddressBookManager;
import com.bridgelabz.AddressBook.services.CustomException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class AddressBookTest {
    @Test
    public void when_Correct_New_FileName_Entered_Should_Return_true() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(false, addressBookManager.createNewAddressBook("Panvel"));
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

    @Test
    public void when_Save_Details_To_New_File_Entered_Should_Return_true() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = addressBookManager.add("MANGESH", "GILL", "123000000", "Akola", "MH", "444002");
        try {
            Assert.assertEquals(true, addressBookManager.saveEntries("Govandi.json", person));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Save_Details_To_InCorrect_File_Entered_Should_Return_Exception() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Person person = addressBookManager.add("MANGESH", "GILL", "123000000", "Akola", "MH", "444002");
        try {
            Assert.assertEquals(true, addressBookManager.saveEntries("Govandi.json", person));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Read_From_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.openFile("Govandi.json"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Read_From_InCorrect_File() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(false, addressBookManager.openFile("Govandi.json"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_First_Name_To_InCorrect_File() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_First_Name_To_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_Last_Name_To_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_Mobile_Number_To_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_State_To_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_City_To_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Edit_In_ZipCode_To_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.editByParticularFields("Govandi.json", "RANA", "123000000", "LastName"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Delete_Person_Details_From_File_Should_Return_True() throws IOException, CustomException {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true, addressBookManager.deletePersonDetails("Govandi.json", "123000000"));
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.NODATAINFILE, e.getMessage());
        }

    }

    @Test
    public void when_Sort_By_Person_FirstName_From_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.sortByName());

    }

    @Test
    public void when_Sort_By_Person_ZipCode_From_File_Should_Return_True() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true, addressBookManager.sortByZipCode());
    }

    @Test
    public void when_Sort_By_Person_ZipCode_Has_Same_Field_Should_Return_False() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(false, addressBookManager.sortByZipCode());
    }


}
