package game.states;

import UI.myComponents.MyComponentsManager;
import game.ControlFlowContext;

public class FinishRoundState extends GameState
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
        componentsManager = ControlFlowContext.getInstance().getComponentManager();
    }

    @Override
    public void startState()
    {
        initialize();

        componentsManager.m_newRoundButton.setDisable(false);
    }

    private void process()
    {
        int length1 = componentsManager.m_cards_p1.length;
        for(int i = 0; i < length1; i++)
            componentsManager.m_cards_p1[i].flip();

        int length2 = componentsManager.m_cards_p2.length;
        for(int i = 0; i < length2; i++)
            componentsManager.m_cards_p2[i].flip();

        int length3 = componentsManager.m_cards_dealer.length;
        for(int i = 0; i < length3; i++)
            componentsManager.m_cards_dealer[i].flip();

        componentsManager.m_history.clear();
    }

    @Override
    public void finishState()
    {
        componentsManager.m_anteBet_p1.setText("");
        componentsManager.m_anteBet_p2.setText("");

        componentsManager.m_pairPlus_p1.setText("");
        componentsManager.m_pairPlus_p2.setText("");

        componentsManager.m_playWager_p1.setText("");
        componentsManager.m_playWager_p2.setText("");

        componentsManager.m_newRoundButton.setDisable(true);
    }

    @Override
    public void gotoNextState()
    {
        ControlFlowContext.getInstance().changeState(new MakeBetsState());
    }

    MyComponentsManager componentsManager;
}
