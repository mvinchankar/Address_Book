package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Person;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AddressBookImplementation {
    public boolean createNewAddressBook(String fileName) throws IOException;

    public Person add(String firstName, String lastName, String mobileNumber, String city, String state, String pincode) throws IOException;

    public boolean saveEntries() throws IOException;

    public boolean editByParticularFields(String newFieldName,String fieldName, String replaceField) throws IOException;

    public boolean readJsonDataConvertIntoList(String SAMPLE_JSON_FILE_PATH) throws IOException;

}
