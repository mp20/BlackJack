import java.util.ArrayList;
import java.util.List;

public class AI {
    private int valueOfHand;
    private List<Cards> AiCards;

    public AI() {
        valueOfHand = 0;
        AiCards = new ArrayList<>();
    }

    public void reset() {
        valueOfHand = 0;
        AiCards.clear();
    }

    public void addToAiCards(Cards card, boolean isVisible) {
        if(card.getRank() == Rank.ACE && valueOfHand + 11 < 21) {
            card.getRank().setAceValue(11);
            if(isVisible) {
            valueOfHand  += 11;
            }
        } else {
            if(isVisible) {
            valueOfHand += card.getRank().value1;
            }
        }        
        AiCards.add(card);
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public void setValueOfHand(int num) {
        this.valueOfHand = num;
    }

    public List<Cards> getAiCards() {
        return AiCards;
    }

    public void setAiCards(List<Cards> aiCards) {
        this.AiCards = aiCards;
    }
    
}
