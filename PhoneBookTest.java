//Name: Nathan Strach
//Date: November 18, 2025
//Instructor: Darrell Criss
//Class: CS 145

public class PhoneBookTest{

    public static void main(String[] args){

        PhoneBookManager phoneBook = new PhoneBookManager();


        //Adds 3 entries to the end of the phone book
        System.out.println("Adding entries to the phone book...");
        phoneBook.addLast("Mary", "Poppins", "17 Cherry Tree Ln", "London", "78987", "777-2000" );
        phoneBook.addLast("The", "MuffinMan", "Drury Lane", "London", "78987", "777-2001" );
        phoneBook.addLast("Jack", "TheRipper", "29 Hanbury Street", "London", "78987", "777-2002" );

        //Display all entries
        phoneBook.printList();

        //Add an entry to the beginning of the phone book
        System.out.println("Adding entry to the beginning of the phone book...");
        phoneBook.addFirst("Paddington", "Bear", "32 Windsor Gardens", "London", "78987", "777-2004" );

        //Display all entries
        phoneBook.printList();

        //Add an entry to the middle of the phone book
        System.out.println("Adding entry to the middle of the phone book...");
        phoneBook.addAtIndex(2,"Jack", "TheRipper", "29 Hanbury Street", "London", "78987", "777-2002" );

        //Display all entries
        phoneBook.printList();

        //Search for an entry by index
        System.out.println("Searching for entry at index 3...");
        ListNode entry = phoneBook.getByIndex(3);
        if (entry != null){
            System.out.println("Found: \n" + entry.toString());
        }
        else{
            System.out.println("No entry found at that index.");
        }

        //Seach for an entry through a phone number
        System.out.println("\n Searching for entry with phone number '777-2001'...");
        entry = phoneBook.findByPhone("777-2001");
        //If entry exists, print out
        if (entry != null) {
            System.out.println("Found:\n" + entry.toString());
        //If entry doesn't exist print not found message
        } else {
            System.out.println("Entry with phone '777-2001' not found.");
        }

        //Modify an entry in the phone book based on the phone number
        System.out.println("\nModifying Mary Poppins entry...");
        phoneBook.modifyEntry("777-2000", "Johnny", "Poppins", "18 Cherry Tree Ln", "London", "78987", "777-2005");
        
        //Display all entries
        phoneBook.printList();

        //Delete an entry based on phone number
        System.out.println("\nDeleting entry with phone number '777-2002'...");
        boolean deleted = phoneBook.deleteByPhone("777-2002");
        System.out.println("Delete successful: " + deleted);
        
        //Display all entries
        phoneBook.printList();
        
        //Delete the head node (changed from Mary to Johnny Poppins)
        System.out.println("\nDeleting top entry in the phone book...");
        phoneBook.deleteByPhone("777-2005");
        
        //Display all entries
        phoneBook.printList();
        
    }
}