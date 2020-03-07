package game;


import Core.Game.Dealer;
import Core.Game.Player.PlayerType;
import UI.myComponents.MyComponentsManager;
import util.Singleton;


public class ControlFlow implements Singleton
{
    public static ControlFlow getInstance()
    {
        if(m_controlFlow == null)
            m_controlFlow = new ControlFlow();

        return m_controlFlow;
    }

    public void startRound()
    {
        if(m_componentsManager == null)
        {
            System.out.println("NEED TO SET COMPONENTS MANAGER");
            return;
        }

        System.out.println("STARTING NEW ROUND");

        m_componentsManager.setHand(m_dealer.DealHand(), PlayerType.PLAYER_1);
        m_componentsManager.setHand(m_dealer.DealHand(), PlayerType.PLAYER_2);
        m_componentsManager.setHand(m_dealer.DealHand(), PlayerType.DEALER);
    }


    void setComponentManager(MyComponentsManager componentsManager)
    {
        m_componentsManager = componentsManager;
    }


    private Dealer m_dealer = new Dealer();
    private MyComponentsManager m_componentsManager = null;

    static private ControlFlow m_controlFlow = null;
}
