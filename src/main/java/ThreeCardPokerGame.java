import Core.Game.Dealer;
import Core.Game.Player;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreeCardPokerGame extends Application {

  private Player _playerOne;
  private Player _playerTwo;
  private Dealer _theDealer;
  private boolean _gameOver;
  public boolean _isPlayerOnePlaying;
  public boolean _isPlayerTwoPlaying;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

  public void test(Stage passedStage) throws Exception {
    // TODO Auto-generated method stub
    passedStage.setTitle("Let's Play Three Card Poker!!!");
    // btn 
    Text textField = new Text("Waiting");
    Button btn = new Button("Play Poker!");

    btn.setOnAction(actionEvent -> {
      textField.setText("This is a text sample");
      btn.setText("Btn Clicked!");
    });

    HBox hb = new HBox(btn, textField);
    
		Scene scene = new Scene(hb,600,600);
		passedStage.setScene(scene);
		passedStage.show();
  }

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
    test(primaryStage);


    _gameOver = false;
    _playerOne = new Player();
    _playerTwo = new Player();
    _theDealer = new Dealer();
    _isPlayerOnePlaying = false;
    _isPlayerTwoPlaying = false;

    // GameLoop
    // while(!_gameOver) {
      // Before each game starts, the Dealer class must check to see if threre are at least 34 cards in the deck
      // _theDealer.CheckDeck();
      // TODO 
        // 1: Listen for Bet Input of Player1 and Player2 
        // 2: Listen for their choice: PLAY or FOLD
      // ----------------------------------------------- SIMULATING GAME [ START ]----------------------------------------------- //
        // Simulate betting
          // _playerOne.SetAnteBet(5);
          // _playerOne.SetAnteBet(5);
        // Depending on bets players put, deal cards to them
          // _playerOne.SetHand(_theDealer.DealHand());
          // _playerTwo.SetHand(_theDealer.DealHand());
          // _theDealer.SetHand(_theDealer.DealHand());
        // wait for choice ( PLAY / FOLD )
          // if (!_isPlayer<One/Two>Playing) ? PLAYER_FOLDED_ACTION_FIRED : PLAYER_ACCEPTED_ACTION_FIRED
        
        // Simulate Choice
          // _isPlayerOnePlaying = true;  
          // _isPlayerTwoPlaying = true;
        // Evaluate Hands 
        // ...
        // continue...
        // ...
      // ----------------------------------------------- SIMULATING GAME [ END ]----------------------------------------------- //
    // }

      

  }


}
