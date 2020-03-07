package Core.Game.Card;

public enum Values
{
    ACE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),

    NUMBER_OF_VALUES('#');

    Values(int val)
    {
        m_intVal = val;
    }

    static public int valToOrdinal(int val)
    {
        return ACE.getIntValue() - val;
    }

    public int getIntValue()
    {
        return m_intVal;
    }

    private int m_intVal;
}
