package Core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Core.Game.Card.Card;

public class ThreeCardLogic {

  public static int evalHand(ArrayList<Card> Hand) {
    ArrayList<Character> Suits = new ArrayList<Character>(Arrays.asList('C', 'D', 'S', 'H'));
    /* 
    - 0 if the hand just has a high card
    • 1 for a straight flush
    • 2 for three of a kind
    • 3 for a straight
    • 4 for a flush
    • 5 for a pair
    */
    Map<Character, Integer> SuitToCardsMap  = new HashMap<Character, Integer>();
    ArrayList<Integer>      ValToCardsArray = new ArrayList<Integer>();

    for(Character s : Suits) {
      SuitToCardsMap.put(s, 0);
    }
    for(int i = 0; i <= 14; i++) {
      ValToCardsArray.add(0);
    }
    // count cards of the same suit and corresponding values
    for(Card CurCard : Hand) {
      SuitToCardsMap.put(CurCard.getSuit(),  SuitToCardsMap.get(CurCard.getSuit()) + 1);
      ValToCardsArray.set(CurCard.getValue(), ValToCardsArray.get(CurCard.getValue()) + 1);
    }

    System.out.println("Evaluated a Hand!");

    return 0;
  }
  // public static int evalPPWinnings(ArrayList<Card> Hand, int bet) {

  // }
  // public static int compareHands(ArrayList<Card> DealerHand, ArrayList<Card> PlayerHand) {

  // }
}
