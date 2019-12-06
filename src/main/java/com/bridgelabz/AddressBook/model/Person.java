package com.bridgelabz.AddressBook.model;

public class Person {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String stateName;
    private String cityName;
    private String zipCode;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", stateName='" + stateName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public Person(String firstName, String lastName, String mobileNumber, String stateName, String cityName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.stateName = stateName;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
