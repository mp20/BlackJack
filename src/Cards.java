import java.lang.annotation.Retention;

public class Cards {
    private Rank rank;
    private Suit suit;    

    public Cards() {
    }

    public Cards(Suit suit, Rank rank) {
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

