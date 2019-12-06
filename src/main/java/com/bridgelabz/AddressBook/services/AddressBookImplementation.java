package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Person;

import java.io.IOException;
import java.util.List;

public interface AddressBookImplementation {
    public boolean createNewAddressBook(String fileName) throws IOException;

    public Person add(String firstName, String lastName, String mobileNumber, String city, String state, String pincode) throws IOException;

    public boolean saveEntries(String fileName, Person person) throws IOException;

    public boolean editByParticularFields(String fileName, String newFieldName, String fieldName, String replaceField) throws IOException;

    public List<Person> readJsonDataConvertIntoList(String SAMPLE_JSON_FILE_PATH) throws IOException;

}
