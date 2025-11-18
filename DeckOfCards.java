import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    private ArrayList<Card> deck;

        public DeckOfCards(){
            this.deck = new ArrayList<Card>();

            // Arrays to assign strings for suits and card rankings 
            // Since there are a set number of cards in a deck
            String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
            String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8",
                              "9", "10", "Jack", "Queen", "King"};
            // For loops to iterate through every card of each suit and add it to the arrayList deck
            for (String suit: suits){
                for (String rank : ranks){
                    // Adds the card to the deck
                    this.deck.add(new Card(rank, suit));
                }
            }
        }

        // Method for shuffling the arraylist
         public void shuffle(){
                // Shuffles the arrayList
                Collections.shuffle(this.deck);
            }

            // Method for dealing cards
            public Card dealCard(){
                if(this.deck.isEmpty()){
                    this.deck = new DeckOfCards().deck;
                    // Shuffles deck
                    shuffle();
                }
                // Takes card at the "top" of the pile and returns it
                // All other cards below get shifted up
                return this.deck.remove(0);
            }

            } 
