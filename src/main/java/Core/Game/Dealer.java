package Core.Game;

import Core.Game.Card.Card;
import java.util.ArrayList;

public class Dealer {
  private Deck _GameDeck;
  private ArrayList<Card> _Hand;
  private ArrayList<Card> _DeckCards;

  public Dealer() {
    _GameDeck = new Deck();
    _DeckCards = _GameDeck.getDeck();
  }

  public ArrayList<Card> DealHand() {
    CheckDeck();
    ArrayList<Card> Hand = new ArrayList<Card>();

    // get 3 cards from the deck
    for(int i = 0; i < 3; i++) {
      Hand.add(_DeckCards.remove(_DeckCards.size() - 1));
    }
    // return hand
    return Hand;
  }

  public void CheckDeck() {
    /*
      if there are more
      than 34 cards left in the deck. If not, theDeck must be reshuffled with a new set of 52
      cards in random order.
    */

    if(_DeckCards.size() < 34) {
      _GameDeck.newDeck();
    }
  }

  public void SetHand(ArrayList<Card> givenHand) {
    _Hand = givenHand;
  }

  public ArrayList<Card> GetHand() {
    return _Hand;
  }
}
