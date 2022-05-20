import java.util.ArrayList;
import java.util.List;

public class AI {
    private int valueOfHand;
    private List<Cards> AiCards;

    public AI() {
        valueOfHand = 0;
        AiCards = new ArrayList<>();
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public void addToAiCards(Cards card) {
        if(card.getRank() == Rank.ACE && valueOfHand + 11 < 21) {
            valueOfHand  += 11;
        } else {
            valueOfHand += card.getRank().value1;
        }
        AiCards.add(card);
    }

    public List<Cards> getAiCards() {
        return AiCards;
    }

    public void setAiCards(List<Cards> aiCards) {
        this.AiCards = aiCards;
    }

    
}
