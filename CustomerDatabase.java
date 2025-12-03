//Name: Nathan Strach
//Instructor: Darrell Criss
//Course: CS 145
//Date: 12/02/2025
public class CustomerDatabase {

    //Beginning of BST, the first/root node
    private CustomerNode root;

    //Constructor for empty customer database
    //Initializes with an empty root
    public CustomerDatabase() {
        this.root = null;
    }

    //Public Method for inserting a customer into the BST
    public void insert(String fName, String lName, String addr, String city, String zip,
                       String phone, String make, String model, String year) {
        //Creates a new customer node with data provided
        CustomerNode newNode = new CustomerNode(fName, lName, addr, city, zip, phone, make, model, year);
        //Inserts new node into the BST
        root = insertRecursive(root, newNode);
    }

    //Private recursive method for inserting a new node into the BST
    private CustomerNode insertRecursive(CustomerNode current, CustomerNode newNode) {
        // Base case: If the current position is empty, insert the new node here.
        if (current == null) {
            //New node becomes the root of this subtree
            return newNode;
        }

        //Sets an integer equal to the value returned by the compareToIgnoreCase method
        //If the new node's last name comes before the current node's last name, a negative integer is returned
        //If the new node's last name comes after the current node's last name, a positive integer is returned
        int comparison = newNode.getLastName().compareToIgnoreCase(current.getLastName());

        if (comparison < 0) {
            // New last name comes before the current node (goes left)
            current.left = insertRecursive(current.left, newNode);
        } else { 
            // New last name comes after or is the same (goes right)
            current.right = insertRecursive(current.right, newNode);
        }

        //Returns the unchanged current node pointer
        return current;
    }

  
    //Public method for searching by last name
    public CustomerNode searchByLastName(String lastName) {
        //Calls the private search method
        return searchLastNameRecursive(root, lastName);
    }

    //Private method for searching the BST by last name
    private CustomerNode searchLastNameRecursive(CustomerNode current, String lastName) {
        //If current node is null then the last name does not exist in the tree
        if (current == null) {
            //Returns null for not found
            return null; 
        }
        
        //Sets an integer equal to the value returned by the compareToIgnoreCase method
        //If the new node's last name comes before the current node's last name, a negative integer is returned
        //If the new node's last name comes after the current node's last name, a positive integer is returned
        int comparison = lastName.compareToIgnoreCase(current.getLastName());

        //If comparison is 0, the last name found matches the name we are searching for
        if (comparison == 0) {
            //Returns the current node and all its data
            return current;

            //If comparison is less than 0, we search the names that come before the current node
        } else if (comparison < 0) {
            //Search continues in the left subtree
            return searchLastNameRecursive(current.left, lastName);

            //If comparison is greater than 0, we search the names that come after the current node
        } else {
            //Search continues in the right subtree
            return searchLastNameRecursive(current.right, lastName);
        }
    }
    
    //Public method for searching by car model
    public CustomerNode searchByCarModel(String model) {
        //Calls the private search method
        return searchModelRecursive(root, model);
    }

    //Private method for searching the BST by car model
    private CustomerNode searchModelRecursive(CustomerNode current, String model) {
        
        //If current node is null then the car model does not exist in the tree
        if (current == null) {
            //Returns null for not found
            return null;
        }

        //If current node's car model matches the search model, return the current node
        //Compares strings instead of integers 
        if (model.equalsIgnoreCase(current.getCarModel())) {
            //If a match is found, return the current node
            return current;
        }

        //Search the left subtree
        CustomerNode foundLeft = searchModelRecursive(current.left, model);
        // If found in left subtree, return it
        if (foundLeft != null) {
            return foundLeft;
        }

        //Search the right subtree
        return searchModelRecursive(current.right, model);
    }


    //Public method for sorting and printing the customer database in order by last name
    public void printInOrder() {
        //Introductory statements 
        System.out.println("\n===== NATHAN'S AUTOMOTIVE CUSTOMER DATABASE =====");
        System.out.println("  (Sorted by Last Name)");
        printInOrderRecursive(root);
        System.out.println("=================================================");
    }

    //Private recursive method for navigating and printing the BST in order
    private void printInOrderRecursive(CustomerNode current) {
        //If the current node is not null, continue navigation
        if (current != null) {
            //Goes all the way left and prints smallest last names first
            printInOrderRecursive(current.left);

            //Prints the current node's customer data
            System.out.println("----------------------------------------------");
            //Calls the toString method from CustomerNode to format the output
            System.out.println(current.toString());

            //Goes to the right subtree to print larger last names
            printInOrderRecursive(current.right);
        }
    }
}