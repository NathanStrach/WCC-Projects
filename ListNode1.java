//Name: Nathan Strach
//Date: November 18, 2025
//Instructor: Darrell Criss
//Class: CS 145

public class ListNode1{

    //Declare Data fields for phonebook info
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String zipCode;
    private String phoneNumber;
    //This links the next node in the list
    public ListNode next;

    //Constructor to create a new node/entry in the phonebook with all info
    public ListNode1(String firstName, String lastName, String streetAddress, String city, String zipCode, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
    //Getters and setters for all data fields
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public String getCity(){
        return city;
    }

    public String getZipCode(){
        return zipCode;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    //End of getters

    //Start of setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //End of setters

    //Override toString method to display phone book infor of a single entry
    //Will be called with printList method in PhoneBookManager class
    @Override
    public String toString(){
        return "Name: " + lastName + ", " + firstName +"\n" +
               "Phone: " + phoneNumber + "\n" +
               "Address: " + streetAddress + "\n" +
               "         " + city + ", " + zipCode + "\n" +
               "-------------------------------------"; 
    }
}