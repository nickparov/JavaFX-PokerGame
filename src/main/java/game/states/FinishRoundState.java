package game.states;

import UI.myComponents.MyComponentsManager;
import game.ControlFlowContext;

public class FinishRoundState extends GameState<Object>
{
    @Override
    public void processState(Object ...args)
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
            componentsManager.m_cards_p1[i].closeCard();

        int length2 = componentsManager.m_cards_p2.length;
        for(int i = 0; i < length2; i++)
            componentsManager.m_cards_p2[i].closeCard();

        int length3 = componentsManager.m_cards_dealer.length;
        for(int i = 0; i < length3; i++)
            componentsManager.m_cards_dealer[i].closeCard();

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


        componentsManager.m_fold_p1.setDisable(true);
        componentsManager.m_fold_p2.setDisable(true);

        componentsManager.m_play_p1.setDisable(true);
        componentsManager.m_play_p2.setDisable(true);


        componentsManager.m_make_bets_button.setDisable(true);
        componentsManager.m_dealButton.setDisable(true);
        componentsManager.m_reveal_cards_button.setDisable(true);
        componentsManager.m_newRoundButton.setDisable(true);
    }

    @Override
    public void gotoNextState()
    {
        ControlFlowContext.getInstance().changeState(new MakeBetsState());
    }

    MyComponentsManager componentsManager;
}
