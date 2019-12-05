package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Address;
import com.bridgelabz.AddressBook.model.Person;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AddressBookManager implements AddressBookImplementation {
    String filePath = "/home/slot1/IdeaProjects/Address Book/src/main/resources/";
    List<Person> arrayList = new ArrayList<>();

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
        Person temp = new Person(firstName, lastName, new Address(city, state, pincode), mobileNumber);
        arrayList.add(temp);

        System.out.println(arrayList);
        return temp;
    }

    public void editByParticularFields(String fieldName, String replaceField) {
        Person person = new Person();
        Address address = new Address();
        if (fieldName.equals("FirstName")) {
            person.setFirstName(replaceField);
        }
        if (fieldName.equals("LastName")) {
            person.setLastName(replaceField);
        }
        if (fieldName.equals("MobileNumber")) {
            person.setMobileNumber(replaceField);
        }
        if (fieldName.equals("StateName")) {
            address.setStateName(replaceField);
        }
        if (fieldName.equals("CityName")) {
            address.setCityName(replaceField);
        }
        if (fieldName.equals("ZipCode")) {
            address.setZipCode(replaceField);
        }

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
        File SAMPLE_JSON_FILE_PATH = new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/"+fileName);
        if (SAMPLE_JSON_FILE_PATH.exists()) {
            Gson gson = new Gson();
            BufferedReader br=new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            Person[] people = gson.fromJson(br,Person[].class);
            System.out.println(Arrays.toString(people));
            return true;
        }
        return false;
    }

}
