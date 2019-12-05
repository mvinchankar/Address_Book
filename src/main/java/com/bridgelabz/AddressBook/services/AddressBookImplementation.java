package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Person;

import java.io.IOException;

public interface AddressBookImplementation {
    public boolean createNewAddressBook(String fileName) throws IOException;

    public Person add(String firstName, String lastName, String mobileNumber, String city, String state, String pincode) throws IOException;

    public boolean saveEntries() throws IOException;

    public void editByParticularFields(String fieldName, String replaceField);

    public boolean readJsonDataConvertIntoList(String SAMPLE_JSON_FILE_PATH) throws IOException;

}
