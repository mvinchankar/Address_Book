package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Address;
import com.bridgelabz.AddressBook.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AddressBookManager implements AddressBookImplementation {
    String filePath = "/home/slot1/IdeaProjects/Address Book/src/main/resources/";

    @Override
    public boolean createNewAddressBook(String fileName) throws IOException {
        File file = new File(filePath + fileName + ".json");
        /*
         * If file exists It will display message
         * or It will create file by that Name
         */
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
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        Address address = new Address();
        List<Person> arrayList = new ArrayList<>();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMobileNumber(mobileNumber);
        address.setCityName(city);
        address.setStateName(state);
        address.setZipCode(pincode);
        /*
         * Create Temp as an object to store in a ArrayList
         */
        Person temp = new Person(firstName, lastName, new Address(city, state, pincode), mobileNumber);
        arrayList.add(temp);

        System.out.println(arrayList);
        return temp;

    }

}
