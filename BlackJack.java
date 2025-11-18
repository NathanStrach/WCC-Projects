import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

        // Declare Variables
        DeckOfCards gameDeck;
        ArrayList<Card> playerHand;
        ArrayList<Card> dealerHand;

        


        public BlackJack() {
            // Initialize lists for the player and dealer's hand
            playerHand = new ArrayList<Card>();
            dealerHand = new ArrayList<Card>();

            // Declares a new list of cards and shuffles the list
            gameDeck = new DeckOfCards();
            gameDeck.shuffle();
        }

        // Deals one card to the player, one to dealer
        // One to player, and another to dealer in that order
        public void deal() {
            playerHand.add(gameDeck.dealCard());
            dealerHand.add(gameDeck.dealCard());
            playerHand.add(gameDeck.dealCard());
            dealerHand.add(gameDeck.dealCard());
        }

        // Method to play blackjack
        public void playGame() {
            Scanner scanner = new Scanner(System.in);
            // Call deal method to give each player cards
            deal();

            boolean playerStands = false;
            
            // While loop for hitting/staying
            while(true) {
                // Prints out player and dealer hand hiding one of the dealer's cards
                printHand("Player", playerHand, false);
                printHand("Dealer", dealerHand, true);

                // If statement for automatic win for player
                if(calculateValue(playerHand) == 21){
                    System.out.println("Blackjack! You win!");
                    // Exits while loop
                    break;
                }

                // Prompt player to hit or stay
                System.out.printf("\n Hit (H) or Stand (S)?");
                String choice = scanner.nextLine().toUpperCase();

                // If statement for hitting
                if(choice.equals("H")){
                    // Deals player another card
                    playerHand.add(gameDeck.dealCard());

                    // Player loses if hand is over 21
                    if(calculateValue(playerHand) > 21){
                        printHand("Player", playerHand, false);
                        System.out.println("Bust! You lose.");
                        playerStands = true;
                        break;
                    }
                }
                // Player chooses to stay, no card is dealt
                else if(choice.equals("S")){
                    playerStands = true;
                    break;
                }
            }
            if(!playerStands){
                // Dealer always hits if dealers hand is less than 17
                while(calculateValue(dealerHand) < 17) {
                    dealerHand.add(gameDeck.dealCard());
                    System.out.println("\nDealer hits ...");
                }
            }
            // Prints out final hands of dealer and player
            System.out.println("\n |Final Hands|");
            printHand("Player", playerHand, false);
            printHand("Dealer", dealerHand, false);

            // Find the dealer and player's totals
            int playerValue = calculateValue(playerHand);
            int dealerValue = calculateValue(dealerHand);

            // Win conditions
            // Player loses if over 21
            if(playerValue > 21){
                System.out.println("Dealer wins.");
            }
            // Dealer loses if over 21
            else if(dealerValue > 21) {
                System.out.println("Dealer busts! You win!");
            }
            // Player beats dealer
            else if(playerValue > dealerValue){
                System.out.println("You win!");
            }
            // Dealer beats player
            else if(dealerValue > playerValue){
                System.out.println("Dealer wins!");
            }
            // Player and dealer tie
            else{
                System.out.println("Tie!");
            }
        }

        // Method for calculating value of the hand
        public int calculateValue(ArrayList<Card> hand){
            int value = 0;
            int aces = 0;

            // Gets and adds each value of each card to the total
            for(Card card : hand){
                value += card.getValue();
                // To mark if you have an ace
                if(card.getRank().equals("Ace")){
                    aces++;
                }
            }
            // Changes values of the ace based on your total hand value
            // If your hand with an ace is over 21 then the ace 
            // Value automatically is reduced to 1
            // This happens for each ace
            while(value > 21 && aces > 0){
                value -= 10;
                aces--;
            }
            // Returns total hand value
            return value;
        }

        // Method to print what cards are in whose hand
        public void printHand(String name, ArrayList<Card> hand, boolean hideCard){
            System.out.println("\n" + name + "'s Hand:");
            // If statement to hide one of the dealers cards
            if(hideCard){
                System.out.println(" " + hand.get(0));
                System.out.println(" (Face down card)");
            }
            // Otherwise prints out players hand like normal
            else{
                for(Card card: hand){
                    System.out.println(" " + card);
                }
                // Also prints out player's hand value
                System.out.println(" Total Value: " + calculateValue(hand));
            }
        }
        
    }
