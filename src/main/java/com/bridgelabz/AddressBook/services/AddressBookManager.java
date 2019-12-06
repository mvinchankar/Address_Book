package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBookManager implements AddressBookImplementation {
    private static List<Person> arrayList = new ArrayList<Person>();
    Gson gson = new Gson();
    BufferedReader br;
    Person temp;
    String filePath = "/home/slot1/IdeaProjects/Address Book/src/main/resources/";
    private static Person person;
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
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMobileNumber(mobileNumber);
        person.setCityName(city);
        person.setStateName(state);
        person.setZipCode(pincode);
        Person temp= new Person(firstName,lastName,mobileNumber,city,state,pincode);
        return person;
    }


    public boolean saveEntries(String fileName, Person person) throws IOException {
        File SAMPLE_JSON_FILE_PATH = new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/Govandi.json");
        if (SAMPLE_JSON_FILE_PATH.exists()) {
            Gson gson = new Gson();
            readJsonDataConvertIntoList(fileName);
            arrayList.add(person);
            String json = gson.toJson(arrayList);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            return true;
        }
        return false;
    }

    public List<Person> readJsonDataConvertIntoList(String fileName) throws IOException {
        try {
            File SAMPLE_JSON_FILE_PATH = new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/" + fileName);
            if (SAMPLE_JSON_FILE_PATH.exists()) {
                Gson gson = new Gson();
                BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
                Person[] person = gson.fromJson(br, Person[].class);
                for (int i = 0; i < person.length; i++) {
                    arrayList.add(person[i]);
                }
                return arrayList;
            }
        } catch (NullPointerException e) {
            System.out.println("EMPTY FILE!!");
        }
        return null;
    }

    public boolean openFile(String fileName) throws IOException {
        List container = readJsonDataConvertIntoList(fileName);
        if (container.equals(null)) {
            return false;
        }
        return true;
    }

    public boolean editByParticularFields(String fileName, String newFieldName, String fieldName, String replaceField) throws IOException {
        readJsonDataConvertIntoList(fileName);
        for (int i = 0; i < arrayList.size(); i++) {
            if (fieldName.equals(arrayList.get(i).getMobileNumber())) {
                switch (replaceField) {
                    case "FirstName":
                        arrayList.get(i).setFirstName(newFieldName);
                        System.out.println(arrayList);
                        return true;
                    case "LastName":
                        arrayList.get(i).setLastName(newFieldName);
                        System.out.println(arrayList);
                        return true;
                    case "MobileNumber":
                        arrayList.get(i).setMobileNumber(newFieldName);
                        System.out.println(arrayList);
                        return true;
                    case "CityName":
                        arrayList.get(i).setCityName(newFieldName);
                        System.out.println(arrayList);
                        return true;
                    case "StateName":
                        arrayList.get(i).setStateName(newFieldName);
                        System.out.println(arrayList);
                        return true;
                    case "ZipCode":
                        arrayList.get(i).setZipCode(newFieldName);
                        System.out.println(arrayList);
                        return true;

                }
            }
        }
        return false;
    }

}
