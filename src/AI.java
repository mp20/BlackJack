import java.util.ArrayList;
import java.util.List;

public class AI {
    private int valueOfHand;
    private List<Cards> AiCards;

    /**
     * Initializes the value of hand the the list of cards the AI/Dealer holds
     */
    public AI() {
        valueOfHand = 0;
        AiCards = new ArrayList<>();
    }

    /** 
     * Resets the total value for the hand the ai holds, and clears the hand.
     */
    public void reset() {
        valueOfHand = 0;
        AiCards.clear();
    }
    /** 
     * adds drawed cards to AIs list of cards that it holds. However, if the card is currently invisible
     * it will not add it to the total value of hand displayed until the card becomes visible.
     */
    public void addToAiCards(Cards card, boolean isVisible) {
        if(card.getRank() == Rank.ACE && valueOfHand + 11 < 21) {
            card.getRank().setAceValue(11); //we can definitly say that particular ace should hold the value 11
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
