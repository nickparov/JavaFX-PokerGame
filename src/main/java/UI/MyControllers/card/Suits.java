package UI.myControllers.card;

public enum Suits
{
    CLUBS('C'), DIAMONDS('D'), SPADES('S'), HEARTS('H'),
    NUMBER_OF_SUITS('#');

    Suits(char val)
    {
        m_charVal = val;
    }

    public char getCharVal()
    {
        return m_charVal;
    }

    private char m_charVal;
}
