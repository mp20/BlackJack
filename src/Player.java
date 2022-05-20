import java.util.ArrayList;
import java.util.List;

public class Player {
    private int money;
    private int handsWon;
    private List<Cards> playersCards;

    public Player() {
        this.setMoney(1000);
        this.setHandsWon(0);
        playersCards = new ArrayList<>();
    }

    public List<Cards> getPlayersCards() {
        return playersCards;
    }

    public void addToPlayersCards(Cards card) {
        playersCards.add(card);
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
