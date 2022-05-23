import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Player player = new Player();
        AI ai = new AI();
        Deck deck = new Deck();
        List<Cards> cards = deck.getListOfCards(); //hold all the cards in the deck
        Scanner scanner = new Scanner(System.in);
        int bet = 0; //hold the amount the user wants to bet
        boolean gameOver = false;
        boolean playAgain = true;

        while (playAgain == true) {
            bet = betMoney(scanner, player);
            setup(deck,player, ai);
            while(player.getValueOfHand() <= 21 && gameOver == false) {
                System.out.println("\nHit('h') or Stand('s'): ");
                String userInput = scanner.next();
                if(userInput.equals("h")) {
                    System.out.println();
                    deck.draw(player);
                    displayPlayer(player);
                    if(player.getValueOfHand() > 21) {
                        checkWinCondition(player, ai, bet);
                        break;
                    }
                    System.out.println();
                    displayDealer(ai);
                } else if(userInput.equals("s")) {
                    System.out.println();
                    ai.getAiCards().get(0).setVisible(true); //reveals dealers first card
                    //adjusts total value of ai's hand to reflect the now visible card    
                    ai.setValueOfHand(ai.getValueOfHand() + ai.getAiCards().get(0).getRank().value1);
                    displayDealer(ai); //revelas the hidden card
                    System.out.println();
                    while(ai.getValueOfHand() < 17) {
                        deck.draw(ai, true);
                        displayDealer(ai);
                    }
                    checkWinCondition(player, ai, bet);
                    gameOver = true;
                } 
            } //while
            System.out.println("------------------------------------------\nContinue 'y' or 'n' ");
            if(scanner.next().equals("n")) { 
                playAgain = false;
            } else {
                gameOver = false;
                deck = new Deck();
                player.reset();
                ai.reset();
            }
        } //while
            
    } //main

    /**
     * Takes in the users bet and reveals how much money they currently have before the start of the round
     * @param scanner takes in the user input for their money
     * @param player the player object
     * @return returns the amount user wants to bet
     */
    private static int betMoney(Scanner scanner, Player player) {
        System.out.println("Current Money: " + player.getMoney());
        System.out.print("Place your bet: ");
        int usersBet = scanner.nextInt();
        System.out.println();
        while(usersBet > player.getMoney()) {
            System.out.println("\nInsufficient Funds!");
            usersBet = scanner.nextInt();
        }
        return usersBet;
    }

    /**
     * Handles all the possible win conditions for both player and the AI in the game
     * @param player the palyer object
     * @param ai  the dealer object
     * @param bet the amount of money on the table for the round
     */
    private static void checkWinCondition(Player player, AI ai , int bet) {
        if(player.getValueOfHand() > 21) {
            ai.getAiCards().get(0).setVisible(true);
            ai.setValueOfHand(ai.getValueOfHand() + ai.getAiCards().get(0).getRank().value1);
            System.out.println();
            displayDealer(ai);
            aiWins(player, bet);
        } else if(ai.getValueOfHand() > 21) {
            playerWins(player, bet);
        } else if(player.getValueOfHand() > ai.getValueOfHand() && player.getValueOfHand() <= 21) {
            playerWins(player, bet);
        } else if(player.getValueOfHand() < ai.getValueOfHand() && ai.getValueOfHand() <= 21) {
            aiWins(player, bet);
        } else if (player.getValueOfHand() == ai.getValueOfHand()) {
            System.out.println("****PUSH****");
        } else {
            aiWins(player, bet);
        }
    }

    /**
     * Sets up the game by giving the player two cards (visible) and two cards to the dealer (1 visible/invisible) 
     * and displays the table
     * @param deck the deck of cards
     * @param player the player object
     * @param ai the dealer object
     */
    private static void setup(Deck deck, Player player, AI ai) {
        deck.draw(player);
        Cards invisibleCard = deck.draw(ai, false); //does not count towards total until it becomes visible
        invisibleCard.setVisible(false);
        deck.draw(player);
        deck.draw(ai, true);
        displayPlayer(player);
        System.out.println();
        displayDealer(ai);
    }

    /**
     * formats how the dealers hand is displayed
     * @param ai the dealer object
     */
    private static void displayDealer(AI ai) {  
        System.out.println("Dealer: \n" + "Total: " + ai.getValueOfHand());
        for(Cards card : ai.getAiCards()) {
            if(card.isVisible() == true) {
                System.out.print(card + " ");
            } else {
                System.out.print("(XX, XX) | ");
            }
        }
        System.out.println();
    }

    /**
     * handles how the players hand is displayed on the table
     * @param player the player object
     */
    private static void displayPlayer(Player player) {
        System.out.println("Player: \n" + "Total: " + player.getValueOfHand());
        for(Cards card : player.getPlayersCards()) {
                System.out.print(card + " ");
            }
        System.out.println();
    }

    /**
     * Displays the player wins screen and sets updated money for player
     * @param player the player object
     * @param bet how much money was betted at the begining of the round
     */
    private static void playerWins(Player player, int bet) {
        System.out.println("\n****Player wins****");
        player.setMoney(player.getMoney() + bet);
        System.out.println("Total Money: " + player.getMoney());
    }
    
    /**
     * Displays the dealer wins screen and sets updated money for player
     * @param player the player object 
     * @param bet how much money was betted at the begining of the round
     */
    private static void aiWins(Player player, int bet) {
        System.out.println("\n****Dealer Wins****");
        player.setMoney(player.getMoney() - bet);
        System.out.println("Total Money: " + player.getMoney());
    }
}