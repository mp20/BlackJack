public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(1);

    int value1;
   
    Rank(int value) {
        this.value1 = value; 
    }
    /**
     * This method is needed due to ACE having two possible states (i.e. 11/1)
     * Using this method we can set the correct value of ace in the given situtation
     * @param num the value we want ace to have, either 1 or 11
     */
    public void setAceValue(int num) {
        Rank.ACE.value1 = num;
    }

    public int getValue1() {
        return value1;
    }
}
