import java.util.Scanner;

public class playBlackJack {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Declare boolean for playing again
        boolean playAgain = true;


        // Introductory message with how to play
        System.out.println("__________________________________________________________");
        System.out.println(" Welcome to blackjack! Here are the rules: ");
        System.out.println(" You and the dealer will be dealt 2 cards.");
        System.out.println(" Dealer will have one face up and one face down.");
        System.out.println(" Card rankings are equal to their value except");
        System.out.println(" face cards are 10 and Aces can be 1 or 11.");
        System.out.println(" The goal of the game is to beat the dealer in");
        System.out.println(" The total value of your cards wtihout going over 21.");
        System.out.println(" If you go over 21 you 'bust' which means you lose.");
        System.out.println(" If you want more cards you can say hit, but if");
        System.out.println(" you don't want to you can say stay (don't get cards).");
        System.out.println(" Once you have decided to hit the dealer will hit or stay.");
        System.out.println(" Ties end the hand, no one wins.");
        System.out.println("___________________________________________________________");

        // While loop to keep the game going as long as the player wants
        while(playAgain){
            BlackJack blackjack = new BlackJack();
            // Method for executing the actual game
            blackjack.playGame();
            // Prompt user to continue playing
            System.out.println("Would you like to play again? (Y) or (N):");
            String choice = scanner.nextLine().toUpperCase();

        // If/else statements to handle players answer
        if(choice.equals("Y")){
            continue;
        }
        else if(choice.equals("N")){
            playAgain = false;
        }
        }
        // Outgoing message
        System.out.println("Come again!y");
        scanner.close();
    }
}
