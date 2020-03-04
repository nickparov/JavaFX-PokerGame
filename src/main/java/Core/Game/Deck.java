package Core.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
  private ArrayList<Character> _Suits = new ArrayList<Character>(Arrays.asList('C', 'D', 'S', 'H'));
  private ArrayList<Card> _CardDeck;

  Deck() {
    newDeck();
  }

  public void newDeck() {
    _CardDeck.clear();
    // create a new deck of 52 cards
    for (Character s : _Suits) {
      for(int i = 2; i <= 14; i++) {
        _CardDeck.add(new Card(s, i));
      }
    }
    // sort in random order
    Collections.shuffle(_CardDeck);
  }

  public ArrayList<Card> getDeck() {
    return _CardDeck;
  }
}
