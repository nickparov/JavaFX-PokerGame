package UI.layout;

import UI.myControllers.card.Card;
import UI.myControllers.card.CardView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import UI.player.HandlersManager;

import UI.Constants;
import javafx.scene.shape.Rectangle;

import UI.myControllers.card.Values;
import UI.myControllers.card.Suits;


public class IntermediateLayout implements LayoutInterface {
    public IntermediateLayout()
    {
        initializeUIComponents();
        attachHandlers();
    }

    @Override
    public BorderPane getLayout()
    {
        BorderPane intermediateLayout = new BorderPane();

        StackPane center = new StackPane();
        center.setAlignment(Pos.TOP_LEFT);

        HBox buttons = new HBox(
                alignComponent(m_play1, new Insets(10, 10, 10, 10)),
                alignComponent(m_fold1, new Insets(10, 550, 10, 10)),
                alignComponent(m_play2, new Insets(10, 10, 10, 10)),
                alignComponent(m_fold2, new Insets(10, 10, 10, 10))
        );


        center.getChildren().add(m_cardView);
        //center.getChildren().addAll(m_table, buttons);


        intermediateLayout.setCenter(center);
        intermediateLayout.setLeft(m_textArea);

        return intermediateLayout;
    }

    private <T extends Node> HBox alignComponent(T component, Insets insets)
    {
        HBox hb = new HBox();
        hb.setPadding(insets);
        hb.getChildren().add(component);
        return hb;
    }

    private void initializeUIComponents()
    {
        m_startRound = new Button("Start The Round");
        m_fold1 = new Button("Fold");
        m_fold2 = new Button("Fold");
        m_play1 = new Button("Play");
        m_play2 = new Button("Play");



        m_textArea = new TextArea();
        m_textArea.setMaxSize(Constants.SCENE_MIN_WIDTH / 6, Constants.TABLE_HEIGHT);

        m_table = new Rectangle(Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT);
        m_cardView = new CardView(new Card(Values.ACE, Suits.DIAMONDS));
    }

    private void attachHandlers()
    {
        m_fold1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               m_handlersManager.getPlayerHandlers().foldButtonPressed();
            }
        });

        m_play1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                m_handlersManager.getPlayerHandlers().playButtonPressed();
            }
        });
    }

    //private Card AceClubs = new Card(Values.ACE, Suits.CLUBS);
    private CardView m_cardView;

    private Button m_startRound;

    private Button m_fold1;
    private Button m_fold2;
    private Button m_play1;
    private Button m_play2;

    private TextField m_anteBet1;
    private TextField m_pairPlusBet1;
    private TextField m_anteBet2;
    private TextField m_pairPlusBet2;

    private TextArea m_textArea;

    private Rectangle m_table;

    private HandlersManager m_handlersManager = new HandlersManager();
}
