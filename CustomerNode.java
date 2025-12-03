//Name: Nathan Strach
//Instructor: Darrell Criss
//Course: CS 145
//Date: 12/02/2025

public class CustomerNode{

    //Establish data fields for customer information
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String zipCode;
    private String phoneNumber;
    //Data fields for customer car information
    private String carMake;
    private String carModel;
    private String carYear;

    //Establish left and right nodes for the BST
    //Right node holds last names after the current node
    //Left node holds last name before the current node
    public CustomerNode right;
    public CustomerNode left;

    //Constructor for customer node including customer data and car data
    public CustomerNode(String firstName, String lastName, String streetAddress, String city, String zipCode, String phoneNumber, String carMake, String carModel, String carYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.right = null;
        this.left = null;
    }

    //Getter method for last name
    public String getLastName(){
        return lastName;
    }

    //Getter method for car model
    public String getCarModel(){
        return carModel;
    }

    // Override toString() method for printing customer info
    @Override
    public String toString(){
        //String.format used for aligning the output neatly
        //Returns customer info and car info
        return String.format("Customer Name: %s %s\nAddress: %s, %s, %s\nPhone Number: %s\nCar Details: %s %s %s",
                firstName, lastName, streetAddress, city, zipCode, phoneNumber, carYear, carMake, carModel);
    }
}