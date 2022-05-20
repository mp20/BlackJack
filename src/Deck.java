import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
    //we want to have an array of cards
    private List<Cards> listOfCards;
    private List<Cards> pulledCards;


    //constructor
    public Deck() {
        listOfCards = new ArrayList<>(52);
        pulledCards = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Cards c = new Cards(s, r); 
                listOfCards.add(c);
            }
        }
       // shuffle();
    } //deck()

    public List<Cards> getListOfCards() {
        return listOfCards;
    }
    public List<Cards> getPulledCards() {
        return pulledCards;
    }


    public void shuffle() {
        Collections.shuffle(listOfCards);
    }

    @Override
    public String toString() {
        String deck = "[";
        for(int i = 0; i < listOfCards.size() - 1; i++) {
            deck += listOfCards.get(i) + ", ";
        }
        return deck + listOfCards.get(51) + "]";
    }

} //class
