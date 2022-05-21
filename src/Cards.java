import java.lang.annotation.Retention;

public class Cards {
    private Rank rank;
    private Suit suit;    
    private boolean visible;

    public Cards() {
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Cards(Suit suit, Rank rank) {
        this.setVisible(true);
        this.setRank(rank);
        this.setSuit(suit);
    }

    public Rank getRank() {
        return rank;
    }
    
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString()
    {
    // Construct a String here that is appropriate for this class.
    return "(" + rank + ", " + suit + ")"; 
    // Return it!
    }

    
}

