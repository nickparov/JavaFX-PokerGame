package Core.Game;

import Core.Game.Card.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
  private ArrayList<Character> _suits = new ArrayList<Character>(Arrays.asList('C', 'D', 'S', 'H'));

  public Deck() {
    newDeck();
  }

  public void newDeck() {
    this.clear(); 
    // create a new deck of 52 cards
    for (Character s : _suits) {
      for(int i = 2; i <= 14; i++) {
        this.add(new Card(s, i));
      }
    }
    // sort in random order
    Collections.shuffle(this);
  }

  public Card getTopCard() {
    return this.remove(this.size() - 1);
  }

  public ArrayList<Card> getDeck() {
    return this;
  }
}
