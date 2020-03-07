package UI.myControllers.card;

public class Card
{
    public Card(Values value, Suits suit)
    {
        this.value = value;
        this.suit = suit;
    }

    public Card(int value, char suit)
    {
        this.value = Values.values()[Values.valToOrdinal(value)];
        this.suit = Suits.values()[Suits.valToOrdinal(suit)];
    }

    public Values value;
    public Suits suit;
}







