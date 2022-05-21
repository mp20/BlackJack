import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Player player = new Player();
        AI ai = new AI();
        Deck deck = new Deck();
        List<Cards> cards = deck.getListOfCards();
        Scanner scanner = new Scanner(System.in);
        int bet = 0;
        boolean gameOver = false;
        boolean playAgain = true;

        while (playAgain == true) {
            bet = betMoney(scanner, player,bet);
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
                    ai.getAiCards().get(0).setVisible(true);
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

    private static int betMoney(Scanner scanner, Player player, int bet) {
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

    private static void checkWinCondition(Player player, AI ai , int bet) {
        if(player.getValueOfHand() > 21) {
            ai.getAiCards().get(0).setVisible(true);
            ai.setValueOfHand(ai.getValueOfHand() + ai.getAiCards().get(0).getRank().value1);
            displayDealer(ai);
            aiWins(player, bet);
        } else if(ai.getValueOfHand() > 21) {
            playerWins(player, bet);
        } else if(player.getValueOfHand() > ai.getValueOfHand() && player.getValueOfHand() <= 21) {
            playerWins(player, bet);
        } else if(player.getValueOfHand() < ai.getValueOfHand() && ai.getValueOfHand() <= 21) {
            aiWins(player, bet);
        } else if (player.getValueOfHand() == ai.getValueOfHand()) {
            System.out.println("****PUSH****(5)");
        } else {
            aiWins(player, bet);
        }
    }

    public static void setup(Deck deck, Player player, AI ai) {
        deck.draw(player);
        Cards invisibleCard = deck.draw(ai, false); //does not count towards total
        invisibleCard.setVisible(false);
        deck.draw(player);
        deck.draw(ai, true);
        System.out.println("player: \n" + "Total: " + player.getValueOfHand() + "\n" + player.getPlayersCards() + "\n");
        displayDealer(ai);
    }

    private static void displayDealer(AI ai) {  
        System.out.println("Dealer: \n" + "Total: " + ai.getValueOfHand());
        for(Cards card : ai.getAiCards()) {
            if(card.isVisible() == true) {
                System.out.print(card + " ");
            } else {
                System.out.print("(XX, XX), ");
            }
        }
        System.out.println();
    }

    private static void displayPlayer(Player player) {
        System.out.println("Player: \n" + "Total: " + player.getValueOfHand());
        for(Cards card : player.getPlayersCards()) {
                System.out.print(card + ", ");
            }
        System.out.println();
    }

    private static void playerWins(Player player, int bet) {
        System.out.println("\n****Player wins****");
        player.setMoney(player.getMoney() + bet);
        System.out.println("Total Money: " + player.getMoney());
    }
    
    private static void aiWins(Player player, int bet) {
        System.out.println("\n****AI Wins****");
        player.setMoney(player.getMoney() - bet);
        System.out.println("Total Money: " + player.getMoney());
    }
}