package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Address;
import com.bridgelabz.AddressBook.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AddressBookManager implements AddressBookImplementation {
    private static List<Person> arrayList = new ArrayList<>();
    Person temp;
    String filePath = "/home/slot1/IdeaProjects/Address Book/src/main/resources/";
    Address address = new Address();
    Person person = new Person();
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean createNewAddressBook(String fileName) throws IOException {
        File file = new File(filePath + fileName + ".json");
        if (file.exists()) {
            System.out.println(
                    "\n\t\tThe name " + fileName + " is already used in this location. Please use a different name.");
            return true;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Person add(String firstName, String lastName, String mobileNumber, String city, String state, String pincode) throws IOException {
        Person person = new Person();
        Address address = new Address();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMobileNumber(mobileNumber);
        address.setCityName(city);
        address.setStateName(state);
        address.setZipCode(pincode);
        temp = new Person(firstName, lastName, new Address(city, state, pincode), mobileNumber);
        arrayList.add(person);

        // System.out.println(arrayList);
        return temp;
    }


    public boolean saveEntries() throws IOException {
        File SAMPLE_JSON_FILE_PATH = new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/Govandi.json");
        if (SAMPLE_JSON_FILE_PATH.exists()) {
            Gson gson = new Gson();
            String json = gson.toJson(arrayList);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            return true;
        }
        return false;
    }

    public boolean readJsonDataConvertIntoList(String fileName) throws IOException {
        File SAMPLE_JSON_FILE_PATH = new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/" + fileName);
        if (SAMPLE_JSON_FILE_PATH.exists()) {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            Person[] people = gson.fromJson(br, Person[].class);
            // System.out.println(Arrays.toString(people));
            return true;
        }
        return false;
    }

    public boolean editByParticularFields(String newFieldName, String fieldName, String replaceField) throws IOException {

        for (int i = 0; i < arrayList.size(); i++) {
            if (fieldName.equals(temp.getMobileNumber())) {
                switch (replaceField) {
                    case "FirstName":
                        temp.setFirstName(newFieldName);
                        System.out.println(temp);
                        return true;
                    case "LastName":
                        temp.setLastName(newFieldName);
                        System.out.println(temp);
                        return true;
                    case "MobileNumber":
                        temp.setMobileNumber(newFieldName);
                        System.out.println(temp);
                        return true;
                }
            }
        }
        return false;
    }


}
