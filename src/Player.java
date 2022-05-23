import java.util.ArrayList;
import java.util.List;

public class Player {
    private int money;
    private int handsWon;
    private int valueOfHand;
    private List<Cards> playersCards;

    public Player() {
        valueOfHand = 0;
        this.setMoney(1000);
        this.setHandsWon(0);
        playersCards = new ArrayList<>();
    }

    /**
     * 
     */
    public void reset() {
        valueOfHand = 0;
        playersCards.clear();
    }
    /**
     * Adds a given card to the players hand, unlike the AI version of this method, this method does not care about
     * visibility of the card as we want the players cards to always be visible in the display
     * @param card takes in a card to add to the players hand
     */
    public void addToPlayersCards(Cards card) {
        if(card.getRank() == Rank.ACE && valueOfHand + 11 < 21) { //checks for the correct value of ace
            valueOfHand  += 11;
        } else {
            valueOfHand += card.getRank().value1;
        }
        playersCards.add(card);
    }

    public List<Cards> getPlayersCards() {
        return playersCards;
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public int getHandsWon() {
        return handsWon;
    }

    public void setHandsWon(int handsWon) {
        this.handsWon = handsWon;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
