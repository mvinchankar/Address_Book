package com.bridgelabz.AddressBook.services;

import com.bridgelabz.AddressBook.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBookManager implements AddressBookImplementation {
    List<Person> arrayList = new ArrayList<Person>();
    Gson gson = new Gson();
    BufferedReader br;
    Person temp;
    String filePath = "/home/slot1/IdeaProjects/Address Book/src/main/resources/";
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
        try {
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setMobileNumber(mobileNumber);
            person.setCityName(city);
            person.setStateName(state);
            person.setZipCode(pincode);
            Person temp = new Person(firstName, lastName, mobileNumber, city, state, pincode);

        } catch (NullPointerException e) {
            System.out.println("NULL!!!");
        }
        return person;
    }


    public boolean saveEntries(String fileName, Person person) throws IOException, CustomException {
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

    public List<Person> readJsonDataConvertIntoList(String fileName) throws IOException, CustomException {
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
            throw new CustomException(CustomException.ExceptionType.NODATAINFILE, "NO DATA IN FILE", e);
        }
        return null;
    }

    public boolean openFile(String fileName) throws IOException, CustomException {
        List container = readJsonDataConvertIntoList(fileName);
        if (container.equals(null)) {
            return false;
        }
        return true;
    }

    public boolean editByParticularFields(String fileName, String newFieldName, String fieldName, String replaceField) throws IOException, CustomException {
        String SAMPLE_JSON_FILE_PATH = "/home/slot1/IdeaProjects/Address Book/src/main/resources/Govandi.json";
        readJsonDataConvertIntoList(fileName);
        int flag = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (fieldName.equals(arrayList.get(i).getMobileNumber())) {
                switch (replaceField) {
                    case "FirstName":
                        arrayList.get(i).setFirstName(newFieldName);
                        System.out.println(arrayList);
                        flag = 1;
                        break;
                    case "LastName":
                        arrayList.get(i).setLastName(newFieldName);
                        System.out.println(arrayList);
                        flag = 1;
                        break;
                    case "MobileNumber":
                        arrayList.get(i).setMobileNumber(newFieldName);
                        System.out.println(arrayList);
                        flag = 1;
                        break;
                    case "CityName":
                        arrayList.get(i).setCityName(newFieldName);
                        System.out.println(arrayList);
                        flag = 1;
                        break;
                    case "StateName":
                        arrayList.get(i).setStateName(newFieldName);
                        System.out.println(arrayList);
                        flag = 1;
                        break;
                    case "ZipCode":
                        arrayList.get(i).setZipCode(newFieldName);
                        System.out.println(arrayList);
                        flag = 1;
                        break;

                }
            }
        }
        String json = gson.toJson(arrayList);
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        if (flag == 1) {
            return true;
        }
        return false;
    }

    public boolean deletePersonDetails(String fileName, String personUniqueDetail) throws IOException, CustomException {
        String SAMPLE_JSON_FILE_PATH = "/home/slot1/IdeaProjects/Address Book/src/main/resources/Govandi.json";
        readJsonDataConvertIntoList(fileName);
        int flag = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (personUniqueDetail.equals(arrayList.get(i).getMobileNumber())) {
                arrayList.remove(i);
                System.out.println(arrayList);
                flag = 1;
            }

        }
        String json = gson.toJson(arrayList);
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        System.out.println(arrayList);
        if (flag == 1) {
            return true;
        }
        return false;
    }

    public boolean sortByName() throws IOException {
        List<Person> list = mapper.readValue(new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/Govandi.json"),
                new TypeReference<List<Person>>() {
                });
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getFirstName().compareTo(list.get(j).getFirstName()) > 0) {
                    Person temp1 = list.remove(i);
                    Person temp2 = list.remove(j - 1);
                    list.add(i, temp2);
                    list.add(j, temp1);
                }
            }
        }
        print(list);
        return true;
    }

    public boolean sortByZipCode() throws IOException {
        List<Person> list = mapper.readValue(new File("/home/slot1/IdeaProjects/Address Book/src/main/resources/Govandi.json"),
                new TypeReference<List<Person>>() {
                });
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getZipCode().compareTo(list.get(j).getZipCode()) > 0) {
                    Person temp1 = list.remove(i);
                    Person temp2 = list.remove(j - 1);
                    list.add(i, temp2);
                    list.add(j, temp1);
                }
            }
        }
        print(list);
        return true;
    }

    public static Boolean print(List<Person> listData) {
        System.out.println("FirstName LastName Mobile_Number State City Zip \n");
        String spaces = " ";
        for (int i = 0; i < listData.size(); i++) {
            System.out.print(listData.get(i).getFirstName() + " " + listData.get(i).getLastName() + " "
                    + listData.get(i).getMobileNumber() + " " + listData.get(i).getCityName() + " "
                    + listData.get(i).getStateName() + " " + listData.get(i).getZipCode());
            System.out.println();
        }
        return true;
    }

}
