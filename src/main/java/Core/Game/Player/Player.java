package Core.Game.Player;

import java.util.ArrayList;
import Core.Game.Card.Card;

/*
  It keeps track of each games current hand
  and current bets as well as the total winnings for that player across multiple games. If
  the player has lost more than he/she has won, that number can be negative.
*/

public class Player {
    private ArrayList<Card> _Hand;
    private int _anteBet;
    private int _playBet;
    private int _pairPlusBet;
    private int _totalWinnings;

    public Player() {
        _Hand = new ArrayList<Card>();
    }

    // Setters
    public void SetHand(ArrayList<Card> givenHand) {
        _Hand = givenHand;
    }

    public void SetAnteBet(int b) {
        _anteBet = b;
    }

    public void SetPlayBet(int b) {
        _playBet = b;
    }

    public void SetPairPlusBet(int b) {
        _pairPlusBet = b;
    }

    public void SetTotalWinnings(int totalWinnings) {
        _totalWinnings = totalWinnings;
    }
    // Getters
    public ArrayList<Card> GetHand() {
        return _Hand;
    }

    public int GetAnteBet(int b) {
        return _anteBet;
    }

    public int GetPlayBet() {
        return _playBet;
    }

    public int GetPairPlusBet() {
        return _pairPlusBet;
    }

    public int GetTotalWinnings() {
        return _totalWinnings;
    }



}
