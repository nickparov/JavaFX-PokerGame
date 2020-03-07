package Core.Game.Card;

public enum Suits
{
    CLUBS('C'),
    DIAMONDS('D'),
    SPADES('S'),
    HEARTS('H'),

    NUMBER_OF_SUITS('#');

    Suits(char val)
    {
        m_charVal = val;
    }

    static public int valToOrdinal(char val)
    {
        switch (val)
        {
            case 'C': return 0;
            case 'D': return 1;
            case 'S': return 2;
            case 'H': return 3;

            default: return -1;
        }
    }

    public char getCharVal()
    {
        return m_charVal;
    }

    private char m_charVal;
}
