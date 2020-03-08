package UI.layout;

import UI.myComponents.MyComponentsManager;
import UI.myComponents.card.CardView;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class GameFieldLayout implements LayoutInterface
{

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
                createGroup(LayoutConstants.HISTORY_AREA, LayoutConstants.NO_SPACING, myComponentsManager.m_history),

                createGroup(LayoutConstants.P1_CARDS_POSITION, LayoutConstants.CARDS_SPACING, myComponentsManager.m_cards_p1),
                createGroup(LayoutConstants.P2_CARDS_POSITION, LayoutConstants.CARDS_SPACING, myComponentsManager.m_cards_p2),

                createGroup(LayoutConstants.P1_BUTTONS_POSITION, LayoutConstants.BUTTONS_SPACING, myComponentsManager.m_fold_p1, myComponentsManager.m_play_p1, myComponentsManager.m_total_winnings_p1),
                createGroup(LayoutConstants.P2_BUTTONS_POSITION, LayoutConstants.BUTTONS_SPACING, myComponentsManager.m_fold_p2, myComponentsManager.m_play_p2, myComponentsManager.m_total_winnings_p2),

                createGroup(LayoutConstants.P1_TEXT_FIELDS_POSITION, LayoutConstants.TEXT_FIELDS_SPACING, myComponentsManager.m_anteBet_p1, myComponentsManager.m_pairPlus_p1, myComponentsManager.m_playWager_p1),
                createGroup(LayoutConstants.P2_TEXT_FIELDS_POSITION, LayoutConstants.TEXT_FIELDS_SPACING, myComponentsManager.m_anteBet_p2, myComponentsManager.m_pairPlus_p2, myComponentsManager.m_playWager_p2),

                createGroup(LayoutConstants.DEALER_CARDS_POSITION, LayoutConstants.CARDS_SPACING, myComponentsManager.m_cards_dealer),
                createGroup(LayoutConstants.MAKE_BETS_BUTTON_POSITION, LayoutConstants.BUTTONS_SPACING, myComponentsManager.m_make_bets_button, myComponentsManager.m_dealButton, myComponentsManager.m_reveal_cards_button, myComponentsManager.m_newRoundButton)
        );
    }

    public <T extends Node>
    StackPane createGroup(ComponentGroupPosition pos, int spacing, T ...components)
    {
        HBox group = new HBox(components);
        group.setSpacing(spacing);

        StackPane groupLayer = new StackPane(group);
        groupLayer.setPadding(pos.getPos());
        groupLayer.setPickOnBounds(false);

        return groupLayer;
    }

    private StackPane m_layout;
}

