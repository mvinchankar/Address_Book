import com.bridgelabz.AddressBook.controller.Driver;
import com.bridgelabz.AddressBook.services.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    @Test
    public void when_Correct_New_FileName_Entered_Should_Return_true() throws IOException {
        AddressBookManager addressBookManager=new AddressBookManager();
        Assert.assertEquals(false,addressBookManager.createNewAddressBook("Govandi"));

    }
}
