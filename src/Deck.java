import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Cards> listOfCards;
    private List<Cards> pulledCards; 

    public Deck() {
        listOfCards = new ArrayList<>(52);
        pulledCards = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Cards c = new Cards(s, r); 
                listOfCards.add(c);
            }
        }
        shuffle();
    } //deck()

    public List<Cards> getListOfCards() {
        return listOfCards;
    }
    public List<Cards> getPulledCards() {
        return pulledCards;
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(listOfCards);
    }
    /**
     * Draws a card for the player and adds it to players list of cards.
     * @param player the player 
     * @return the card that was drawn out of the deck.
     */
    public Cards draw(Player player) {
        Cards card = listOfCards.get(0);
        player.addToPlayersCards(card);
        listOfCards.remove(card);
        pulledCards.add(card);
        return card;
    }
    /**
     * Draws a card for the ai and adds it to ai list of cards.
     * @param player the dealer 
     * @return the card that was drawn out of the deck.
     */
    public Cards draw(AI ai, boolean isVisible) {
        Cards card = listOfCards.get(0);
        ai.addToAiCards(card, isVisible);
        listOfCards.remove(card);
        pulledCards.add(card);
        return card;
    }

    @Override
    public String toString() {
        String deck = "[";
        for(int i = 0; i < listOfCards.size() - 1; i++) {
            deck += listOfCards.get(i) + ", ";
        }
        return deck + listOfCards.get(listOfCards.size() - 1) + "]";
    }

} //class 
