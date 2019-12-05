package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.services.AddressBookManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        if(addressBookManager.createNewAddressBook("HASAN")==true)
        {
            System.out.println("Exists!!!!!!");
        }
        addressBookManager.add("RAMESH","SURESH","946867975","Akola","MH","444002");
    }


}
