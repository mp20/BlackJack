import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //create a deck of cards
            //makes a deck and shuffles it
        Player player = new Player();
        Deck deck = new Deck();
        List<Cards> cards = deck.getListOfCards();
        
        setup(deck,player);

        //player draws() a card
        //dealer draws() a card(face down)
        //player draw() another card
        //dealer draws() a card(face up)
        //while the total is not greater than 21 the player gets to hit or stand
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
    public static void setup(Deck deck, Player player) {
        Cards playersFirstCard = deck.draw();
        System.out.println("Player's card 1: " + playersFirstCard + "\n");
        player.addToPlayersCards(playersFirstCard);
        Cards dealersHidden = deck.draw();
        Cards playersSecondCard = deck.draw();
        player.addToPlayersCards(playersSecondCard);
        System.out.println("Player's card 2: " + playersSecondCard + "\n");
        Cards dealersVisible = deck.draw();
        System.out.println("Dealer's card 1: (xx, xx) \n");
        System.out.println("Dealer's card 2: " + dealersVisible + "\n");
        System.out.println(player.getPlayersCards());
    }
}
