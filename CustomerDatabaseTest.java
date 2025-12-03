//Name: Nathan Strach
//Instructor: Darrell Criss
//Course: CS 145
//Date: 12/02/2025
public class CustomerDatabaseTest {

    //Main method
    public static void main(String[] args) {
        
        //Creates a new CustomerDatabase
        CustomerDatabase database = new CustomerDatabase();

        //Print statement to indicate we are calling methods to build our database/BST
        System.out.println("Building Customer Database...");
        
        //Inserting multiple customers into database
        //Order is jumbled to test the tree's sorting
        database.insert("Emily", "Roberts", "505 Oak St", "Renton", "98055", "555-1234", "Honda", "CRV", "2018");
        database.insert("Alex", "Zimmerman", "101 Pine Ln", "Seattle", "98101", "555-9090", "Ford", "F-150", "2022");
        database.insert("Dan", "Smith", "777 Main St", "Auburn", "98002", "555-1001", "Toyota", "Camry", "2015");
        database.insert("Michael", "Abrams", "303 Elm Ave", "Kent", "98032", "555-8888", "BMW", "X5", "2020");
        database.insert("Sarah", "Jones", "202 Cedar Pkwy", "Bellevue", "98004", "555-5555", "Subaru", "Outback", "2019");

        //Prints the customer database in order of last names from A to Z
        System.out.println("\nPrinting Customer Database In Order (A-Z)");
        database.printInOrder();
        
        //Demonstrates the search method
        System.out.println("\nTesting Search by Last Name (Smith)...");
        //Testing the search by last name method
        CustomerNode smith = database.searchByLastName("Smith");
        //If a customer with the last name is found, print their data
        if (smith != null) {
            System.out.println("Customer Found:\n" + smith);
        //If customer is not found print not found message
        } else {
            System.out.println("Customer not found.");
        }
        
        //Demonstrates the search by car model method
        System.out.println("\nTesting Search by Car Model (Outback)...");
        //Testing the search by car model method
        CustomerNode outback = database.searchByCarModel("Outback");
        //If a customer with the car model is foundm, print their data
        if (outback != null) {
            System.out.println("Customer Found:\n" + outback);
        //If not found, print not found message
        } else {
            System.out.println("Car Model not found.");
        }
        
        //Demonstrates the search by car model method for a car model not in the database
        System.out.println("\nTesting Search by Car Model (Tesla)...");
        //Testing the search by car model method
        CustomerNode Tesla = database.searchByCarModel("Tesla");
        //If a customer with the car model is foundm, print their data
        if (Tesla != null) {
            System.out.println("Customer Found:\n" + Tesla);
        //If not found, print not found message
        } else {
            System.out.println("Car Model not found.");
        }
        
    }
}