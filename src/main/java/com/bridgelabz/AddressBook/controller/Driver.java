package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.services.AddressBookManager;

import java.io.IOException;

public class Driver {

    AddressBookManager addressBookManager=new AddressBookManager();

    public static void main(String[] args) throws IOException {
        AddressBookManager addressBookManager=new AddressBookManager();
        if(addressBookManager.createNewAddressBook("Vashi")==true){
            System.out.println("File Already Exists!!!!!!!!!!!!!!");
        }

    }

}
