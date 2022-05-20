import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.element.Element;

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


        setup(deck,player, ai);
        
        while (playAgain == true) {
            deck.reset();
            while(player.getValueOfHand() <= 21 && gameOver == false) {
                System.out.println("Hit('h') or Stand('s'): ");
                String userInput = scanner.next();
                if(userInput.equals("h")) {
                    deck.draw(player);
                    System.out.println("\nplayer: \n" + "Total: " + player.getValueOfHand() + "\n" + player.getPlayersCards() + "\n");
                    if (player.getValueOfHand() > 21) {
                        System.out.println("Player loses");
                    }
                } else if(userInput.equals("s")) {
                    while(ai.getValueOfHand() < 17) {
                        deck.draw(ai);
                        System.out.println("\nDealer: \n" + "Total: " + ai.getValueOfHand() + "\n" + ai.getAiCards() + "\n");
                    }
                    checkWinCondition(player, ai, bet);
                    gameOver = true;
                } 
            }
            System.out.println("Continue 'y' or 'n' ");
            if(scanner.next() == "n") { playAgain = false;}
        }
        
            //player hits
                //draw() a card
            //player stands
                //dealer reveals card
                //if the total of dealers cards is less than 17
                    //dealer draws() a card
                //if the dealer has more points than the player the hosue wins
                //if hte dealer has == points to the player the result is a "push"/draw
                //if the dealer has less points the player wins 
    }
    private static void checkWinCondition(Player player, AI ai , int bet) {
        if(player.getValueOfHand() > ai.getValueOfHand() && player.getValueOfHand() <= 21) {
            System.out.println("****Player wins****");
            player.setMoney(player.getMoney() + bet);
        } else if(player.getValueOfHand() < ai.getValueOfHand() && ai.getValueOfHand() <= 21) {
            System.out.println("****AI Wins****");
            player.setMoney(player.getMoney() - bet);
        } else if (player.getValueOfHand() == ai.getValueOfHand()) {
            System.out.println("****PUSH****");
        } else {
            System.out.println("****AI Wins****");
        }
    }
    public static void setup(Deck deck, Player player, AI ai) {
        Cards playersFirstCard = deck.draw(player);
        Cards dealersHidden = deck.draw(ai);
        Cards playersSecondCard = deck.draw(player);
        Cards dealersVisible = deck.draw(ai);
        System.out.println("player: \n" + "Total: " + player.getValueOfHand() + "\n" + player.getPlayersCards() + "\n");
        System.out.println("Dealer: \n" + "Total: " + ai.getValueOfHand() + "\n" + ai.getAiCards() + "\n");
    }

}
