package com.bridgelabz.AddressBook.services;

import sun.tools.jstat.Scale;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
}
