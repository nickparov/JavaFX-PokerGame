package game;

import Core.Game.Dealer;
import Core.Game.Player.Player;
import UI.myComponents.MyComponentsManager;
import game.states.FinishRoundState;
import game.states.GameState;
import game.states.MakeBetsState;

public class ControlFlowContext
{
    public static ControlFlowContext getInstance()
    {
        if(m_controlFlowContext == null)
            m_controlFlowContext = new ControlFlowContext();

        return m_controlFlowContext;
    }


    public <T>
    void processState(T ...args)
    {
        m_gameState.processState(args);
    }


    public <T>
    void changeState(GameState<T> newState)
    {
        m_gameState = newState;
        m_gameState.startState();
    }

    public void setComponentManager(MyComponentsManager componentsManager)
    {
        m_componentsManager = componentsManager;
    }

    public MyComponentsManager getComponentManager()
    {
        return m_componentsManager;
    }

    public Player getPlayer1()
    {
        return m_player1;
    }

    public Player getPlayer2()
    {
        return m_player2;
    }

    public Dealer getDealer()
    {
        return m_dealer;
    }

    public void freshStart()
    {
        FinishRoundState finishRoundState = new FinishRoundState();
        finishRoundState.startState();
        finishRoundState.processState();
        changeState(new MakeBetsState());

        m_componentsManager.m_total_winnings_p1.set(0);
        m_componentsManager.m_total_winnings_p2.set(0);
    }

    private ControlFlowContext()
    {

    }


    private GameState m_gameState;
    static private ControlFlowContext m_controlFlowContext = null;

    private Player m_player1 = new Player();
    private Player m_player2 = new Player();
    private Dealer m_dealer = new Dealer();

    private MyComponentsManager m_componentsManager = null;
}
