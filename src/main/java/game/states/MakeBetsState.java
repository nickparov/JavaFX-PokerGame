package game.states;

import UI.myComponents.MyComponentsManager;
import game.ControlFlowContext;

import java.awt.*;

public class MakeBetsState extends GameState
{
    @Override
    public <T>
    void processState(T... args)
    {
        if (!process())
            return;

        finishState();
        gotoNextState();
    }


    private void initialize()
    {
        m_componentsManager = ControlFlowContext.getInstance().getComponentManager();
    }


    @Override
    public void startState()
    {
        initialize();

        m_componentsManager.m_anteBet_p1.setDisable(false);
        m_componentsManager.m_anteBet_p2.setDisable(false);
        m_componentsManager.m_pairPlus_p1.setDisable(false);
        m_componentsManager.m_pairPlus_p2.setDisable(false);

        m_componentsManager.m_make_bets_button.setDisable(false);
    }


    private boolean process()
    {
        if(!m_componentsManager.m_anteBet_p1.isTextValid(m_componentsManager.m_history) ||
                !m_componentsManager.m_anteBet_p2.isTextValid(m_componentsManager.m_history))
        {
            return false;
        }

        if(!m_componentsManager.m_pairPlus_p1.isTextValid(m_componentsManager.m_history) ||
                !m_componentsManager.m_pairPlus_p2.isTextValid(m_componentsManager.m_history))
        {
            return false;
        }

        m_componentsManager.m_history.prependText("Bets made successfully\n");

        return true;
    }


    @Override
    public void finishState()
    {
        m_componentsManager.m_anteBet_p1.setDisable(true);
        m_componentsManager.m_anteBet_p2.setDisable(true);
        m_componentsManager.m_pairPlus_p1.setDisable(true);
        m_componentsManager.m_pairPlus_p2.setDisable(true);

        m_componentsManager.m_make_bets_button.setDisable(true);
    }


    @Override
    public void gotoNextState()
    {
        ControlFlowContext.getInstance().changeState(new DealState());
    }


    private MyComponentsManager m_componentsManager;
}
