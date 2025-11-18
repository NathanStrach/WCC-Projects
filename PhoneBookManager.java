//Name: Nathan Strach
//Date: November 18, 2025
//Instructor: Darrell Criss
//Class: CS 145

public class PhoneBookManager{

    //Declares Head of linked list and int for number of entries
    private ListNode head;
    private int size;

    //Constructor to initialize empty phone book
    public PhoneBookManager(){
        this.head = null;
        this.size = 0;
    }

    //Getter for number of phonebook entries
    public int getSize(){
        return size;
    }

    //Method to add entry to beginning of phone book
    public void addFirst(String fName, String lName, String addr, String city, String zip, String phone){
        ListNode newNode = new ListNode(fName, lName, addr, city, zip, phone);

        //Point new node's next to the current head
        newNode.next = head;
        
        //Turns the new node into the head
        head = newNode;
        //Increment size of phone book up by one
        size++;
    }

    //Basically the same as the previous method but adding entry to the end of the phone book
    public void addLast(String fName, String lName, String addr, String city, String zip, String phone){
        ListNode newNode = new ListNode(fName, lName, addr, city, zip, phone);
        
        //If there are no entries, make the new node the head
        if(head == null){
            head = newNode;
        }
        //If there are entries, naviagte to the end and add the new node there
        else{
            
            ListNode current = head;
            //Continues until it reaches the last node
            while(current.next != null){
                current = current.next;
            }
            //Sets the last node's next to the new node
            current.next = newNode;
        }
        //Increment size of phone book up by one
        size++;
    }

    //Method to add entry at a specific index in the phone book
    public boolean addAtIndex(int index, String fName, String lName, String addr, String city, String zip, String phone){

        //Check to see if the index exists in the phone book
        //If doesn't exist, print error message and return false
        if (index < 0 || index > size){
            System.out.println("Error: Index " + index + " is out of bounds.");
            return false;
        }
        //If index is 0, add to beginning of the phone book
        if(index == 0){
            addFirst(fName, lName, addr, city, zip, phone);
            return true;
        }
        //If the index is the size of the phone book you are just adding to the end of it
        if (index == size){
            addLast(fName, lName, addr, city, zip, phone);
            return true;
        }
        //Finds the node before the index selected
        ListNode current = head;
        //Loops to the node before the index
        for(int i = 0; i < index - 1; i++){
            //Moves to the next node
            current = current.next;
        }

        //Creates a new node to be added
        ListNode newNode = new ListNode(fName, lName, addr, city, zip, phone);

        //Inserts the new node at the index selected
        newNode.next = current.next;
        current.next = newNode;
        //Increment size of phone book up by one
        size++;
        return true;
    }

    //Method to delete an entry based on a selected phone number
    public boolean deleteByPhone(String phoneNumber){
        
        //If the list is empty, return false
        if (head == null){
            return false;
        }
        //If it is the head node getting deleted
        if (head.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
            //Move head to the next node
            head = head.next;
            //Reduce phonebook size by one
            size--;
            return true;
        }

        //If it is not the head node, this navigates to the index that is to be deleted
        ListNode current = head;
        //Keeps track of the previous node
        ListNode previous = null;

        //Loops until it finds the phone number or reaches the end of the list
        while(current != null && !current.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
            previous = current;
            current = current.next;
        }

        //If the phone number does not exist, return false
        previous.next = current.next;
        //Reduce phonebook size by one
        size--;
        return true;
    }

    //Method to get an entry for a specific index
    public ListNode getByIndex(int index){
        //Check to see if index exists
        if (index < 0 || index >= size){
            //If not return null
            return null;
        }

        //Otherwise go to the index
        ListNode current = head;
        //Loop through to the index
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        //Returns the node at the index
        return current;
    }


    //Method to find an entry based on phone number
    public ListNode findByPhone(String phonenumber){
        ListNode current = head;
        //Loops through the list until it finds the phone number
        while (current != null){
            //Returns the phone number if found
            if (current.getPhoneNumber().equalsIgnoreCase(phonenumber)){
                return current;
            }
            current = current.next;
        }
        //If not found, return null
        return null;
    }


    //Method to find an entry based on last name
    public ListNode findByLastName(String LastName){
        ListNode current = head;
        //Loops through the list until it finds the last name
        while (current != null){
            //Returns the entry if found
            if (current.getLastName().equalsIgnoreCase(LastName)){
                return current;
            }
            current = current.next;
        }
        //If not found returns null
        return null;
    }

    //Method to modify an entry based on phone number
    public boolean modifyEntry(String oldPhone, String newFName, String newLName, String newAddr, String newCity, String newZip, String newPhone){

        //Find the node to be modified
        ListNode nodeToModify = findByPhone(oldPhone);

        //If node exists, this changes all the data fields to the new information
        if (nodeToModify != null){
            nodeToModify.setFirstName(newFName);
            nodeToModify.setLastName(newLName);
            nodeToModify.setStreetAddress(newAddr);
            nodeToModify.setCity(newCity);
            nodeToModify.setZipCode(newZip);
            nodeToModify.setPhoneNumber(newPhone);
            return true;
        }
        //If the entry doesn't exist, return false
        return false;
    }

    //Method to print all entries in the phone book w/formatting
    public void printList(){
        System.out.println("=====================================");
        System.out.println("      PHONE BOOK ENTRIES (Total: " + size +")");
        System.out.println("=====================================");

        //If the list is empty print message and return
        if (head == null){
            System.out.println("            [List is empty]");
            System.out.println("=====================================");
            return;
        }

        //If there are entries, loop through each one and print its information
        ListNode current = head;
        //Loop for printing info
        while (current != null){
            System.out.println(current.toString());
            current = current.next;
        }
        //Separation line after each entry to make it a little mor readable/separable
        System.out.println("====================================="); 
    }
}