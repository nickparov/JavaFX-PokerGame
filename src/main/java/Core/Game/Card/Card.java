package Core.Game.Card;

public class Card {
    public Card(char suit, int value)
    {
        m_suit = suit; // C D S H
        m_value = value;
    }

    public char getSuit()
    {
        return m_suit;
    }

    public int getValue()
    {
        return m_value;
    }

    public int getSuitIdx()
    {
        return Suits.valToOrdinal(m_suit);
    }

    public int getValueIdx()
    {
        return Values.valToOrdinal(m_value);
    }

    private int m_value;
    private char m_suit;
}


