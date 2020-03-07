package UI.layout;

import UI.myControllers.buttons.NewRoundButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Core.Game.Player;
import UI.myControllers.buttons.FoldButton;
import UI.myControllers.buttons.PlayButton;
import UI.myControllers.card.CardView;
import UI.myControllers.textFields.AnteBetTextField;
import UI.myControllers.textFields.PairPlusBetTextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import UI.myControllers.*;
import UI.myControllers.card.*;

import UI.Constants;

import javax.swing.text.html.ImageView;
import java.awt.*;

class BackgroundLayout implements LayoutInterface {

    public BackgroundLayout()
    {
        initializeUIComponents();
        linkComponents();
    }

    @Override
    public StackPane getLayout()
    {
        StackPane backgroundLayout = new StackPane();

        StackPane card_group_p1 = createCardGroup(m_cards_p1, new Insets(10, 0, 0,10 ), 10);
        StackPane card_group_p2 = createCardGroup(m_cards_p2, new Insets(10, 0, 0,500 ), 10);
        StackPane card_group_dealer = createCardGroup(m_cards_dealer, new Insets(400, 0, 0,200 ), 10);

        StackPane button_group_p1 = createButtonGroup(new Insets(200, 0, 0, 100), 10, m_fold_p1, m_play_p1);
        StackPane button_group_p2 = createButtonGroup(new Insets(200, 0, 0, 700), 10, m_fold_p2, m_play_p2);
        StackPane button_group_Round = createButtonGroup(new Insets(700, 0, 0, 300), 10, m_newRoundButton);

        StackPane textFiled_group_p1 = createTextFieldGroup(new Insets(250, 0, 0, 100), 10, m_anteBet_p1, m_pairPlus_p1);
        StackPane textFiled_group_p2 = createTextFieldGroup(new Insets(250, 0, 0, 700), 10, m_anteBet_p2, m_pairPlus_p2);


        backgroundLayout.getChildren().addAll(
                card_group_p1,
                card_group_p2,
                button_group_p1,
                button_group_p2,
                textFiled_group_p1,
                textFiled_group_p2,
                card_group_dealer,
                button_group_Round
        );

        return backgroundLayout;
    }


    private StackPane createCardGroup(CardView[] cards, Insets paddingValues, int spacing)
    {
        HBox cardGroup = new HBox(cards);
        cardGroup.setSpacing(spacing);

        StackPane cardGroupLayer = new StackPane(cardGroup);
        cardGroupLayer.setPadding(paddingValues);
        cardGroupLayer.setPickOnBounds(false);

        return cardGroupLayer;
    }

    private <T extends Button>
    StackPane createButtonGroup(Insets paddingValues, int spacing, T ...buttons)
    {
        HBox buttonGroup = new HBox(buttons);
        buttonGroup.setSpacing(spacing);

        StackPane buttonGroupLayer = new StackPane(buttonGroup);
        buttonGroupLayer.setPadding(paddingValues);
        buttonGroupLayer.setPickOnBounds(false);

        return buttonGroupLayer;
    }

    private <T extends TextField>
    StackPane createTextFieldGroup(Insets paddingValues, int spacing, T ...textFields)
    {
        HBox textFieldGroup = new HBox(textFields);
        textFieldGroup.setSpacing(spacing);

        StackPane textFieldGroupLayer = new StackPane(textFieldGroup);
        textFieldGroupLayer.setPadding(paddingValues);
        textFieldGroupLayer.setPickOnBounds(false);

        return textFieldGroupLayer;
    }


    private void initializeUIComponents()
    {
        for(int i = 0; i < m_cards_p1.length; i++)
            m_cards_p1[i] = new CardView(new Card(14, 'C'));

        for(int i = 0; i < m_cards_p2.length; i++)
            m_cards_p2[i] = new CardView(new Card(13, 'D'));

        for(int i = 0; i < m_cards_dealer.length; i++)
            m_cards_dealer[i] = new CardView(new Card(12, 'H'));
    }

    private void linkComponents()
    {
        m_ControllersManager.addControllers(
                m_fold_p1,
                m_fold_p2,
                m_play_p1,
                m_play_p2,
                m_anteBet_p1,
                m_anteBet_p2,
                m_pairPlus_p1,
                m_pairPlus_p2
                );

        m_ControllersManager.addControllers(m_cards_p1);
        m_ControllersManager.addControllers(m_cards_p2);
        m_ControllersManager.addControllers(m_cards_dealer);
    }


    private FoldButton m_fold_p1 = new FoldButton();
    private FoldButton m_fold_p2 = new FoldButton();

    private PlayButton m_play_p1 = new PlayButton();
    private PlayButton m_play_p2 = new PlayButton();

    private NewRoundButton m_newRoundButton = new NewRoundButton();

    private AnteBetTextField m_anteBet_p1 = new AnteBetTextField();
    private AnteBetTextField m_anteBet_p2 = new AnteBetTextField();

    private PairPlusBetTextField m_pairPlus_p1 = new PairPlusBetTextField();
    private PairPlusBetTextField m_pairPlus_p2 = new PairPlusBetTextField();

    private CardView[] m_cards_p1 = new CardView[3];
    private CardView[] m_cards_p2 = new CardView[3];
    private CardView[] m_cards_dealer = new CardView[3];

    private Publisher m_ControllersManager = new Publisher();
}
