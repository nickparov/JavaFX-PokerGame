import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreeCardPokerGame extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
    test(primaryStage);
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

}
