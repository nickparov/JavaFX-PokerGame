import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Core.ThreeCardLogic;
import Core.Game.Dealer;
import Core.Game.Deck;
import Core.Game.Card.Card;
import Core.Game.Player.Player;

class ThreeCardTest {
  private Deck deck;
  private Dealer d;
  private ArrayList<Card> Hand1;
  private ArrayList<Card> Hand2;
  private ArrayList<Character> _suits = new ArrayList<Character>(Arrays.asList('C', 'D', 'S', 'H'));

  @BeforeEach
  void before() {

    Hand1 = new ArrayList<Card>();
    Hand2 = new ArrayList<Card>();
    deck = new Deck();
    d = new Dealer();

  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("highCard")
  @Test
	void EvalHandHighCard() {
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('H', 4));
    Hand1.add(new Card('S', 6));

    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('H', 5));
    Hand2.add(new Card('S', 7));

    assertEquals(0, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(0, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("highCard Additional")
  @Test
	void EvalHandHighCardAdditional() {
    Hand1.add(new Card('H', 6));
    Hand1.add(new Card('C', 7));
    Hand1.add(new Card('S', 2));

    Hand2.add(new Card('C', 4));
    Hand2.add(new Card('H', 9));
    Hand2.add(new Card('S', 3));

    assertEquals(0, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(0, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("Flush")
  @Test
	void EvalHandFlushCard() {
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('C', 4));
    Hand1.add(new Card('C', 6));

    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('H', 5));
    Hand2.add(new Card('H', 7));

    assertEquals(4, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(4, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }
  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("Flush Additional")
  @Test
	void EvalHandFlushCardAdditional() {
    Hand1.add(new Card('D', 2));
    Hand1.add(new Card('D', 4));
    Hand1.add(new Card('D', 6));

    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('C', 5));
    Hand2.add(new Card('C', 7));

    assertEquals(4, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(4, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("Pair")
  @Test
	void EvalHandPairCard() {
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('H', 6));

    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('C', 7));

    assertEquals(5, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(5, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }
  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("Pair Additional")
  @Test
	void EvalHandPairCardAdditional() {
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('D', 3));
    Hand1.add(new Card('H', 3));

    Hand2.add(new Card('H', 4));
    Hand2.add(new Card('H', 7));
    Hand2.add(new Card('C', 7));

    assertEquals(5, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(5, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("Straight")
  @Test
	void EvalHandStraightCard() {
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('C', 3));
    Hand1.add(new Card('H', 4));

    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('H', 4));
    Hand2.add(new Card('C', 5));

    assertEquals(3, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(3, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }
  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("Straight Additional")
  @Test
	void EvalHandStraightCardAdditional() {
    Hand1.add(new Card('C', 10));
    Hand1.add(new Card('C', 11));
    Hand1.add(new Card('H', 12));

    Hand2.add(new Card('H', 11));
    Hand2.add(new Card('H', 12));
    Hand2.add(new Card('C', 13));

    assertEquals(3, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(3, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("StraightFlush")
  @Test
	void EvalHandStraightFlushCard() {
    Hand1.add(new Card('C', 2));
    Hand1.add(new Card('C', 3));
    Hand1.add(new Card('C', 4));

    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('H', 4));
    Hand2.add(new Card('H', 5));

    assertEquals(1, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(1, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("StraightFlush Additional")
  @Test
	void EvalHandStraightFlushCardAdditional() {
    Hand1.add(new Card('D', 5));
    Hand1.add(new Card('D', 6));
    Hand1.add(new Card('D', 7));

    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('C', 4));
    Hand2.add(new Card('C', 5));
    
    assertEquals(1, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(1, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("ThreeOfKind")
  @Test
	void EvalHandThreeOfAKindCard() {
    Hand1.add(new Card('H', 2));
    Hand1.add(new Card('D', 2));
    Hand1.add(new Card('C', 2));

    Hand2.add(new Card('D', 3));
    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('H', 3));

    assertEquals(2, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(2, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }

  @Tag("ThreeCardLogicClass")
  @Tag("EvalHand")
  @Tag("ThreeOfKind Additional")
  @Test
	void EvalHandThreeOfAKindCardAdditional() {
    Hand1.add(new Card('H', 7));
    Hand1.add(new Card('D', 7));
    Hand1.add(new Card('C', 7));

    Hand2.add(new Card('D', 12));
    Hand2.add(new Card('C', 12));
    Hand2.add(new Card('H', 12));

    assertEquals(2, ThreeCardLogic.evalHand(Hand1), "Wrong hand Power!"); 
    assertEquals(2, ThreeCardLogic.evalHand(Hand2), "Wrong hand Power!"); 
  }


  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Nobody Wins")
  @Test
	void CompareHandsNobody() {
    Hand1.add(new Card('H', 2));
    Hand1.add(new Card('D', 3));
    Hand1.add(new Card('C', 6));

    Hand2.add(new Card('D', 3));
    Hand2.add(new Card('C', 6));
    Hand2.add(new Card('H', 9));

   assertEquals(0, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Nobody Wins Additional")
  @Test
	void CompareHandsNobodyAdditional() {
    Hand1.add(new Card('H', 2));
    Hand1.add(new Card('D', 4));
    Hand1.add(new Card('C', 6));

    Hand2.add(new Card('D', 4));
    Hand2.add(new Card('C', 6));
    Hand2.add(new Card('H', 2));

   assertEquals(0, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Nobody Wins Additional 2")
  @Test
	void CompareHandsNobodyAdditional2() {
    Hand1.add(new Card('D', 9));
    Hand1.add(new Card('D', 10));
    Hand1.add(new Card('D', 11));

    Hand2.add(new Card('C', 4));
    Hand2.add(new Card('C', 5));
    Hand2.add(new Card('C', 6));

   assertEquals(0, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Dealer Wins")
  @Test
	void CompareHandsDealer() {
    Hand1.add(new Card('H', 2));
    Hand1.add(new Card('D', 3));
    Hand1.add(new Card('C', 4));

    Hand2.add(new Card('D', 3));
    Hand2.add(new Card('C', 6));
    Hand2.add(new Card('H', 9));

   assertEquals(1, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Dealer Wins Additional")
  @Test
	void CompareHandsDealerAdditionalTest() {
    Hand1.add(new Card('H', 2));
    Hand1.add(new Card('D', 2));
    Hand1.add(new Card('C', 4));

    Hand2.add(new Card('D', 3));
    Hand2.add(new Card('C', 6));
    Hand2.add(new Card('H', 9));

   assertEquals(1, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Dealer Wins Additional 2")
  @Test
	void CompareHandsDealerAdditionalTest2() {
    Hand1.add(new Card('D', 2));
    Hand1.add(new Card('D', 3));
    Hand1.add(new Card('D', 4));

    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('H', 6));
    Hand2.add(new Card('H', 9));

   assertEquals(1, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Player Wins")
  @Test
	void CompareHandsPlayer() {
    Hand1.add(new Card('H', 2));
    Hand1.add(new Card('D', 3));
    Hand1.add(new Card('C', 4));

    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('C', 4));
    Hand2.add(new Card('C', 5));

   assertEquals(2, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Player Wins Additional")
  @Test
	void CompareHandsPlayerAdditionalTest() {
    Hand1.add(new Card('H', 3));
    Hand1.add(new Card('D', 4));
    Hand1.add(new Card('C', 5));

    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('D', 3));

   assertEquals(2, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }

  @Tag("ThreeCardLogicClass")
  @Tag("compareHands")
  @Tag("Player Wins Additional 2")
  @Test
	void CompareHandsPlayerAdditionalTest2() {
    Hand1.add(new Card('H', 3));
    Hand1.add(new Card('D', 4));
    Hand1.add(new Card('C', 5));

    Hand2.add(new Card('C', 3));
    Hand2.add(new Card('H', 3));
    Hand2.add(new Card('D', 3));

   assertEquals(2, ThreeCardLogic.compareHands(Hand1, Hand2), "Wrong result number!");
  }


  @Tag("Deck Class")
  @Tag("size of the deck")
  @Test
  void sizeTest() {
    assertEquals(52, deck.size(), "Wrong Size!");
  }
  @Tag("Deck Class")
  @Tag("size after get top card")
  @Test
  void sizeTest1() {
    deck.getTopCard();
    assertEquals(51, deck.size(), "Wrong Size!");
  }
  @Tag("Deck Class")
  @Tag("size after 3 get top card")
  @Test
  void sizeTest2() {
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    assertEquals(49, deck.size(), "Wrong Size!");
  }

  @Tag("Deck Class")
  @Tag("size after 3 get top card and new Deck")
  @Test
  void sizeTest3() {
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    deck.newDeck();
    assertEquals(52, deck.size(), "Wrong Size!");
  }

  @Tag("Deck Class")
  @Tag("size after 5 get top card and new Deck and 5 get top card")
  @Test
  void sizeTest4() {
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    deck.newDeck();
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    deck.getTopCard();
    assertEquals(47, deck.size(), "Wrong Size!");
  }

  @Tag("Deck Class")
  @Tag("similar cards!")
  @Test
  void testDeckUniqueness(){
    assertEquals(true, isUnique(deck), "Deck is not Unique!");
  }

  @Tag("DeckClass")
  @Tag("Uniqueness")
  @Test
  void testUniquenessAfternewDeck() {
    deck.newDeck();
    deck.newDeck();
    assertEquals(true, isUnique(deck), "Deck is not unique after newDeck execution!!!");
  }


  @Tag("Dealer Class")
  @Tag("Constructor")
  @Test
  void dealerTest() {
    assertEquals(52, d.getDeck().size() , "Wrong size!"); 
  }

  @Tag("Dealer Class")
  @Tag("DealHand")
  @Test
  void dealerMethodTest() {
    assertEquals(3, d.DealHand().size() , "Wrong size!"); 
  }

  @Tag("Dealer Class")
  @Tag("DealHand 2 times + size of the deck")
  @Test
  void dealerMethodTest2() {
    assertEquals(3, d.DealHand().size() , "Wrong size!"); 
    assertEquals(3, d.DealHand().size(), "Wrong Size!");
    assertEquals(46, d.getDeck().size(), "Wrong Size!");
  }

  private boolean isUnique(Deck p_deck) {
    Map< Character, ArrayList<Integer> > CardsMap = new HashMap<>();
    for(Character c : _suits) {
      CardsMap.put(c, new ArrayList());
      for(int i = 0; i <= 14; i++) {
        CardsMap.get(c).add(0);
      }
      CardsMap.get(c).set(0, 1);
      CardsMap.get(c).set(1, 1);
    }
    for(Card c : deck) {
      CardsMap.get(c.getSuit()).set(c.getValue(), CardsMap.get(c.getSuit()).get(c.getValue()) + 1);
    }
    for(Character c : _suits) {
      for(int i = 2; i <= 14; i++) {
        if(CardsMap.get(c).get(i) != 1) 
          return false;
      }
    }

    return true;
  }

  






}
