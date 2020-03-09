import Core.Game.Dealer;
import Core.Game.Player.Player;

import UI.layout.LayoutManager;
import game.SetUp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import UI.Constants;

public class ThreeCardPokerGame extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
     // TODO Auto-generated method stub

     primaryStage.setTitle("Let's Play Three Card Poker!!!");
     primaryStage.setResizable(false);

     SetUp setup = new SetUp();

     primaryStage.setScene(setup.getScene());
     primaryStage.show();
  }


}
