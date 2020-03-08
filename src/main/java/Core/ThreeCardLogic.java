package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Core.Game.Card.Card;
import Core.Game.Card.Suits;

public class ThreeCardLogic {
  public static class HandInfo {

    public Map<Character, Integer> SuitMap;
    public ArrayList<Integer>      ValArr;

    public HandInfo() {
      SuitMap  = new HashMap<Character, Integer>();
      ValArr = new ArrayList<Integer>();
    }
    public HandInfo(ArrayList<Card> PassedHand) {
      SuitMap  = new HashMap<Character, Integer>();
      ValArr = new ArrayList<Integer>();

      for(Suits suit : Suits.values()) {
        SuitMap.put(suit.getCharVal(), 0);
      }
      for(int i = 0; i <= 14; i++) {
        ValArr.add(0);
      }
      // count cards of the same suit and corresponding values
      for(Card CurCard : PassedHand) {
        SuitMap.put(CurCard.getSuit(),  SuitMap.get(CurCard.getSuit()) + 1);
        ValArr.set(CurCard.getValue(), ValArr.get(CurCard.getValue()) + 1);
      }
    }
  }

  private static boolean isFlush(HandInfo handInfo) {
    for(Integer n : handInfo.SuitMap.values()) {
        if(n == 3) return true;
    }
    return false;
  }

  private static boolean isThreeOfKind(HandInfo handInfo) {
    for(Integer n : handInfo.ValArr) {
      if(n == 3) return true;
    }

    return false;
  }

  private static boolean isPair(HandInfo handInfo) {
    for(Integer n : handInfo.ValArr) {
      if(n == 2) return true;
    }

    return false;
  }


  private static boolean isStraight(HandInfo handInfo) {

    if(handInfo.ValArr.get(14) == 1 
      && handInfo.ValArr.get(2) == 1 
      && handInfo.ValArr.get(3) == 1)
      return true;

    int trueComparisons = 0;
    int curValue = 0;
    int prevValue = 0;
    for(int i = 3; i <= 14; i++) {
      prevValue = handInfo.ValArr.get(i - 1);
      curValue = handInfo.ValArr.get(i);
      if(prevValue == curValue && curValue == 1 ) {
        trueComparisons++;
      }
    }

    return trueComparisons == 2 ? true : false;
  }

  private static boolean isStraightFlush(HandInfo handInfo) {
    return isStraight(handInfo) && isThreeOfKind(handInfo) ? true : false;
  }



  public static int evalHand(ArrayList<Card> Hand) {
    
    /* 
    - 0 if the hand just has a high card
    • 1 for a straight flush
    • 2 for three of a kind
    • 3 for a straight
    • 4 for a flush
    • 5 for a pair
    */
    HandInfo handInfo = new HandInfo(Hand);

    if(isStraightFlush(handInfo)) return 1;
    if(isThreeOfKind(handInfo))   return 2;
    if(isStraight(handInfo))      return 3;
    if(isFlush(handInfo))         return 4;
    if(isPair(handInfo))          return 5;

    return 0;

  }
  public static int evalPPWinnings(ArrayList<Card> Hand, int bet) {
    switch(evalHand(Hand)) {
      case 1:
        return bet *= 40;
      case 2:
        return bet *= 30;
      case 3:
        return bet *= 6;
      case 4:
        return bet *= 3;
      case 5:
        return bet *= 1;
      default:
        bet = 0;
    }
    return bet;
  }
  public static int compareHands(ArrayList<Card> DealerHand, ArrayList<Card> PlayerHand) {
    int dealerPower = evalHand(DealerHand); // 0 - 5
    int playerPower = evalHand(PlayerHand); // 0 - 5
    int res = 0;
    // 1 - dealer won 
    // 2 - player won
    if(playerPower != 0 && dealerPower != 0) {
      // both nonzeroes
      if(dealerPower < playerPower)
        res = 1;
      if(playerPower < dealerPower) 
        res = 2;
    } else if(playerPower == dealerPower) {
      // both same
      res = 0;
    } else {
      // one of them is zero
      if(dealerPower == 0 && playerPower != 0)
        res = 2;
      else 
        res = 1;
    }

    return res;
  }
}
