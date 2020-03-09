package game.states;

import Core.Game.Dealer;
import Core.Game.Player.Player;
import Core.ThreeCardLogic;
import UI.myComponents.MyComponentsManager;
import game.ControlFlowContext;

import java.text.ParseException;

public class RevealState extends GameState
{
    @Override
    public <T>
    void processState(T ...args)
    {
        process((boolean) args[0], (boolean) args[1]);

        finishState();
        gotoNextState();
    }

    private void initialize()
    {
        player1 = ControlFlowContext.getInstance().getPlayer1();
        player2 = ControlFlowContext.getInstance().getPlayer2();
        dealer = ControlFlowContext.getInstance().getDealer();

        componentsManager = ControlFlowContext.getInstance().getComponentManager();
    }

    @Override
    public void startState()
    {
        initialize();

        componentsManager.m_fold_p1.setDisable(false);
        componentsManager.m_fold_p2.setDisable(false);
        componentsManager.m_play_p1.setDisable(false);
        componentsManager.m_play_p2.setDisable(false);
    }


    private void process(boolean player1Plays, boolean player2Plays)
    {
       // System.out.println("TExt is = " + componentsManager.m_anteBet_p1.getText() +  "\n");

        if(player1Plays)
            componentsManager.m_playWager_p1.setText(componentsManager.m_anteBet_p1.getText());

        if(player2Plays)
            componentsManager.m_playWager_p2.setText(componentsManager.m_anteBet_p2.getText());




        int length = componentsManager.m_cards_dealer.length;
        for(int i = 0; i < length; i++)
            componentsManager.m_cards_dealer[i].flip();

        if(!player1Plays)
        {
            componentsManager.m_history.prependText("Player one folds\n");
            componentsManager.m_total_winnings_p1.add(
                            -componentsManager.m_anteBet_p1.getInt()
                            -componentsManager.m_playWager_p1.getInt()
            );
        }

        if(!player2Plays)
        {
            componentsManager.m_history.prependText("Player two folds\n");
            componentsManager.m_total_winnings_p2.add(
                            -componentsManager.m_anteBet_p2.getInt()
                            -componentsManager.m_playWager_p2.getInt()
            );
        }


        if(!player1Plays && !player2Plays)
        {
            return;
        }


        if(ThreeCardLogic.evalHand(dealer.GetHand()) == 0 && !dealer.hasQueenOrAbove())
        {
            componentsManager.m_history.prependText("Dealer does not have at least Queen high; ante wager is pushed\n");
            return;
        }


        int player1Res = -1, player2Res = -1;
        if(player1Plays)
        {
            player1Res = ThreeCardLogic.compareHands(dealer.GetHand(), player1.GetHand()); // 0 - 2
        }
        if(player2Plays)
        {
            player2Res = ThreeCardLogic.compareHands(dealer.GetHand(), player2.GetHand()); // 0 - 2
        }


        switch (player1Res)
        {
            case -1: // Player folds
                break;
            case 0: componentsManager.m_history.prependText("Player one draws the dealer\n");
                break;
            case 1:
                componentsManager.m_history.prependText("Player one loses to dealer\n");
                componentsManager.m_total_winnings_p1.add(
                                -componentsManager.m_anteBet_p1.getInt()
                                -componentsManager.m_playWager_p1.getInt()
                );
                break;
            case 2:
                componentsManager.m_history.prependText("Player one beats dealer\n");
                componentsManager.m_total_winnings_p1.add(
                                2 * componentsManager.m_anteBet_p1.getInt() +
                                2 * componentsManager.m_playWager_p1.getInt()
                );
                break;
        }

        switch (player2Res)
        {
            case -1: // Player folds
                break;
            case 0: componentsManager.m_history.prependText("Player two draws the dealer\n");
                break;
            case 1:
                componentsManager.m_history.prependText("Player two loses to dealer\n");
                componentsManager.m_total_winnings_p2.add(
                                -componentsManager.m_anteBet_p2.getInt()
                                -componentsManager.m_playWager_p2.getInt()
                );
                break;
            case 2:
                componentsManager.m_history.prependText("Player two beats dealer\n");
                componentsManager.m_total_winnings_p2.add(
                                2 * componentsManager.m_anteBet_p2.getInt() +
                                2 * componentsManager.m_playWager_p2.getInt()
                );
                break;
        }
    }

    @Override
    public void finishState()
    {
        componentsManager.m_fold_p1.setDisable(true);
        componentsManager.m_fold_p2.setDisable(true);
        componentsManager.m_play_p1.setDisable(true);
        componentsManager.m_play_p2.setDisable(true);

        componentsManager.m_reveal_cards_button.setDisable(true);
    }

    @Override
    public void gotoNextState()
    {
        ControlFlowContext.getInstance().changeState(new FinishRoundState());
    }


    Player player1;
    Player player2;
    Dealer dealer;

    MyComponentsManager componentsManager;
}
