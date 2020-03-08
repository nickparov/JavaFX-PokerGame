package game;

import Core.Game.Card.Card;
import Core.Game.Dealer;
import Core.Game.Player.Player;
import Core.Game.Player.PlayerType;
import Core.ThreeCardLogic;
import UI.myComponents.MyComponentsManager;
import util.Singleton;

import java.util.ArrayList;


public class ControlFlow implements Singleton
{
    public static ControlFlow getInstance()
    {
        if(m_controlFlow == null)
            m_controlFlow = new ControlFlow();

        return m_controlFlow;
    }

    public void makeBets()
    {
        if(m_componentsManager.m_anteBet_p1.getText().isEmpty())
        {
            m_componentsManager.m_history.prependText("PLAYER 1 MUST SET ANTE BET\n");
            return;
        }

        if(m_componentsManager.m_anteBet_p2.getText().isEmpty())
        {
            m_componentsManager.m_history.prependText("PLAYER 2 MUST SET ANTE BET\n");
            return;
        }

        m_componentsManager.m_anteBet_p1.setEditable(false);
        m_componentsManager.m_anteBet_p2.setEditable(false);

        m_componentsManager.m_pairPlus_p1.setEditable(false);
        m_componentsManager.m_pairPlus_p2.setEditable(false);

        // TODO set a fancy disable effect on text fields

        m_componentsManager.m_history.prependText("BETS SUCCESSFULLY MADE\n");
        m_componentsManager.m_history.prependText("PLAYER'S 1 ANTE BET IS: " + m_componentsManager.m_anteBet_p1.getText() + "\n");
        m_componentsManager.m_history.prependText("PLAYER'S 2 ANTE BET IS: " + m_componentsManager.m_anteBet_p2.getText() + "\n");

        m_componentsManager.m_make_bets_button.setDisable(true);
        m_componentsManager.m_dealButton.setDisable(false);
    }

    public void dealCards()
    {
        m_player1.SetHand(m_dealer.DealHand());
        m_player2.SetHand(m_dealer.DealHand());
        m_dealer.SetHand(m_dealer.DealHand());

        m_componentsManager.setHand(m_player1.GetHand(), PlayerType.PLAYER_1);
        m_componentsManager.setHand(m_player2.GetHand(), PlayerType.PLAYER_2);
        m_componentsManager.setHand(m_dealer.GetHand(), PlayerType.DEALER);

        int length1 = m_componentsManager.m_cards_p1.length;
        for(int i = 0; i < length1; i++)
            m_componentsManager.m_cards_p1[i].flip();

        int length2 = m_componentsManager.m_cards_p2.length;
        for(int i = 0; i < length2; i++)
            m_componentsManager.m_cards_p2[i].flip();

        m_componentsManager.m_fold_p1.setDisable(false);
        m_componentsManager.m_fold_p2.setDisable(false);
        m_componentsManager.m_play_p1.setDisable(false);
        m_componentsManager.m_play_p2.setDisable(false);

        m_componentsManager.m_dealButton.setDisable(true);
        //m_componentsManager.m_reveal_cards_button.setDisable(false);
    }

    public void revealAndCalculate(boolean player1Plays, boolean player2Plays)
    {
        int length = m_componentsManager.m_cards_dealer.length;
        for(int i = 0; i < length; i++)
            m_componentsManager.m_cards_dealer[i].flip();

        int player1Res = -1, player2Res = -1;
        if(player1Plays)
        {
            player1Res = ThreeCardLogic.compareHands(m_dealer.GetHand(), m_player1.GetHand()); // 0 - 2
        }
        if(player2Plays)
        {
            player2Res = ThreeCardLogic.compareHands(m_dealer.GetHand(), m_player2.GetHand()); // 0 - 2
        }

        m_componentsManager.m_history.prependText("\n");

        switch (player1Res)
        {
            case -1: m_componentsManager.m_history.prependText("PLAYER1 FOLD\n");
                break;
            case 0: m_componentsManager.m_history.prependText("PLAYER1 DRAWS DEALER\n");
                break;
            case 1:  m_componentsManager.m_history.prependText("PLAYER1 LOSE\n");
                break;
            case 2:  m_componentsManager.m_history.prependText("PLAYER1 WIN\n");
                break;
        }

        switch (player2Res)
        {
            case -1: m_componentsManager.m_history.prependText("PLAYER2 FOLD\n");
                break;
            case 0: m_componentsManager.m_history.prependText("PLAYER2 DRAWS DEALER\n");
                break;
            case 1:  m_componentsManager.m_history.prependText("PLAYER2 LOSE\n");
                break;
            case 2:  m_componentsManager.m_history.prependText("PLAYER2 WIN\n");
                break;
        }

        m_componentsManager.m_fold_p1.setDisable(true);
        m_componentsManager.m_fold_p2.setDisable(true);
        m_componentsManager.m_play_p1.setDisable(true);
        m_componentsManager.m_play_p2.setDisable(true);

        m_componentsManager.m_reveal_cards_button.setDisable(true);
        m_componentsManager.m_newRoundButton.setDisable(false);
    }

    public void finishRound()
    {
        m_componentsManager.m_history.clear();

        m_componentsManager.m_anteBet_p1.setEditable(true);
        m_componentsManager.m_anteBet_p2.setEditable(true);

        m_componentsManager.m_pairPlus_p1.setEditable(true);
        m_componentsManager.m_pairPlus_p2.setEditable(true);

        // TODO unset a fancy disable effect on text fields

        m_componentsManager.m_fold_p1.setDisable(true);
        m_componentsManager.m_fold_p2.setDisable(true);
        m_componentsManager.m_play_p1.setDisable(true);
        m_componentsManager.m_play_p2.setDisable(true);

        m_componentsManager.m_make_bets_button.setDisable(false);
        m_componentsManager.m_dealButton.setDisable(true);
        m_componentsManager.m_reveal_cards_button.setDisable(true);
        m_componentsManager.m_newRoundButton.setDisable(true);

        int length1 = m_componentsManager.m_cards_p1.length;
        for(int i = 0; i < length1; i++)
            m_componentsManager.m_cards_p1[i].flip();

        int length2 = m_componentsManager.m_cards_p2.length;
        for(int i = 0; i < length2; i++)
            m_componentsManager.m_cards_p2[i].flip();

        int length3 = m_componentsManager.m_cards_dealer.length;
        for(int i = 0; i < length3; i++)
            m_componentsManager.m_cards_dealer[i].flip();
    }


    public void setComponentManager(MyComponentsManager componentsManager)
    {
        m_componentsManager = componentsManager;
    }


    private Player m_player1 = new Player();
    private Player m_player2 = new Player();
    private Dealer m_dealer = new Dealer();

    private MyComponentsManager m_componentsManager = null;

    static private ControlFlow m_controlFlow = null;
}
