package ps.evulator;

public class Card {


    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    public final static int ACE = 14;


    public final static int HEARTS = 3;
    public final static int SPADES = 4;
    public final static int CLUBS = 1;
    public final static int DIAMONDS = 2;



    public final static int NUM_SUITS = 4; // 4 масти
    public final static int NUM_RANKS = 13;  // по 13 карт каждой
    public final static int NUM_CARDS = 52;  // количеств кард 52

    private int gIndex; // у каждой карты свой индекс!!!





    /**
     * Constructor.
     * Creates a card from its character based representation.
     * @param rank the character representing the card's rank
     * @param suit the character representing the card's suit
     */
    public Card(char rank, char suit) {
        gIndex = chars2index(rank,suit);
    }

    public Card(int index) {
        if (index >= 0 && index < NUM_CARDS)
            gIndex = index;
    }



    private int chars2index(char rank, char suit) {
        int r = -1;
        switch (rank) {
            case '2': r = TWO; break;
            case '3': r = THREE; break;
            case '4': r = FOUR; break;
            case '5': r = FIVE; break;
            case '6': r = SIX; break;
            case '7': r = SEVEN; break;
            case '8': r = EIGHT; break;
            case '9': r = NINE; break;
            case 'T': r = TEN; break;
            case 'J': r = JACK; break;
            case 'Q': r = QUEEN; break;
            case 'K': r = KING; break;
            case 'A': r = ACE; break;
            case 't': r = TEN; break;
            case 'j': r = JACK; break;
            case 'q': r = QUEEN; break;
            case 'k': r = KING; break;
            case 'a': r = ACE; break;
        }
        int s = -1;
        switch (suit) {
            case 'h': s = HEARTS; break;
            case 'd': s = DIAMONDS; break;
            case 's': s = SPADES; break;
            case 'c': s = CLUBS; break;
            case 'H': s = HEARTS; break;
            case 'D': s = DIAMONDS; break;
            case 'S': s = SPADES; break;
            case 'C': s = CLUBS; break;
        }
        if (s != -1 && r != -1)
            return toIndex(r,s);
      //  else return BAD_CARD;
        else return -1;
    }

    public int getIndex() {
        return gIndex;
    }


    public static int toIndex(int rank, int suit) {
        return (NUM_RANKS*suit) + rank;
    }

    public Card(String s) {
        if (s.length()==2)
            gIndex = chars2index(s.charAt(0),s.charAt(1));
    }
    /**
     * Obtain the rank of this card
     * @return rank
     */
    public static int getRank(int i) {
        return (int)(i%NUM_RANKS);  // остаток от деления на цело 34%13 = 8  2х13=26
    }
    /**
     * Obtain the rank of this card
     * @return rank
     */
    public int getRank() {
        return (int)(gIndex%NUM_RANKS);
    }


    /**
     * Obtain the suit of this card
     * @return suit
     */
    public final static int getSuit(int i) {
        return (i / NUM_RANKS);
    }


//    /**
//     * Obtain the suit of this card
//     * @return suit
//     */
//    public int getSuit() {
//        return (int)(gIndex/NUM_RANKS);
//    }

}
