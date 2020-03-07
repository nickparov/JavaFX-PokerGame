package UI.myComponents.card;

import util.Singleton;
import Core.Game.Card.Card;
import Core.Game.Card.Suits;
import Core.Game.Card.Values;


class CardDatabase implements Singleton
{
    static CardDatabase getInstance()
    {
        if(m_cardDatabase == null)
            return new CardDatabase();

        return m_cardDatabase;
    }

    String getCardFileName(Card card)
    {
        return m_dataBase[hashCard(card.getValueIdx(), card.getSuitIdx())];
    }

    private int hashCard(int val, int suit)
    {
        return val * Suits.NUMBER_OF_SUITS.ordinal() + suit;
    }


    private CardDatabase()
    {
        String fileNameBase = "src/res/Cards/";
        String fileExtension = ".png";

        for(Values value : Values.values())
        {
            for (Suits suit : Suits.values())
            {
                m_dataBase[hashCard(value.ordinal(), suit.ordinal())] =
                        fileNameBase + Integer.toString(value.getIntValue()) + suit.getCharVal() + fileExtension;
            }
        }
    }


    private static CardDatabase m_cardDatabase = null;
    private String[] m_dataBase = new String[1000];
}

