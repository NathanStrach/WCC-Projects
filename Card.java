// Card.java
// Card class represents a playing Card 

public class Card {
    private final String rank; // face o card ("Ace", "Deuce", ...) 
    private final String suit; // suit of card ("Hearts", Diamonds", etc)
    private final int value; // value of card "1, 2 ,3 ,... 10"
    
    // two-argument constructor initializes card's face and suit 
    public Card(String cardFace, String cardSuit) {
        this.rank = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card 

        // Sets base value for Aces to 11
        if (rank.equals("Ace")){
            this.value = 11;
        }
        // Sets values for face cards at 10
        else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")){
        this.value = 10;
    }
        else {
            //Sets the value of number cards as its number
            this.value = Integer.parseInt(rank);
        }
    } // end of Card Constructor 

    // Getter for the cards rank
    public String getRank(){
        return this.rank;
    }

    // Getter for the cards value
    public int getValue(){
        return this.value;
    }
    
    // return String representation of Card
    @Override
    public String toString() {
        return rank + " of " + suit; 
    } // end of toString method 
} // end class Card 

// DeckOfCardsTest.java
// Card shuffling and dealing

