
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        // Creating a Scanner class for player input
  
        Scanner player = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        // Create the playing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffleDeck();

        // Create hands for the player and the dealer
        // hands are created from methods that are made in the deck class

        Deck playerHand = new Deck();
        Deck dealerHand = new Deck();

        // assigning initial playermoney

        System.out.println("Enter the money you have:");

        double playerMoney = player.nextDouble();

        // Game loops

        while (playerMoney > 0) {

            // Play on
            // Take the player's bet

            System.out.println("You have $" + playerMoney + ", how much would you like to bet?");

            // Take the players bet

            double playerBet = player.nextDouble();

            // if player bets more than the balance ask to put lower amount

            if (playerBet > playerMoney) {

                System.out.println("You cannot bet more than you have. Please leave!");

                break;

            }

            boolean endRound = false;

            // Start Dealing
            // Player gets two cards

            playerHand.draw(playingDeck);
            playerHand.draw(playingDeck);

            // Dealer gets two cards

            dealerHand.draw(playingDeck);
            dealerHand.draw(playingDeck);

            while (true) {

                System.out.println("Your hand: " + playerHand.toString());

                System.out.println("Your hand is valued at: " + playerHand.deckValue());

                // Determine if player has Blackjack

                if (playerHand.deckValue() == 21) {
                    System.out.println("BlackJack You win!.");
                    playerMoney += playerBet;
                    endRound = true;
                    break;

                }

                // System.out.println("End of Round");

                // Display Dealer Hand

                System.out.println("Dealer's Hand: " + dealerHand.getCard(0).toString() + " and [Hidden]");

                // What does the player want to do?

                System.out.println("Would you like to Hit or Stand ? Enter 1 for Hit and 2 for Stand.");

                int response = player.nextInt();

                // if player selects hit

                if (response == 1) {
                    playerHand.draw(playingDeck);
                    System.out.println("You draw a: " + playerHand.getCard(playerHand.deckSize() - 1).toString());

                    // Bust if > 21

                    if (playerHand.deckValue() > 21) {
                        System.out.println("Bust! You lose the hand! Your hand is valued at: " + playerHand.deckValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;

                    }

                }

                if (response == 2) {

                    break;
                }

            }

            // Reveal Dealer Cards

            System.out.println("Dealer's Hand: " + dealerHand.toString());

            // Determine if Dealer has Blackjack

            if ((dealerHand.deckValue() == 21) && endRound == false) {
                System.out.println("Dealer has Blackjack! You lose!");
                playerMoney -= playerBet;
                endRound = true;
            }

            // See if dealer has more points than player

            if ((dealerHand.deckValue() > playerHand.deckValue()) && endRound == false) {

                System.out.println("Dealer beats you!");
                playerMoney -= playerBet;
                endRound = true;

            }

            // Dealer Draws at 16, stands at 17

            while ((dealerHand.deckValue() < 17) && endRound == false) {
                dealerHand.draw(playingDeck);
                System.out.println("Dealer Draws: " + dealerHand.getCard(dealerHand.deckSize() - 1).toString());

            }

            // Display Total Value for Dealer

            System.out.println("Dealer's Hand is valued at: " + dealerHand.deckValue());

            // Determine if Dealer busted

            if ((dealerHand.deckValue() > 21) && endRound == false) {
                System.out.println("Dealer busts! You win!");
                playerMoney += playerBet;
                endRound = true;
            }

            // Determine if push (a draw or a tie)

            if ((playerHand.deckValue() == dealerHand.deckValue()) && endRound == false) {

                System.out.println("You both have equal value - Push");

                endRound = true;

            }

            // Determine if player has more points

            if ((playerHand.deckValue() > dealerHand.deckValue()) && endRound == false) {

                System.out.println("You win the hand!");
                playerMoney += playerBet;
                endRound = true;
            }

            else if (endRound == false) {
                System.out.println("You lose the hand.");
                playerMoney -= playerBet;
                endRound = true;
            }

            playerHand.moveAllToDeck(playingDeck);
            dealerHand.moveAllToDeck(playingDeck);
            System.out.println("End of round.");

        }

        System.out.println("Game over! You are out of money!");

        player.close();

    }

}
