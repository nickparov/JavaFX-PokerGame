package UI.layout;

import UI.myComponents.MyComponentsManager;
import UI.myComponents.card.CardView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class GameFieldLayout implements LayoutInterface {

    public GameFieldLayout(MyComponentsManager myComponentsManager)
    {
        buildLayout(myComponentsManager);
    }

    @Override
    public StackPane getLayout()
    {
        return m_layout;
    }


    private void buildLayout(MyComponentsManager myComponentsManager)
    {
        m_layout = new StackPane(
                createCardGroup(LayoutConstants.P1_CARDS_POSITION, LayoutConstants.CARDS_SPACING, myComponentsManager.m_cards_p1),
                createCardGroup(LayoutConstants.P2_CARDS_POSITION, LayoutConstants.CARDS_SPACING, myComponentsManager.m_cards_p2),
                createCardGroup(LayoutConstants.DEALER_CARDS_POSITION, LayoutConstants.CARDS_SPACING, myComponentsManager.m_cards_dealer),

                createButtonGroup(LayoutConstants.P1_BUTTONS_POSITION, LayoutConstants.BUTTONS_SPACING, myComponentsManager.m_fold_p1, myComponentsManager.m_play_p1),
                createButtonGroup(LayoutConstants.P2_BUTTONS_POSITION, LayoutConstants.BUTTONS_SPACING, myComponentsManager.m_fold_p2, myComponentsManager.m_play_p2),
                createButtonGroup(LayoutConstants.NEW_ROUND_BUTTON_POSITION, LayoutConstants.BUTTONS_SPACING, myComponentsManager.m_newRoundButton),

                createTextFieldGroup(LayoutConstants.P1_TEXT_FIELDS_POSITION, LayoutConstants.TEXT_FIELDS_SPACING, myComponentsManager.m_anteBet_p1, myComponentsManager.m_pairPlus_p1),
                createTextFieldGroup(LayoutConstants.P2_TEXT_FIELDS_POSITION, LayoutConstants.TEXT_FIELDS_SPACING, myComponentsManager.m_anteBet_p2, myComponentsManager.m_pairPlus_p2)
        );
    }

    private StackPane createCardGroup(ComponentGroupPosition pos, int spacing, CardView[] cards)
    {
        HBox cardGroup = new HBox(cards);
        cardGroup.setSpacing(spacing);

        StackPane cardGroupLayer = new StackPane(cardGroup);
        cardGroupLayer.setPadding(pos.getPos());
        cardGroupLayer.setPickOnBounds(false);

        return cardGroupLayer;
    }

    private <T extends Button>
    StackPane createButtonGroup(ComponentGroupPosition pos, int spacing, T ...buttons)
    {
        HBox buttonGroup = new HBox(buttons);
        buttonGroup.setSpacing(spacing);

        StackPane buttonGroupLayer = new StackPane(buttonGroup);
        buttonGroupLayer.setPadding(pos.getPos());
        buttonGroupLayer.setPickOnBounds(false);

        return buttonGroupLayer;
    }

    private <T extends TextField>
    StackPane createTextFieldGroup(ComponentGroupPosition pos, int spacing, T ...textFields)
    {
        HBox textFieldGroup = new HBox(textFields);
        textFieldGroup.setSpacing(spacing);

        StackPane textFieldGroupLayer = new StackPane(textFieldGroup);
        textFieldGroupLayer.setPadding(pos.getPos());
        textFieldGroupLayer.setPickOnBounds(false);

        return textFieldGroupLayer;
    }


    private StackPane m_layout;
}

