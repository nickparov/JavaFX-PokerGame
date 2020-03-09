package game.states;

import Core.Game.Dealer;
import Core.Game.Player.Player;
import Core.Game.Player.PlayerType;
import Core.ThreeCardLogic;
import UI.myComponents.MyComponentsManager;
import game.ControlFlowContext;

public class DealState extends GameState
{
    @Override
    public <T>
    void processState(T ...args)
    {
        process();

        finishState();
        gotoNextState();
    }

    private void initialize()
    {
        m_player1 = ControlFlowContext.getInstance().getPlayer1();
        m_player2 = ControlFlowContext.getInstance().getPlayer2();
        m_dealer = ControlFlowContext.getInstance().getDealer();

        m_componentsManager = ControlFlowContext.getInstance().getComponentManager();
    }

    @Override
    public void startState()
    {
        initialize();

        m_componentsManager.m_dealButton.setDisable(false);
    }

    private void process()
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

        int pairPlusWinAmountP1 = ThreeCardLogic.evalPPWinnings(m_player1.GetHand(), m_componentsManager.m_pairPlus_p1.getInt());
        int pairPlusWinAmountP2 = ThreeCardLogic.evalPPWinnings(m_player2.GetHand(), m_componentsManager.m_pairPlus_p2.getInt());

        if(pairPlusWinAmountP1 != 0)
        {
            m_componentsManager.m_history.prependText("Player one wins Pair Plus\n");
            m_componentsManager.m_total_winnings_p1.add(pairPlusWinAmountP1);
        }
        if(pairPlusWinAmountP2 != 0)
        {
            m_componentsManager.m_history.prependText("Player two wins Pair Plus\n");
            m_componentsManager.m_total_winnings_p2.add(pairPlusWinAmountP2);
        }
    }

    @Override
    public void finishState()
    {
        m_componentsManager.m_dealButton.setDisable(true);
    }

    @Override
    public void gotoNextState()
    {
        ControlFlowContext.getInstance().changeState(new RevealState());
    }

    Player m_player1;
    Player m_player2;
    Dealer m_dealer;
    MyComponentsManager m_componentsManager;
}
