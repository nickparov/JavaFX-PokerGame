package Core.Game;

public class Card {
  private char _suit;
  private int _value;

  Card(char s, int v) {
    _suit = s; //  ‘C’, ‘D’, ’S’, ‘H’
    _value = v; // 2 - 14
  };

  public char GetSuit() {
    return _suit;
  }

  public int GetValue() {
    return _value;
  }

}
